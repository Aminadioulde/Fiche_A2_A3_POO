package fiche2.src.demo.testStatic;

import fiche2.src.exercice6.MatriceSymetrique.MatCarree;

/**
 * Tests statiques pour l'exercice 6 (Matrices symétriques)
 */
public class TestExercice6 {
    
    /**
     * Exécute les tests pour l'exercice 6
     */
    public static void tester() {
        System.out.println("\n=== Test de l'exercice 6 - Matrices symétriques ===");
        
        // Création d'une matrice 4x4
        System.out.println("Création d'une matrice 4x4...");
        MatCarree matrice = new MatCarree(4);
        
        // Remplissage de la matrice avec des valeurs symétriques
        matrice.setElement(0, 0, 1);
        matrice.setElement(0, 1, 2);
        matrice.setElement(0, 2, 3);
        matrice.setElement(0, 3, 4);
        
        matrice.setElement(1, 0, 2);  // Symétrique avec (0,1)
        matrice.setElement(1, 1, 5);
        matrice.setElement(1, 2, 6);
        matrice.setElement(1, 3, 7);
        
        matrice.setElement(2, 0, 3);  // Symétrique avec (0,2)
        matrice.setElement(2, 1, 6);  // Symétrique avec (1,2)
        matrice.setElement(2, 2, 8);
        matrice.setElement(2, 3, 9);
        
        matrice.setElement(3, 0, 4);  // Symétrique avec (0,3)
        matrice.setElement(3, 1, 7);  // Symétrique avec (1,3)
        matrice.setElement(3, 2, 9);  // Symétrique avec (2,3)
        matrice.setElement(3, 3, 10);
        
        // Affichage de la matrice
        System.out.println("\nMatrice :");
        // Implement afficher method for MatCarree
        for (int i = 0; i < matrice.getTaille(); i++) {
            for (int j = 0; j < matrice.getTaille(); j++) {
                System.out.print(matrice.getElement(i, j) + "\t");
            }
            System.out.println();
        }
        
        // Vérification de la symétrie
        System.out.println("\nLa matrice est-elle symétrique ? " + 
                fiche2.src.exercice6.MatriceSymetrique.symetrique(matrice));
        
        // Création de la représentation compacte
        System.out.println("\nReprésentation compacte :");
        double[] compact = fiche2.src.exercice6.MatriceSymetrique.symCompacte(matrice, matrice.getTaille());
        
        System.out.print("[ ");
        for (double val : compact) {
            System.out.print(val + " ");
        }
        System.out.println("]");
        
        // Traitement d'une ligne
        System.out.println("\nValeurs de la ligne 2 :");
        double[] ligne = new double[matrice.getTaille()];
        for (int j = 0; j < matrice.getTaille(); j++) {
            ligne[j] = matrice.getElement(2, j);
        }
        
        System.out.print("[ ");
        for (double val : ligne) {
            System.out.print(val + " ");
        }
        System.out.println("]");
    }
}