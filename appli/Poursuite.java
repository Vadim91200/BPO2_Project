package appli;

import Element.Jeu;


public class Poursuite {
    public static boolean fini(Jeu theGame) {
        return perdu(theGame) || gagne(theGame);
    }

    private static boolean perdu(Jeu theGame) {
        return false;
    }

    private static boolean gagne(Jeu theGame) {
        return false;
    }

}