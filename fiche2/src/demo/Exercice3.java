package fiche2.src.demo;

import java.util.Scanner;
import fiche2.src.exercice3.ListeEntiers;
import utils.Utilitaires;

public class Exercice3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ListeEntiers liste1 = null;
        ListeEntiers liste2 = null;
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔══════════════════════════════════════════════════╗");
            System.out.println("║    EXERCICE 3 - TRAITEMENT LISTES CHAÎNÉES       ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Créer la liste 1                             ║");
            System.out.println("║  2. Créer la liste 2                             ║");
            System.out.println("║  3. Afficher la liste 1                          ║");
            System.out.println("║  4. Afficher la liste 2                          ║");
            System.out.println("║  5. Tester l'égalité des listes                  ║");
            System.out.println("║  6. Concaténer (nouvelle liste)                  ║");
            System.out.println("║  7. Concaténer (sans copie)                      ║");
            System.out.println("║  0. Retour au menu de la fiche 2                 ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    liste1 = ListeEntiers.creerListe();

                    System.out.println("Liste 1 créée.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 2:
                    liste2 = ListeEntiers.creerListe();
                    System.out.println("Liste 2 créée.");
                    break;
                case 3:
                    System.out.println("Liste 1 : " + liste1);
                    if (liste1 != null) {

                        liste1.afficher();
                    } else {
                        System.out.println("La liste 1 n'a pas encore été créée.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 4:
                    if (liste2 != null) {
                        liste2.afficher();
                    } else {
                        System.out.println("La liste 2 n'a pas encore été créée.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 5:
                    if (liste1 != null && liste2 != null) {
                        if (liste1.estEgal(liste2)) {
                            System.out.println("Les listes sont égales.");
                        } else {
                            System.out.println("Les listes sont différentes.");
                        }
                    } else {
                        System.out.println("Les deux listes doivent être créées d'abord.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 6:
                    if (liste1 != null && liste2 != null) {
                        ListeEntiers liste3 = liste1.concatener(liste2);
                        System.out.println("Listes concaténées dans une nouvelle liste :");
                        liste3.afficher();
                    } else {
                        System.out.println("Les deux listes doivent être créées d'abord.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 7:
                    if (liste1 != null && liste2 != null) {
                        liste1.concatenerSansCopie(liste2);
                        System.out.println("Liste 2 concaténée à la liste 1 :");
                        liste1.afficher();
                    } else {
                        System.out.println("Les deux listes doivent être créées d'abord.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 0:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayerf.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
            }
        }
    }
}
