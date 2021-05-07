package appli;

import TypeJoueur.Humain;
import TypeJoueur.Ordinateur;
import tableur.Echiquier;

public class SelectionJoueur {
    public static Echiquier choisir(int nb){
        assert(nb!=555555);
        switch (nb){
            case 1: return new Echiquier(new Humain(),new Humain());
            case 2: return new Echiquier(new Humain(),new Ordinateur());
            case 3: return new Echiquier(new Ordinateur(),new Ordinateur());
        }
        return null;
    }
}
