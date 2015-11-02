/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm;

import treasure.ihm.component.GridView;
import treasure.ihm.component.MyProgressBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import treasure.ihm.controller.AgainAction;
import treasure.ihm.controller.HistoryAction;
import treasure.ihm.controller.QuitAction;
import treasure.ihm.controller.ThemeAction;
import treasure.ihm.exceptions.LooseEvent;
import treasure.model.GameInfo;
import treasure.model.GameManager;
import treasure.model.Settings;

/**
 * La vue d'une partie.
 * Elle contient les composants graphiques d'une partie.
 * 
 * @author Boubacar
 */
public class GameView extends JFrame implements WindowListener{
   
    /**
     * Menu principal
     */
    private JMenu menu;
    /**
     * Menu concernant le thème
     */
    private JMenu themeMenu;
    /**
     * Barre de menu
     */
    private JMenuBar menuBar;
    /**
     * Elément du menu permettant de faire une nouvelle partie à tout moment
     */
    private JMenuItem againItem;
    /**
     * Elément du menu permettant de quitter proprement la partie
     */
    private JMenuItem quitItem;
    /**
     * Elément du menu permettant au joueur d'accéder à l'historique des parties
     */
    private JMenuItem historyItem;
    /**
     * Elément du menu permettant au joueur de modifier le thème du jeu à tout moment
     */
    private JMenuItem themeItem;
    /**
     * Composant graphique qui contient la grille de jeu et qui la gère.
     */
    private GridView gridPanel;
    /**
     * Label affichant le nombre de coups joués
     */
    private JLabel nbHits;
    /**
     * Label affichant le nombre de coups restants
     */
    private JLabel maxHits;
    /**
     * Boutton permettant de quitter la partie après avoir gagné ou perdu.
     */
    private JButton quitBtn;
    /**
     * Boutton permettant de rejouer une partie après avoir gagné ou perdu.
     */
    private JButton againBtn;
    /**
     * Barre de progression utilisée pour indiquer au joueur s'il est près ou pas du trésor.
     * Elle peut être aussi utilisée pour indiquer le temps restant éventuellement
     * ou le nombre de vie restante.
     */
    private JProgressBar hints;
    
    /**
     * Booléen indiquant si la partie est perdue
     */
    private boolean looser;
    /**
     * Booléen indiquant si la partie est gagnée
     */
    private boolean winner;
    /**
     * Chaine de caractère constante utilisée pour générer de l'affichage
     */
    private static final String nbHitsString = "Nombre de coups joués : ";
    /**
     * Chaine de caractère constante utilisée pour générer de l'affichage
     */
    private static final String maxHitsString = "Coups restants : ";
    
    /**
     * Nombre de coups joués depuis le début de la partie
     */
    private int hits;
    
    /**
     * Nom du joueur
     */
    private String name;
    
    /**
     * Constructeur
     * Créer une fenêtre sans l'afficher. Pour l'afficher il faut utiliser la
     * fonction Show().
     * 
     * Elle prend le titre passé en paramètre, appel le constructeur de la grille de jeu
     * et dispose les composants dans la fenêtre.
     * 
     * @param title le titre du jeu
     * @param l le nombre de lignes de la grille
     * @param c le nombre de colonnes de la grille
     * @param n le nom du joueur
     * @see Show()
     */
    public GameView(String title, int l, int c, String n){
        super(title);
        
        // Composants swing pour les menus
     
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        themeMenu = new JMenu("Theme");
        quitItem = new JMenuItem("Quit");
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.VK_CONTROL));
        againItem = new JMenuItem("New Game");
        historyItem = new JMenuItem("History");
        themeItem = new JMenuItem("Change theme");
        menu.add(againItem);
        menu.add(historyItem);
        menu.addSeparator();
        menu.add(quitItem);
        
        themeMenu.add(themeItem);
        
        menuBar.add(menu);
        menuBar.add(themeMenu);
        
        // Panel
        gridPanel = new GridView(l,c);
        
        // Boutons et  JLabel
        nbHits = new JLabel(nbHitsString + 0);
        maxHits = new JLabel(maxHitsString + Settings.defaultMaxHits);
        quitBtn = new JButton("Quit");
        quitBtn.setVisible(false);
        againBtn = new JButton("Again ?");
        againBtn.setVisible(false);
        
        // barre de progression
        hints = new JProgressBar(0,5);
        hints.setValue(0);
        hints.setUI(new MyProgressBarUI());
        hints.setStringPainted(true);
        hints.setString("Hints");
        
        // Ajout des composants
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        this.setJMenuBar(menuBar);
        
        this.add(hints);
        Box b = Box.createHorizontalBox();
        b.add(Box.createGlue());
        b.add(Box.createRigidArea(new Dimension(40,0)));
        b.add(nbHits);
        b.add(Box.createGlue());
        b.add(Box.createRigidArea(new Dimension(40,0)));
        b.add(Box.createGlue());
        b.add(maxHits);
        b.add(Box.createRigidArea(new Dimension(40,0)));
        b.add(Box.createGlue());
        
        this.add(Box.createRigidArea(new Dimension(0,40)));
        this.add(b);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        
        b = Box.createHorizontalBox();
        b.add(Box.createRigidArea(new Dimension(40,0)));
        b.add(gridPanel);
        b.add(Box.createRigidArea(new Dimension(40,0)));
        this.add(b);
        
        this.add(Box.createRigidArea(new Dimension(0,40)));
        b = Box.createHorizontalBox();
        b.add(Box.createGlue());
        b.add(quitBtn);
        b.add(Box.createRigidArea(new Dimension(40,0)));
        b.add(againBtn);
        b.add(Box.createGlue());
        this.add(b);
        this.add(Box.createRigidArea(new Dimension(0,40)));
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        
        this.setLocationRelativeTo(null);
        
        // model de jeu
        hits = 0;
        looser = false;
        winner = false;
        name = n;
        
        //ajout d'écouteurs aux composants
        againBtn.addActionListener(new AgainAction());
        againItem.addActionListener(new AgainAction());
        quitItem.addActionListener(new QuitAction());
        quitBtn.addActionListener(new QuitAction());
        themeItem.addActionListener(new ThemeAction());
        historyItem.addActionListener(new HistoryAction());
        this.addWindowListener(this);
        
        // Ajoute la fenêtre dans le gestionnaire de vues
        ViewManager.addGame(this);
        
    }
    
    /**
     * Permet d'afficher la fenêtre de la vue.
     */
    public void Show(){
        this.setVisible(true);
    }
    
    /**
     * Permet de cacher la fenêtre.
     */
    public void Hide(){
        this.setVisible(false);
    }
    
    
    /**
     * Fonction permettant de mettre à jour le thème du jeu (la grille).
     */
    public void updateTheme(){
        gridPanel.updateTheme();
    }
    
    /**
     * Fonction permettant de lancer une nouvelle partie.
     * Elle remet à zero les composants.
     */
    public void nextGame(){
        /**
         * rechargement de la grille
         */
        gridPanel.reload();
        hits = 0;
        winner = false;
        looser = false;
        /**
         * on masque les button quitter et again
         */
        quitBtn.setVisible(false);
        againBtn.setVisible(false);
        hints.setValue(0);
        hints.setString("Hints");
        this.maxHits.setText(maxHitsString + (Settings.defaultMaxHits - hits));
        this.nbHits.setText(nbHitsString + hits);
    }
    
    /**
     * Fonction permettant de tester si un bouton quitter
     * appartient bien à la vue ou non.
     * La fonction est destinée au gestionnaire de vues.
     * 
     * @param b le bouton à tester
     * @return vrai si le bouton passé en paramètre est un bouton de la vue qui permet de quitter la partie.
     */
    public boolean isMyQuitBtn(AbstractButton b){
        return (b == quitBtn || b == quitItem);
    }
    
    
    /**
     * Fonction permettant de tester si un bouton appartient 
     * à la barre de menu de la vue.
     * 
     * @param b un bouton
     * @return vrai si le boutton appartient à la barre de menu de la vue, faux sinon
     */
    boolean isMyMenuBtn(AbstractButton b) {
       if((b == againItem)
        ||(b == themeItem)
        ||(b == quitItem)
        ||(b == historyItem)){
           return true;
       }else{
           return false;
       }
    }
    
    
    /**
     * Met à jour l'indice de la vue en fonction de la case cliquée
     * Elle modifie en conséquence l'apparence de la ProgressBar
     * 
     * @param l la ligne de la case choisie
     * @param c la colonne de la case choisie
     * @return entier correspondant à la distance maximum entre la case choisie et le trésor
     */
    public int refreshHint(int l, int c){
        hints.setValue(5);
        int n = gridPanel.getHints(l, c);
        switch(n){
            case 0:
                // Le trésor a été trouvé
                hints.setString("You Find Treasure");
                hints.setForeground(Color.GREEN);
                break;
            case 1:
                hints.setString("On Fire");
                hints.setForeground(Color.RED);
                break;
            case 2:
                hints.setString("Hot");
                hints.setForeground(Color.ORANGE);
                break;
            case 3:
                hints.setString("Warm");
                hints.setForeground(Color.YELLOW);
                break;
            case 4:
                hints.setString("Cold");
                hints.setForeground(Color.CYAN);
                break;
            default:
                hints.setString("Frozen");
                hints.setForeground(Color.BLUE);
                break;
        }
        return n;
    }
    
    /**
     * fonction appelée lorsque l'utilisateur clic sur une case,
     * La fonction met à jour les informations de la vue
     * concernant le nombre de coups joués et restants.
     * Elle lève et traite une exception si le nombre de coups joués 
     * est supérieur au nombre de coups maximums.
     * 
     */
    public void hit(){
        
        try{
            if(Settings.defaultMaxHits - hits - 1 <= 0){
                throw new LooseEvent();
            }
            this.hits++;
            this.maxHits.setText(maxHitsString + (Settings.defaultMaxHits - hits));
            this.nbHits.setText(nbHitsString + hits);
        }catch(LooseEvent e){
            if(Settings.defaultMaxHits - hits > 0){
                this.hits++;
                this.maxHits.setText(maxHitsString + (Settings.defaultMaxHits - hits));
                this.nbHits.setText(nbHitsString + hits);
            }
            this.lose();
            e.showPopMessage();
            
        }
    }
    
    /**
     * Indique si la partie est perdue ou non
     * @return vrai si la partie est perdue, faux sinon
     */
    public boolean isLooser(){
        return looser;
    }
    
    /**
     * Indique si la partie est gagnée ou non
     * @return vrai si la partie est gagnée,faux sinon
     */
    public boolean isWinner(){
        return winner;
    }
    
    /**
     * L'appel de cette fonction indique à la vue que la partie est gagnée
     * et la vue est mise à jour en conséquence.
     */
    public void win(){
        winner = true;
        againBtn.setVisible(true);
        quitBtn.setVisible(true);
        GameManager.addHistory(new GameInfo(name,gridPanel.getTreasure(),hits,winner));
    }
    /**
     * L'appel de cette fonction indique à la vue que la partie est perdue
     * et la vue est mise à jour en conséquence.
     */
    public void lose(){
        looser = true;
        againBtn.setVisible(true);
        quitBtn.setVisible(true);
        GameManager.addHistory(new GameInfo(name,gridPanel.getTreasure(),hits,winner));
    }
    
 
    /**
     * Appelée lorsque la fenêtre s'ouvre
     * @param e 
     */

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    
    /**
     * Appelée lorsque la fenêtre est en train de se fermer
     * @param e 
     */
    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    /**
     * Appel le gestionnaire de vue et lui demande d'afficher le menu.
     * @param e Evenement de la fenêtre
     */
    @Override
    public void windowClosed(WindowEvent e) {
        ViewManager.showMenu();
    }


    
    public static void main(String[]args){
        GameView gV = new GameView("TreasureHunt",8,8,"Diallo");
        /*
        *affichage par defaut de la grille du jeu 
        */
        gV.Show();
    }
    
    
    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
       
    }

    
}
