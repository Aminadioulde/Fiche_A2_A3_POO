package fiche2.src.demo;

import java.util.Scanner;
import fiche2.src.exercice4.Polynome;
import utils.Utilitaires;

public class Exercice4 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Polynome polynome = new Polynome();
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔═════════════════════════════════════════════════╗");
            System.out.println("║        EXERCICE 4 - DÉRIVÉE POLYNÔME            ║");
            System.out.println("╠═════════════════════════════════════════════════╣");
            System.out.println("║  1. Ajouter un terme au polynôme                ║");
            System.out.println("║  2. Afficher le polynôme                        ║");
            System.out.println("║  3. Calculer la dérivée                         ║");
            System.out.println("║  4. Calculer la dérivée k-ième                  ║");
            System.out.println("║  0. Retour au menu de la fiche 2                ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le coefficient : ");
                    int coefficient = Utilitaires.lireEntier();
                    System.out.print("Entrez le degré : ");
                    int degre = Utilitaires.lireEntier();
                    polynome.ajouterTerme(coefficient, degre);
                    System.out.println("Terme ajouté au polynôme.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("P(x) = ");
                    polynome.afficher();
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 3:
                    Polynome derivee = polynome.derivee();
                    System.out.print("P'(x) = ");
                    derivee.afficher();
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Entrez l'ordre k de la dérivée : ");
                    int k = Utilitaires.lireEntier();
                    Polynome deriveek = polynome.deriveeKieme(k);
                    System.out.print("P" + "(".repeat(k) + "x" + ")".repeat(k) + " = ");
                    deriveek.afficher();
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 0:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
            }
        }
    }
}
