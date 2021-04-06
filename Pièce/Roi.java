package Pièce;

import géométrie.Direction;

public class Roi extends Pièce{
    private Direction cap;
    public Roi(){
        super.setNom("Roi");
    }
    @Override
    public String toString() {
        return "r";
    }
}
