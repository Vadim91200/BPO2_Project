package Element;

import TypeDeJoueur.Joueur;
import tableur.Coord;
import tableur.Tableur;
import typesCellules.CellulePi�ce;
import Pi�ce.Roi;
import Pi�ce.Tour;
import Pi�ce.Pi�ce;

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
        Pi�ce RoiNoir = new Roi();
        t.set(c05, new CellulePi�ce(RoiNoir));
        NOIR.attribution(0,4,"r");
        Pi�ce TourBlanc = new Tour();
        t.set(c11, new CellulePi�ce(TourBlanc));
        BLANC.attribution(1,1,"t");
        Pi�ce RoiBlanc = new Roi();
        t.set(c24, new CellulePi�ce(RoiBlanc));
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