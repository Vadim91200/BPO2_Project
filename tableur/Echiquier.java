package tableur;

import Pi�ces.*;
import TypeJoueur.Humain;

import java.util.Arrays;
import java.util.ArrayList;


public class Echiquier {
    public static final int NBCOLONNES = 8;
    public static final int NBLIGNE = 8;
    public static final Coord c84 = new Coord(8, 4);
    public static final Coord c71 = new Coord(7, 1);
    public static final Coord c64 = new Coord(6, 4);
    public static final Coord c01 = new Coord(0, 1);

    private IJoueur NOIR;
    private IJoueur BLANC;
    private ArrayList<Pi�ce> blanches = new ArrayList<Pi�ce>(Arrays.asList(new Tour(Couleurs.Blanc, c71), new Roi(Couleurs.Blanc, c64)));
    private ArrayList<Pi�ce> noires = new ArrayList<Pi�ce>(Arrays.asList(new Roi(Couleurs.Noir, c84), new Tour(Couleurs.Noir, c01)));
    private int Tour;

    public Echiquier(IJoueur NOIR, IJoueur BLANC) {
        this.NOIR = NOIR;
        this.BLANC = BLANC;
        Tour = 0;
    }

    public IJoueur JoueurJouer() {
        if (Tour % 2 == 0) {
            return NOIR;
        } else {
            return BLANC;
        }
    }

    public ArrayList<Pi�ce> CouleurJouer() {
        if (Tour % 2 == 0) {
            return blanches;
        } else {
            return noires;
        }
    }

    public ArrayList<Pi�ce> CouleurEnAttente() {
        if (Tour % 2 == 0) {
            return noires;
        } else {
            return blanches;
        }
    }

    public Pi�ce occupant(Coord coord) {
        for (Pi�ce p : blanches)
            if (p.occupe(coord))
                return p;
        for (Pi�ce p : noires)
            if (p.occupe(coord))
                return p;
        return null;
    }

    public boolean PeutEliminer(Coord Arriv�e, Coord D�part) {
        return (estOpposant(Arriv�e, occupant(D�part)));
    }

    public boolean estLibre(Coord coord) {
        return occupant(coord) == null;
    }

    public boolean estUneSaisiValide(Coord D�part, Coord Arriv�e) {
        return JoueurJouer().estUneSaisiValide(D�part,Arriv�e, this);
    }

    public boolean finie() {
        for (int i = 0; i < CouleurJouer().size(); i++) {
            if (CouleurJouer().get(i).toString().equals("r")) {
                return echecetmat();
            }
        }
        return true;
    }

    private boolean echecetmat() {
        for (int i = 0; i < CouleurJouer().size(); i++) {
            if (CouleurJouer().get(i).toString().equals("r")) {
                if (echec(CouleurJouer().get(i))){
                    return (nepeuxpasechapper(CouleurJouer().get(i)));
                }
            }
        }
        return false;
    }
    private boolean nepeuxpasechapper(Pi�ce P){
        for (int i=-1; i<=1; i++){
            for (int j=-1; j<=1; j++){
                Coord modif = new Coord(P.coord().getLigne()+i, P.coord().getColonne()+j);
                if(estUneSaisiValide(P.coord(), modif) && !estAttaquableParOpposant(modif, P)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean echec(Pi�ce P){
        if (estAttaquableParOpposant(P.coord(), P)) {
            return true;

        } else {
            return false;
        }
    }
public void d�placer(Coord D�part, Coord Arriv�e){
        JoueurJouer().d�placer(D�part, Arriv�e,this);
        }
public boolean jouable(Pi�ce p,Coord coord){
        assert(blanches.contains(p)||noires.contains(p));
        return coord.getColonne()>=1&&coord.getColonne()<=8&&coord.getLigne()>=1&&coord.getLigne()<=8
        &&(estLibre(coord)||estOpposant(coord,p))
        &&p.peutAllerEn(coord,this)
        &&(!p.estSensible()||!estAttaquableParOpposant(coord,p));
        }
private boolean estAttaquableParOpposant(Coord coord,Pi�ce p){
        ArrayList<Pi�ce> opposants=blanches.contains(p)?noires:blanches;
        for(Pi�ce op:opposants)
        if(op.peutAllerEn(coord,this))
        return true;
        return false;
        }

private boolean estOpposant(Coord coord,Pi�ce p){
        Pi�ce autre=occupant(coord);
        return(blanches.contains(p)&&noires.contains(autre))||(blanches.contains(autre)&&noires.contains(p));
        }

public int getTour(){
        return Tour;
        }

public void setTour(){
        Tour++;
        }

public String toString(){
        char convertedChar=(char)97;
        int Velue=8;
        int Value=8;
        String s="  ";

        for(int i=NBLIGNE;i>=0;i--){
        if(i==NBLIGNE){
        for(int m=0;m< 8;m++){
        s+="  "+convertedChar+" ";
        convertedChar++;
        }
        s+="\n  ";

        for(int m=0;m< 8;m++){
        s+=" ---";
        }
        s+="\n";
        }else{
        s+="  ";
        for(int m=0;m< 8;m++){
        s+=" ---";
        }
        s+="\n";
        }
        for(int k=0;k<NBCOLONNES; k++){
        if(k==0){
        s+=Velue;
        Velue--;

        }
        boolean Blanc=true;
        boolean Noir=true;
        for(int g=0;g<CouleurJouer().size();g++){
        if(CouleurJouer().get(g).coord().equals(new Coord(i,k))||CouleurJouer().get(g).coord().equals(new Coord(i,k))){
        s+=" | "+CouleurJouer().get(g).toString().toUpperCase()+"";
        Blanc=true;
        break;
        }else{
        Blanc=false;
        }
        }
        for(int g=0;g<CouleurEnAttente().size();g++){
        if(CouleurEnAttente().get(g).coord().equals(new Coord(i,k))||CouleurEnAttente().get(g).coord().equals(new Coord(i,k))){
        s+=" | "+CouleurEnAttente().get(g)+"";
        Noir=true;
        break;
        }else{
        Noir=false;
        }

        }
        if(!Blanc&&!Noir){
        s+=" |  ";

        }
        }
        s+=" | ";
        s+=Value;
        Value--;
        s+="\n";
        }
        s+="  ";
        for(int m=0;m< 8;m++){
        s+=" ---";
        }
        s+="\n  ";
        convertedChar=97;
        for(int m=0;m< 8;m++){
        s+="  "+convertedChar+" ";
        convertedChar++;
        }
        return s;
        }
        }
