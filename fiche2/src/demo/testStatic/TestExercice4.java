package fiche2.src.demo.testStatic;

import fiche2.src.exercice4.Polynome;

/**
 * Tests statiques pour l'exercice 4 (Dérivée d'un polynôme)
 */
public class TestExercice4 {
    
    /**
     * Exécute les tests pour l'exercice 4
     */
    public static void tester() {
        System.out.println("\n=== Test de l'exercice 4 - Dérivée d'un polynôme ===");
        
        // Création d'un polynôme
        Polynome polynome = new Polynome();
        
        // Ajout de termes
        System.out.println("Création d'un polynôme : 3x^4 + 2x^3 - 5x^2 + x - 7");
        polynome.ajouterTerme(3, 4);
        polynome.ajouterTerme(2, 3);
        polynome.ajouterTerme(-5, 2);
        polynome.ajouterTerme(1, 1);
        polynome.ajouterTerme(-7, 0);
        
        // Affichage du polynôme
        System.out.println("\nPolynôme : ");
        polynome.afficher();
        
        // Calcul de la dérivée
        System.out.println("\nDérivée première : ");
        Polynome derivee = polynome.derivee();
        derivee.afficher();
        
        // Calcul de la dérivée seconde
        System.out.println("\nDérivée seconde : ");
        Polynome deriveSeconde = polynome.deriveeKieme(2);
        deriveSeconde.afficher();
        
        // Calcul de la dérivée troisième
        System.out.println("\nDérivée troisième : ");
        Polynome deriveTroisieme = polynome.deriveeKieme(3);
        deriveTroisieme.afficher();
    }
}