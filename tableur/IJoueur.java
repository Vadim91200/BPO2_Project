package tableur;

import Pi�ces.Coord;

public interface IJoueur {
    void coup(Echiquier e);
    void d�placer(Coord D�part, Coord Arriv�e, Echiquier e);
    boolean estUneSaisiValide(Coord D�part, Coord Arriv�e, Echiquier e);
    int Correspondances(String s);
    boolean isHumain();
}
