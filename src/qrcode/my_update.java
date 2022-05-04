/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qrcode;

/**
 *
 * @author WIN10
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class my_update{

    private String name;
    private String slno;
	
void  my_db_update(String slno,String name) {
try{  
	Class.forName("com.mysql.cj.jdbc.Driver");  
	// database is my_tutorial, userid =root, password //
       // Update your usrid, password and database name // 	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qrdata","root", "6609");
	Statement st=con.createStatement();  
	// Adding record 
	String query1="INSERT INTO `qrdata`.`list`"
	 + " (`sl_no`, `name`)"
	 + "VALUES('" +slno+"','"+name+"')";
	st.executeUpdate(query1); // record added. 
	
	con.close();  
	
}catch(Exception e){ System.out.println(e);} 
	//////////////////////////////
}

    void my_db_update(String path) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
