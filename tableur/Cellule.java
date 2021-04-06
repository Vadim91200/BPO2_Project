package tableur;

public abstract  class Cellule {
	@Override
	public String toString() {
		return "| "+ getValeur();
	}
	public abstract String getValeur();
}