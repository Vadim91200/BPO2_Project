package TypeJoueur;
import Pi�ces.Coord;
import tableur.Echiquier;
import tableur.IJoueur;

import java.util.Scanner;

public class Humain implements IJoueur{
    private static final Scanner sc = new Scanner(System.in);
    @Override
    public void coup(Echiquier e) {
        // Dans le cas g�n�ral, un affichage plus une demande de saisie au joueur
        System.out.print("> ");
        String cartesJouer = sc.nextLine();
        Coord D�part = new Coord((Integer.parseInt(cartesJouer.substring(1,2))), Correspondances(cartesJouer.substring(0,1)));
        Coord Arriv�e = new Coord((Integer.parseInt(cartesJouer.substring(3,4))),Correspondances(cartesJouer.substring(2,3)));

        // Dans le cas o� la saisie du joueur n'est pas une saisie valide
        while(!estUneSaisiValide(D�part,Arriv�e, e) && cartesJouer.length()==4){
            System.out.print("#> ");
            String reJouer = sc.nextLine();
            Coord D�part2 = new Coord((Integer.parseInt(reJouer.substring(1,2))), Correspondances(reJouer.substring(0,1)));
            Coord Arriv�e2 = new Coord((Integer.parseInt(reJouer.substring(3,4))),Correspondances(reJouer.substring(2,3)));
            D�part =  D�part2;
            Arriv�e = Arriv�e2;
        }
        d�placer(D�part,Arriv�e, e);
    }

    @Override
    public void d�placer(Coord D�part, Coord Arriv�e, Echiquier e) {
        assert (estUneSaisiValide(D�part, Arriv�e,e));
        for(int i =0; i< e.CouleurJouer().size();i++) {
            if (e.CouleurJouer().get(i).coord().equals(D�part)) {
                if(e.PeutEliminer(Arriv�e, D�part)){
                    e.CouleurEnAttente().remove(e.occupant(Arriv�e));
                }
                e.CouleurJouer().get(i).D�placer(Arriv�e, e);
            }
        }
    }
    @Override
    public boolean estUneSaisiValide(Coord D�part, Coord Arriv�e, Echiquier e){
        for(int i =0; i< e.CouleurJouer().size();i++){
            if(e.CouleurJouer().get(i).coord().equals(D�part)){
                return e.jouable(e.occupant(D�part),Arriv�e);
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
