package fiche2.src.demo;

import java.util.Scanner;
import fiche2.src.exercice7.ArbreBinaire;
import fiche2.src.exercice7.ArbreBinaire.Noeud;
import utils.Utilitaires;

public class Exercice7 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArbreBinaire arbre = null;
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔═════════════════════════════════════════════════╗");
            System.out.println("║    EXERCICE 7 - TERMINOLOGIE DES ARBRES         ║");
            System.out.println("╠═════════════════════════════════════════════════╣");
            System.out.println("║  1. Créer un arbre d'exemple                    ║");
            System.out.println("║  2. Créer un arbre personnalisé                 ║");
            System.out.println("║  3. Afficher les feuilles                       ║");
            System.out.println("║  4. Afficher les degrés des nœuds               ║");
            System.out.println("║  5. Chercher la profondeur d'un nœud            ║");
            System.out.println("║  6. Calculer la hauteur de l'arbre              ║");
            System.out.println("║  7. Calculer la somme des nœuds                 ║");
            System.out.println("║  0. Retour au menu de la fiche 2                ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    arbre = ArbreBinaire.creerArbreExemple();
                    System.out.println("Arbre d'exemple créé.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 2:
                    arbre = creerArbrePersonnalise();
                    System.out.println("Arbre personnalisé créé.");
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 3:
                    if (arbre != null) {
                        arbre.feuille();
                    } else {
                        System.out.println("Vous devez d'abord créer un arbre.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 4:
                    if (arbre != null) {
                        arbre.degre();
                    } else {
                        System.out.println("Vous devez d'abord créer un arbre.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 5:
                    if (arbre != null) {
                        System.out.print("Entrez la valeur du nœud : ");
                        int valeur = Utilitaires.lireEntier();
                        arbre.profondeur(valeur);
                    } else {
                        System.out.println("Vous devez d'abord créer un arbre.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 6:
                    if (arbre != null) {
                        arbre.hauteur();
                    } else {
                        System.out.println("Vous devez d'abord créer un arbre.");
                    }
                    System.out.println("\nAppuyez sur Entrée pour continuer...");
                    scanner.nextLine();
                    break;
                case 7:
                    if (arbre != null) {
                        arbre.somNoeuds();
                    } else {
                        System.out.println("Vous devez d'abord créer un arbre.");
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

    private static ArbreBinaire creerArbrePersonnalise() {
        System.out.println("Création d'un arbre binaire personnalisé");
        System.out.print("Entrez la valeur de la racine : ");
        int valeurRacine = Utilitaires.lireEntier();

        Noeud racine = new Noeud(valeurRacine);
        ArbreBinaire arbre = new ArbreBinaire(racine);

        System.out.println("Arbre créé avec la racine " + valeurRacine);
        System.out.println("Vous pouvez maintenant ajouter des nœuds à l'arbre.");

        boolean continuer = true;
        while (continuer) {
            System.out.println("\nMenu d'ajout de nœuds :");
            System.out.println("1. Ajouter un nœud");
            System.out.println("0. Terminer la création de l'arbre");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    ajouterNoeud(arbre);
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

        return arbre;
    }

    private static void ajouterNoeud(ArbreBinaire arbre) {
        System.out.print("Entrez la valeur du nœud parent : ");
        int valeurParent = Utilitaires.lireEntier();

        System.out.print("Entrez la valeur du nouveau nœud : ");
        int valeurNoeud = Utilitaires.lireEntier();

        System.out.print("Côté (G pour gauche, D pour droite) : ");
        String cote = scanner.nextLine().trim().toUpperCase();

        boolean ajoute = ajouterNoeudRecursif(arbre.getRacine(), valeurParent, valeurNoeud, cote);

        if (ajoute) {
            System.out.println("Nœud ajouté avec succès.");
        } else {
            System.out.println(
                    "Impossible d'ajouter le nœud. Vérifiez que le nœud parent existe et que la position est libre.");
        }
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }

    private static boolean ajouterNoeudRecursif(Noeud noeud, int valeurParent, int valeurNoeud, String cote) {
        if (noeud == null) {
            return false;
        }

        if (noeud.getValeur() == valeurParent) {
            if (cote.equals("G")) {
                if (noeud.getGauche() == null) {
                    noeud.setGauche(new Noeud(valeurNoeud));
                    return true;
                } else {
                    return false; // Position déjà occupée
                }
            } else if (cote.equals("D")) {
                if (noeud.getDroite() == null) {
                    noeud.setDroite(new Noeud(valeurNoeud));
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return ajouterNoeudRecursif(noeud.getGauche(), valeurParent, valeurNoeud, cote) ||
                ajouterNoeudRecursif(noeud.getDroite(), valeurParent, valeurNoeud, cote);
    }
}
