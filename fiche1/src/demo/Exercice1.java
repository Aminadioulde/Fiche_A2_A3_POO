package fiche1.src.demo;

import fiche1.src.exercice1.Liste;
import utils.Utilitaires;
import java.util.Scanner;

public class Exercice1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Liste liste = null;
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔═══════════════════════════════════════════════════╗");
            System.out.println("║         EXERCICE 1 - LISTES CHAÎNÉES              ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║  1. Créer une nouvelle liste                      ║");
            System.out.println("║  2. Ajouter un élément à la fin                   ║");
            System.out.println("║  3. Trier la liste (QuickSort)                    ║");
            System.out.println("║  4. Afficher la liste                             ║");
            System.out.println("║  5. Supprimer les éléments inférieurs             ║");
            System.out.println("║  0. Retour au menu de la fiche 1                  ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    System.out.println("Entrez les valeurs de la liste (terminez par une ligne vide) :");
                    System.out.print("Valeur : ");
                    String premierElement = scanner.nextLine();
                    if (!premierElement.trim().isEmpty()) {
                        liste = new Liste(premierElement);
                        String valeur;
                        do {
                            System.out.print("Valeur (ou vide pour terminer) : ");
                            valeur = scanner.nextLine();
                            if (!valeur.trim().isEmpty()) {
                                liste.append(new Liste(valeur));
                            }
                        } while (!valeur.trim().isEmpty());
                        System.out.println("Nouvelle liste créée.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 2:
                    if (liste != null) {
                        System.out.println("Entrez les valeurs à ajouter (terminez par une ligne vide) :");
                        String nouvelleValeur;
                        do {
                            System.out.print("Valeur (ou vide pour terminer) : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.trim().isEmpty()) {
                                liste.append(new Liste(nouvelleValeur));
                            }
                        } while (!nouvelleValeur.trim().isEmpty());
                        System.out.println("Valeurs ajoutées à la liste.");
                    } else {
                        System.out.println("Créez d'abord une liste.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 3:
                    if (liste != null) {
                        liste = liste.quicksort();
                        System.out.println("Liste triée.");
                    } else {
                        System.out.println("Créez d'abord une liste.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 4:
                    if (liste != null) {
                        System.out.println("\nContenu de la liste :");
                        liste.afficher();
                    } else {
                        System.out.println("La liste est vide.");
                    }
                    Utilitaires.attendreEntree();
                    break;
                case 5:
                    if (liste != null) {
                        Liste inferieurs = liste.supprimerInferieur();
                        System.out.println("Éléments inférieurs supprimés :");
                        if (inferieurs != null) {
                            inferieurs.afficher();
                        } else {
                            System.out.println("Aucun élément inférieur trouvé.");
                        }
                    } else {
                        System.out.println("Créez d'abord une liste.");
                    }
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
