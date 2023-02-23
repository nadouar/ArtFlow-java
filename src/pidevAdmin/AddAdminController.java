/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAdmin;

import Interfaces.AdminInterface;
import Model.Admin;
import Service.AdminService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class AddAdminController implements Initializable {
    
    AdminInterface admin =new AdminService();
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private TextField lastname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveAdmin(ActionEvent event) {
        Admin c = new Admin();
        c.setFirstname(firstname.getText());
        c.setLastname(lastname.getText());
        c.setPhoneNumber(phoneNumber.getText());
        c.setEmail(email.getText());
        c.setUsername(username.getText());
        c.setPassword(password.getText());
        admin.saveAdmin(c);
    }
    
}
