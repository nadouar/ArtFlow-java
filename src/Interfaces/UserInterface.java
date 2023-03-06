/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Model.Client;
import Model.User;
import java.util.List;

/**
 *
 * @author kanza
 */
public interface UserInterface {
        public User Userinsert (User a);
        public int authentification(User u);
        public int test(String username, String password);
        public User getUserbyusername(String username);
    public List<User> fetchUser();
        public List<User> getUserbyId(int id);
        public void UpdateUser(User p);
         public void deleteUser(String username);


}
