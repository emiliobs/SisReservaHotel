package Logica;

import Datos.VCliente;
import Datos.VProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FCliente {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSql = " ";
    private String sSql2 = " ";
    public int TotalRegistros;

    ////SELECT `idproducto`, `nombre`, `descripcion`, `unidad_medida`, `precio_venta` FROM `producto` WHERE 1
    public DefaultTableModel Mostrar(String Buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno",
            "Tipo Documento", "Número Documento", "Dirección", "Teléfono",
            "Email", "Código Cliente"
        };

        String[] registro = new String[10];

        TotalRegistros = 0;

        modelo = new DefaultTableModel(null, titulos);
        //SELECT `idpersona`, `nombre`, `apaterno`, `amaterno`, `tipo_documento`, `num_documento`, `direccion`, `telefono`, `email` FROM `persona` 
        sSql = "select p.idpersona,p.nombre,p.apaterno,p.amaterno,p.tipo_documento,p.num_documento,p.direccion,p.telefono,p.email,c.codigo_cliente from persona p inner join cliente c on p.idpersona = c.idpersona where num_documento like '%" + Buscar + "%' order by idpersona desc";

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
                registro[9] = rs.getString("codigo_cliente");

                TotalRegistros = TotalRegistros + 1;

                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean Insertar(VCliente cliente) {

        sSql = "INSERT INTO persona(nombre,apaterno,amaterno,"
                + "tipo_documento,num_documento,direccion,telefono,email) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        sSql2 = "INSERT INTO cliente(idpersona,codigo_cliente)"
                + "VALUES ((select idpersona from persona order by idpersona desc limit 1),?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            PreparedStatement pst2 = cn.prepareStatement(sSql2);

            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApaterno());
            pst.setString(3, cliente.getAmaterno());
            pst.setString(4, cliente.getTipo_documento());
            pst.setString(5, cliente.getNum_documento());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());

            pst2.setString(1, cliente.getCodigoCliente());

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

    public boolean Editar(VCliente cliente) 
    {
        sSql = "UPDATE persona SET  nombre = ?,amaterno = ?,apaterno = ?,"
                + "tipo_documento = ?, num_documento = ?, direccion = ?, telefono = ?,"
                + "email = ? WHERE idpersona = ? ";
        
        sSql2 = "UPDATE cliente SET  codigo_cliente = ?"
                + "WHERE idpersona = ? ";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            PreparedStatement pst2 = cn.prepareStatement(sSql2);

            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApaterno());
            pst.setString(3, cliente.getAmaterno());
            pst.setString(4, cliente.getTipo_documento());
            pst.setString(5, cliente.getNum_documento());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());
            pst.setInt(9, cliente.getIdpersona());

            pst2.setString(1, cliente.getCodigoCliente());
            pst2.setInt(2, cliente.getIdpersona());

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

    public boolean Eliminar(VCliente cliente) 
    {
        //primero elimino un cliente y .uego elimino una persona, por la relación:
        sSql = "DELETE FROM  cliente  WHERE idpersona = ?";
        sSql2 = "DELETE FROM  persona  WHERE idpersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);
            PreparedStatement pst2 = cn.prepareStatement(sSql2);

            
            pst.setInt(1, cliente.getIdpersona());

           
            pst2.setInt(1, cliente.getIdpersona());

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
}
