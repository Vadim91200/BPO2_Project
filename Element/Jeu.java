package Element;

import TypeDeJoueur.Joueur;
import tableur.Coord;
import tableur.Tableur;
import typesCellules.CellulePièce;
import Pièce.Roi;
import Pièce.Tour;
import Pièce.Pièce;

public class Jeu {
    public static final int NBCOLONNES = 8;
    private Joueur BLANC = new Joueur();
    private Joueur NOIR = new Joueur();
    private static int Tour;
    private static int Mode;
    public Jeu(Tableur t) {

        Coord c05 = new Coord(0, 4);
        Coord c11 = new Coord(1, 1);
        Coord c24 = new Coord(2, 4);
        Pièce RoiNoir = new Roi();
        t.set(c05, new CellulePièce(RoiNoir));
        NOIR.attribution(0,4,"r");
        Pièce TourBlanc = new Tour();
        t.set(c11, new CellulePièce(TourBlanc));
        BLANC.attribution(1,1,"t");
        Pièce RoiBlanc = new Roi();
        t.set(c24, new CellulePièce(RoiBlanc));
        BLANC.attribution(2,4,"r");
        Tour = 0;
        Mode =5;

    }


    public int getTour() {
        return Tour;
    }

    public Joueur getBLANC() {
        return BLANC;
    }

    public Joueur getNOIR() {
        return NOIR;
    }
    public int getMode(){return Mode;}

    public static void setMode(int mode) {
        Mode = mode;
    }

    public void changementTour() {
        Tour++;
    }
    public Joueur joueurCourant(){
        if (Tour % 2 == 0) {
            return BLANC;
        } else {
            return NOIR;
        }
    }
    public Joueur joueurEnattente(){
        if (Tour % 2 == 0) {
            return NOIR;
        } else {
            return BLANC;
        }
    }
}