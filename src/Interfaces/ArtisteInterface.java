/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Model.Artiste;
import Model.User;
import java.util.List;

/**
 *
 * @author kanza
 */
public interface ArtisteInterface {
    public Artiste saveArtiste(Artiste p);
    public List<Artiste> fetchArtiste();
    public Artiste getArtiste(int id);
    public void updateArtiste(Artiste p);
    public void deleteArtiste(String username);
    public User Userinsert (User a);
    public Artiste getArtistebyusername(String username);
        public List<Artiste> recherche(String username);


}
