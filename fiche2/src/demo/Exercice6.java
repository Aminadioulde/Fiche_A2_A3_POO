package fiche2.src.demo;

import java.util.Scanner;
import fiche2.src.exercice6.MatriceSymetrique;
import fiche2.src.exercice6.MatriceSymetrique.MatCarree;
import utils.Utilitaires;

public class Exercice6 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MatCarree matrice = null;
        double[] compact = null;
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔═════════════════════════════════════════════════╗");
            System.out.println("║       EXERCICE 6 - MATRICES SYMÉTRIQUES         ║");
            System.out.println("╠═════════════════════════════════════════════════╣");
            System.out.println("║  1. Créer une matrice                           ║");
            System.out.println("║  2. Remplir la matrice                          ║");
            System.out.println("║  3. Vérifier la symétrie                        ║");
            System.out.println("║  4. Créer la représentation compacte            ║");
            System.out.println("║  5. Afficher la matrice                         ║");
            System.out.println("║  6. Traiter une ligne                           ║");
            System.out.println("║  0. Retour au menu de la fiche 2                ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    System.out.print("Entrez la taille de la matrice : ");
                    int taille = Utilitaires.lireEntier();
                    matrice = new MatCarree(taille);
                    System.out.println("Matrice créée.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 2:
                    if (matrice != null) {
                        for (int i = 0; i < matrice.getTaille(); i++) {
                            for (int j = 0; j < matrice.getTaille(); j++) {
                                System.out.printf("Élément [%d,%d] : ", i, j);
                                double valeur = Double.parseDouble(scanner.nextLine().trim());
                                matrice.setElement(i, j, valeur);
                            }
                        }
                        System.out.println("Matrice remplie.");
                    } else {
                        System.out.println("Créez d'abord une matrice.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 3:
                    if (matrice != null) {
                        boolean sym = MatriceSymetrique.symetrique(matrice);
                        System.out.println("La matrice " + (sym ? "est" : "n'est pas") + " symétrique.");
                    } else {
                        System.out.println("Créez d'abord une matrice.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 4:
                    if (matrice != null) {
                        compact = MatriceSymetrique.symCompacte(matrice, matrice.getTaille());
                        if (compact != null) {
                            System.out.println("Représentation compacte créée.");
                        } else {
                            System.out.println("La matrice n'est pas symétrique.");
                        }
                    } else {
                        System.out.println("Créez d'abord une matrice.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 5:
                    if (compact != null) {
                        MatriceSymetrique.afficher(compact, matrice.getTaille());
                    } else {
                        System.out.println("Créez d'abord une représentation compacte.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 6:
                    if (compact != null) {
                        System.out.print("Entrez le numéro de la ligne à traiter : ");
                        int ligne = Utilitaires.lireEntier();
                        if (ligne >= 0 && ligne < matrice.getTaille()) {
                            MatriceSymetrique.traiterLigne(compact, matrice.getTaille(), ligne);
                        } else {
                            System.out.println("Numéro de ligne invalide.");
                        }
                    } else {
                        System.out.println("Créez d'abord une représentation compacte.");
                    }
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