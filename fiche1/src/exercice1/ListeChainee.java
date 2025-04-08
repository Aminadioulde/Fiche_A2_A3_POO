package fiche1.exercice1;

/**
 * Implémentation d'une liste chaînée de chaînes de caractères
 * @author v0
 */
public class ListeChainee {
    /**
     * Structure de maillon pour la liste chaînée
     */
    public static class Maillon {
        private String mot;
        private Maillon suiv;

        /**
         * Constructeur de maillon
         * @param mot le mot à stocker
         */
        public Maillon(String mot) {
            this.mot = mot;
            this.suiv = null;
        }

        /**
         * Getter pour le mot
         * @return le mot stocké
         */
        public String getMot() {
            return mot;
        }

        /**
         * Setter pour le mot
         * @param mot le nouveau mot
         */
        public void setMot(String mot) {
            this.mot = mot;
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
    public ListeChainee() {
        this.tete = null;
    }

    /**
     * Ajoute un mot au début de la liste
     * @param mot le mot à ajouter
     * @return la liste modifiée
     */
    public ListeChainee ajouteDebut(String mot) {
        Maillon nouveau = new Maillon(mot);
        nouveau.setSuiv(tete);
        tete = nouveau;
        return this;
    }

    /**
     * Ajoute un mot à la fin de la liste
     * @param mot le mot à ajouter
     * @return la liste modifiée
     */
    public ListeChainee ajouteFin(String mot) {
        Maillon nouveau = new Maillon(mot);
        
        if (tete == null) {
            tete = nouveau;
            return this;
        }
        
        Maillon courant = tete;
        while (courant.getSuiv() != null) {
            courant = courant.getSuiv();
        }
        
        courant.setSuiv(nouveau);
        return this;
    }

    /**
     * Supprime la première occurrence d'un mot dans la liste
     * @param mot le mot à supprimer
     * @return la liste modifiée
     */
    public ListeChainee supprimer(String mot) {
        if (tete == null) {
            return this;
        }
        
        // Cas spécial: le mot est en tête de liste
        if (tete.getMot().equals(mot)) {
            tete = tete.getSuiv();
            return this;
        }
        
        Maillon courant = tete;
        while (courant.getSuiv() != null && !courant.getSuiv().getMot().equals(mot)) {
            courant = courant.getSuiv();
        }
        
        if (courant.getSuiv() != null) {
            courant.setSuiv(courant.getSuiv().getSuiv());
        }
        
        return this;
    }

    /**
     * Affiche les n premiers mots de la liste
     * @param n le nombre de mots à afficher
     */
    public void premiers(int n) {
        if (tete == null) {
            System.out.println("La liste est vide.");
            return;
        }
        
        System.out.println("Les " + n + " premiers mots de la liste :");
        
        Maillon courant = tete;
        int compteur = 0;
        
        while (courant != null && compteur < n) {
            System.out.println((compteur + 1) + ". " + courant.getMot());
            courant = courant.getSuiv();
            compteur++;
        }
        
        if (compteur < n) {
            System.out.println("La liste ne contient que " + compteur + " mot(s).");
        }
    }

    /**
     * Purifie la liste en supprimant les doublons
     * Note: la liste est supposée être triée
     */
    public void purifie() {
        if (tete == null || tete.getSuiv() == null) {
            return;
        }
        
        Maillon courant = tete;
        
        while (courant != null && courant.getSuiv() != null) {
            if (courant.getMot().equals(courant.getSuiv().getMot())) {
                // Suppression du doublon
                courant.setSuiv(courant.getSuiv().getSuiv());
            } else {
                courant = courant.getSuiv();
            }
        }
    }

    /**
     * Affiche tous les mots de la liste
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
            System.out.println((compteur + 1) + ". " + courant.getMot());
            courant = courant.getSuiv();
            compteur++;
        }
    }
}

