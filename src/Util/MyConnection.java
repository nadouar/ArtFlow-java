/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kanza
 */
public class MyConnection {
     //DB PARAM
    static final String URL ="jdbc:mysql://localhost:3306/artflow1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER ="root";
    static final String PASSWORD ="";
    
    //var
    private Connection cnx;
    //1
    static MyConnection instance;
    
    //const
    //2
    public MyConnection(){
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connected successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
   

    //3
    public static MyConnection getInstance() {
        if(instance == null)
            instance = new MyConnection();
        
        return instance;
    }
    
    public Connection getCnx() {
        return cnx;
    }
    
}
