package Pièces;
import tableur.Echiquier;

public class Roi extends Pièce {
    public Roi(Couleurs couleur, Coord coord) {
        super(couleur, coord);
    }

    public boolean peutAllerEn(Coord coord, Echiquier e) {
        if (Math.abs(this.coord().getColonne() - coord.getColonne()) > 1
                || Math.abs(this.coord().getLigne() - coord.getLigne()) > 1)
            return false;
        return true;
    }

    public boolean estSensible() {
        return false;
    }
    @Override
    public String toString(){
        return "r";
    }
}
