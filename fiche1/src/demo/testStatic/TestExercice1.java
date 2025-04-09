package fiche1.src.demo.testStatic;

import fiche1.src.exercice1.Liste;

public class TestExercice1 {

    public static void main(String[] args) {

        System.out.println("\n=== Test Statique Exercice 1 : ===");
           // Test avec une seule valeur
        System.out.print("Test avec une seule valeur : ");
        Liste l1 = new Liste("A");
        l1.afficher(); // A -> null

        // Test avec plusieurs maillons
        System.out.print("Test avec plusieurs maillons : ");
        Liste l3 = new Liste("C");
        Liste l2 = new Liste("B", l3);
        Liste l = new Liste("A", l2);
        l.afficher(); // A -> B -> C -> null

        // Test de append
        System.out.println("Test append: ");
        Liste a1 = new Liste("X", new Liste("Y"));
        Liste a2 = new Liste("Z", new Liste("W"));
        System.out.print("Avant append : ");
        a1.afficher();
        System.out.print("Liste à ajouter : ");
        a2.afficher();

        a1.append(a2);

        System.out.print("Après append : ");
        a1.afficher();

        // Test de supprimerInferieur
        System.out.println("\n> Test de supprimerInferieur");

        // Créer la liste D -> B -> A -> F -> C
        Liste n5 = new Liste("C");
        Liste n4 = new Liste("F", n5);
        Liste n3 = new Liste("A", n4);
        Liste n2 = new Liste("B", n3);
        Liste n1 = new Liste("D", n2);

        System.out.print("Avant suppression : ");
        n1.afficher();

        Liste suppr = n1.supprimerInferieur();

        System.out.print("Après suppression : ");
        n1.afficher();

        System.out.print("Éléments supprimés : ");
        if (suppr != null) {
            suppr.afficher();
        } else {
            System.out.println("Aucun élément supprimé.");
        }

        // Test de quicksort
        System.out.println("\n>>> Test de quicksort");

        // Créer la liste D -> B -> A -> F -> C
        Liste q5 = new Liste("C");
        Liste q4 = new Liste("F", q5);
        Liste q3 = new Liste("A", q4);
        Liste q2 = new Liste("B", q3);
        Liste q1 = new Liste("D", q2);

        System.out.print("Liste avant tri : ");
        q1.afficher();

        // Appliquer quicksort
        Liste triee = q1.quicksort();

        System.out.print("Liste après tri : ");
        triee.afficher();
        System.out.println("\nTests terminés.");
    }
}
