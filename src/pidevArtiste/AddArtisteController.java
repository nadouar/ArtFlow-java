/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevArtiste;

import Interfaces.ArtisteInterface;
import Model.Artiste;
import Service.ArtisteService;
import Util.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class AddArtisteController implements Initializable {
        Connection cnx = MyConnection.getInstance().getCnx();

    ArtisteInterface artiste = new ArtisteService();
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField email;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField adress;
    @FXML
    private TextField description;
    @FXML
    private TextField birthdate;
    @FXML
    private TextField birthplace;
    @FXML
    private TextField lastname;
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private Button image;
    @FXML
    private Button AddArtiste;
    private File selectedFile;

    private FileChooser filechooser;
    private File file;
    private Stage stage;
    @FXML
    private AnchorPane ancorepane;
    private ImageView imageView;
    
    private Image imagee;
    @FXML
    private TextField imagefield;
    @FXML
    private ImageView image_view;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filechooser = new FileChooser();
        //filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image", "*.*")
        //);
    }    

    @FXML
    private void saveArtiste(ActionEvent event) throws IOException {                
        Artiste c = new Artiste();
    
        if (firstname.getText().length() == 0||lastname.getText().length() == 0||birthplace.getText() == null||birthdate.getText().length() == 0||description.getText().length() == 0||imagefield.getText()==null||adress.getText()==null||phonenumber.getText()==null||email.getText()==null||username.getText()==null||password.getText()==null) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("Please check your empty fields"+ "");
            alert.show();

        } else if(!phonenumber.getText().matches("\\d{8}")){
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("your phone number has to contain 8 caracter"+ "");
            alert.show();
          
          }else {
            
        c.setFirstname(firstname.getText());
        c.setLastname(lastname.getText());        
        c.setBirthplace(birthplace.getText());
        c.setBirthdate(birthdate.getText());
        c.setDescription(description.getText());
        c.setImage(imagefield.getText());
        c.setAddress(adress.getText());
        c.setPhonenumber(phonenumber.getText());
        c.setEmail(email.getText());
        c.setUsername(username.getText());
        c.setPassword(password.getText());
        
         String htdocsPath = "";
                 File destinationFile = new File(htdocsPath + imagefield.getText());
            if(selectedFile!=null){
                try (InputStream in = new FileInputStream(selectedFile);
                 OutputStream out = new FileOutputStream(destinationFile)) {
                byte[] buf = new byte[8192];
                int length;
                while ((length = in.read(buf)) > 0) {
                    out.write(buf, 0, length);
                }
        
        artiste.saveArtiste(c);
        FXMLLoader loader= new FXMLLoader(getClass().getResource("AddArtiste.fxml"));
        Parent view_2=loader.load();
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                }else{
                System.out.println("selected file is null "+selectedFile);
            }
        }
        
    }

    @FXML
    private void takeimage(ActionEvent event) {
//        FileChooser fc = new FileChooser();
//           fc.getExtensionFilters().addAll(
//            new ExtensionFilter("Image Files","*.png"));
//           File selectedFile = fc.showOpenDialog(null);
//           if(selectedFile != null) {
//               imagefield.setText(selectedFile.getAbsolutePath());
//           } else {
//               System.err.println("file is not valid");
//           }

            FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.JPG", "*.gif"));
          fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);
         if (selectedFile != null) {
                imagefield.setText(selectedFile.getName());
                 try {
                Image images = new Image("file:"+selectedFile.getPath().toString());
                image_view.setImage(images);
                System.out.println(selectedFile.getPath().toString());
        } catch (Exception ex) {
                     System.out.println(ex);
        }
                
            }
    }}
    
    

