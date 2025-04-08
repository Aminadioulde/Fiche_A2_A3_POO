package fiche2.src.demo.testStatic;

import fiche2.src.exercice3.ListeEntiers;

/**
 * Tests statiques pour l'exercice 3 (Traitement de listes chaînées)
 */
public class TestExercice3 {
    
    /**
     * Exécute les tests pour l'exercice 3
     */
    public static void tester() {
        System.out.println("\n=== Test de l'exercice 3 - Traitement de listes chaînées ===");
        
        // Création de listes avec des valeurs prédéfinies
        ListeEntiers liste1 = new ListeEntiers();
        ListeEntiers liste2 = new ListeEntiers();
        
        // Ajout de valeurs
        System.out.println("Création de deux listes...");
        for (int i = 1; i <= 5; i++) {
            liste1.ajouterFin(i);
        }
        
        for (int i = 6; i <= 10; i++) {
            liste2.ajouterFin(i);
        }
        
        // Affichage des listes
        System.out.println("\nListe 1 :");
        liste1.afficher();
        
        System.out.println("\nListe 2 :");
        liste2.afficher();
        
        // Test d'égalité
        System.out.println("\nTest d'égalité entre liste1 et liste2 : " + liste1.estEgal(liste2));
        
        // Création d'une liste identique à liste1
        ListeEntiers liste3 = new ListeEntiers();
        for (int i = 1; i <= 5; i++) {
            liste3.ajouterFin(i);
        }
        
        System.out.println("\nTest d'égalité entre liste1 et liste3 : " + liste1.estEgal(liste3));
        
        // Test de concaténation
        System.out.println("\nConcaténation de liste1 et liste2 :");
        ListeEntiers listeConcat = liste1.concatener(liste2);
        listeConcat.afficher();
        
        // Test de concaténation sans copie
        System.out.println("\nConcaténation sans copie (liste1 += liste2) :");
        liste1.concatenerSansCopie(liste2);
        liste1.afficher();
    }
}