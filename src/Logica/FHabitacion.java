
package Logica;

import Datos.VHabitacion;
import  Logica.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.management.resource.internal.TotalResourceContext;


public class FHabitacion 
{
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSql = " ";
    public  int TotalRegistros;
    
    public DefaultTableModel Mostrar(String Buscar)
    {
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","piso", "Número", "Descripción", "Caracteristicas", 
                             "Precio", "Estado", "Tipo Habitación"};
        
        String [] registro = new String[8];
        
       TotalRegistros =0;
       
       modelo = new DefaultTableModel(null, titulos);
       
       sSql = "select * from habitacion where piso like '%"+ Buscar + "%' order by idhabitacion";
       
        try 
        {
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(sSql);
           
            while (rs.next())
            {      

               registro[0] = rs.getString("idhabitacion");
               registro[1] = rs.getString("piso");
               registro[2] = rs.getString("numero");
               registro[3] = rs.getString("descripcion");
               registro[4] = rs.getString("caracteristicas");
               registro[5] = rs.getString("precio_diario");
               registro[6] = rs.getString("estado");
               registro[7] = rs.getString("tipo_habitacion");
               
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
    
    public DefaultTableModel MostrarVistaHabitacion(String Buscar)
    {
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","piso", "Número", "Descripción", "Caracteristicas", 
                             "Precio", "Estado", "Tipo Habitación"};
        
        String [] registro = new String[8];
        
       TotalRegistros =0;
       
       modelo = new DefaultTableModel(null, titulos);
       
       sSql = "select * from habitacion where piso like '%"+ Buscar + "%' and estado = 'Disponible' order by idhabitacion";
       
        try 
        {
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(sSql);
           
            while (rs.next())
            {      

               registro[0] = rs.getString("idhabitacion");
               registro[1] = rs.getString("numero");
               registro[2] = rs.getString("piso");
               registro[3] = rs.getString("descripcion");
               registro[4] = rs.getString("caracteristicas");
               registro[5] = rs.getString("precio_diario");
               registro[6] = rs.getString("estado");
               registro[7] = rs.getString("tipo_habitacion");
               
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
    
    public boolean Insertar (VHabitacion havitacion)
    {
       
            sSql = "INSERT INTO habitacion (numero, piso, descripcion,"
             + "caracteristicas,precio_diario,estado,tipo_habitacion) "
             + "VALUES (?,?,?,?,?,?,?)";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            pst.setString(1, havitacion.getNumero());
            pst.setString(2, havitacion.getPiso());
            pst.setString(3, havitacion.getDescripcion());
            pst.setString(4, havitacion.getCaracteristicas());
            pst.setDouble(5, havitacion.getPrecioDiario());
            pst.setString(6, havitacion.getEstado());
            pst.setString(7, havitacion.getTipoHabitacion());
            
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
    
    public boolean Editar (VHabitacion havitacion)
    {
        sSql = "UPDATE habitacion SET  numero = ?,"
             + "piso = ?,descripcion = ?, caracteristicas = ?,"
             + " precio_diario = ?, estado = ?, tipo_habitacion = ?"
             + "WHERE idhabitacion = ? ";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            pst.setString(1, havitacion.getNumero());
            pst.setString(2, havitacion.getPiso());
            pst.setString(3, havitacion.getDescripcion());
            pst.setString(4, havitacion.getCaracteristicas());
            pst.setDouble(5, havitacion.getPrecioDiario());
            pst.setString(6, havitacion.getEstado());
            pst.setString(7, havitacion.getTipoHabitacion());
            pst.setInt(8, havitacion.getIdHabitacion());
            
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
    
    public boolean Eliminar (VHabitacion havitacion)
    {
        sSql="DELETE FROM  habitacion  WHERE idhabitacion = ?";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            
            pst.setInt(1, havitacion.getIdHabitacion());
            
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
    
    public boolean Desocupar (VHabitacion havitacion)
    {
        sSql = "UPDATE habitacion set estado='Disponible' WHERE idhabitacion=?";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            
            pst.setInt(1, havitacion.getIdHabitacion());
            
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
    
    public boolean Ocupar (VHabitacion havitacion)
    {
        sSql = "UPDATE habitacion set estado='Ocupado' WHERE idhabitacion=?";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            
            pst.setInt(1, havitacion.getIdHabitacion());
            
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
