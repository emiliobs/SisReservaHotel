
package Logica;

import Datos.VHabitacion;
import Datos.VProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datos.Vpago;


public class FPago 
{
     private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSql = " ";
    public  int TotalRegistros;
    
 
    public DefaultTableModel Mostrar(String Buscar)
    {
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Id Reserva", "Tipo Comprobante", "Número Comprobante",
                             "Igv","Total Pago", "Fecha Emisión", "Fecha Pago"
                            };
        
        String [] registro = new String[8];
        
       TotalRegistros = 0;
       
       modelo = new DefaultTableModel(null, titulos);
       
       sSql = "select * from pago where idreserva="+ Buscar +" order by idpago desc";
       
        try 
        {
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(sSql);
           
            while (rs.next())
            {      

               registro[0] = rs.getString("idpago");
               registro[1] = rs.getString("idreserva");
               registro[2] = rs.getString("tipo_comprobante");
               registro[3] = rs.getString("num_comprobante");
               registro[4] = rs.getString("igv");
               registro[5] = rs.getString("total_pago");
               registro[6] = rs.getString("fecha_emision");
               registro[7] = rs.getString("fecha_pago");
               
               
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
    
    public boolean Insertar (Vpago datos)
    {
       
            sSql = "INSERT INTO pago(idreserva, tipo_comprobante,"
                 + "num_comprobante, igv, total_pago,fecha_emision,fecha_pago) "
                 + "VALUES (?,?,?,?,?,?,?)";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            pst.setInt(1, datos.getIdReserva());
            pst.setString(2, datos.getTipoComprobante());
            pst.setString(3, datos.getNumeroComprobante());
            pst.setDouble(4, datos.getIgv());
            pst.setDouble(5, datos.getTotalPago());
            pst.setDate(6, datos.getFechaEmision());
            pst.setDate(7, datos.getFechaPago());
                       
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
    
    public boolean Editar (Vpago datos)
    {
        sSql = "UPDATE pago SET  idreserva = ?,tipo_comprobante = ?,num_comprobante = ?,"
             + "igv = ?, total_pago = ?, fecha_emision = ?, fecha_pago = ?  WHERE idpago = ? ";
        
        try 
        {
           PreparedStatement pst = cn.prepareStatement(sSql);
            pst.setInt(1, datos.getIdReserva());
            pst.setString(2, datos.getTipoComprobante());
            pst.setString(3, datos.getNumeroComprobante());
            pst.setDouble(4, datos.getIgv());
            pst.setDouble(5, datos.getTotalPago());
            pst.setDate(6, datos.getFechaEmision());
            pst.setDate(7, datos.getFechaPago());
            
            pst.setInt(8, datos.getIdPago());
            
            
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
    
    public boolean Eliminar (Vpago datos)
    {
        sSql="DELETE FROM  pago  WHERE idpago = ?";
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement(sSql);
            
            pst.setInt(1, datos.getIdPago());
            
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
