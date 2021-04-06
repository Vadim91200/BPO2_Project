package tableur;

import typesCellules.CelluleVide;
import Element.Jeu;
import java.util.Locale;

public class Tableur {
	private Cellule [][] cellules;
	
	public Tableur(int nbLignes, int nbColonnes) {
		cellules = new Cellule [nbLignes][nbColonnes];
		for (int lig =0; lig < nbLignes; ++lig)
			for(int col = 0; col < nbColonnes; ++ col)
				cellules[lig][col] = new CelluleVide();
	}
	public String toString(Jeu Echec) {
		int asciiValue = 97;
		char convertedChar = (char)asciiValue;
		int Velue = 8;
		int Value = 8;
		String s = "  ";

		for(int i=0; i<cellules.length; i++){
			if(i==0){
				for(int m =0; m<8;m++){
					s+= "  " + convertedChar +" ";
					convertedChar++;
				}
				s += "\n  ";

				for(int m =0; m<8;m++) {
					s += " ---";
				}
				s += "\n";
			}else {
				s +="  ";
				for(int m =0; m<8;m++) {
					s += " ---";
				}
				s += "\n";
			}
			for(int k=0; k< cellules.length; k++) {
				if(k==0){
					s += Velue +" ";
					Velue--;
				}
				if(Echec.getTour()%2==0){
					if(cellules[i][k].toString().contains(Echec.getBLANC().getCarré(i,k))){
						s += cellules[i][k].toString().toUpperCase() +" ";
					}else{
						s += cellules[i][k] +" ";
					}
				}else {
					if(cellules[i][k].toString() == Echec.getNOIR().getCarré(i,k)){
						s += cellules[i][k].toString().toUpperCase() +" ";
					}else{
						s += cellules[i][k] +" ";
					}
				}



			}
			s += "| ";
			s += Value;
			Value--;
			s+="\n";
		}
		s+= "  ";
		for(int m =0; m<8;m++) {
			s += " ---";
		}
		s += "\n  ";
		convertedChar = 97;
		for(int m =0; m<8;m++){
			s+= "  " + convertedChar +" ";
			convertedChar++;
		}
		return s;
	}
	
	public void set(Coord coord, Cellule cellule) {
		assert(coordCorrecte(coord));
		cellules [coord.getLigne()][coord.getColonne()] = cellule;
	}
	
	public Cellule get(Coord coord) {
		assert(coordCorrecte(coord));
		return cellules [coord.getLigne()][coord.getColonne()];
	}
	
  public boolean coordCorrecte(Coord c) {
	    return 0 <= c.getColonne() && 
	           c.getColonne() < getNbColonnes() &&
	           0 <= c.getLigne() && 
	           c.getLigne() < getNbLignes();
	}
  
  public int getNbLignes() {
	    return cellules.length;
	  }
	  
	  public int getNbColonnes() {
	    return cellules[0].length;
	  }
}
