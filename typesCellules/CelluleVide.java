package typesCellules;

import tableur.Cellule;

public class CelluleVide extends Cellule {
	@Override
	public String toString() {
		return "|  ";
	}
	@Override
	public String getValeur() {
		return " ";
	}
}
