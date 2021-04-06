package typesCellules;

import Pi�ce.Pi�ce;
import tableur.Cellule;

public class CellulePi�ce extends Cellule {
    private Pi�ce valeur;
    public CellulePi�ce(Pi�ce valeur) {
        this.valeur = valeur;
    }

    @Override
    public String getValeur() {
        return valeur.toString();
    }
}
