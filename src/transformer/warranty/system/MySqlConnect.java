/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jatin
 */
public class MySqlConnect {
    public Connection sqlcon(Connection conn){
        
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		
	}
        Statement stmt= null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transrec","Zebra", "zebra12138");
           /* stmt = conn.createStatement();
            String createtb = "CREATE TABLE mailsender(email_id_sender varchar(30) NOT NULL ,password_sender varchar(50) NOT NULL ,PRIMARY KEY(email_id_sender))";
            stmt.executeUpdate(createtb);
            System.out.println("table created");*/
            /*MD5Generator md5pass = new MD5Generator();
            String generatedpass = md5pass.passwordgenerator("transrec12138");
            String email = "zebrahelp@gmail.com";
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO mailsender VALUES('"+email+"','"+generatedpass+"')");
            System.out.println("data inserted");*/
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
	/*try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transrec","Zebra", "zebra12138");
               
                stmt = conn.createStatement();
               
                              String createtb = "CREATE TABLE Transf_Details"+
                                  "(Tid VARCHAR(20) NOT NULL,"+
                                  "Purchased_date INTEGER NOT NULL,"+
                                  "Purchased_month INTEGER NOT NULL,"+
                                  "Purchased_year INTEGER NOT NULL,"+
                                  "Po_No VARCHAR(20) NOT NULL,"+
                                  "Buyer VARCHAR(30) NOT NULL,"+
                                  "Item VARCHAR(30) NOT NULL,"+
                                  "Department VARCHAR(30) NOT NULL,"+
                                  "Price DECIMAL(10, 2) NOT NULL,"+
                                  "Warranty INTEGER NOT NULL,"+
                                  "Warehouse INTEGER NOT NULL,"+
                                  "Installed_date INTEGER NULL,"+
                                  "Installed_month INTEGER NULL,"+
                                  "Installed_year INTEGER NULL,"+
                                  "PRIMARY KEY(Tid))";
                
                stmt.executeUpdate(createtb);
                System.out.println("Created");
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
          try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transrec","Zebra", "zebra12138");
               
                stmt = conn.createStatement();
               
                String createtb = "CREATE TABLE Type_of_warranty"+
                                  "(Tid VARCHAR(20) NOT NULL,"+
                                  "Warranty_month INTEGER NOT NULL,"+
                                  "Warehouse_month INTEGER NOT NULL,"+
                                  "Warranty_Days INTEGER NULL,"+
                                  "Warehouse_Days INTEGER NULL,"+
                                  "PRIMARY KEY(Tid))";
                
                stmt.executeUpdate(createtb);
                System.out.println("Created");
	} catch (SQLException e) {
		e.printStackTrace();
		
        }*/

 
	if (conn != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
        
     return(conn);
       
 }
}
