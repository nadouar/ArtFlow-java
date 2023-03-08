/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthAdmin;

import Model.Client;
import Service.ClientService;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class ListClientController implements Initializable {
 ClientService client = new ClientService();
 
    private ListView<Client> listClient;
    @FXML
    private TextField searchField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
//        System.out.println(client.fetchClient());
//      List<Client>  clients = client.fetchClient();
//     ObservableList<Client> e = FXCollections.observableArrayList(clients);
//     listClient.setItems(e);
     /*e.addAll(client.fetchClient());
        
             listClient.setItems(e);*/
            affichlistclient ();

    }    

    private void affichlistclient (){
         List<Client>  clients = client.fetchClient();
     ObservableList<Client> e = FXCollections.observableArrayList(clients);
     listClient.setItems(e);
    
    }
    @FXML
    private void Artistlist(ActionEvent event) {
    }

    @FXML
    private void Clientlist(ActionEvent event) {
    }

    @FXML
    private void Settings(ActionEvent event) {
    }

    @FXML
    private void searchClientbyUsername(ActionEvent event) {
       // String searchWords = searchField.getText();
        
        
    }
    
//     private List<Client> searchClients(String searchWords, List<Client> listOfClients) {
//
//    List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
//
//    return listOfClients.stream().filter(client -> {
//        return searchWordsArray.stream().allMatch(word ->
//                client.getUsername().toLowerCase().contains(word.toLowerCase())
//                
//                );
//    }).collect(Collectors.toList());
//}

    
}
