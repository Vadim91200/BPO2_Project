package Pièce;

public abstract class Pièce {
    private String Nom;
    public void setNom(String Nom){
        this.Nom = Nom;
    }
    public String getValeur(){
        return this.Nom;
    }
}
