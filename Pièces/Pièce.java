package Pièces;
import tableur.Echiquier;
public abstract class Pièce {

    private Coord coord;
    private Couleurs couleur;
    public Pièce(Couleurs couleur, Coord coord) {
        this.coord = new Coord(coord.getLigne(), coord.getColonne());
        this.couleur = couleur;
    }

    public boolean occupe(Coord coord) {
        return this.coord.getColonne() == coord.getColonne() && this.coord.getLigne() == coord.getLigne();
    }

    public Couleurs Couleurs() {
       return couleur;
    }

    public Coord coord() {
        return coord;
    }
    public void Déplacer(Coord coord, Echiquier e){
        assert(peutAllerEn(coord, e));
        this.coord = coord;
    }

    public abstract boolean peutAllerEn(Coord coord, Echiquier e);

    public boolean estSensible() {
        return false;
    }
}
