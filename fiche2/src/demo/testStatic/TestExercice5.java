package fiche2.src.demo.testStatic;

import fiche2.src.exercice5.VecteurCreux;

/**
 * Tests statiques pour l'exercice 5 (Vecteurs creux)
 */
public class TestExercice5 {
    
    /**
     * Exécute les tests pour l'exercice 5
     */
    public static void tester() {
        System.out.println("\n=== Test de l'exercice 5 - Vecteurs creux ===");
        
        // Création de vecteurs creux
        System.out.println("Création de deux vecteurs creux...");
        VecteurCreux vecteurA = new VecteurCreux(10);
        VecteurCreux vecteurB = new VecteurCreux(10);
        
        // Remplissage des vecteurs
        vecteurA.ajouterComposante(0, 5);
        vecteurA.ajouterComposante(3, 7);
        vecteurA.ajouterComposante(7, -2);
        
        vecteurB.ajouterComposante(0, 3);
        vecteurB.ajouterComposante(3, -4);
        vecteurB.ajouterComposante(5, 8);
        
        // Affichage des vecteurs
        System.out.println("\nVecteur A :");
        vecteurA.afficher();
        
        System.out.println("\nVecteur B :");
        vecteurB.afficher();
        
        // Addition des vecteurs
        System.out.println("\nAddition A + B :");
        VecteurCreux somme = vecteurA.additionner(vecteurB);
        somme.afficher();
        
        // Produit scalaire
        System.out.println("\nProduit scalaire A · B : " + vecteurA.multiplier(vecteurB));
    }
}