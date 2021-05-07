package tableur;

import Pièces.Coord;

public interface IJoueur {
    void coup(Echiquier e);
    void déplacer(Coord Départ, Coord Arrivée, Echiquier e);
    boolean estUneSaisiValide(Coord Départ, Coord Arrivée, Echiquier e);
    int Correspondances(String s);
    boolean isHumain();
}
