package fiche2.src.exercice1;

/**
 * Implémentation d'une liste chaînée de chaînes de caractères
 */
public class ListeChainee {
    /**
     * Référence vers le premier maillon de la liste
     */
    private Maillon tete;

    /**
     * Constructeur par défaut
     * Initialise une liste vide
     */
    public ListeChainee() {
        this.tete = null;
    }

    /**
     * Structure de maillon pour la liste chaînée
     */
    private static class Maillon {
        private String mot;
        private Maillon suiv;

        public Maillon(String mot) {
            if (mot == null) {
                throw new IllegalArgumentException("Le mot ne peut pas être null");
            }
            this.mot = mot;
            this.suiv = null;
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
            System.out.println((compteur + 1) + ". " + courant.mot);
            courant = courant.suiv;
            compteur++;
        }
    }

    /**
     * Ajoute un mot au début de la liste
     * 
     * @param mot le mot à ajouter
     */
    public void ajouteDebut(String mot) {
        if (mot == null) {
            throw new IllegalArgumentException("Le mot ne peut pas être null");
        }
        Maillon nouveau = new Maillon(mot);
        nouveau.suiv = tete;
        tete = nouveau;
    }

    /**
     * Ajoute un mot à la fin de la liste
     * 
     * @param mot le mot à ajouter
     */
    public void ajouteFin(String mot) {
        if (mot == null) {
            throw new IllegalArgumentException("Le mot ne peut pas être null");
        }

        Maillon nouveau = new Maillon(mot);
        if (tete == null) {
            tete = nouveau;
            return;
        }

        Maillon courant = tete;
        while (courant.suiv != null) {
            courant = courant.suiv;
        }
        courant.suiv = nouveau;
    }

    /**
     * Supprime la première occurrence d'un mot dans la liste
     * 
     * @param mot le mot à supprimer
     */
    public void supprimer(String mot) {
        if (tete == null || mot == null) {
            return;
        }

        if (tete.mot.equals(mot)) {
            tete = tete.suiv;
            return;
        }

        Maillon courant = tete;
        while (courant.suiv != null && !courant.suiv.mot.equals(mot)) {
            courant = courant.suiv;
        }

        if (courant.suiv != null) {
            courant.suiv = courant.suiv.suiv;
        }
    }

    /**
     * Affiche les n premiers mots de la liste
     * 
     * @param n le nombre de mots à afficher
     */
    public void afficheNPremiers(int n) {
        if (tete == null) {
            System.out.println("La liste est vide.");
            return;
        }

        System.out.println("Les " + n + " premiers mots de la liste :");
        Maillon courant = tete;
        int compteur = 0;

        while (courant != null && compteur < n) {
            System.out.println((compteur + 1) + ". " + courant.mot);
            courant = courant.suiv;
            compteur++;
        }
    }

    /**
     * Purifier la liste en supprimant les doublons
     * Suppose que la liste est déjà triée
     */
    public void purifier() {
        if (tete == null || tete.suiv == null) {
            return;
        }

        Maillon courant = tete;
        while (courant != null && courant.suiv != null) {
            if (courant.mot.equals(courant.suiv.mot)) {
                courant.suiv = courant.suiv.suiv;
            } else {
                courant = courant.suiv;
            }
        }
    }
}