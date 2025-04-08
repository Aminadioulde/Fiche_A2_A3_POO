package fiche2.src.demo;

import java.util.Scanner;
import fiche2.src.exercice2.ListeChaineeDouble;
import utils.Utilitaires;

public class Exercice2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ListeChaineeDouble liste = new ListeChaineeDouble();
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔══════════════════════════════════════════════════╗");
            System.out.println("║      EXERCICE 2 - LISTES BIDIRECTIONNELLES       ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Ajouter une chaîne au début                  ║");
            System.out.println("║  2. Supprimer une chaîne                         ║");
            System.out.println("║  3. Afficher la liste (tête vers queue)          ║");
            System.out.println("║  4. Afficher la liste (queue vers tête)          ║");
            System.out.println("║  0. Retour au menu de la fiche 2                 ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    System.out.print("Entrez la chaîne à ajouter au début : ");
                    String chaine = scanner.nextLine();
                    liste.ajouterDevant(chaine);
                    System.out.println("Chaîne ajoutée au début de la liste.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Entrez la chaîne à supprimer : ");
                    String chaineSuppr = scanner.nextLine();
                    liste.supprimer(chaineSuppr);
                    System.out.println("Chaîne supprimée de la liste (si elle existait).");
                    break;
                case 3:
                    liste.afficher();
                    break;
                case 4:
                    liste.afficherInverse();
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
