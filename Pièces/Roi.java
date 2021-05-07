package Pièces;
import tableur.Echiquier;

public class Roi extends Pièce {
    public Roi(Couleurs couleur, Coord coord) {
        super(couleur, coord);
    }
    @Override
    public boolean peutAllerEn(Coord coord, Echiquier e) {
        if (coord.getColonne()>7 || coord.getColonne()<0 || coord.getLigne()>8 || coord.getLigne()<0){
            return false;
        }
        if (Math.abs(this.coord().getColonne() - coord.getColonne()) > 1 || Math.abs(this.coord().getLigne() - coord.getLigne()) > 1)
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