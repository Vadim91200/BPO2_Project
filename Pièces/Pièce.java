package Pi�ces;
import tableur.Echiquier;
public abstract class Pi�ce {

    private Coord coord;
    private Couleurs couleur;
    public Pi�ce(Couleurs couleur, Coord coord) {
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
    public void D�placer(Coord coord, Echiquier e){
        assert(peutAllerEn(coord, e));
        this.coord = coord;
    }

    public abstract boolean peutAllerEn(Coord coord, Echiquier e);

    public boolean estSensible() {
        return false;
    }
}
