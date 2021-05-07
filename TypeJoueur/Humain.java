package TypeJoueur;
import Pièces.Coord;
import tableur.Echiquier;
import tableur.IJoueur;

import java.util.Scanner;

public class Humain implements IJoueur{
    private static final Scanner sc = new Scanner(System.in);
    @Override
    public void coup(Echiquier e) {
        // Dans le cas général, un affichage plus une demande de saisie au joueur
        System.out.print("> ");
        String cartesJouer = sc.nextLine();
        Coord Départ = new Coord((Integer.parseInt(cartesJouer.substring(1,2))), Correspondances(cartesJouer.substring(0,1)));
        Coord Arrivée = new Coord((Integer.parseInt(cartesJouer.substring(3,4))),Correspondances(cartesJouer.substring(2,3)));

        // Dans le cas où la saisie du joueur n'est pas une saisie valide
        while(!estUneSaisiValide(Départ,Arrivée, e) && cartesJouer.length()==4){
            System.out.print("#> ");
            String reJouer = sc.nextLine();
            Coord Départ2 = new Coord((Integer.parseInt(reJouer.substring(1,2))), Correspondances(reJouer.substring(0,1)));
            Coord Arrivée2 = new Coord((Integer.parseInt(reJouer.substring(3,4))),Correspondances(reJouer.substring(2,3)));
            Départ =  Départ2;
            Arrivée = Arrivée2;
        }
        déplacer(Départ,Arrivée, e);
    }

    @Override
    public void déplacer(Coord Départ, Coord Arrivée, Echiquier e) {
        assert (estUneSaisiValide(Départ, Arrivée,e));
        for(int i =0; i< e.CouleurJouer().size();i++) {
            if (e.CouleurJouer().get(i).coord().equals(Départ)) {
                if(e.PeutEliminer(Arrivée, Départ)){
                    e.CouleurEnAttente().remove(e.occupant(Arrivée));
                }
                e.CouleurJouer().get(i).Déplacer(Arrivée, e);
            }
        }
    }
    @Override
    public boolean estUneSaisiValide(Coord Départ, Coord Arrivée, Echiquier e){
        for(int i =0; i< e.CouleurJouer().size();i++){
            if(e.CouleurJouer().get(i).coord().equals(Départ)){
                return e.jouable(e.occupant(Départ),Arrivée);
            }
        }
        return false;
    }
    @Override
    public int Correspondances(String s){
        assert (true);
        int Number=5555555;
        switch (s){
            case "a":  Number = 0;
                break;
            case "b":  Number = 1;
                break;
            case "c":  Number = 2;
                break;
            case "d":  Number = 3;
                break;
            case "e": Number = 4;
                break;
            case "f": Number = 5;
                break;
            case "g": Number = 6;
                break;
            case "h": Number = 7;
                break;
        }
        return Number;
    }

    @Override
    public boolean isHumain() {
        return true;
    }
}
