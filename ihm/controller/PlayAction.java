/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import treasure.ihm.MenuView;
import treasure.ihm.ViewManager;
import treasure.model.GameManager;

/**
 * Ecouteur qui va lancer une partie
 * @author Boubacar
 */
public class PlayAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            
           /*
            *Boite de dialogue pour saisir un pseudo
            */
            
            String name = "";
            while(name == null || name.length() == 0){
                name = (String) JOptionPane.showInputDialog(null, "Veuillez choisir un pseudo :", "Choix du Pseudo", JOptionPane.OK_OPTION,new ImageIcon("Img/photo.png"),null,"");
                if(name == null){
                    break;
                }
            }
            
            if(name != null){
                MenuView m = (MenuView) SwingUtilities.getRoot((Component) e.getSource());
                GameManager.newPlayer(name);
                ViewManager.newGame(m.getNbLine(), m.getNbColumn(),name);
            }
        }catch(ClassCastException except){
            System.out.println("Problème récupération des informations du nouveau jeu");
        }
        
    }
    
}
