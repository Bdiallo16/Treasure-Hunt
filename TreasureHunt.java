/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure;

import javax.swing.SwingUtilities;
import treasure.ihm.MenuView;

/**
 * Classe principale du Treasure Hunt.
 * Initialise le jeu
 * 
 * 
 * @author Boubacar
 */
public class TreasureHunt {
    
    
    /**
     * Point d'entrée de l'application
     * Lance le menu du jeu.
     * Le reste du jeu est ensuite géré par le gestionnaire de vue et le menu.
     */
    public static void createAndShowGUI(){
        MenuView v = new MenuView("TreasureHunt");
        v.Show();
    }
    
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                createAndShowGUI();
            }
        });
        
    }
}
