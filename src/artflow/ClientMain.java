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
import Model.Client;
import Service.ArtisteService;
import Service.ClientService;
import Util.MyConnection;

/**
 *
 * @author kanza
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// singleton
        /*MyConnection m1 = MyConnection.getInstance(); 
        m1.getCnx();
        MyConnection m2 = MyConnection.getInstance(); 
        m2.getCnx();*/
                ClientService as= new ClientService();
                
                
                //add 
       //Client p = as.saveClient(new Client("nada","kanzari","tunis","12345678","kanzarinadak@gmail.com","nada","nada"));
         
         
          //affichage
        // System.out.println(as.getClientbyusername("nada"));
        
        System.out.println(as.recherche("nada"));
         
                //update 
//                Client p=new Client();
//                
//                p.setFirstname("emna");
//                p.setLastname("cheniti");
//                p.setAddress("mourouj");
//                p.setEmail("emna@gmail.com");
//                p.setPhonenumber("87654321");
//                p.setUsername("nada1");
//                p.setPassword("amna");
//                as.updateClient(p);
                

//        
         
         //delete admin
        // as.deleteClient("nada1");
         
    }
    
}
