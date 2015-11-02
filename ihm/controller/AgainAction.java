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
import treasure.ihm.GameView;
import treasure.ihm.ViewManager;

/**
 * Classe qui permet de déclencher une nouvelle partie
 * @author Boubacar
 */
public class AgainAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            GameView game = (GameView) SwingUtilities.getRoot((Component) e.getSource());
            if(game == null){
                game = ViewManager.getGameView((AbstractButton) e.getSource());
            }
            if(game.isWinner()||game.isLooser())
                game.nextGame();
            else{
                // Demander une confirmation pour rejouer
                game.nextGame();
            }
        }catch(ClassCastException castError){
            
        }
    }
    
}
