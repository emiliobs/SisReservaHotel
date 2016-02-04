
package Logica;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion
{
    public  String db = "basereserva";
    public  String url = "jdbc:mysql://127.0.0.1:3306/" + db;
    public  String user = "root";
    public  String password = "Emilio55";
    
    public  Conexion()
    {
        
    }
    
    public Connection conectar()
    {
        Connection link = null;
        
        try 
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            
            link = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } 
        catch (ClassNotFoundException |  SQLException e) 
        {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        
        return link;
    }
}
