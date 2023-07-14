/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenley
 */
public class user {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/uas_pbo?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    
    
    public int checkUser(String uname, String paswd){
       try{
            Class.forName(JDBC_DRIVER);	   
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tuser WHERE nama=? AND paswd=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,paswd);
            ps.execute();
            rs = ps.executeQuery();
            int count = 0;
           while(rs.next()){
               count++;
           }
           return count;
            
       }
       catch(Exception e)
       {
           e.printStackTrace();
           return 0;
       }
}
}
