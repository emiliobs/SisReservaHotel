package Logica;

import Datos.VCliente;
import Datos.VProducto;
import Datos.VTrabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FTrabajador {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSql = " ";
    private String sSql2 = " ";
    public int TotalRegistros;

    ////SSELECT `idpersona`, `sueldo`, `acceso`, `login`, `password`, `estado` FROM `trabajador` WHERE 1
    public DefaultTableModel Mostrar(String Buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno",
            "Tipo Documento", "Número Documento", "Dirección", "Teléfono",
            "Email","Sueldo","Acceso","Login","Clave","Estado"
        };

        String[] registro = new String[14];

        TotalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
        //SELECT `idpersona`, `nombre`, `apaterno`, `amaterno`, `tipo_documento`, `num_documento`, `direccion`, `telefono`, `email` FROM `persona` 
        //idpersona`, `sueldo`, `acceso`, `login`, `password`, `estado
        sSql = "select p.idpersona,p.nombre,p.apaterno,p.amaterno,p.tipo_documento,p.num_documento,p.direccion,p.telefono,p.email,t.sueldo,t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t on p.idpersona = t.idpersona where num_documento like '%" + Buscar + "%' order by idpersona desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {

                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");

                TotalRegistros = TotalRegistros + 1;

                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean Insertar(VTrabajador trabajador) {

        sSql = "INSERT INTO persona(nombre,apaterno,amaterno,"
                + "tipo_documento,num_documento,direccion,telefono,email) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        sSql2 = "INSERT INTO trabajador(idpersona,sueldo,acceso,login,password,estado)"
                + "VALUES ((select idpersona from persona order by idpersona desc limit 1),?,?,?,?,?)";//Aqui captura el registro de la última persona..

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            PreparedStatement pst2 = cn.prepareStatement(sSql2);

            pst.setString(1, trabajador.getNombre());
            pst.setString(2, trabajador.getApaterno());
            pst.setString(3, trabajador.getAmaterno());
            pst.setString(4, trabajador.getTipo_documento());
            pst.setString(5, trabajador.getNum_documento());
            pst.setString(6, trabajador.getDireccion());
            pst.setString(7, trabajador.getTelefono());
            pst.setString(8, trabajador.getEmail());

            pst2.setDouble(1, trabajador.getSueldo());
            pst2.setString(2, trabajador.getAcceso());
            pst2.setString(3, trabajador.getLogin());
            pst2.setString(4, trabajador.getPassword());
            pst2.setString(5, trabajador.getEstado());

            //Ingreso un persona, sipuedo                      
            int n = pst.executeUpdate();

            if (n != 0) {
                //Aquí ingreso un clientro
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

            return false;
        }
    }

    public boolean Editar(VTrabajador trabajador) 
    {
        sSql = "UPDATE persona SET  nombre = ?,amaterno = ?,apaterno = ?,tipo_documento = ?, num_documento = ?, direccion = ?, telefono = ?,email = ? WHERE idpersona = ? ";
        
        sSql2 = "UPDATE trabajador SET  sueldo = ?, acceso = ?, login = ?, password = ?, estado = ? WHERE idpersona = ? ";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            PreparedStatement pst2 = cn.prepareStatement(sSql2);

            pst.setString(1, trabajador.getNombre());
            pst.setString(2, trabajador.getApaterno());
            pst.setString(3, trabajador.getAmaterno());
            pst.setString(4, trabajador.getTipo_documento());
            pst.setString(5, trabajador.getNum_documento());
            pst.setString(6, trabajador.getDireccion());
            pst.setString(7, trabajador.getTelefono());
            pst.setString(8, trabajador.getEmail());
            pst.setInt(9, trabajador.getIdpersona());

            pst2.setDouble(1, trabajador.getSueldo());
            pst2.setString(2, trabajador.getAcceso());
            pst2.setString(3,trabajador.getLogin());
            pst2.setString(4, trabajador.getPassword());
            pst2.setString(5, trabajador.getEstado());
            pst2.setInt(6, trabajador.getIdpersona());

            //Ingreso un persona, sipuedo                      
            int n = pst.executeUpdate();

            if (n != 0) {
                //Aquí ingreso un clientro
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

            return false;
        }
    }

    public boolean Eliminar(VTrabajador trabajador) 
    {
        //primero elimino un cliente y .uego elimino una persona, por la relación:
        sSql = "DELETE FROM  trabajador WHERE idpersona = ?";
        sSql2 = "DELETE FROM  persona  WHERE idpersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            PreparedStatement pst2 = cn.prepareStatement(sSql2);

            
            pst.setInt(1, trabajador.getIdpersona());

           
            pst2.setInt(1, trabajador.getIdpersona());

            //eimino un trabajador                      
            int n = pst.executeUpdate();

            if (n != 0) {
                //Aquí elimino una persona
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

            return false;
        }
    }
    
    ////SSELECT `idpersona`, `sueldo`, `acceso`, `login`, `password`, `estado` FROM `trabajador` WHERE 1
    public DefaultTableModel Login(String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno","Acceso",
                            "Login","Clave","Estado"
        };

        String[] registro = new String[8];

        TotalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
        //SELECT `idpersona`, `nombre`, `apaterno`, `amaterno`, `tipo_documento`, `num_documento`, `direccion`, `telefono`, `email` FROM `persona` 
        //idpersona`, `sueldo`, `acceso`, `login`, `password`, `estado
        sSql = "select p.idpersona,p.nombre,p.apaterno,p.amaterno,t.acceso,t.login,t.password,t.estado from persona p inner join trabajador t on p.idpersona = t.idpersona where t.login = '" + login + "' and t.password = '" + password + "' and t.estado = 'A'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {

                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");

                TotalRegistros = TotalRegistros + 1;

                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
}
