
package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




public class userDao {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    //get user table max row
    public int getMaxRow(){
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(uid) from user");
            while(rs.next()){
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
        
    }
    //checks if email already exists
    public boolean isEmailExist(String email){
        try {
            ps = con.prepareStatement("select * from user where uemail = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //checks if phone already exists
    public boolean isPhoneExist(String phone){
        try {
            ps = con.prepareStatement("select * from user where uphone = ?");
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }
    
    //to insert data into user table
    
    public void insert(int id, String username, String email, String password, String phone,
            String secqus, String ans)
    {  
    
      String sql = "insert into user values(?, ?, ?, ?, ?, ?, ?)" ; 
      try {
          ps = con.prepareStatement(sql);
          ps.setInt(1, id);
          ps.setString(2, username);
          ps.setString(3, email);
          ps.setString(4, password);
          ps.setString(5, phone);
          ps.setString(6, secqus);
          ps.setString(7, ans);
          if(ps.executeUpdate() > 0){
              JOptionPane.showMessageDialog(null, "User added successfully");
          }
      } catch (SQLException ex) {
          Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
      
      
    }}
} 
      
   
   
       
    

    
    
    
 
