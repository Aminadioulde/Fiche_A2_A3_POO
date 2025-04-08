package fiche1.exercice2;

import java.util.Scanner;

/**
 * Classe de démonstration pour l'exercice 2
 * @author v0
 */
public class DemoListeChaineeDouble {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ListeChaineeDouble liste = new ListeChaineeDouble();
        boolean continuer = true;
        
        System.out.println("===== Exercice 2: Listes chaînées bidirectionnelles =====");
        
        while (continuer) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter une chaîne au début");
            System.out.println("2. Supprimer une chaîne");
            System.out.println("3. Afficher la liste (de la tête vers la queue)");
            System.out.println("4. Afficher la liste (de la queue vers la tête)");
            System.out.println("0. Retour au menu de la fiche 1");
            System.out.print("Votre choix : ");
            
            int choix = lireEntier();
            
            switch (choix) {
                case 1:
                    System.out.print("Entrez la chaîne à ajouter au début : ");
                    String chaine = scanner.nextLine();
                    liste.ajouterDevant(chaine);
                    System.out.println("Chaîne ajoutée au début de la liste.");
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

