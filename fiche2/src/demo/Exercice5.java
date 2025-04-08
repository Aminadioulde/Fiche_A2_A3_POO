package fiche2.src.demo;

import java.util.Scanner;
import fiche2.src.exercice5.VecteurCreux;
import utils.Utilitaires;

public class Exercice5 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        VecteurCreux vecteurA = null;
        VecteurCreux vecteurB = null;
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔═════════════════════════════════════════════════╗");
            System.out.println("║         EXERCICE 5 - VECTEURS CREUX             ║");
            System.out.println("╠═════════════════════════════════════════════════╣");
            System.out.println("║  1. Créer le vecteur A                          ║");
            System.out.println("║  2. Créer le vecteur B                          ║");
            System.out.println("║  3. Afficher le vecteur A                       ║");
            System.out.println("║  4. Afficher le vecteur B                       ║");
            System.out.println("║  5. Additionner les vecteurs                    ║");
            System.out.println("║  6. Multiplier les vecteurs                     ║");
            System.out.println("║  0. Retour au menu de la fiche 2                ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    System.out.print("Entrez la taille du vecteur : ");
                    int tailleA = Utilitaires.lireEntier();
                    vecteurA = new VecteurCreux(tailleA);
                    System.out.println("Vecteur A créé.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Entrez la taille du vecteur : ");
                    int tailleB = Utilitaires.lireEntier();
                    vecteurB = new VecteurCreux(tailleB);
                    System.out.println("Vecteur B créé.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 3:
                    if (vecteurA != null) {
                        vecteurA.afficher();
                    } else {
                        System.out.println("Le vecteur A n'a pas encore été créé.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 4:
                    if (vecteurB != null) {
                        vecteurB.afficher();
                    } else {
                        System.out.println("Le vecteur B n'a pas encore été créé.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 5:
                    if (vecteurA != null && vecteurB != null) {
                        VecteurCreux somme = vecteurA.additionner(vecteurB);
                        System.out.println("Somme des vecteurs :");
                        somme.afficher();
                    } else {
                        System.out.println("Les deux vecteurs doivent être créés d'abord.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 6:
                    if (vecteurA != null && vecteurB != null) {
                        float produit = vecteurA.multiplier(vecteurB);
                        System.out.println("Produit scalaire : " + produit);
                    } else {
                        System.out.println("Les deux vecteurs doivent être créés d'abord.");
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
