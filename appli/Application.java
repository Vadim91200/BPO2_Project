package appli;
import tableur.Echiquier;


import java.util.Scanner;

public class Application {

    private static int Afficher() {

        System.out.println("Bonjour et bienvennu dans cette partie d'échec votre but est de terminer cette partie ");
        System.out.println("Veuillez tout d'abord choisir votre mode de jeu: Humain contre Humain(hh), Humain contre Ordinateur(ho) ou bien Ordinateur contre Ordinateur(oo)");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s;
            s = sc.nextLine();
            if (estValide(s)==1) {
                return 1;
            }else if(estValide(s)==2){
                return 2;
            }else if(estValide(s)==3){
                return 3;
            }
            System.out.println("Saisi invalide veuillez ressayé ");
        }
    }
    private static int estValide(String s) {
        if (s.equals("hh")) {
            return 1;
        } else if (s.equals("ho")) {
            return 2;
        } else if (s.equals("oo")) {
            return 3;
        }
        return 555555;
    }

    public static void main(String args[]) {
        Echiquier Echec = SelectionJoueur.choisir(Afficher()) ;
        System.out.println(Echec.toString());
        while (!Echec.finie()) {
            Echec.JoueurJouer().coup(Echec);
            Echec.setTour();
            System.out.println(Echec);
        }

    }
}