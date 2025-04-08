package fiche1.exercice1;

import java.util.Scanner;

/**
 * Classe de démonstration pour l'exercice 1
 */
public class DemoListeChainee {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ListeChainee liste = new ListeChainee();
        boolean continuer = true;

        System.out.println("===== Exercice 1: Listes chaînées et chaînes de caractères =====");

        while (continuer) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un mot au début");
            System.out.println("2. Ajouter un mot à la fin");
            System.out.println("3. Supprimer un mot");
            System.out.println("4. Afficher les n premiers mots");
            System.out.println("5. Purifier la liste (supprimer les doublons)");
            System.out.println("6. Afficher toute la liste");
            System.out.println("0. Retour au menu de la fiche 1");
            System.out.print("Votre choix : ");

            int choix = lireEntier();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le mot à ajouter au début : ");
                    String motDebut = scanner.nextLine();
                    liste.ajouteDebut(motDebut);
                    System.out.println("Mot ajouté au début de la liste.");
                    break;
                case 2:
                    System.out.print("Entrez le mot à ajouter à la fin : ");
                    String motFin = scanner.nextLine();
                    liste.ajouteFin(motFin);
                    System.out.println("Mot ajouté à la fin de la liste.");
                    break;
                case 3:
                    System.out.print("Entrez le mot à supprimer : ");
                    String motSuppr = scanner.nextLine();
                    liste.supprimer(motSuppr);
                    System.out.println("Mot supprimé de la liste (s'il existait).");
                    break;
                case 4:
                    System.out.print("Combien de mots voulez-vous afficher ? ");
                    int n = lireEntier();
                    liste.premiers(n);
                    break;
                case 5:
                    liste.purifie();
                    System.out.println("Liste purifiée (doublons supprimés).");
                    break;
                case 6:
                    liste.afficher();
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
     * 
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
