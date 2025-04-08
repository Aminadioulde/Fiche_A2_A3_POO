package fiche2.src.demo;

import java.util.Scanner;
import fiche2.src.exercice8.IndexABR;
import utils.Utilitaires;

public class Exercice8 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IndexABR index = null;
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔═══════════════════════════════════════════════════╗");
            System.out.println("║             EXERCICE 8 - LCB ET ABR               ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║  1. Créer un index d'exemple                      ║");
            System.out.println("║  2. Ajouter un nom propre                         ║");
            System.out.println("║  3. Supprimer un numéro de page                   ║");
            System.out.println("║  4. Supprimer un nom propre                       ║");
            System.out.println("║  5. Rechercher les occurrences d'un nom           ║");
            System.out.println("║  6. Afficher l'index                              ║");
            System.out.println("║  7. Afficher les statistiques de l'index          ║");
            System.out.println("║  0. Retour au menu de la fiche 2                  ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    index = IndexABR.creerIndexExemple();
                    System.out.println("Index d'exemple créé.");
                    break;
                case 2:
                    if (index == null) {
                        index = new IndexABR();
                    }

                    System.out.print("Entrez le nom propre : ");
                    String nom = scanner.nextLine().trim();

                    System.out.print("Entrez le nombre de pages : ");
                    int nombre = Utilitaires.lireEntier();

                    int[] pages = new int[nombre];
                    System.out.println("Entrez les numéros de page :");

                    for (int i = 0; i < nombre; i++) {
                        System.out.print("Page " + (i + 1) + " : ");
                        pages[i] = Utilitaires.lireEntier();
                    }

                    index = IndexABR.ajoutNomPropre(nom, pages, nombre, index);
                    System.out.println("Nom propre ajouté à l'index.");
                    break;
                case 3:
                    if (index != null) {
                        System.out.print("Entrez le nom propre : ");
                        String nomSuppr = scanner.nextLine().trim();

                        System.out.print("Entrez le numéro de page à supprimer : ");
                        int numeroSuppr = Utilitaires.lireEntier();

                        index = IndexABR.supprimerNumero(nomSuppr, numeroSuppr, index);
                        System.out.println("Numéro de page supprimé (s'il existait).");
                    } else {
                        System.out.println("Vous devez d'abord créer un index.");
                    }
                    break;
                case 4:
                    if (index != null) {
                        System.out.print("Entrez le nom propre à supprimer : ");
                        String nomSuppr = scanner.nextLine().trim();

                        index = IndexABR.supprimerNom(nomSuppr, index);
                        System.out.println("Nom propre supprimé (s'il existait).");
                    } else {
                        System.out.println("Vous devez d'abord créer un index.");
                    }
                    break;
                case 5:
                    if (index != null) {
                        System.out.print("Entrez le nom propre à rechercher : ");
                        String nomRecherche = scanner.nextLine().trim();

                        int[] occurrences = index.rechercherOccurrences(nomRecherche);

                        if (occurrences == null) {
                            System.out.println("Le nom '" + nomRecherche + "' n'existe pas dans l'index.");
                        } else {
                            System.out.print("Occurrences de '" + nomRecherche + "' : ");
                            for (int i = 0; i < occurrences.length; i++) {
                                System.out.print(occurrences[i]);
                                if (i < occurrences.length - 1) {
                                    System.out.print(", ");
                                }
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Vous devez d'abord créer un index.");
                    }
                    break;
                case 6:
                    if (index != null) {
                        index.afficherIndex();
                    } else {
                        System.out.println("Vous devez d'abord créer un index.");
                    }
                    break;
                case 7:
                    if (index != null) {
                        System.out.println("Statistiques de l'index :");
                        System.out.println("Hauteur de l'arbre : " + index.hauteur());
                        System.out.println("Nombre de noms propres : " + index.nombreNoeuds());
                    } else {
                        System.out.println("Vous devez d'abord créer un index.");
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
}
