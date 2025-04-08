package fiche2.src.demo.testStatic;

import fiche2.src.exercice2.ListeChaineeDouble;

/**
 * Tests statiques pour l'exercice 2 (Listes chaînées bidirectionnelles)
 */
public class TestExercice2 {
    
    /**
     * Exécute les tests pour l'exercice 2
     */
    public static void tester() {
        System.out.println("\n=== Test de l'exercice 2 - Listes bidirectionnelles ===");
        
        // Création d'une liste chaînée bidirectionnelle
        ListeChaineeDouble liste = new ListeChaineeDouble();
        
        // Ajout de chaînes
        System.out.println("Ajout de chaînes à la liste...");
        liste.ajouterDevant("Premier");
        liste.ajouterDevant("Deuxième");
        liste.ajouterDevant("Troisième");
        liste.ajouterDevant("Quatrième");
        
        // Affichage de la liste dans les deux sens
        System.out.println("\nAffichage de la tête vers la queue :");
        liste.afficher();
        
        System.out.println("\nAffichage de la queue vers la tête :");
        liste.afficherInverse();
        
        // Test de suppression
        System.out.println("\nSuppression de 'Deuxième'...");
        liste.supprimer("Deuxième");
        
        System.out.println("\nAffichage après suppression :");
        liste.afficher();
    }
}