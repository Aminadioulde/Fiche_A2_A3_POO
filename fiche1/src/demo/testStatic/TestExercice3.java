package fiche1.src.demo.testStatic;

import fiche1.src.exercice3.GrandInt;

/**
 * Classe de test pour les grands entiers (GrandInt)
 */
public class TestExercice3 {

    public static void main(String args[]) {
        System.out.println("\n=== Test Statique Exercice 3 : Grands entiers ===");

        // Test du constructeur public et toString()
        System.out.println("\n1. Test de création et affichage:");
        GrandInt nombre1 = new GrandInt(12345);
        GrandInt nombre2 = new GrandInt(0);
        GrandInt nombre3 = new GrandInt(9876543);

        System.out.println("Nombre 1 = " + nombre1);
        System.out.println("Nombre 2 = " + nombre2);
        System.out.println("Nombre 3 = " + nombre3);

        // Test de nombreDeChiffres()
        System.out.println("\n2. Test du nombre de chiffres:");
        System.out.println("Nombre de chiffres de " + nombre1 + " : " + nombre1.nombreDeChiffres());
        System.out.println("Nombre de chiffres de " + nombre2 + " : " + nombre2.nombreDeChiffres());
        System.out.println("Nombre de chiffres de " + nombre3 + " : " + nombre3.nombreDeChiffres());

        // Test avec des cas particuliers
        System.out.println("\n3. Test des cas particuliers:");
        GrandInt nombreNegatif = new GrandInt(-123);
        GrandInt grandNombre = new GrandInt(Integer.MAX_VALUE);
        System.out.println("Nombre négatif = " + nombreNegatif);
        System.out.println("Très grand nombre = " + grandNombre);
        System.out.println("Nombre de chiffres du grand nombre : " + grandNombre.nombreDeChiffres());

        System.out.println("\n =====  Tests terminés. =======");
    }
}
