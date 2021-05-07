package TypeJoueur;

import Pi�ces.*;
import tableur.Echiquier;
public class Ordinateur extends Humain {
    @Override
    public void coup(Echiquier e) {
        Pi�ce p = e.CouleurJouer().get((int)(Math.random() * ((e.CouleurJouer().size()-1 - (0)) + 1)) + (0));
        Coord D�part = p.coord();
        Coord Arriv�e = new Coord((p.coord().getLigne()+(int)(Math.random() * ((1 - (-1) + 1)) + (-1))),p.coord().getColonne()+(int)(Math.random() * ((1 - (-1)) + 1)) + (-1));
       while(!estUneSaisiValide(D�part,Arriv�e, e)){
           Pi�ce p2 = e.CouleurJouer().get((int)(Math.random() * ((e.CouleurJouer().size()-1 - (0)) + 1)) + (0));
           Coord D�part2 = p2.coord();
           Coord Arriv�e2 = new Coord((p.coord().getLigne()+(int)(Math.random() * ((1 - (-1) + 1)) + (-1))),p.coord().getColonne()+(int)(Math.random() * ((1 - (-1)) + 1)) + (-1));
           D�part =  D�part2;
           Arriv�e = Arriv�e2;
       }
        d�placer(D�part,Arriv�e,e);
    }
    @Override
    public boolean isHumain() {
        return false;
    }
}
