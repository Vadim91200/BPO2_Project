package TypeJoueur;

import Pièces.*;
import tableur.Echiquier;
public class Ordinateur extends Humain {
    @Override
    public void coup(Echiquier e) {
        Pièce p = e.CouleurJouer().get((int)(Math.random() * ((e.CouleurJouer().size()-1 - (0)) + 1)) + (0));
        Coord Départ = p.coord();
        Coord Arrivée = new Coord((p.coord().getLigne()+(int)(Math.random() * ((1 - (-1) + 1)) + (-1))),p.coord().getColonne()+(int)(Math.random() * ((1 - (-1)) + 1)) + (-1));
       while(!estUneSaisiValide(Départ,Arrivée, e)){
           Pièce p2 = e.CouleurJouer().get((int)(Math.random() * ((e.CouleurJouer().size()-1 - (0)) + 1)) + (0));
           Coord Départ2 = p2.coord();
           Coord Arrivée2 = new Coord((p.coord().getLigne()+(int)(Math.random() * ((1 - (-1) + 1)) + (-1))),p.coord().getColonne()+(int)(Math.random() * ((1 - (-1)) + 1)) + (-1));
           Départ =  Départ2;
           Arrivée = Arrivée2;
       }
        déplacer(Départ,Arrivée,e);
    }
    @Override
    public boolean isHumain() {
        return false;
    }
}
