

package treasure.ihm;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import treasure.ihm.controller.HistoryAction;
import treasure.ihm.controller.PlayAction;
import treasure.ihm.controller.QuitAction;
import treasure.ihm.controller.ThemeAction;
import treasure.model.Settings;

/**
 * Vue du menu. Menu du jeu et point de départ de l'application.
 * 
 * @author Boubacar
 */
public class MenuView extends JFrame implements ChangeListener{
    /**
     * Label qui affiche le nom du jeu
     */
    private JLabel titleLabel;
    /**
     * Label affichant la taille de la grille du jeu qui va être créée.
     */
    private JLabel gridSize;
    /**
     * Bouton pour jouer
     */
    private JButton playBtn;
    /**
     * Bouton pour accéder à l'historique des parties.
     */
    private JButton historyBtn;
    /**
     * Bouton pour modifier le thème du jeu.
     */
    private JButton themeBtn;
    /**
     * Bouton pour quitter l'application.
     */
    private JButton quitBtn;
    /**
     * Slider pour choisir le nombre de ligne de la grille.
     */
    private JSlider lineSlider;
    /**
     * Slider pour choisir le nombre de colonne de la grille.
     */
    private JSlider colSlider;
   
    /**
     * Constructeur du menu.
     * @param gameName nom du jeu 
     */
    public MenuView(String gameName){
        super("Menu - "+gameName);
        
        this.titleLabel = new JLabel(gameName);
        this.titleLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        
        this.gridSize = new JLabel(Settings.defaultLineSize + "  x  " + Settings.defaultColSize);
        gridSize.setFont(new Font("Verdana",Font.PLAIN, 18));
        /*
        *Instanciation et définition des dimensions du bouton play
        */
        this.playBtn = new JButton("Play");
        this.playBtn.setPreferredSize(new Dimension(100,20 ));
         /*
        *Instanciation et définition des dimensions du bouton history
        */
        this.historyBtn = new JButton("History");
        this.historyBtn.setPreferredSize(new Dimension(100,20));
         /*
        *Instanciation et définition des dimensions du bouton thèmes
        */
        this.themeBtn = new JButton("Themes");
        this.themeBtn.setPreferredSize(new Dimension(100,20));
         /*
        *Instanciation et définition des dimensions du bouton quitter
        */
        this.quitBtn = new JButton("Quit");
        this.quitBtn.setPreferredSize(new Dimension(100,20));
         /*
        Instanciation et définition des dimensions des slider vertical et horizontal
        */
        this.lineSlider = new JSlider(JSlider.VERTICAL,4,Settings.defaultMaxLine,Settings.defaultLineSize);
        this.colSlider = new JSlider(JSlider.HORIZONTAL,4,Settings.defaultMaxCol,Settings.defaultColSize);
        lineSlider.setPreferredSize(new Dimension(30,50));
        colSlider.setPreferredSize(new Dimension(30,30));
        
        //JLabel bg = new JLabel(new ImageIcon("Img/menu.jpg"));
        //this.setContentPane(bg);
        
        this.setResizable(false);
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        
        // Boites principales
        Box boiteTitre = Box.createHorizontalBox();
        Box boiteTaille = Box.createHorizontalBox();
        Box boiteBtnPlay = Box.createHorizontalBox();
        Box boiteBtnHistory = Box.createHorizontalBox();
        Box boiteBtnTheme = Box.createHorizontalBox();
        Box boiteBtnQuit = Box.createHorizontalBox();
        
        // Boites Secondaires
        Box boiteLabelSize = Box.createHorizontalBox();
        Box boiteColSlider = Box.createVerticalBox();
        
        // TITRE
        boiteTitre.add(Box.createGlue());
        boiteTitre.add(titleLabel);
        boiteTitre.add(Box.createGlue());
        
        // CHOIX DE LA TAILLE DE LA GRILLE
        boiteTaille.add(Box.createGlue());
        boiteTaille.setPreferredSize(new Dimension(300,80));
        boiteTaille.add(lineSlider);
        boiteColSlider.add(Box.createGlue());
        boiteLabelSize.add(gridSize);
        boiteColSlider.add(boiteLabelSize);
        boiteColSlider.add(Box.createGlue());
        boiteColSlider.add(colSlider);
        boiteTaille.add(boiteColSlider);
        boiteTaille.add(Box.createGlue());
        
        
        // placement des boutons dans le panneau
        
        boiteBtnPlay.add(Box.createGlue());
        boiteBtnPlay.add(playBtn);
        boiteBtnPlay.add(Box.createGlue());
        
        boiteBtnHistory.add(Box.createGlue());
        boiteBtnHistory.add(historyBtn);
        boiteBtnHistory.add(Box.createGlue());
        
        boiteBtnTheme.add(Box.createGlue());
        boiteBtnTheme.add(themeBtn);
        boiteBtnTheme.add(Box.createGlue());
        
        boiteBtnQuit.add(Box.createGlue());
        boiteBtnQuit.add(quitBtn);
        boiteBtnQuit.add(Box.createGlue());
        
        
        // AJOUT DES COMPOSANTS DANS LA FENETRE
        this.add(Box.createGlue());
        this.add(boiteTitre);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(Box.createGlue());
        this.add(boiteTaille);
        this.add(Box.createGlue());
        this.add(boiteBtnPlay);
        this.add(Box.createGlue());
        this.add(boiteBtnHistory);
        this.add(Box.createGlue());
        this.add(boiteBtnTheme);
        this.add(Box.createGlue());
        this.add(boiteBtnQuit);
        this.add(Box.createGlue());
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(300,400));
        this.pack();
        this.setLocationRelativeTo(null);
        

        // Ajout des ecouteurs aux differnts composants
        playBtn.addActionListener(new PlayAction());
        historyBtn.addActionListener(new HistoryAction());
        themeBtn.addActionListener(new ThemeAction());
        quitBtn.addActionListener(new QuitAction());
        colSlider.addChangeListener(this);
        lineSlider.addChangeListener(this);
        
        // Créer un lien dans le gestionnaire de vue vers le menu.
        ViewManager.initMenu(this);
        
    }
    
    /**
     * Fonction permettant d'obtenir le nom du jeu.
     * @return chaine de caractère représentant le nom du jeu
     */
    public String getGameName(){
        return this.titleLabel.getText();
    }
    
    /**
     * Obtenir le nombre de lignes choisies
     * @return le nombre de ligne
     */
    public int getNbLine(){
        return this.lineSlider.getValue();
    }
    
    /**
     * Obtenir le nombre de colonnes choisies
     * @return le nombre de colonnes
     */
    public int getNbColumn(){
        return this.colSlider.getValue();
    }
    
    /**
     * Affiche le menu
     */
    public void Show(){
        this.setVisible(true);
    }
    
    /**
     * rendre invisible le menu
     */
    public void Hide(){
        this.setVisible(false);
    }
    

    /**
     * fonction ppelée quand un slider est modifié et met à jour l'affichage de la taille
     * de la grille.
     * @param e slider change event
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        this.gridSize.setText(lineSlider.getValue()+"  x  "+colSlider.getValue());
    }
    
    
    public static void main(String[]args){
        MenuView v = new MenuView("TreasureHunt");
        v.Show();
    }

}
