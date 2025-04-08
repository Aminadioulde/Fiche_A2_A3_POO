package fiche1.src.demo.testStatic;

import fiche1.src.exercice4.Polynome;
import fiche1.src.exercice4.Polynome2;

public class TestExercice4 {
    public static void main(String[] args) {
        System.out.println("\n=== Test Statique Exercice 4 : Polynômes ===");

        // Test de la classe Polynome
        System.out.println("\n1. Test de création et affichage d'un polynôme:");
        Polynome p1 = new Polynome(4, 3, 2); // 2x² + 3x + 4
        System.out.println("P1(x) = " + p1);

        // Test d'addition
        System.out.println("\n2. Test d'addition:");
        Polynome p2 = new Polynome(2, 0, -3, 0, 1); // x⁴ - 3x² + 2
        System.out.println("P2(x) = " + p2);
        Polynome somme = Polynome.additionner(p1, p2);
        System.out.println("P1 + P2 = " + somme);

        // Test de dérivée
        System.out.println("\n3. Test de dérivée:");
        Polynome derivee = Polynome.derivee(p1);
        System.out.println("Dérivée de P1 = " + derivee);

        // Test d'évaluation
        System.out.println("\n4. Test d'évaluation:");
        double x = 2;
        System.out.println("P1(" + x + ") = " + Polynome.evaluer(p1, x));

        // Test de Polynome2
        System.out.println("\n5. Test de Polynome2:");
        Polynome2 p3 = new Polynome2(1, -5, 6); // 6x² - 5x + 1
        System.out.println("P3(x) = " + p3);
        System.out.println("Résolution de P3(x) = 0:");
        p3.resoudreEquation();

        System.out.println("\n=== Tests terminés ===");
    }
}

