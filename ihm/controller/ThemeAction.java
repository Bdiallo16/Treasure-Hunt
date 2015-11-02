/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import treasure.ihm.ThemeView;

/**
 * Ecouteur qui lance la fenêtre permettant de changer le thème
 * @author Boubacar
 */
public class ThemeAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        ThemeView tV = new ThemeView();
        tV.Show();
    }
    
}
