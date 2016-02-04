/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0663715
 */
package jbosswildfly;
import java.sql.*;
import javax.json.JsonArray;
import javax.json.JsonObject;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;



public class Jbosswildfly {
    
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found exception! " +
                e.getMessage());
        }
       
        String host = System.getenv("IPRO");
        String port = System.getenv("3306");
        String name = "jbosswildfly";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
        String username = System.getenv("adminMqKc7Sm");
        String password = System.getenv("nCsgkE2kaN3e");
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
   }
    
    public static String getJSON() {
        String output = "";
        try {
            JsonArray arr = new JsonArray();
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM people");
            while (rs.next()) {
                JsonObject obj = new JsonObject();
                obj.addProperty("id", rs.getInt("id"));
                obj.addProperty("name", rs.getString("name"));
                obj.addProperty("bio", rs.getString("bio"));
                arr.add(obj);
            }
            output = arr.toString();
            conn.close();
        } catch (SQLException ex) {
            output = "SQL Exception Error: " + ex.getMessage();
        }
        return output;
    }
    
    public static String getJSON(int id) {
        String output = "";
        try {
            JsonArray arr = new JsonArray();
            Connection conn = getConnection();
            String query = "SELECT * FROM people WHERE id = 1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JsonObject obj = new JsonObject();
                obj.addProperty("id", rs.getInt("id"));
                obj.addProperty("name", rs.getString("name"));
                obj.addProperty("bio", rs.getString("bio"));
                arr.add(obj);
            }
            output = arr.toString();
            conn.close();
        } catch (SQLException ex) {
            output = "SQL Exception Error: " + ex.getMessage();
        }
        return output;
    }



    
}
     
    
    
    
   
        
        
    