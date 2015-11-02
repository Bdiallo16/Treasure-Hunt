/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm;

import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Gestionnaire de vue de l'application.
 * 
 * @author Boubacar
 */
public class ViewManager {
    /**
     * Menu de l'application.
     */
    private static MenuView menu;
    /**
     * Gestion de Liste des parties en cours à l'aide d'un ArrayList.
     */
    private static ArrayList<GameView> games = new ArrayList<GameView>();
    
    // indice qui permet de garder en mémoire combien de fenêtres de jeu ont été fermées
    private static int nbGameQuit = 0;
    // indice indiquant au bout de combien de fois on remet à jour la liste des fenêtres.
    private static int nbGameQuitBeforeRefreshList = 4;
    
    /**
     * Ajoute une partie au gestionnaire.
     * @param g partie
     */
    public static void addGame(GameView g){
        games.add(g);
    }
    
    /**
     * Initialise le menu
     * @param m le menu
     */
    public static void initMenu(MenuView m){
        menu = m;
    }
    
    /**
     * Affiche le menu.
     */
    public static void showMenu(){
        if(menu != null){
            menu.Show();
        }else{
            menu = new MenuView("TreasureHunt");
            menu.Show();
        }
    }
    
    /**
     * Indique si l'objet correspond à la fenêtre du menu.
     * Utilisé dans le cas de l'évènement quitter qui est différent si on est dans le menu
     * ou dans une partie.
     * @param o objet à tester
     * @return vrai si l'objet est le menu,faux sinon.
     */
    public static boolean isMenu(Object o){
        return o == menu;
    }
    
    /**
     * Lance une nouvelle partie et cache le menu.
     * @param l nombre de lignes de la grille
     * @param c nombre de colonnes de la grille
     * @param n nom du joueur
     */
    public static void newGame(int l, int c, String n){
        GameView g = new GameView(menu.getGameName(),l,c,n);
        menu.Hide();
        g.Show();
    }
    
    /**
     * Informe les parties que le thème a changé et qu'il faut le recharger
     */
    public static void updateTheme(){
        
        for(GameView g : games){
            g.updateTheme();
        }
    }
    /**
     * Retourne le GameView qui contient le bouton passé en paramètre.
     * Le bouton passé en paramètre est un bouton du menu du GameView.
     * 
     * @param b bouton du menu appartenant à un GameView
     * @return le GameView correspondant
     */
    public static GameView getGameView(AbstractButton b){
        for(GameView g : games){
            if(g.isMyMenuBtn(b)){
                return g;
            }
        }
        
        return null;
    }
    /**
     * Ferme la fenêtre de jeu d'où provient l'ordre de quitter la partie
     * @param b bouton quitter
     */
    public static void quitGame(AbstractButton b){
        
        for(GameView g : games){
            if(g.isMyQuitBtn(b)){
                g.dispose();
                nbGameQuit++;
                showMenu();
            }
        }
        // Enlève les fenêtres qui ont été fermées.
        // Evite de garder en mémoire des fenêtres qui ont été fermées.
        if(nbGameQuit >= nbGameQuitBeforeRefreshList){
            for(int i=0;i<games.size();i++){
                if(!games.get(i).isVisible()){
                    games.remove(i);
                    i--;
                }
            }
            nbGameQuit=0;
        }
    }
    
    
    
    
}
