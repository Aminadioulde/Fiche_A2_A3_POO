package fiche2.src.demo;

import fiche2.src.exercice1.ListeChainee;
import utils.Utilitaires;

/**
 * Classe de démonstration pour l'exercice 1 (Listes chaînées et chaînes de caractères)
 */
public class Exercice1 {

    /**
     * Méthode principale pour la démonstration de l'exercice 1
     * 
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        ListeChainee liste = new ListeChainee();
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            System.out.println("\n╔═══════════════════════════════════════════════════╗");
            System.out.println("║      EXERCICE 1 - LISTES CHAÎNÉES SIMPLES         ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║  1. Ajouter un mot au début                       ║");
            System.out.println("║  2. Ajouter un mot à la fin                       ║");
            System.out.println("║  3. Supprimer un mot                              ║");
            System.out.println("║  4. Afficher les n premiers mots                  ║");
            System.out.println("║  5. Purifier la liste                             ║");
            System.out.println("║  6. Afficher toute la liste                       ║");
            System.out.println("║  0. Retour au menu de la fiche 2                  ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le mot à ajouter au début : ");
                    String motDebut = Utilitaires.lireChaine();
                    liste.ajouteDebut(motDebut);
                    System.out.println("Mot ajouté au début de la liste.");
                    Utilitaires.attendreEntree();
                    break;
                case 2:
                    System.out.print("Entrez le mot à ajouter à la fin : ");
                    String motFin = Utilitaires.lireChaine();
                    liste.ajouteFin(motFin);
                    System.out.println("Mot ajouté à la fin de la liste.");
                    Utilitaires.attendreEntree();
                    break;
                case 3:
                    System.out.print("Entrez le mot à supprimer : ");
                    String motSuppr = Utilitaires.lireChaine();
                    liste.supprimer(motSuppr);
                    System.out.println("Mot supprimé de la liste (s'il existait).");
                    Utilitaires.attendreEntree();
                    break;
                case 4:
                    System.out.print("Combien de mots voulez-vous afficher ? ");
                    int n = Utilitaires.lireEntier();
                    liste.afficheNPremiers(n);
                    Utilitaires.attendreEntree();
                    break;
                case 5:
                    liste.purifier();
                    System.out.println("Liste purifiée (doublons supprimés).");
                    Utilitaires.attendreEntree();
                    break;
                case 6:
                    liste.afficher();
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
