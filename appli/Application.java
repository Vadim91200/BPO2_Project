package appli;
import tableur.Echiquier;


import java.util.Scanner;

public class Application {
    private static final Scanner sc = new Scanner(System.in);
    private static void Afficher(Echiquier Echec) {

        System.out.println("Bonjour et bienvennu dans cette partie d'échec votre but est de terminer cette partie ");
        System.out.println("Veuillez tout d'abord choisir votre mode de jeu: Humain contre Humain(hh), Humain contre Ordinateur(ho) ou bien Ordinateur contre Ordinateur(oo)");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s;
            s = sc.nextLine();
            if (estValide(s,Echec)) {
                break;
            }
            System.out.println("Saisi invalide veuillez ressayé ");
        }
    }
    private static boolean estValide(String s, Echiquier Echec) {
        if (s.equals("hh")) {
            Echec.setMode(1);
            return true;
        } else if (s.equals("ho")) {
            Echec.setMode(2);
            return true;
        } else if (s.equals("oo")) {
            Echec.setMode(3);
            return true;
        }
        return false;
    }
    public static void demarer(Echiquier Echec){
        if (Echec.getMode()==1){
            while (Echec.finie()){
                joue(Echec);
                Echec.setTour();
                System.out.println(Echec);

            }

        }else if(Echec.getMode()==2){
            joue(Echec);

        }else if(Echec.getMode()==3){

        }else{
            System.out.println("MERDE");
        }
    }
    private static void joue(Echiquier Echec){// Dans le cas général, un affichage plus une demande de saisie au joueur
        System.out.print("> ");
        String cartesJouer = sc.nextLine();


        // Dans le cas où la saisie du joueur n'est pas une saisie valide
        while(!Echec.estUneSaisiValide(cartesJouer)){
            System.out.print("#> ");
            String reJouer = sc.nextLine();
            cartesJouer = reJouer;
        }
        Echec.déplacer(cartesJouer);
    }
    public static void main(String args[]) {
        Echiquier Echec = new Echiquier();
        System.out.println(Echec.toString());
        Afficher(Echec);
        demarer(Echec);
        System.out.println(Echec.toString());

      //  if (Echec.joueurCourant() == Test.getBLANC()) {
        //    System.out.println("partie finie, " + "NomJoueur" + " a gagné");
       // } else {
        //    System.out.println("partie finie," + "NomJoueur" + "a gagné");
        //}
    }
}