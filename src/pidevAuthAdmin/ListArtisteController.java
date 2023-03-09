/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthAdmin;

import Model.Artiste;
import Model.Client;
import Service.ArtisteService;
import java.io.IOException;
import java.net.URL;
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
public class ListArtisteController implements Initializable {
    
    ArtisteService artiste = new ArtisteService();
    @FXML
    private TextField searchField;
    @FXML
    private ListView<Artiste> listArtiste;
    ObservableList<Artiste> e;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Artiste> artistes = artiste.fetchArtiste();
     ObservableList<Artiste> e = FXCollections.observableArrayList(artistes);
     listArtiste.setItems(e);
    }    

    @FXML
    private void Artistlist(ActionEvent event) {
    }

    @FXML
    private void Clientlist(ActionEvent event) throws IOException {
        FXMLLoader loader;
       loader= new FXMLLoader(getClass().getResource("ListClient.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
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
    private void Logout(ActionEvent event) throws IOException {
         FXMLLoader loader;
       loader= new FXMLLoader(getClass().getResource("LoginAdmin.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }
    private List<Artiste> searchList(String searchWords, List<Artiste> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split("\n"));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.getUsername().toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }

    @FXML
    private void searchArtistebyUsername(ActionEvent event) {
         listArtiste.getItems().clear();
        List<Artiste>  artistes = artiste.recherche(searchField.getText());
        ObservableList<Artiste> e = FXCollections.observableArrayList(artistes);
        listArtiste.setItems(e);
        
    }
    
}
