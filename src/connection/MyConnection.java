
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.io.IOException;



public class MyConnection {
    public static final String username = "root";
    public static final String password = "PFH#23kgrw9";
    public static final String url = "jdbc:mysql://localhost:3306/e_commerce";
    public static Connection con = null;
    
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ""+ex,"",JOptionPane.WARNING_MESSAGE);
            
           
        } 
        return con;
    }
    
    
}
