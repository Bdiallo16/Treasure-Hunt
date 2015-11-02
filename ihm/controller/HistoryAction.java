/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import treasure.ihm.HistoryView;

/**
 * Ecouteur qui affiche la fenêtre avec l'historique
 * @author Boubacar
 */
public class HistoryAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        HistoryView h = new HistoryView();
        /*
        *Affichage de la fenetre de l'historique
        */
        h.Show();
    }
    
}
