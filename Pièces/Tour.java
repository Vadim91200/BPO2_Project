package Pièces;
import tableur.Echiquier;
public class Tour extends Pièce {

    public Tour(Couleurs couleur,Coord coord) {
        super(couleur, coord);
    }

    public boolean peutAllerEn(Coord coord, Echiquier e) {
        if (Math.abs(this.coord().getColonne() - coord.getColonne()) > 1
                || Math.abs(this.coord().getLigne() - coord.getLigne()) > 1)
            return false;
        return true;
    }
    @Override
    public String toString(){
        return "t";
    }
}
