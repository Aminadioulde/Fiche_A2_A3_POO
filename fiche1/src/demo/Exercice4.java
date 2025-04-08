package fiche1.src.demo;

import fiche1.src.exercice4.Polynome;
import fiche1.src.exercice4.Polynome2;
import utils.Utilitaires;

public class Exercice4 {
    public static void main(String[] args) {
        boolean continuer = true;
        Polynome polynome = null;
        Polynome2 polynome2 = null;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔═══════════════════════════════════════════════════╗");
            System.out.println("║           EXERCICE 4 - POLYNÔMES                  ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║  1. Créer un polynôme                             ║");
            System.out.println("║  2. Créer un polynôme du second degré             ║");
            System.out.println("║  3. Afficher le polynôme courant                  ║");
            System.out.println("║  4. Calculer et afficher la dérivée               ║");
            System.out.println("║  5. Évaluer pour une valeur de x                  ║");
            System.out.println("║  6. Additionner avec 2-3x²+x⁴                     ║");
            System.out.println("║  0. Quitter                                       ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");

            System.out.print("Choix : ");
            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    System.out.println("\nCréation d'un polynôme");
                    System.out.println("Entrez les coefficients (N pour terminer):");
                    int[] coeffs = new int[10];
                    int i = 0;
                    while (i < 10) {
                        System.out.print("Coeff " + (i + 1) + " : ");
                        String chaine = Utilitaires.lireChaine();
                        if (chaine.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            coeffs[i++] = Integer.parseInt(chaine);
                        }
                    }
                    Integer[] finalCoeffs = new Integer[i];
                    for (int j = 0; j < i; j++) {
                        finalCoeffs[j] = coeffs[j];
                    }
                    polynome = new Polynome(finalCoeffs);
                    System.out.println("Polynôme créé : " + polynome);
                    break;

                case 2:
                    System.out.println("\nCréation d'un polynôme du second degré (ax² + bx + c)");
                    System.out.print("Entrez le coefficient de x² (a) : ");
                    int a = Utilitaires.lireEntier();
                    System.out.print("Entrez le coefficient de x (b) : ");
                    int b = Utilitaires.lireEntier();
                    System.out.print("Entrez le coefficient constant (c) : ");
                    int c = Utilitaires.lireEntier();
                    polynome2 = new Polynome2(c, b, a);
                    System.out.println("Polynôme créé : " + polynome2);
                    polynome2.resoudreEquation();
                    break;

                case 3:
                    if (polynome != null) {
                        System.out.println("Polynôme actuel : " + polynome);
                    } else if (polynome2 != null) {
                        System.out.println("Polynôme actuel : " + polynome2);
                    } else {
                        System.out.println("Aucun polynôme n'a été créé");
                    }
                    break;

                case 4:
                    if (polynome != null) {
                        System.out.println("Dérivée : " + Polynome.derivee(polynome));
                    } else if (polynome2 != null) {
                        System.out.println("Dérivée : " + Polynome.derivee(polynome2));
                    } else {
                        System.out.println("Aucun polynôme n'a été créé");
                    }
                    break;

                case 5:
                    if (polynome != null || polynome2 != null) {
                        System.out.print("Entrez la valeur de x : ");
                        double x = Utilitaires.lireDouble();
                        if (polynome != null) {
                            System.out.println("P(" + x + ") = " + Polynome.evaluer(polynome, x));
                        } else {
                            System.out.println("P(" + x + ") = " + Polynome.evaluer(polynome2, x));
                        }
                    } else {
                        System.out.println("Aucun polynôme n'a été créé");
                    }
                    break;

                case 6:
                    if (polynome != null || polynome2 != null) {
                        Polynome special = new Polynome(2, 0, -3, 0, 1);
                        System.out.println("Polynôme spécial : " + special);
                        if (polynome != null) {
                            System.out.println("Résultat : " + Polynome.additionner(polynome, special));
                        } else {
                            System.out.println("Résultat : " + Polynome.additionner(polynome2, special));
                        }
                    } else {
                        System.out.println("Aucun polynôme n'a été créé");
                    }
                    break;

                case 0:
                    continuer = false;
                    break;

                default:
                    System.out.println("Choix invalide!");
            }

            if (choix != 0) {
                Utilitaires.attendreEntree();
            }
        }
    }
}