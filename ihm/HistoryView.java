/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm;

import java.awt.Label;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import treasure.model.GameInfo;
import treasure.model.GameManager;

/**
 *
 * Vue de l'historique.
 * 
 * @author Boubacar
 */
public class HistoryView extends JFrame{
    
    private ArrayList<GameInfo> historique;
    /*
    l
    */
    private JList list;
    
    /**
     * Constructeur par défaut.
     * Elle crée une fenêtre affichant l'historique des parties.
     */
    public HistoryView(){
        super("History");
        /*
        * permet de créer et palcer en horizontal (abscisse) l'historique du jeu 
        */
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));
        
        historique = GameManager.getHistory();
        /*
        *ajoute un composant invisible, de hauteur fixe égale à 20 pixels
        */
        this.add(Box.createHorizontalStrut(20));
        /*
        *ajoute un composant extensible
        */
        this.add(Box.createGlue());
        /*
        *appel de la fonction listHistory()
        */
        listHistory();
        
        this.add(Box.createGlue());
         /*
        *ajoute un composant invisible, de hauteur fixe égale à 20 pixels
        */
        this.add(Box.createHorizontalStrut(20));
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    /**
     * Insère les données dans la vue
     */
    private void listHistory(){
        
        /*
        *Création d'une boite verticale pour afficher la vue de l'historique du jeu
        */
        Box b = Box.createVerticalBox();
        /*
        *ajoute un composant invisible, de hauteur fixe égale à 20 pixels
        */
        b.add(Box.createVerticalStrut(20));
        /*
        *vérifie si l'historique est vide
        */
        if(historique.isEmpty()){
            /*
            *ajout d'un label affichant le message "Aucun historique"
            */
            b.add(new Label("Aucun historique"));
        }else{
            
            list = new JList(historique.toArray());
            
            b.add(list);
            
            
        }
        
        b.add(Box.createVerticalStrut(20));
        
        this.add(b);
        
    }
    
    
    /**
     * Affiche la fenêtre.
     */
    public void Show(){
        this.setVisible(true);
    }
    
    
    public static void main(String[]args){
        HistoryView h = new HistoryView();
        h.Show();
    }
}
