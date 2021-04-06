package TypeDeJoueur;


import Pièce.Pièce;

public class Joueur {
    private String [][] carré;
    public Joueur() {
        carré = new String [8][8];
    }
    public void attribution(int ligne, int colonne, String Pièce){
        carré[ligne][colonne] = Pièce;
    }
    public String getCarré(int i, int k ){
        if (carré[i][k]==null){
            return "NOO";
        }else
        return carré[i][k];
    }
   /* public void jouer(String Coup, Pièce Selectionner)  {
       if(EstValide(Coup,Selectionner)){
            Selectionner.
       }
    }*/
}