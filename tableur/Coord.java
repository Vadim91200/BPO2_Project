package tableur;

public class Coord {
  private int ligne, colonne;

  public Coord(int ligne, int colonne) {
    this.ligne = ligne;
    this.colonne = colonne;
  }

  public int getLigne() {
    return ligne;
  }

  public int getColonne() {
    return colonne;
  }
}
