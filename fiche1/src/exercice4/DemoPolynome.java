package fiche1.exercice4;

import java.util.Scanner;

/**
 * Classe de démonstration pour l'exercice 4
 * @author v0
 */
public class DemoPolynome {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Polynome polynome = new Polynome();
        boolean continuer = true;
        
        System.out.println("===== Exercice 4: Dérivée d'un polynôme =====");
        
        while (continuer) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un terme au polynôme");
            System.out.println("2. Afficher le polynôme");
            System.out.println("3. Calculer la dérivée");
            System.out.println("4. Calculer la dérivée k-ième");
            System.out.println("0. Retour au menu de la fiche 1");
            System.out.print("Votre choix : ");
            
            int choix = lireEntier();
            
            switch (choix) {
                case 1:
                    System.out.print("Entrez le coefficient : ");
                    int coefficient = lireEntier();
                    System.out.print("Entrez le degré : ");
                    int degre = lireEntier();
                    polynome.ajouterTerme(coefficient, degre);
                    System.out.println("Terme ajouté au polynôme.");
                    break;
                case 2:
                    System.out.print("P(x) = ");
                    polynome.afficher();
                    break;
                case 3:
                    Polynome derivee = polynome.derivee();
                    System.out.print("P'(x) = ");
                    derivee.afficher();
                    break;
                case 4:
                    System.out.print("Entrez l'ordre k de la dérivée : ");
                    int k = lireEntier();
                    try {
                        Polynome deriveeK = polynome.deriveeKieme(k);
                        System.out.print("P^(" + k + ")(x) = ");
                        deriveeK.afficher();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
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
     * Lit un entier depuis l'entrée standard avec gestion des erreurs
     * @return l'entier saisi
     */
    private static int lireEntier() {
        int valeur = 0;
        boolean valide = false;
        
        while (!valide) {
            try {
                valeur = Integer.parseInt(scanner.nextLine().trim());
                valide = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Veuillez saisir un nombre : ");
            }
        }
        
        return valeur;
    }
}

