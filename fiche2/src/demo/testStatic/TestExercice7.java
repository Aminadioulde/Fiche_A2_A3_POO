package fiche2.src.demo.testStatic;

import fiche2.src.exercice7.ArbreBinaire;

/**
 * Tests statiques pour l'exercice 7 (Terminologie sur les arbres)
 */
public class TestExercice7 {
    
    /**
     * Exécute les tests pour l'exercice 7
     */
    public static void tester() {
        System.out.println("\n=== Test de l'exercice 7 - Terminologie sur les arbres ===");
        
        // Création d'un arbre d'exemple
        System.out.println("Création d'un arbre binaire d'exemple...");
        ArbreBinaire arbre = ArbreBinaire.creerArbreExemple();
        
        // Test des méthodes
        System.out.println("\nFeuilles de l'arbre :");
        arbre.feuille();
        
        System.out.println("\nDegrés des noeuds :");
        arbre.degre();
        
        System.out.println("\nProfondeur du noeud 5 :");
        arbre.profondeur(5);
        
        System.out.println("\nProfondeur du noeud 12 :");
        arbre.profondeur(12);
        
        System.out.println("\nHauteur de l'arbre :");
        arbre.hauteur();
        
        System.out.println("\nSomme des noeuds :");
        arbre.somNoeuds();
    }
}