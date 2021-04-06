package Brouillon;

public class Brouillon {
    /*public static void jouer(Jeu theGame) {
        int c = 0;
        int g = 0;
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("> ");
        s = sc.nextLine();
        while (true) {
            String[] tab = s.split("\\s+");
            for (String mot : tab) {
                if (mot.contains("'")) {
                    g++;
                }
                if (estValide(mot, theGame.joueurCourant(), theGame.joueurEnattente())) {
                    c++;
                    ajoutTemporaire(mot, theGame.joueurCourant(), theGame.joueurEnattente());
                }
            }
            if (c == tab.length && tab.length != 1 && g <= 1) {
                for (String mot : tab) {
                    ajouter(mot, theGame.joueurCourant(), theGame.joueurEnattente());
                }
                remplissage(theGame.joueurCourant(), s, c);
                ajoutTemporaire(Integer.toString(theGame.joueurCourant().getAscendant()) + "^", theGame.joueurCourant(), theGame.joueurEnattente());
                ajoutTemporaire(Integer.toString(theGame.joueurCourant().getDescendant()) + "v", theGame.joueurCourant(), theGame.joueurEnattente());
                break;
            }
            ajoutTemporaire(Integer.toString(theGame.joueurCourant().getAscendant()) + "^", theGame.joueurCourant(), theGame.joueurEnattente());
            ajoutTemporaire(Integer.toString(theGame.joueurCourant().getDescendant()) + "v", theGame.joueurCourant(), theGame.joueurEnattente());
            ajoutTemporaire(Integer.toString(theGame.joueurEnattente().getAscendant()) + "^", theGame.joueurEnattente(), theGame.joueurCourant());
            ajoutTemporaire(Integer.toString(theGame.joueurEnattente().getDescendant()) + "v", theGame.joueurEnattente(), theGame.joueurCourant());
            c = 0;
            g = 0;
            System.out.print("#> ");
            s = sc.nextLine();
        }
        theGame.changementTour();
    }*/

   /* private static void remplissage(Joueur j1, String s, int c) {
        if (j1.getPcarte().getElement().size() < 6) {
            if (j1.getPcarte().getElement().isEmpty()) {
                System.out.println(c + " cartes posées, 0 cartes piochées ");
            } else if ((NBCARTESMAIN-j1.getMain().size()) > j1.getPcarte().getElement().size()) {
                System.out.println(c + " cartes posées, " + j1.getPcarte().getElement().size() + " cartes piochées ");
                j1.remplirMain(j1.getPcarte().getElement().size());
            }else{
                int i = 0;
                while (j1.getMain().size() < 6) {
                    j1.remplirMain(1);
                    i++;
                }
                System.out.println(c + " cartes posées, " + i + " cartes piochées ");
            }
        } else if (s.contains("'")) {
            int i = 0;
            while (j1.getMain().size() < 6) {
                j1.remplirMain(1);
                i++;
            }
            System.out.println(c + " cartes posées, " + i + " cartes piochées ");

        } else {
            j1.remplirMain(2);
            System.out.println(c + " cartes posées, 2 cartes piochées ");
        }
    }*/

    /*private static boolean estValide(String s, Joueur j, Joueur j2) {
        if (s.length() < 3) {
            return false;
        }
        boolean isValid = true;
        String nb = s.substring(0, 2);
        try {
            Integer.parseInt(nb);
        } catch (NumberFormatException nfe) {
            isValid = false;
        }
        if (isValid) {
            if (!j.getMain().contains(Integer.parseInt(nb))) {
                return false;
            }
            String crochet = s.substring(2, 3);
            if (crochet.equals("v") || crochet.equals("^")) {
                if (s.contains("'")) {
                    String apostrophe = s.substring(3, 4);
                    if (apostrophe.equals("'")) {
                        return (estPosable(s, j, j2, nb));
                    } else return false;
                } else return (estPosable(s, j, j2, nb));
            } else return false;

        }
        return false;
    }

    private static boolean estPosable(String s, Joueur j, Joueur j2, String nb) {
        if (s.contains("'")) {
            if (s.contains("^")) {
                return (Integer.parseInt(nb) < j2.getAscendantTemporaire());
            } else {

                return (Integer.parseInt(nb) > j2.getDescendantTemporaire());
            }
        } else if (s.contains("^")) {
            return (Integer.parseInt(nb) > j.getAscendantTemporaire() || (j.getAscendantTemporaire() - Integer.parseInt(nb)) == 10);
        } else if (s.contains("v")) {
            return (Integer.parseInt(nb) < j.getDescendantTemporaire() || (Integer.parseInt(nb) - j.getDescendantTemporaire()) == 10);
        }
        return false;
    }

    private static void ajouter(String s, Joueur j1, Joueur j2) {
        assert (estValide(s, j1, j2));
        String k = s.substring(0, 2);
        if (s.contains("'")) {
            if (s.contains("^")) {
                j2.PileAscendante().push(Integer.parseInt(k));
            } else {
                j2.PileDescendante().push(Integer.parseInt(k));
            }
            j1.getMain().remove((Integer) Integer.parseInt(k));
        } else if (s.contains("^")) {
            j1.PileAscendante().push(Integer.parseInt(k));
            j1.getMain().remove((Integer) Integer.parseInt(k));
        } else if (s.contains("v")) {
            j1.PileDescendante().push(Integer.parseInt(k));
            j1.getMain().remove((Integer) Integer.parseInt(k));
        }
    }

    private static void ajoutTemporaire(String s, Joueur j1, Joueur j2) {
        assert (estValide(s, j1, j2));
        if (s.length() == 2) {
            s = 0 + s;
        }
        String k = s.substring(0, 2);
        if (s.contains("'")) {
            if (s.contains("^")) {
                j2.setAscendantTemporaire(Integer.parseInt(k));
            } else {
                j2.setDescendantTemporaire(Integer.parseInt(k));
            }
        } else if (s.contains("^")) {
            j1.setAscendantTemporaire(Integer.parseInt(k));
        } else if (s.contains("v")) {
            j1.setDescendantTemporaire(Integer.parseInt(k));
        }
    }*/
}
