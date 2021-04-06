package appli;

import tableur.Cellule;
import tableur.Coord;
import tableur.Tableur;
//import typesCellules.CelluleAddition;
import typesCellules.CellulePièce;
import Element.Jeu;
import appli.Poursuite;
import java.util.Scanner;

public class Application {
    public static final int NBCOLONNES = 8;
    private static void Afficher(Jeu Echec) {

        System.out.println("Bonjour et bienvennu dans cette partie d'échec votre but est de terminer cette partie ");
        System.out.println("Veuillez tout d'abord choisir votre mode de jeu: Humain contre Humain(hh), Humain contre Ordinateur(ho) ou bien Ordinateur contre Ordinateur(oo)");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s;
            s = sc.nextLine();
            if (estValide(s,Echec)) {
                break;
            }
            System.out.println("Saisi invalide veuillez ressayé ");
        }
    }
    private static boolean estValide(String s, Jeu theGame) {
        if (s.equals("hh")) {
            theGame.setMode(1);
            return true;
        } else if (s.equals("ho")) {
            theGame.setMode(2);
            return true;
        } else if (s.equals("oo")) {
            theGame.setMode(3);
            return true;
        }
        return false;
    }
    public static void demarer(Jeu Echec){
        if (Echec.getMode()==1){
            while (!Poursuite.fini(Echec)) {

            }
        }else if(Echec.getMode()==2){

        }else if(Echec.getMode()==3){

        }else{
            System.out.println("MERDE");
        }
    }
    public static void main(String args[]) {
        Tableur t = new Tableur(NBCOLONNES, NBCOLONNES);
        Jeu Echec = new Jeu(t);
        System.out.println(t.toString(Echec));
        Afficher(Echec);
        demarer(Echec);

        if (Echec.joueurCourant() == Echec.getBLANC()) {
            System.out.println("partie finie, " + "NomJoueur" + " a gagné");
        } else {
            System.out.println("partie finie," + "NomJoueur" + "a gagné");
        }
    }
}