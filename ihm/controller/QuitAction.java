/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.SwingUtilities;
import treasure.ihm.ViewManager;

/**
 * Ecouteur qui permet de quitter la partie ou le jeu
 * @author Boubacar
 */
public class QuitAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(ViewManager.isMenu(SwingUtilities.getRoot((Component)e.getSource()))){
            
            System.exit(0);
        }else{
            ViewManager.quitGame((AbstractButton) e.getSource());
        }
       
    }
    
}
