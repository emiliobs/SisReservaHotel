
package Logica;

import Datos.VHabitacion;
import Datos.VProducto;
import Datos.VReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FReserva 
{
     private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSql = " ";
    public  int TotalRegistros;
    
    ////SELECT `idproducto`, `nombre`, `descripcion`, `unidad_medida`, `precio_venta` FROM `producto` WHERE 1
    public DefaultTableModel Mostrar(String Buscar)
    {
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","IdHabitación", "Número","iCliente","Cliente",
                             "IdTrabajador","Trabajador","Tipo Reserva","Fecha Reserva",
                              "Fecha Ingreso","Fecha Salida","Costo Alojamiento","Estado" 
                            };
        
        String [] registro = new String[13];
        
       TotalRegistros = 0;
       
       modelo = new DefaultTableModel(null, titulos);
       
       sSql = "select r.idreserva,r.idhabitacion,h.numero,r.idcliente,"+
              "(select nombre from persona where idpersona = r.idcliente) as NombreCliente,"+
              "(select apaterno from persona where idpersona = r.idcliente) as ApellidoCliente,"+
              "r.idtrabajador,(select nombre from persona where idpersona = r.idtrabajador) as NombreTrabjador,"+
              "(select apaterno from persona where idpersona = r.idtrabajador) as ApellidoTrabajador,"+
              "r.tipo_reserva,r.fecha_reserva,r.fecha_ingreso,r.fecha_salida,"+
              "r.costo_alojamiento,r.estado from reserva r inner join habitacion h on r.idhabitacion = r.idhabitacion where r.fecha_reserva like '%"+ Buscar + "%' order by idreserva desc";
       
        try 
        {
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(sSql);
           
            while (rs.next())
            {      

               registro[0] = rs.getString("Idreserva");
               registro[1] = rs.getString("idhabitacion");
               registro[2] = rs.getString("numero");
               registro[3] = rs.getString("idcliente");
               registro[4] = rs.getString("NombreCliente") + " " + rs.getString("ApellidoCliente");
               registro[5] = rs.getString("idtrabajador");
               registro[6] = rs.getString("NombreTrabjador") + " " + rs.getString("ApellidoTrabajador");
               registro[7] = rs.getString("tipo_reserva");
               registro[8] = rs.getString("fecha_reserva");
               registro[9] = rs.getString("fecha_ingreso");
               registro[10] = rs.getString("fecha_salida");
               registro[11] = rs.getString("costo_alojamiento");
               registro[12] = rs.getString("estado");
               
               
               TotalRegistros = TotalRegistros + 1 ;
               
               modelo.addRow(registro);
            }
            
            return modelo;
        }
        catch (Exception e) 
        {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
       
    }
    
    public boolean Insertar (VReserva datos)
    {
       
            sSql = "INSERT INTO reserva(idreserva,idhabitacion,idcliente,idtrabajador,"+
                 "tipo_reserva,fecha_reserva,fecha_ingresa,fecha_salida,costo_alojamiento,estado) VALUE(?,?,?,?,?,?,?,?,?)";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            pst.setInt(1, datos.getIdHabitacion());
            pst.setInt(2, datos.getIdCliente());
            pst.setInt(3, datos.getIdTrabajador());
            pst.setString(4, datos.getTipoRserva());
            pst.setDate(5, datos.getFechaReserva());
            pst.setDate(6, datos.getFechaIngreso());
            pst.setDate(7, datos.getFechaSalida());
            pst.setDouble(8, datos.getCostoAlojamiento());
            pst.setString(9, datos.getEstado());
                       
            int n = pst.executeUpdate();
            
            if (n != 0) 
            {
                return true;
            }
            else
            {
                return false;
            }
        } 
        catch (Exception e) 
        {
           JOptionPane.showConfirmDialog(null, e);
           
           return false;
        }
    }
    
    public boolean Editar (VProducto producto)
    {
        sSql = "UPDATE producto SET  nombre = ?,descripcion = ?,unidad_medida = ?,"
             + "precio_venta = ? WHERE idproducto = ? ";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getDescripcion());
            pst.setString(3, producto.getUnidadMedida());
            pst.setDouble(4, producto.getPrecioVenta());
            pst.setInt(5, producto.getIdProducto());
            
            
            int n = pst.executeUpdate();
            
            if (n != 0) 
            {
                return true;
            }
            else
            {
                return false;
            }
        } 
        catch (Exception e) 
        {
           JOptionPane.showConfirmDialog(null, e);
           
           return false;
        }
    }
    
    public boolean Eliminar (VProducto producto)
    {
        sSql="DELETE FROM  producto  WHERE idproducto = ?";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            
            pst.setInt(1, producto.getIdProducto());
            
            int n = pst.executeUpdate();
            
            if (n != 0) 
            {
                return true;
            }
            else
            {
                return false;
            }
        } 
        catch (Exception e) 
        {
           JOptionPane.showConfirmDialog(null, e);
           return false;
        }
    }
}
