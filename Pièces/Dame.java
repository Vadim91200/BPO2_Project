package Pièces;

import tableur.Echiquier;

public class Dame extends Pièce {

    public Dame(Couleurs couleur,Coord coord) {
        super(couleur, coord);
    }

    public boolean peutAllerEn(Coord coord, Echiquier e) {
        if (Math.abs(this.coord().getColonne() - coord.getColonne()) != Math.abs(this.coord().getLigne() - coord.getLigne()))
            return false;
        int dx = this.coord().getColonne() - coord.getColonne() > 0 ? -1 : 1;
        int dy = this.coord().getLigne() - coord.getLigne() > 0 ? -1 : 1;
        for (int i = 1; i < Math.abs(this.coord().getColonne() - coord.getColonne()); ++i)
            if (e.estLibre(new Coord(this.coord().getLigne() + i * dy,this.coord().getColonne() + i * dx)))
                return false;
        return true;
    }
    
}