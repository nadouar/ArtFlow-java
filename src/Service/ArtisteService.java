/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interfaces.ArtisteInterface;
import Model.Artiste;
import Model.User;
import Util.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class ArtisteService implements ArtisteInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
    public boolean exists(String username) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM artiste");
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
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM artiste");
    ResultSet rs = a.executeQuery();
     while (rs.next()) {
        Pattern pattern = Pattern.compile(em);
    return pattern.matcher(email).matches();
    }
    return false;

}
    public boolean validphonenumber(String phonenumber) throws SQLException {
    
    PreparedStatement a = cnx.prepareStatement("SELECT * FROM artiste");
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

    
    @Override
    public Artiste saveArtiste(Artiste p) {
        String email= p.getEmail();
        
        try {
            if(exists(p.getUsername())!=true){
                if(isValidEmail(email)){
                if(validphonenumber(p.getPhonenumber())!=true){
                   
        try {
            PreparedStatement a = cnx.prepareStatement( "INSERT INTO `artiste`(`firstname`, `lastname`,`birthplace`,`birthdate`,`description`,`image`,`address`, `phonenumber`,`email`, `username`, `password`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            String password = p.getPassword();
            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            //FileInputStream imagefile= new FileInputStream(p.getImage());
           // fls= new FileInputStream(file);
            //byte[] image =new byte[imagefile.available()];
            //imagefile.read(image);
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getBirthplace());
            a.setString(4, p.getBirthdate());
            a.setString(5, p.getDescription());
            a.setString(6, p.getImage());
            a.setString(7, p.getAddress());
            a.setString(8, p.getPhonenumber());
            a.setString(9, p.getEmail());
            a.setString(10, p.getUsername());
            a.setString(11, encryptedPassword);
            a.executeUpdate();
           System.out.println("artiste Added successfully!");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }}
            } 
        }catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Artiste> fetchArtiste() {
          List<Artiste> artiste = new ArrayList<>();
          
        try {
            String req = "SELECT * FROM artiste";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Artiste p = new Artiste();
                p.setId(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setBirthplace(rs.getString("birthplace"));
                p.setBirthdate(rs.getString("birthdate"));
                p.setDescription(rs.getString("description"));
                p.setImage(rs.getString("image"));
                p.setAddress(rs.getString("address"));
                p.setPhonenumber(rs.getString("phoneNumber"));
                p.setEmail(rs.getString("email"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));

                artiste.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return artiste;
    }

    @Override
    public Artiste getArtiste(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateArtiste(Artiste p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "UPDATE `artiste` SET `firstname`=?,`lastname`=?,`birthplace`=?,`birthdate`=?,`description`=?,`image`=?,`address`=?,`phoneNumber`=?,`email`=?,`username`=?,`password`=? WHERE `id_artiste`=?");
            String password = p.getPassword();
            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getBirthplace());
            a.setString(4, p.getBirthdate());
            a.setString(5, p.getDescription());
            a.setString(6, p.getImage());
            a.setString(7, p.getAddress());
            a.setString(8, p.getPhonenumber());
            a.setString(9, p.getEmail());
            a.setString(10, p.getUsername());
            a.setString(11, encryptedPassword);

            a.setInt(12, p.getId());


            a.executeUpdate();
            System.out.println("artiste modified successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteArtiste(int id) {
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `artiste` WHERE id_artiste=?");
            
            a.setInt(1, id);
            a.executeUpdate();
            System.out.println("artiste deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}