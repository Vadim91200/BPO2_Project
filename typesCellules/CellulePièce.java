package typesCellules;

import Pièce.Pièce;
import tableur.Cellule;

public class CellulePièce extends Cellule {
    private Pièce valeur;
    public CellulePièce(Pièce valeur) {
        this.valeur = valeur;
    }

    @Override
    public String getValeur() {
        return valeur.toString();
    }
}
