/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artflow;

/**
 *
 * @author kanza
 */
import Model.Artiste;
import Service.AdminService;
import Service.ArtisteService;
import Util.MyConnection;
import java.util.Scanner;

/**
 *
 * @author kanza
 */
public class ArtisteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*// singleton
        MyConnection m1 = MyConnection.getInstance(); 
        m1.getCnx();
        MyConnection m2 = MyConnection.getInstance(); 
        m2.getCnx();*/
//        
                ArtisteService as= new ArtisteService();
//                
//                //update 
//                Artiste p=new Artiste();
//                p.setId(3);
//                p.setFirstname("mouhamed");
//                p.setLastname("miaoui");
//                p.setBirthplace("tunis");
//                p.setBirthdate("11/01/2022");
//                p.setDescription("artiste");
//                p.setImage("C:/Users/kanza/OneDrive/Bureau/logo.png");
//                p.setAddress("tunis");
//                p.setPhonenumber("12356874");
//                p.setUsername("md");
//                p.setPassword("md");
//                p.setEmail("md@gmail.com");
//
//                as.updateArtiste(p);

        //add 
         //Artiste p = as.saveArtiste(new Artiste("nada","kanzari","tunis","11/01/2022","artiste","logo.png","tunis","12356874","o","nada","nada@fgmailcom"));
         
         
         //affichage
        System.out.println(as.fetchArtiste());
        
        
        
         //delete admin
       // as.deleteArtiste(0);
         
    }
    
}

