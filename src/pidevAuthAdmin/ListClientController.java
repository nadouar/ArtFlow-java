/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthAdmin;

import Model.Client;
import Service.ClientService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class ListClientController implements Initializable {
 ClientService client = new ClientService();
 @FXML
    private ListView<Client> listClient;
    @FXML
    private TextField searchField;
    
    ObservableList<Client> e;
    
    //ArrayList<Client> words = new ArrayList<>(Arrays.asList());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        //System.out.println(client.fetchClient());
//        System.out.println(client.fetchClient());

      List<Client>  clients = client.fetchClient();
     ObservableList<Client> e = FXCollections.observableArrayList(clients);
     listClient.setItems(e);

     /*e.addAll(client.fetchClient());
        
             listClient.setItems(e);*/
            //affichlistclient ();

    }    

    private void affichlistclient (){
     List<Client>  clients = client.fetchClient();
     e = FXCollections.observableArrayList(clients);
     listClient.setItems(e);
    
    }
    @FXML
    private void Artistlist(ActionEvent event) throws IOException {
         FXMLLoader loader;
       loader= new FXMLLoader(getClass().getResource("ListArtiste.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }
     

    @FXML
    private void Clientlist(ActionEvent event) {
    }

    @FXML
    private void Settings(ActionEvent event) throws IOException {
         FXMLLoader loader;
       loader= new FXMLLoader(getClass().getResource("SettingAdmin.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void searchClientbyUsername(ActionEvent event) {
        listClient.getItems().clear();
        List<Client>  clients = client.recherche(searchField.getText());
        ObservableList<Client> e = FXCollections.observableArrayList(clients);
        listClient.setItems(e);
}

    private List<Client> searchList(String searchWords, List<Client> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split("\n"));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.getUsername().toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        FXMLLoader loader;
       loader= new FXMLLoader(getClass().getResource("LoginAdmin.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }
  

    
}
