package fiche1.src;

import java.util.Scanner;
import fiche1.src.exercice1.DemoListeChainee;
import fiche1.src.exercice3.GrandInt;
import fiche1.src.exercice4.Polynome;
//import fiche2.src.exercice1.ListeChainee;

/**
 * Menu pour la fiche 1
 * 
 * @author v0
 */
public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Affiche le menu de la fiche 1 et traite le choix de l'utilisateur
     */
    public void afficherEtTraiter() {
        boolean continuer = true;

        afficherBanniere();

        while (continuer) {
            System.out.println("\n===== FICHE 1 =====");
            System.out.println("1. Exercice 1 - Liste chaines");
            System.out.println("2. Exercice 3 - Grands Entiers");
            System.out.println("3. Exercice 4 - Representation et Manipulation de Polynomes");
            System.out.println("4. Exercice 5 - Intervalles d'entiers");
            System.out.println("0. Retour au menu principal");
            System.out.print("Votre choix : ");

            int choix = lireEntier();

            switch (choix) {
                case 1:
                    DemoListeChainee.main(null);
                    break;
                case 2:
                    GrandInt.main(null);
                    break;
                case 3:
                    Polynome.main(null);
                    break;
                //case 4:
                    //.main(null;
                    //break;
                case 0:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    /**
     * Affiche une bannière pour la fiche 1
     */
    private void afficherBanniere() {
        System.out.println("*************************************************************");
        System.out.println("*                                                           *");
        System.out.println("*                        FICHE 1                            *");
        System.out.println("*                                                           *");
        System.out.println("*************************************************************");
        System.out.println();
        System.out.println("Cette fiche contient les exercices suivants :");
        System.out.println("- Exercice 1 : Listes chaînées et chaînes de caractères");
        System.out.println("- Exercice 3 : Listes chaînées bidirectionnelles");
        System.out.println("- Exercice 4: Traitement de listes chaînées");
        System.out.println("- Exercice 5 : Dérivée d'un polynôme");
        System.out.println();
    }

    /**
     * Lit un entier depuis l'entrée standard avec gestion des erreurs
     * 
     * @return l'entier saisi
     */
    private int lireEntier() {
        int valeur = 0;
        boolean valide = false;

        while (!valide) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Entrée vide. Veuillez saisir un nombre : ");
                    continue;
                }
                valeur = Integer.parseInt(input);
                valide = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Veuillez saisir un nombre : ");
            }
        }

        return valeur;
    }
}
