package fiche2.src;

import fiche2.src.demo.Exercice1;
import fiche2.src.demo.Exercice2;
import fiche2.src.demo.Exercice3;
import fiche2.src.demo.Exercice4;
import fiche2.src.demo.Exercice5;
import fiche2.src.demo.Exercice6;
import fiche2.src.demo.Exercice7;
import fiche2.src.demo.Exercice8;
import fiche2.src.demo.testStatic.*;
import utils.Utilitaires;

/**
 * Classe de menu pour la fiche 2 d'exercices
 */
public class MenuFiche2 {

    /**
     * Affiche et traite le menu principal de la fiche 2
     */
    public static void afficherEtTraiter() {
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔══════════════════════════════════════════════════╗");
            System.out.println("║                     FICHE 2                      ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Listes chaînées et chaînes de caractères     ║");
            System.out.println("║  2. Listes chaînées bidirectionnelles            ║");
            System.out.println("║  3. Traitement de listes chaînées                ║");
            System.out.println("║  4. Dérivée d'un polynôme                        ║");
            System.out.println("║  5. Vecteurs creux                               ║");
            System.out.println("║  6. Matrices symétriques                         ║");
            System.out.println("║  7. Terminologie sur les arbres                  ║");
            System.out.println("║  8. LCB et ABR                                   ║");
            System.out.println("║  0. Retour au menu principal                     ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    Exercice1.main(null);
                    break;
                case 2:
                    Exercice2.main(null);
                    break;
                case 3:
                    Exercice3.main(null);
                    break;
                case 4:
                    Exercice4.main(null);
                    break;
                case 5:
                    Exercice5.main(null);
                    break;
                case 6:
                    Exercice6.main(null);
                    break;
                case 7:
                    Exercice7.main(null);
                    break;
                case 8:
                    Exercice8.main(null);
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
            System.out.println("║              TESTS STATIQUES - FICHE 2           ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Test Exercice 1 - Listes chaînées simples    ║");
            System.out.println("║  2. Test Exercice 2 - Listes bidirectionnelles   ║");
            System.out.println("║  3. Test Exercice 3 - Traitement de listes       ║");
            System.out.println("║  4. Test Exercice 4 - Dérivée d'un polynôme      ║");
            System.out.println("║  5. Test Exercice 5 - Vecteurs creux             ║");
            System.out.println("║  6. Test Exercice 6 - Matrices symétriques       ║");
            System.out.println("║  7. Test Exercice 7 - sur les arbres             ║");
            System.out.println("║  8. Test Exercice 8 - LCB et ABR                 ║");
            System.out.println("║  9. Exécuter tous les tests                      ║");
            System.out.println("║  0. Retour au menu principal                     ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    TestExercice1.tester();
                    Utilitaires.attendreEntree();
                    break;
                case 2:
                    TestExercice2.tester();
                    Utilitaires.attendreEntree();
                    break;
                case 3:
                    TestExercice3.tester();
                    Utilitaires.attendreEntree();
                    break;
                case 4:
                    TestExercice4.tester();
                    Utilitaires.attendreEntree();
                    break;
                case 5:
                    TestExercice5.tester();
                    Utilitaires.attendreEntree();
                    break;
                case 6:
                    TestExercice6.tester();
                    Utilitaires.attendreEntree();
                    break;
                case 7:
                    TestExercice7.tester();
                    Utilitaires.attendreEntree();
                    break;
                case 8:
                    TestExercice8.tester();
                    Utilitaires.attendreEntree();
                    break;
                case 9:
                    executerTousLesTests();
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

    /**
     * Exécute tous les tests statiques pour les exercices de la fiche 2
     */
    private static void executerTousLesTests() {
        Utilitaires.clearScreen();
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║           TOUS LES TESTS STATIQUES               ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        TestExercice1.tester();
        TestExercice2.tester();
        TestExercice3.tester();
        TestExercice4.tester();
        TestExercice5.tester();
        TestExercice6.tester();
        TestExercice7.tester();
        TestExercice8.tester();

        System.out.println("\n'Tous les tests statiques ont été exécutés.");
    }
}
