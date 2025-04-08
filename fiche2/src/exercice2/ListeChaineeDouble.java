package fiche2.src.exercice2;

/**
 * Implémentation d'une liste chaînée bidirectionnelle de chaînes de caractères
 * 
 */
public class ListeChaineeDouble {
    /**
     * Structure de maillon pour la liste chaînée bidirectionnelle
     */
    public static class Maillon {
        private Maillon prec;
        private String info;
        private Maillon suiv;

        /**
         * Constructeur de maillon
         * 
         * @param info la chaîne à stocker
         */
        public Maillon(String info) {
            this.info = info;
            this.suiv = null;
            this.prec = null;
        }

        /**
         * Getter pour l'information
         * 
         * @return l'information stockée
         */
        public String getInfo() {
            return info;
        }

        /**
         * Setter pour l'information
         * 
         * @param info la nouvelle information
         */
        public void setInfo(String info) {
            this.info = info;
        }

        /**
         * Getter pour le maillon suivant
         * 
         * @return le maillon suivant
         */
        public Maillon getSuiv() {
            return suiv;
        }

        /**
         * Setter pour le maillon suivant
         * 
         * @param suiv le nouveau maillon suivant
         */
        public void setSuiv(Maillon suiv) {
            this.suiv = suiv;
        }

        /**
         * Getter pour le maillon précédent
         * 
         * @return le maillon précédent
         */
        public Maillon getPrec() {
            return prec;
        }

        /**
         * Setter pour le maillon précédent
         * 
         * @param prec le nouveau maillon précédent
         */
        public void setPrec(Maillon prec) {
            this.prec = prec;
        }
    }

    // Variables globales pour la tête et la queue de la liste
    private Maillon premier;
    private Maillon dernier;

    /**
     * Constructeur par défaut
     */
    public ListeChaineeDouble() {
        this.premier = null;
        this.dernier = null;
    }

    /**
     * Ajoute une chaîne au début de la liste
     * Correspond à la fonction ajouter_devant(char *s) de l'exercice
     * 
     * @param s la chaîne à ajouter
     */
    public void ajouterDevant(String s) {
        Maillon nouveau = new Maillon(s);

        if (premier == null) {
            // Liste vide
            premier = nouveau;
            dernier = nouveau;
        } else {
            nouveau.setSuiv(premier);
            premier.setPrec(nouveau);
            premier = nouveau;
        }
    }

    /**
     * Ajoute une chaîne au début de la liste (version avec paramètres)
     * Correspond à la réécriture de ajouter_devant avec premier et dernier en paramètres
     * 
     * @param s       la chaîne à ajouter
     * @param premier référence au premier maillon
     * @param dernier référence au dernier maillon
     * @return le nouveau premier maillon
     */
    public static Maillon ajouterDevant(String s, Maillon premier, Maillon dernier) {
        Maillon nouveau = new Maillon(s);

        if (premier == null) {
            // Liste vide
            dernier = nouveau;
            return nouveau;
        } else {
            nouveau.setSuiv(premier);
            premier.setPrec(nouveau);
            return nouveau;
        }
    }

    /**
     * Supprime la première occurrence d'une chaîne dans la liste
     * Correspond à la fonction supprimer(char *s) de l'exercice
     * 
     * @param s la chaîne à supprimer
     */
    public void supprimer(String s) {
        if (premier == null) {
            return; // Liste vide
        }

        Maillon courant = premier;

        // Recherche du maillon à supprimer
        while (courant != null && !courant.getInfo().equals(s)) {
            courant = courant.getSuiv();
        }

        if (courant == null) {
            return; // Chaîne non trouvée
        }

        // Suppression du maillon
        if (courant == premier) {
            // Suppression en tête
            premier = courant.getSuiv();
            if (premier != null) {
                premier.setPrec(null);
            } else {
                dernier = null; // La liste devient vide
            }
        } else if (courant == dernier) {
            // Suppression en queue
            dernier = courant.getPrec();
            dernier.setSuiv(null);
        } else {
            // Suppression au milieu
            courant.getPrec().setSuiv(courant.getSuiv());
            courant.getSuiv().setPrec(courant.getPrec());
        }
    }

    /**
     * Affiche le contenu de la liste
     */
    public void afficher() {
        if (premier == null) {
            System.out.println("La liste est vide.");
            return;
        }

        System.out.println("Contenu de la liste (de la tête vers la queue) :");

        Maillon courant = premier;
        int compteur = 0;

        while (courant != null) {
            System.out.println((compteur + 1) + ". " + courant.getInfo());
            courant = courant.getSuiv();
            compteur++;
        }
    }

    /**
     * Affiche le contenu de la liste en sens inverse
     */
    public void afficherInverse() {
        if (dernier == null) {
            System.out.println("La liste est vide.");
            return;
        }

        System.out.println("Contenu de la liste (de la queue vers la tête) :");

        Maillon courant = dernier;
        int compteur = 0;

        while (courant != null) {
            System.out.println((compteur + 1) + ". " + courant.getInfo());
            courant = courant.getPrec();
            compteur++;
        }
    }
}
