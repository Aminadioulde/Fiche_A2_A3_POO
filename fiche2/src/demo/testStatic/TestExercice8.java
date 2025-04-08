package fiche2.src.demo.testStatic;

import fiche2.src.exercice8.IndexABR;

/**
 * Tests statiques pour l'exercice 8 (LCB et ABR)
 */
public class TestExercice8 {
    
    /**
     * Exécute les tests pour l'exercice 8
     */
    public static void tester() {
        System.out.println("\n=== Test de l'exercice 8 - LCB et ABR ===");
        
        // Création d'un index d'exemple
        System.out.println("Création d'un index d'exemple...");
        IndexABR index = IndexABR.creerIndexExemple();
        
        // Affichage de l'index
        System.out.println("\nContenu de l'index :");
        index.afficherIndex();
        
        // Recherche d'occurrences
        System.out.println("\nRecherche des occurrences de 'Java' :");
        index.rechercherOccurrences("Java");
        
        // Ajout d'un nom propre
        System.out.println("\nAjout de 'Python' à la page 42 :");
        int[] pagesPython = {42};
        IndexABR.ajoutNomPropre("Python", pagesPython, 1, index);
        
        System.out.println("\nIndex après ajout :");
        index.afficherIndex();
        
        // Suppression d'un numéro de page
        System.out.println("\nSuppression de la page 10 pour 'Java' :");
        IndexABR.supprimerNumero("Java", 10, index);
        
        System.out.println("\nIndex après suppression de page :");
        index.afficherIndex();
        
        // Suppression d'un nom propre
        System.out.println("\nSuppression du nom propre 'Python' :");
        IndexABR.supprimerNom("Python", index);
        
        System.out.println("\nIndex après suppression de nom propre :");
        index.afficherIndex();
        
        // Statistiques
        System.out.println("\nStatistiques de l'index :");
        System.out.println("Hauteur de l'arbre : " + index.hauteur());
        System.out.println("Nombre de nœuds : " + index.nombreNoeuds());
    }
}