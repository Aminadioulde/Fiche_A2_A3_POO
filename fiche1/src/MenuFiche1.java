package fiche1.src;

import fiche1.src.demo.Exercice1;
import fiche1.src.demo.Exercice3;
import fiche1.src.demo.Exercice4;
import fiche1.src.demo.Exercice5;
import fiche1.src.demo.testStatic.*;
import utils.Utilitaires;

/**
 * Classe de menu pour la fiche 11 d'exercices
 */
public class MenuFiche1 {

    /**
     * Affiche et traite le menu principal de la fiche 1
     */
    public static void afficherEtTraiter() {
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔══════════════════════════════════════════════════╗");
            System.out.println("║                     FICHE 1 (A2)                 ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Listes chaînées                              ║");
            System.out.println("║  3. Grands entiers                               ║");
            System.out.println("║  4. Représentation et Manipulation de Polynômes  ║");
            System.out.println("║  5. Intervalles d'entiers                        ║");
            System.out.println("║  0. Retour au menu principal                     ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    Exercice1.main(null);
                    Utilitaires.attendreEntree();
                    break;
                case 3:
                    Exercice3.main(null);
                    Utilitaires.attendreEntree();
                    break;
                case 4:
                    Exercice4.main(null);
                    Utilitaires.attendreEntree();
                    break;
                case 5:
                    new Exercice5().afficherEtTraiter();
                    Utilitaires.attendreEntree();
                    break;
                case 0:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    /**
     * Affiche et traite le menu des tests statiques
     */
    public static void afficherMenuTestsStatiques() {
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔══════════════════════════════════════════════════╗");
            System.out.println("║            TESTS STATIQUES - FICHE 1 (A2)        ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Listes chaînées                              ║");
            System.out.println("║  3. Grands entiers                               ║");
            System.out.println("║  4. Représentation et Manipulation de Polynômes  ║");
            System.out.println("║  5. Intervalles d'entiers                        ║");
            System.out.println("║  0. Retour au menu principal                     ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    TestExercice1.main(null);
                    Utilitaires.attendreEntree();
                    break;
                case 3:
                    TestExercice3.main(null);
                    Utilitaires.attendreEntree();
                    break;
                case 4:
                    TestExercice4.main(null);
                    Utilitaires.attendreEntree();
                    break;
                case 5:
                    TestExercice5.main(null);
                    Utilitaires.attendreEntree();
                    break;
                case 0:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    Utilitaires.attendreEntree();
            }
        }
    }

}
