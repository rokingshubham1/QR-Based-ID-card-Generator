/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qrcode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author WIN10
 */
class DBConnection {        
	public static Connection getConnection(){          
		Connection connection=null;                      
		System.out.println("Connection called");                  
		try {                                                                  
			Class.forName("com.mysql.cj.jdbc.Driver");              
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qrdata","root", "6609");
		}
                catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
