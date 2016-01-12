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
public class SQLConnect {
    public Connection sqlCon(Connection conn){
//        Connection conn2; 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("error " + ex.getMessage());
        }
             String userName = "sa";
             String password = "zebra5110";
             String url = "jdbc:sqlserver://localhost:1025;databaseName=transrec;";
             Statement stmt=null;
             try{
                 conn = DriverManager.getConnection(url, userName, password);
//                 conn2 = DriverManager.getConnection(url, userName, password);
             }
             catch (SQLException ex) {
            System.out.println("Error " +  ex.getMessage());
             }
//            try{
//             stmt = conn.createStatement();
//             String createdb = "CREATE DATABASE transrec";
//             stmt.executeUpdate(createdb);
//                 System.out.println("CReated");
//             }
//             catch (SQLException ex) {
//            System.out.println("Error " +  ex.getMessage());
//             }
//        try {
//          
//            stmt = conn.createStatement();
//               
//                              String createtb = "CREATE TABLE Transf_Details"+
//                                  "(Tid VARCHAR(60) NOT NULL,"+
//                                  "Purchased_date INTEGER NOT NULL,"+
//                                  "Purchased_month INTEGER NOT NULL,"+
//                                  "Purchased_year INTEGER NOT NULL,"+
//                                  "Po_No VARCHAR(60) NOT NULL,"+
//                                  "Buyer VARCHAR(30) NOT NULL,"+
//                                  "Item VARCHAR(30) NOT NULL,"+
//                                  "Department VARCHAR(30) NOT NULL,"+
//                                  "Price DECIMAL(10, 2) NOT NULL,"+
//                                  "Warranty INTEGER NOT NULL,"+
//                                  "Warehouse INTEGER NOT NULL,"+
//                                  "Installed_date INTEGER NULL,"+
//                                  "Installed_month INTEGER NULL,"+
//                                  "Installed_year INTEGER NULL,"+
//                                  "PRIMARY KEY(Tid))";
//                
//                stmt.executeUpdate(createtb);
//                System.out.println("Created");
//        } catch (SQLException ex) {
//            System.out.println("Error " +  ex.getMessage());
//        }
//             try {
//            //conn = DriverManager.getConnection(url, userName, password);
//           stmt = conn.createStatement();
//               
//                String createtb1 = "CREATE TABLE Type_of_warranty"+
//                                  "(Tid VARCHAR(20) NOT NULL,"+
//                                  "Warranty_month INTEGER NOT NULL,"+
//                                  "Warehouse_month INTEGER NOT NULL,"+
//                                  "Warranty_Days INTEGER NULL,"+
//                                  "Warehouse_Days INTEGER NULL,"+
//                                  "PRIMARY KEY(Tid))";
//                
//                stmt.executeUpdate(createtb1);
//                System.out.println("Created");
//        } catch (SQLException ex) {
//            System.out.println("Error " +  ex.getMessage());
//        }
//             try {
//            //conn = DriverManager.getConnection(url, userName, password);
//           stmt = conn.createStatement();
//               
//                String createtb2 = "CREATE TABLE login"+
//                        "(email_id varchar(30) not null,"+
//                        "username varchar(30) not null,"+
//                        "password varchar(50) not null,"+
//                        "account_type varchar(10) not null,"+
//                        "first_name varchar(15),"+
//                        "lastname varchar(15)"+
//                        "PRIMARY KEY(email_id))";
//                                
//                
//                stmt.executeUpdate(createtb2);
//                System.out.println("Created");
//        } catch (SQLException ex) {
//            System.out.println("Error " +  ex.getMessage());
//        }
        if (conn != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
      return(conn);
      
    }
}
