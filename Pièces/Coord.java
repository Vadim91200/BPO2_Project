package Pièces;

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
  
  public boolean equals(Coord coord){
    if (coord.getColonne() == this.getColonne() && coord.getLigne() == this.getLigne()){
      return true;
    }
    return false;
  }
}
