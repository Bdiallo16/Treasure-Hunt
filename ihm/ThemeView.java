/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm;

import treasure.ihm.component.GridView;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import treasure.model.Grid;

/**
 *
 * Fenêtre permettant de modifier le thème du jeu.
 * 
 * @author Boubacar
 */
public class ThemeView extends JFrame implements ActionListener, ChangeListener{
    
    /**
     * Composant pour choisir une couleur.
     */
    private JColorChooser selectionColor;
    /**
     * Bouton radio pour modifier les bordures.
     */
    private JRadioButton bordersColor;
    /**
     * Bouton radio pour modifier le fond des cases
     */
    private JRadioButton caseBackground;
    /**
     * Bouton radio pour modifier les bords de la case qui a le focus
     */
    private JRadioButton selectedCaseColor;
    /**
     * Bouton radio pour modifier la couleur des cases déjà vues
     */
    private JRadioButton alreadyViewColor;
    /**
     * Groupe de boutons contenant les boutons radios.
     */
    private ButtonGroup options;
    
    /**
     * Constructeur par défaut.
     * Construit une fenêtre permettant de modifier le thème.
     */
    public ThemeView(){
        super("Configuration Theme");
        
        /*
        *Initialisation des composants et attribution des titres à chaque composant
        */
        selectionColor = new JColorChooser(GridView.getBackgroundColor());
        bordersColor = new JRadioButton("Bordure des cases");
        selectedCaseColor = new JRadioButton("Bordure de la case courante");
        alreadyViewColor = new JRadioButton("Fond des cases déjà vues");
        caseBackground = new JRadioButton("Fond des cases");
        caseBackground.setSelected(true);
        
        
        
        // Création du groupe de bouttons
        options = new ButtonGroup();
        options.add(bordersColor);
        options.add(selectedCaseColor);
        options.add(alreadyViewColor);
        options.add(caseBackground);
        
        // Disposition des composants dans le panneau
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        //création d'une boite horizontale pour placer les composants du thème
        Box b = Box.createHorizontalBox();
        
        b.add(caseBackground);
        b.add(bordersColor);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(b);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        
        b = Box.createHorizontalBox();
        b.add(selectedCaseColor);
        b.add(alreadyViewColor);
        
        this.add(b);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(selectionColor);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        
        /*
        *Ajout d'ecouteurs
        */
        caseBackground.addActionListener(this);
        bordersColor.addActionListener(this);
        selectionColor.getSelectionModel().addChangeListener(this);
    }

    /**
     * Fonction appelée lorsque le joueur choisis un bouton radio.
     * Elle charge la couleur actuelle dans le sélecteur de couleur.
     * @param e actionEvent permettant de recupérer le bouton qui vient d'être choisi
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radio = (JRadioButton) e.getSource();
        if(radio == bordersColor){
            selectionColor.setColor(GridView.getBorderColor());
        }else if(radio == selectedCaseColor){
            selectionColor.setColor(GridView.getSelectionColor());
        }else if(radio == alreadyViewColor){
            selectionColor.setColor(GridView.getAlreadyViewColor());
        }else if(radio == caseBackground){
            selectionColor.setColor(GridView.getBackgroundColor());
        }
    }

    /**
     * Fonction appelée lorsque qu'une couleur est choisie.
     * La couleur est modifiée et elle appelle le gestionnaire de vue
     * pour qu'il informe toutes les vues que le thème a changé et modifie leur thème.
     * @param e ChangeEvent permettant de récupérer la couleur choisie
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        ColorSelectionModel selection = (ColorSelectionModel) e.getSource();
        if(options.isSelected(bordersColor.getModel())){
            GridView.setBorderColor(selection.getSelectedColor());
        }else if(options.isSelected(selectedCaseColor.getModel())){
            GridView.setSelectionColor(selection.getSelectedColor());
        }else if(options.isSelected(alreadyViewColor.getModel())){
            GridView.setAlreadyViewColor(selection.getSelectedColor());
        }else{
            GridView.setBackgroundColor(selection.getSelectedColor());
        }
        ViewManager.updateTheme();
    }
    
    /**
     * Affiche la fenêtre
     */
    public void Show(){
        this.setVisible(true);
    }
    
    /**
     * Cache la fenêtre.
     */
    public void Hide(){
        this.setVisible(false);
    }
    
    
    public static void main(String[]args){
        ThemeView v = new ThemeView();
        v.Show();
    }

}
