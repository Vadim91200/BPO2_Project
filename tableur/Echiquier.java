package tableur;

import Pièces.*;

import java.util.Arrays;
import java.util.ArrayList;


public class Echiquier {
    public static final int NBCOLONNES = 8;
    public static final int NBLIGNE = 8;
    public static final Coord c84 = new Coord(8, 4);
    public static final Coord c71 = new Coord(7, 1);
    public static final Coord c64 = new Coord(6, 4);
    public static final Coord c01 = new Coord(0,1);

    private ArrayList<Pièce> blanches = new ArrayList<Pièce>(Arrays.asList(new Tour(Couleurs.Blanc, c71), new Roi(Couleurs.Blanc, c64)));
    private ArrayList<Pièce> noires = new ArrayList<Pièce>(Arrays.asList(new Roi(Couleurs.Noir, c84), new Tour(Couleurs.Noir, c01)));
    private int Mode;
    private int Tour;

    public Echiquier() {
        Tour = 0;
        Mode = 5;
    }

    public int getMode() {
        return Mode;
    }

    public void setMode(int mode) {
        Mode = mode;
    }

    private ArrayList<Pièce> CouleurJouer() {
        if (Tour % 2 == 0) {
            return blanches;
        } else {
            return noires;
        }
    }

    public ArrayList<Pièce> CouleurEnAttente() {
        if (Tour % 2 == 0) {
            return noires;
        } else {
            return blanches;
        }
    }

    private Pièce occupant(Coord coord) {
        for (Pièce p : blanches)
            if (p.occupe(coord))
                return p;
        for (Pièce p : noires)
            if (p.occupe(coord))
                return p;
        return null;
    }

    public boolean estLibre(Coord coord) {
        return occupant(coord) == null;
    }

    public boolean estUneSaisiValide(String s){
        if(s.length()>4){ return false;};
        Coord Arrivée = new Coord((Integer.parseInt(s.substring(3,4))),Correspondances(s.substring(2,3)));
        Coord Départ = new Coord((Integer.parseInt(s.substring(1,2))), Correspondances(s.substring(0,1)));
        for(int i =0; i< CouleurJouer().size();i++){
            if(CouleurJouer().get(i).coord().equals(Départ)){
                return jouable(occupant(Départ),Arrivée);
            }
        }
        return false;
    }
    public boolean finie (){
        return true;
    }
    public void déplacer(String s){
        assert (estUneSaisiValide(s));
        Coord Arrivée = new Coord((Integer.parseInt(s.substring(3,4))),Correspondances(s.substring(2,3)));
        Coord Départ = new Coord((Integer.parseInt(s.substring(1,2))), Correspondances(s.substring(0,1)));
        for(int i =0; i< CouleurJouer().size();i++) {
            if (CouleurJouer().get(i).coord().equals(Départ)) {
                CouleurJouer().get(i).Déplacer(Arrivée, this);
            }
        }
    }
    public boolean jouable(Pièce p, Coord coord) {
        assert (blanches.contains(p) || noires.contains(p));
        return coord.getColonne() >= 1 && coord.getColonne() <= 8 && coord.getLigne() >= 1 && coord.getLigne() <= 8
                && (estLibre(coord) || estOpposant(coord, p))
                && p.peutAllerEn(coord, this)
                && (!p.estSensible() || !estAttaquableParOpposant(coord, p));
    }
    private int Correspondances(String s){
        assert (true);
        int Number=5555555;
        switch (s){
            case "a":  Number = 0;
                break;
            case "b":  Number = 1;
                break;
            case "c":  Number = 2;
                break;
            case "d":  Number = 3;
                break;
            case "e": Number = 4;
                break;
            case "f": Number = 5;
                break;
            case "g": Number = 6;
                break;
            case "h": Number = 7;
                break;
        }
        return Number;
    }
    private boolean estAttaquableParOpposant(Coord coord, Pièce p) {
        ArrayList<Pièce> opposants = blanches.contains(p) ? noires : blanches;
        for (Pièce op : opposants)
            if (op.peutAllerEn(coord, this))
                return true;
        return false;
    }

    private boolean estOpposant(Coord coord, Pièce p) {
        Pièce autre = occupant(coord);
        return (blanches.contains(p) && noires.contains(autre)) || (blanches.contains(autre) && noires.contains(p));
    }

    public int getTour() {
        return Tour;
    }

    public void setTour() {
        Tour++;
    }

    public String toString() {
        char convertedChar = (char) 97;
        int Velue = 8;
        int Value = 8;
        String s = "  ";

        for (int i = NBLIGNE; i>=0; i--) {
            if (i == NBLIGNE) {
                for (int m = 0; m < 8; m++) {
                    s += "  " + convertedChar + " ";
                    convertedChar++;
                }
                s += "\n  ";

                for (int m = 0; m < 8; m++) {
                    s += " ---";
                }
                s += "\n";
            } else {
                s += "  ";
                for (int m = 0; m < 8; m++) {
                    s += " ---";
                }
                s += "\n";
            }
            for (int k = 0; k < NBCOLONNES ; k++) {
                if (k == 0) {
                    s += Velue;
                    Velue--;

                }
                boolean Blanc = true;
                boolean Noir = true;
                for (int g = 0; g < CouleurJouer().size(); g++) {
                    if (CouleurJouer().get(g).coord().equals(new Coord(i, k)) || CouleurJouer().get(g).coord().equals(new Coord(i, k))) {
                        s += " | " + CouleurJouer().get(g).toString().toUpperCase() + "";
                        Blanc = true;
                        break;
                    } else {
                        Blanc = false;
                    }
                }
                for (int g = 0; g < CouleurEnAttente().size(); g++) {
                    if (CouleurEnAttente().get(g).coord().equals(new Coord(i, k)) || CouleurEnAttente().get(g).coord().equals(new Coord(i, k))) {
                        s += " | " + CouleurEnAttente().get(g) + "";
                        Noir = true;
                        break;
                    } else{
                        Noir = false;
                    }

                }
                if (!Blanc && !Noir) {
                    s += " |  ";

                }
            }
            s += " | ";
            s += Value;
            Value--;
            s += "\n";
        }
        s += "  ";
        for (int m = 0; m < 8; m++) {
            s += " ---";
        }
        s += "\n  ";
        convertedChar = 97;
        for (int m = 0; m < 8; m++) {
            s += "  " + convertedChar + " ";
            convertedChar++;
        }
        return s;
    }
}
