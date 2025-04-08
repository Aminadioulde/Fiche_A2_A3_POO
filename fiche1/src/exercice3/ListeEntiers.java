package fiche1.exercice3;

import java.util.Scanner;

/**
 * Implémentation d'une liste chaînée d'entiers
 * @author v0
 */
public class ListeEntiers {
    /**
     * Structure de maillon pour la liste chaînée d'entiers
     */
    public static class Maillon {
        private int valeur;
        private Maillon suiv;
        
        /**
         * Constructeur de maillon
         * @param valeur la valeur à stocker
         */
        public Maillon(int valeur) {
            this.valeur = valeur;
            this.suiv = null;
        }
        
        /**
         * Getter pour la valeur
         * @return la valeur stockée
         */
        public int getValeur() {
            return valeur;
        }
        
        /**
         * Setter pour la valeur
         * @param valeur la nouvelle valeur
         */
        public void setValeur(int valeur) {
            this.valeur = valeur;
        }
        
        /**
         * Getter pour le maillon suivant
         * @return le maillon suivant
         */
        public Maillon getSuiv() {
            return suiv;
        }
        
        /**
         * Setter pour le maillon suivant
         * @param suiv le nouveau maillon suivant
         */
        public void setSuiv(Maillon suiv) {
            this.suiv = suiv;
        }
    }
    
    private Maillon tete;
    
    /**
     * Constructeur par défaut
     */
    public ListeEntiers() {
        this.tete = null;
    }
    
    /**
     * Crée une liste avec dix valeurs saisies au clavier
     * @return la liste créée
     */
    public static ListeEntiers creerListe() {
        ListeEntiers liste = new ListeEntiers();
        Scanner scanner = new Scanner(System.in);
          {
        ListeEntiers liste = new ListeEntiers();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Veuillez saisir 10 entiers :");
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Entier " + (i + 1) + " : ");
            int valeur = 0;
            boolean valide = false;
            
            while (!valide) {
                try {
                    valeur = Integer.parseInt(scanner.nextLine().trim());
                    valide = true;
                } catch (NumberFormatException e) {
                    System.out.print("Entrée invalide. Veuillez saisir un nombre : ");
                }
            }
            
            liste.ajouterFin(valeur);
        }
        
        return liste;
    }
    
    /**
     * Ajoute un entier à la fin de la liste
     * @param valeur l'entier à ajouter
     */
    public void ajouterFin(int valeur) {
        Maillon nouveau = new Maillon(valeur);
        
        if (tete == null) {
            tete = nouveau;
            return;
        }
        
        Maillon courant = tete;
        while (courant.getSuiv() != null) {
            courant = courant.getSuiv();
        }
        
        courant.setSuiv(nouveau);
    }
    
    /**
     * Teste l'égalité de deux listes
     * @param autre la liste à comparer
     * @return true si les listes sont égales, false sinon
     */
    public boolean estEgal(ListeEntiers autre) {
        Maillon courant1 = this.tete;
        Maillon courant2 = autre.tete;
        
        while (courant1 != null && courant2 != null) {
            if (courant1.getValeur() != courant2.getValeur()) {
                return false;
            }
            courant1 = courant1.getSuiv();
            courant2 = courant2.getSuiv();
        }
        
        // Les deux listes doivent avoir la même longueur
        return courant1 == null && courant2 == null;
    }
    
    /**
     * Concatène deux listes dans une troisième liste
     * @param autre la liste à concaténer
     * @return la liste résultante
     */
    public ListeEntiers concatener(ListeEntiers autre) {
        ListeEntiers resultat = new ListeEntiers();
        
        // Copie de la première liste
        Maillon courant = this.tete;
        while (courant != null) {
            resultat.ajouterFin(courant.getValeur());
            courant = courant.getSuiv();
        }
        
        // Copie de la deuxième liste
        courant = autre.tete;
        while (courant != null) {
            resultat.ajouterFin(courant.getValeur());
            courant = courant.getSuiv();
        }
        
        return resultat;
    }
    
    /**
     * Concatène deux listes sans créer une troisième liste
     * @param autre la liste à concaténer
     */
    public void concatenerSansCopie(ListeEntiers autre) {
        if (this.tete == null) {
            this.tete = autre.tete;
            return;
        }
        
        if (autre.tete == null) {
            return;
        }
        
        Maillon courant = this.tete;
        while (courant.getSuiv() != null) {
            courant = courant.getSuiv();
        }
        
        courant.setSuiv(autre.tete);
    }
    
    /**
     * Affiche le contenu de la liste
     */
    public void afficher() {
        if (tete == null) {
            System.out.println("La liste est vide.");
            return;
        }
        
        System.out.println("Contenu de la liste :");
        
        Maillon courant = tete;
        int compteur = 0;
        
        while (courant != null) {
            System.out.println((compteur + 1) + ". " + courant.getValeur());
            courant = courant.getSuiv();
            compteur++;
        }
    }
}

