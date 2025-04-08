package fiche2.src.demo.testStatic;

import fiche2.src.exercice1.ListeChainee;

/**
 * Tests statiques pour l'exercice 1 (Listes chaînées et chaînes de caractères)
 */
public class TestExercice1 {

    /**
     * Exécute les tests pour l'exercice 1
     */
    public static void tester() {
        System.out.println("\n=== Test de l'exercice 1 - Listes chaînées simples ===");

        // Création d'une liste chaînée
        ListeChainee liste = new ListeChainee();

        // Ajout de mots
        System.out.println("Ajout de mots à la liste...");
        liste.ajouteDebut("Bonjour");
        liste.ajouteFin("le");
        liste.ajouteFin("monde");
        liste.ajouteDebut("Salut");
        liste.ajouteFin("!");

        // Affichage de la liste
        System.out.println("\nContenu de la liste :");
        liste.afficher();

        // Test de la purification
        System.out.println("\nPurification de la liste...");
        liste.ajouteFin("le"); // Ajout d'un doublon
        liste.ajouteFin("Salut"); // Ajout d'un doublon
        System.out.println("Liste avant purification :");
        liste.afficher();

        liste.purifier();
        System.out.println("\nListe après purification :");
        liste.afficher();

        // Test d'affichage des n premiers mots
        System.out.println("\nAffichage des 3 premiers mots :");
        liste.afficheNPremiers(3);
    }
}