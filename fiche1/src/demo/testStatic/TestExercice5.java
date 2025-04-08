package fiche1.src.demo.testStatic;

import fiche1.src.exercice5.*;

public class TestExercice5 {
    public static void main(String[] args) {
        System.out.println("\n=== Test Statique Exercice 5 : Intervalles d'entiers ===");

        // Test des intervalles ouverts
        IntervOuvert io1 = new IntervOuvert(1, 5); // ]1,5[ = {2,3,4}
        IntervOuvert io2 = new IntervOuvert(3, 7); // ]3,7[ = {4,5,6}

        System.out.println("\nTests IntervOuvert:");
        System.out.println("2 est dans ]1,5[ ? " + io1.estDans(2)); // true
        System.out.println("1 est dans ]1,5[ ? " + io1.estDans(1)); // false
        System.out.println("]1,5[ est vide ? " + io1.estVide()); // false
        System.out.println("]1,2[ est vide ? " + new IntervOuvert(1, 2).estVide()); // true

        IntervOuvert intersection = io1.intersection(io2);
        System.out.println("4 est dans l'intersection ? " + intersection.estDans(4)); // true

        // Test des intervalles fermés
        IntervFerme if1 = new IntervFerme(1, 5); // [1,5] = {1,2,3,4,5}
        // IntervFerme if2 = new IntervFerme(3, 7); // [3,7] = {3,4,5,6,7}

        System.out.println("\nTests IntervFerme:");
        System.out.println("1 est dans [1,5] ? " + if1.estDans(1)); // true
        System.out.println("5 est dans [1,5] ? " + if1.estDans(5)); // true
        System.out.println("[1,5] est vide ? " + if1.estVide()); // false
        System.out.println("[2,1] est vide ? " + new IntervFerme(2, 1).estVide()); // true

        System.out.println("\nTests terminés.");
    }
}