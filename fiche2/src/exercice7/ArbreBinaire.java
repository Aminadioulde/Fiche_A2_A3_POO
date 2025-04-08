package fiche2.src.exercice7;

/**
 * Implémentation d'un arbre binaire d'entiers
 */
public class ArbreBinaire {
    /**
     * Structure de nœud pour l'arbre binaire
     */
    public static class Noeud {
        private int valeur;
        private Noeud gauche;
        private Noeud droite;

        /**
         * Constructeur de nœud
         * 
         * @param valeur la valeur à stocker
         */
        public Noeud(int valeur) {
            this.valeur = valeur;
            this.gauche = null;
            this.droite = null;
        }

        /**
         * Getter pour la valeur
         * 
         * @return la valeur stockée
         */
        public int getValeur() {
            return valeur;
        }

        /**
         * Setter pour la valeur
         * 
         * @param valeur la nouvelle valeur
         */
        public void setValeur(int valeur) {
            this.valeur = valeur;
        }

        /**
         * Getter pour le fils gauche
         * 
         * @return le fils gauche
         */
        public Noeud getGauche() {
            return gauche;
        }

        /**
         * Setter pour le fils gauche
         * 
         * @param gauche le nouveau fils gauche
         */
        public void setGauche(Noeud gauche) {
            this.gauche = gauche;
        }

        /**
         * Getter pour le fils droit
         * 
         * @return le fils droit
         */
        public Noeud getDroite() {
            return droite;
        }

        /**
         * Setter pour le fils droit
         * 
         * @param droite le nouveau fils droit
         */
        public void setDroite(Noeud droite) {
            this.droite = droite;
        }
    }

    private Noeud racine;

    /**
     * Constructeur par défaut
     */
    public ArbreBinaire() {
        this.racine = null;
    }

    /**
     * Constructeur avec racine
     * 
     * @param racine la racine de l'arbre
     */
    public ArbreBinaire(Noeud racine) {
        this.racine = racine;
    }

    /**
     * Getter pour la racine
     * 
     * @return la racine de l'arbre
     */
    public Noeud getRacine() {
        return racine;
    }

    /**
     * Setter pour la racine
     * 
     * @param racine la nouvelle racine
     */
    public void setRacine(Noeud racine) {
        this.racine = racine;
    }

    /**
     * Affiche les feuilles de l'arbre
     */
    public void feuille() {
        System.out.println("Feuilles de l'arbre :");
        feuilleRecursif(racine);
        System.out.println();
    }

    /**
     * Fonction récursive pour afficher les feuilles
     * 
     * @param noeud le nœud courant
     */
    private void feuilleRecursif(Noeud noeud) {
        if (noeud == null) {
            return;
        }

        if (noeud.getGauche() == null && noeud.getDroite() == null) {
            // C'est une feuille
            System.out.print(noeud.getValeur() + " ");
        } else {
            // Parcours en profondeur, en commençant par la gauche
            feuilleRecursif(noeud.getGauche());
            feuilleRecursif(noeud.getDroite());
        }
    }

    /**
     * Affiche les nœuds de l'arbre avec leurs degrés respectifs
     */
    public void degre() {
        System.out.println("Nœuds de l'arbre avec leurs degrés :");
        degreRecursif(racine);
    }

    /**
     * Fonction récursive pour afficher les degrés
     * 
     * @param noeud le nœud courant
     */
    private void degreRecursif(Noeud noeud) {
        if (noeud == null) {
            return;
        }

        int degre = 0;
        if (noeud.getGauche() != null) {
            degre++;
        }
        if (noeud.getDroite() != null) {
            degre++;
        }

        System.out.println("Nœud " + noeud.getValeur() + " : degré " + degre);

        degreRecursif(noeud.getGauche());
        degreRecursif(noeud.getDroite());
    }

    /**
     * Cherche et affiche la profondeur d'un nœud
     * 
     * @param valeur la valeur du nœud à chercher
     */
    public void profondeur(int valeur) {
        int profondeur = profondeurRecursif(racine, valeur, 0);

        if (profondeur == -1) {
            System.out.println("Le nœud " + valeur + " n'existe pas dans l'arbre.");
        } else {
            System.out.println("Profondeur du nœud " + valeur + " : " + profondeur);
        }
    }

    /**
     * Fonction récursive pour calculer la profondeur d'un nœud
     * 
     * @param noeud              le nœud courant
     * @param valeur             la valeur recherchée
     * @param profondeurActuelle la profondeur actuelle
     * @return la profondeur du nœud, ou -1 s'il n'existe pas
     */
    private int profondeurRecursif(Noeud noeud, int valeur, int profondeurActuelle) {
        if (noeud == null) {
            return -1;
        }

        if (noeud.getValeur() == valeur) {
            return profondeurActuelle;
        }

        int profondeurGauche = profondeurRecursif(noeud.getGauche(), valeur, profondeurActuelle + 1);
        if (profondeurGauche != -1) {
            return profondeurGauche;
        }

        return profondeurRecursif(noeud.getDroite(), valeur, profondeurActuelle + 1);
    }

    /**
     * Calcule la hauteur de l'arbre
     * 
     * @return la hauteur de l'arbre
     */
    public int hauteur() {
        int hauteur = hauteurRecursif(racine);
        System.out.println("Hauteur de l'arbre : " + hauteur);
        return hauteur;
    }

    /**
     * Fonction récursive pour calculer la hauteur d'un sous-arbre
     * 
     * @param noeud la racine du sous-arbre
     * @return la hauteur du sous-arbre
     */
    private int hauteurRecursif(Noeud noeud) {
        if (noeud == null) {
            return -1; // Un arbre vide a une hauteur de -1
        }

        int hauteurGauche = hauteurRecursif(noeud.getGauche());
        int hauteurDroite = hauteurRecursif(noeud.getDroite());

        return 1 + Math.max(hauteurGauche, hauteurDroite);
    }

    /**
     * Calcule la somme des valeurs des nœuds de l'arbre
     * 
     * @return la somme des valeurs
     */
    public int somNoeuds() {
        int somme = somNoeudsRecursif(racine);
        System.out.println("Somme des nœuds de l'arbre : " + somme);
        return somme;
    }

    /**
     * Fonction récursive pour calculer la somme des valeurs des nœuds
     * 
     * @param noeud la racine du sous-arbre
     * @return la somme des valeurs
     */
    private int somNoeudsRecursif(Noeud noeud) {
        if (noeud == null) {
            return 0;
        }

        return noeud.getValeur() + somNoeudsRecursif(noeud.getGauche()) + somNoeudsRecursif(noeud.getDroite());
    }

    /**
     * Crée un arbre binaire d'exemple
     * 
     * @return l'arbre créé
     */
    public static ArbreBinaire creerArbreExemple() {
        Noeud racine = new Noeud(10);

        Noeud n1 = new Noeud(5);
        Noeud n2 = new Noeud(15);

        Noeud n3 = new Noeud(3);
        Noeud n4 = new Noeud(7);

        Noeud n5 = new Noeud(12);
        Noeud n6 = new Noeud(18);

        racine.setGauche(n1);
        racine.setDroite(n2);

        n1.setGauche(n3);
        n1.setDroite(n4);

        n2.setGauche(n5);
        n2.setDroite(n6);

        return new ArbreBinaire(racine);
    }
}
