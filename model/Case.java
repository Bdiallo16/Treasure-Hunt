

package treasure.model;

/**
 * Représentation d'une case
 * @author Boubacar
 */
public class Case {
    
    /**
    * Ligne et Colonne de la case
    */
    private int l, c;
    /**
     * Booléen qui indique si elle possède le trésor
     */
    private boolean hasTreasure;
    /**
     * Booléen qui indique si une case a déjà été vue
     */
    private boolean viewed;
    
    /**
     * Constructeur par défaut
     * @param l ligne de la case
     * @param c colonne de la case
     */
    public Case(int l, int c){
        this.l = l;
        this.c = c;
        hasTreasure = false;
        viewed = false;
    }
    
    /**
     * Renvoie la ligne de la case
     * @return la ligne de la case
     */ 
    public int getLine(){
        return l;
    }
    /**
     * Renvoie la colonne de la case
     * @return la colonne de la case
     */
    public int getColumn(){
        return c;
    }
    
    /**
     * Indique si elle a le trésor
     * @return true si elle a le trésor, false sinon
     */
    public boolean hasTreasure(){
        return hasTreasure;
    }
    /**
     * Indique si elle a déjà été testée
     * @return true si on a déjà cliqué dessus, false sinon.
     */
    public boolean isViewed(){
        return viewed;
    }
    
    /**
     * Indique à la case qu'elle vient d'être vue
     */
    public void viewed(){
        viewed = true;
    }
    
    /**
     * Donne à la case le trésor
     */
    public void giveTreasure(){
        this.hasTreasure = true;
    }
    /*
    *permet d'afficher la somme du numero de lignes et de colonnes d'un bouton (possedant le focus) dans la grille de jeu
    */
    @Override
    public String toString(){
        return "( "+l+" , "+ c+" )";
    }
}
