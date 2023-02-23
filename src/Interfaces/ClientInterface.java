/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Model.Client;
import java.util.List;

/**
 *
 * @author kanza
 */
public interface ClientInterface {
    public Client saveClient(Client p);
    public List<Client> fetchClient();
    public Client getClient(int id);
    public void updateClient(Client p);
    public void deleteClient(int id);
    
}
