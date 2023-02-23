/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interfaces.UserInterface;
import Model.User;
import Util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kanza
 */
public class UserService implements UserInterface {
        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
     public User Userinsert(User u){
         
    try {
    PreparedStatement a1 = cnx.prepareStatement("INSERT INTO `user`(`username`, `password`,`type`) VALUES (?,?,?)");
    ResultSet rs = a1.executeQuery();
    a1.setString(1, u.getUsername());
    a1.setString(2, u.getPassword());
    a1.setString(3, u.getType());
    a1.executeUpdate();
        System.out.println("0000");
     } catch (SQLException ex) {
        ex.printStackTrace();
      }
    return u;
     }
     /*if (user.getType()!="admin") {
            user.setUsername(p.getUsername());
            user.setPassword(p.getPassword());
            user.setType("admin");
            System.out.println("u re not an admin");*/
     
     
     
      public int authentification(String login, String password){
       int i=0 ;
        try {
    PreparedStatement a1 = cnx.prepareStatement("SELECT * FROM user");
            ResultSet rs=a1.executeQuery();
            while(rs.next()){
                if (login.equals(rs.getString("username"))== false){
                    i= -1;  
                }
                else{
                    i=1;
                    break;
                }
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
          if (i==-1){
                    System.out.print("verify your info");
                }
                else{
                    i=1;
                     System.out.print("user authentifié avec succés");
                }
       
      return i ;     
   }
     
}
