package TypeDeJoueur;


import Pi�ce.Pi�ce;

public class Joueur {
    private String [][] carr�;
    public Joueur() {
        carr� = new String [8][8];
    }
    public void attribution(int ligne, int colonne, String Pi�ce){
        carr�[ligne][colonne] = Pi�ce;
    }
    public String getCarr�(int i, int k ){
        if (carr�[i][k]==null){
            return "NOO";
        }else
        return carr�[i][k];
    }
   /* public void jouer(String Coup, Pi�ce Selectionner)  {
       if(EstValide(Coup,Selectionner)){
            Selectionner.
       }
    }*/
}