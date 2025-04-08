package fiche1.src.demo;

import fiche1.src.exercice3.GrandInt;
import utils.Utilitaires;

/**
 * Pour tester les fonctionnalités de l'exercice 3.
 */
public class Exercice3 {

    public static void main(String args[]) {
        System.out.println("\n=== Test  Exercice 3 : Grands entiers ===");

        // Demande du nombre à l'utilisateur
        System.out.print("Entrez un nombre entier : ");
        int nombre = Utilitaires.lireEntier();

        // Création et affichage du GrandInt
        GrandInt grandInt = new GrandInt(nombre);
        System.out.println("\nVotre nombre : " + grandInt);
        System.out.println("Nombre de chiffres : " + grandInt.nombreDeChiffres());

        System.out.println("\n=== Test terminé ===");
    }
}
