
package Logica;

import Datos.VHabitacion;
import Datos.VProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FProducto 
{
     private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSql = " ";
    public  int TotalRegistros;
    
    ////SELECT `idproducto`, `nombre`, `descripcion`, `unidad_medida`, `precio_venta` FROM `producto` WHERE 1
    public DefaultTableModel Mostrar(String Buscar)
    {
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Nombre", "Descripción", "Unidad de Medida",
                             "Precio de Venta"
                            };
        
        String [] registro = new String[5];
        
       TotalRegistros = 0;
       
       modelo = new DefaultTableModel(null, titulos);
       
       sSql = "select * from producto where nombre like '%"+ Buscar + "%' order by idproducto desc";
       
        try 
        {
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(sSql);
           
            while (rs.next())
            {      

               registro[0] = rs.getString("idproducto");
               registro[1] = rs.getString("nombre");
               registro[2] = rs.getString("descripcion");
               registro[3] = rs.getString("unidad_medida");
               registro[4] = rs.getString("precio_venta");
               
               
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
    
    public boolean Insertar (VProducto producto)
    {
       
            sSql = "INSERT INTO producto(nombre, descripcion,"
                 + " unidad_medida, precio_venta) "
                 + "VALUES (?,?,?,?)";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getDescripcion());
            pst.setString(3, producto.getUnidadMedida());
            pst.setDouble(4, producto.getPrecioVenta());
                       
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
