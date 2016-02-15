
package Logica;

import Datos.VConsumo;
import Datos.VHabitacion;
import Datos.VProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Fconsumo 
{
     private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSql = " ";
    public  int TotalRegistros;
    public  double totalConsumo;
    
    
    public DefaultTableModel Mostrar(String Buscar)
    {
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","", "Id Reserva", "Id Producto",
                             "Producto","Cantidad","Precio de Venta","Estado"
                            };
        
        String [] registro = new String[7];
        
       TotalRegistros = 0;
       totalConsumo = 0.0;
       
       modelo = new DefaultTableModel(null, titulos);
       //`idconsumo`, `idreserva`, `idproducto`, `cantidad`, `precio_venta`, `estado` FROM `consumo`
       sSql = "select c.idconsumo,c.idreserva,c.idproducto,p.nombre,c.cantidad,c.precio_venta,c.estado from consumo c inner join producto p on c.idproducto=p.idproducto where c.idreserva ="+ Buscar + " order by c.idconsumo desc";
        try 
        {
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(sSql);
           
            while (rs.next())
            {      

               registro[0] = rs.getString("idconsumo");
               registro[1] = rs.getString("idreserva");
               registro[2] = rs.getString("idproducto");
               registro[3] = rs.getString("nombre");
               registro[4] = rs.getString("cantidad");
               registro[5] = rs.getString("precio_venta");
               registro[6] = rs.getString("estado");
               
               
               TotalRegistros = TotalRegistros + 1 ;
               totalConsumo = totalConsumo + (rs.getDouble("cantidad") * rs.getDouble("precio_venta"));
               
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
    
    public boolean Insertar (VConsumo dts)
    {
       
            sSql = "insert into consumo (idreserva,idproducto,cantidad,precio_venta,estado)values (?,?,?,?,?)";
        
        try 
        {
           PreparedStatement pst=cn.prepareStatement(sSql);
           pst.setInt(1, dts.getIdreserva());
           pst.setInt(2, dts.getIdproducto());
           pst.setDouble(3, dts.getCantidad());
           pst.setDouble(4, dts.getPrecio_venta());
           pst.setString(5, dts.getEstado());
                       
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
    
    public boolean Editar (VConsumo datos)
    {
        sSql = "UPDATE consumo SET  idreserva = ?,idproducto = ?,cantidad = ?,"
             + "precio_venta = ?, estado = ? WHERE idconsumo = ? ";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            
           
            pst.setInt(1, datos.getIdreserva());
            pst.setInt(2, datos.getIdproducto());
            pst.setDouble(3, datos.getCantidad());
            pst.setDouble(4, datos.getPrecio_venta());
            pst.setString(5, datos.getEstado());
            
            pst.setInt(6, datos.getIdconsusmo());
            
            
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
    
    public boolean Eliminar (VConsumo datos)
    {
        sSql="DELETE FROM  consumo  WHERE idconsumo = ?";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            
            pst.setInt(1, datos.getIdconsusmo());
            
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
