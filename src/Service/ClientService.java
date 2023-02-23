/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interfaces.ClientInterface;
import Model.Client;
import Model.User;
import Util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author kanza
 */
public class ClientService implements ClientInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

        public boolean exists(String username) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM client");
    ResultSet rs = a.executeQuery();
     while (rs.next()) {
        if (username.equals(rs.getString("username"))) {
            System.out.println("this user already exists");
            return true;
        }
    }
    return false;

}
    
        public boolean isValidEmail(String email) throws SQLException {
       String em ="^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM Client");
    ResultSet rs = a.executeQuery();
     while (rs.next()) {
        Pattern pattern = Pattern.compile(em);
    return pattern.matcher(email).matches();
    }
    return false;

}
    public boolean validphonenumber(String phonenumber) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM client");
    ResultSet rs = a.executeQuery();
    String cutString = phonenumber.substring(0, 8);
     while (rs.next()) {
        if (phonenumber!=cutString) {
            System.out.println("coorect your phonenb");
            return true;
        }
    }
    return false;

}
  
    @Override
    public Client saveClient(Client p) {
        String email= p.getEmail();
        
        
        try {
            if(exists(p.getUsername())!=true){
                if(isValidEmail(email)){
                if(validphonenumber(p.getPhonenumber())!=true){
            try {
            PreparedStatement a = cnx.prepareStatement( "INSERT INTO `client`(`firstname`, `lastname`,`address`, `phonenumber`,`email`,`username`, `password`) VALUES (?,?,?,?,?,?,?)");
            String password = p.getPassword();
            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getAddress());
            a.setString(4, p.getPhonenumber());
            a.setString(5, p.getEmail());
            a.setString(6, p.getUsername());
            a.setString(7,encryptedPassword);
            a.executeUpdate();
            System.out.println("client Added successfully!");
         } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }}
            } 
        }catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;    }

    @Override
    public List<Client> fetchClient() {
        List<Client> client = new ArrayList<>();
        try {
            String req = "SELECT * FROM client";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Client p = new Client();
                p.setId(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setAddress(rs.getString("address"));
                p.setPhonenumber(rs.getString("phoneNumber"));
                p.setEmail(rs.getString("email"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));

                client.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return client;
    }

    @Override
    public Client getClient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateClient(Client p) {
        try {
            String req =  "UPDATE `client` SET `firstname`=?,`lastname`=?,`address`=?,`phonenumber`=?,`email`=?,`username`=?,`password`=? WHERE `id`=?";
            PreparedStatement a = cnx.prepareStatement(req);
            String password = p.getPassword();
            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());            
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getAddress());
            a.setString(4, p.getPhonenumber());
            a.setString(5, p.getEmail());
            a.setString(6, p.getUsername());
            a.setString(7, encryptedPassword);
            a.setInt(8, p.getId());
            a.executeUpdate();
            System.out.println("client modified successfully!");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void deleteClient(int id) {
try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `client` WHERE id=?");
            
            a.setInt(1, id);
            a.executeUpdate();
            System.out.println("client deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
