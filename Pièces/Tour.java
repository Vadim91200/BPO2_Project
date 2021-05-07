package Pièces;
import tableur.Echiquier;
public class Tour extends Pièce {

    public Tour(Couleurs couleur,Coord coord) {
        super(couleur, coord);
    }

    public boolean peutAllerEn(Coord coord, Echiquier e) {
        if (coord.getColonne()>7 || coord.getColonne()<0 || coord.getLigne()>8 || coord.getLigne()<0){
            return false;
        }
        int x = coord.getColonne();
        int y = coord.getLigne();
        int xx = this.coord.getColonne();
        int yy = this.coord.getLigne();
        if ( xx != x && yy == y){
            return true;
        }
        if ( yy != y && xx == x){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return "t";
    }
}
