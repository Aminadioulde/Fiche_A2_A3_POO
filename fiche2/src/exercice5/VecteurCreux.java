package fiche2.src.exercice5;

/**
 * Implémentation d'un vecteur creux sous forme de liste chaînée
 * Seules les composantes non nulles sont stockées
 * Les composantes sont maintenues triées par ordre croissant des indices
 */
public class VecteurCreux {
    private Maillon tete;
    private int taille;

    /**
     * Structure de maillon pour le vecteur creux
     */
    public static class Maillon {
        private int indice;
        private float valeur;
        private Maillon suiv;

        /**
         * Constructeur de maillon
         * 
         * @param indice l'indice de la composante
         * @param valeur la valeur de la composante
         */
        public Maillon(int indice, float valeur) {
            this.indice = indice;
            this.valeur = valeur;
            this.suiv = null;
        }

        /**
         * Getter pour l'indice
         * 
         * @return l'indice
         */
        public int getIndice() {
            return indice;
        }

        /**
         * Setter pour l'indice
         * 
         * @param indice le nouvel indice
         */
        public void setIndice(int indice) {
            this.indice = indice;
        }

        /**
         * Getter pour la valeur
         * 
         * @return la valeur
         */
        public float getValeur() {
            return valeur;
        }

        /**
         * Setter pour la valeur
         * 
         * @param valeur la nouvelle valeur
         */
        public void setValeur(float valeur) {
            this.valeur = valeur;
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
    }

    /**
     * Constructeur par défaut
     */
    public VecteurCreux() {
        this.tete = null;
        this.taille = 0;
    }

    /**
     * Constructeur avec taille spécifiée
     * 
     * @param taille la taille du vecteur
     */
    public VecteurCreux(int taille) {
        this.tete = null;
        this.taille = taille;
    }

    /**
     * Getter pour la taille
     * 
     * @return la taille du vecteur
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Crée un vecteur creux à partir d'un tableau
     * 
     * @param t le tableau source
     * @param n la taille du tableau
     * @return un nouveau vecteur creux
     */
    public static VecteurCreux vecteurCreux(float[] t, int n) {
        VecteurCreux vecteur = new VecteurCreux();

        for (int i = 0; i < n; i++) {
            if (t[i] != 0) {
                vecteur.ajouterComposante(i, t[i]);
            }
        }

        return vecteur;
    }

    /**
     * Ajoute une composante non nulle au vecteur
     * 
     * @param indice l'indice de la composante
     * @param valeur la valeur de la composante
     */
    public void ajouterComposante(int indice, float valeur) {
        if (valeur == 0) {
            return; // On n'ajoute pas les composantes nulles
        }

        Maillon nouveau = new Maillon(indice, valeur);

        if (tete == null) {
            tete = nouveau;
            return;
        }

        // Insertion en tête si l'indice est plus petit
        if (indice < tete.getIndice()) {
            nouveau.setSuiv(tete);
            tete = nouveau;
            return;
        }

        // Mise à jour de la valeur si l'indice existe déjà
        if (indice == tete.getIndice()) {
            tete.setValeur(valeur);
            return;
        }

        // Insertion au bon endroit dans la liste (triée par indice croissant)
        Maillon courant = tete;
        while (courant.getSuiv() != null && courant.getSuiv().getIndice() < indice) {
            courant = courant.getSuiv();
        }

        if (courant.getSuiv() != null && courant.getSuiv().getIndice() == indice) {
            // L'indice existe déjà, on met à jour la valeur
            courant.getSuiv().setValeur(valeur);
        } else {
            // Insertion d'une nouvelle composante
            nouveau.setSuiv(courant.getSuiv());
            courant.setSuiv(nouveau);
        }
    }

    /**
     * Additionne deux vecteurs creux
     * 
     * @param b le vecteur à additionner avec this
     * @return un nouveau vecteur représentant la somme
     */
    public VecteurCreux additionner(VecteurCreux b) {
        return somme(this, b);
    }

    /**
     * Additionne deux vecteurs creux (méthode statique)
     * 
     * @param a le premier vecteur
     * @param b le second vecteur
     * @return un nouveau vecteur représentant la somme
     */
    public static VecteurCreux somme(VecteurCreux a, VecteurCreux b) {
        VecteurCreux resultat = new VecteurCreux();

        // Parcours du premier vecteur
        Maillon courantA = a.tete;
        while (courantA != null) {
            resultat.ajouterComposante(courantA.getIndice(), courantA.getValeur());
            courantA = courantA.getSuiv();
        }

        // Parcours du deuxième vecteur
        Maillon courantB = b.tete;
        while (courantB != null) {
            // Recherche de la composante dans le résultat
            Maillon courantRes = resultat.tete;
            boolean trouve = false;

            while (courantRes != null && !trouve) {
                if (courantRes.getIndice() == courantB.getIndice()) {
                    // L'indice existe déjà, on ajoute la valeur
                    courantRes.setValeur(courantRes.getValeur() + courantB.getValeur());
                    trouve = true;
                }
                courantRes = courantRes.getSuiv();
            }

            if (!trouve) {
                // L'indice n'existe pas encore, on l'ajoute
                resultat.ajouterComposante(courantB.getIndice(), courantB.getValeur());
            }

            courantB = courantB.getSuiv();
        }

        return resultat;
    }

    /**
     * Calcule le produit scalaire de deux vecteurs
     * 
     * @param b le vecteur à multiplier avec this
     * @return le produit scalaire
     */
    public float multiplier(VecteurCreux b) {
        float produit = 0;

        Maillon courantA = this.tete;

        while (courantA != null) {
            Maillon courantB = b.tete;

            while (courantB != null) {
                if (courantA.getIndice() == courantB.getIndice()) {
                    produit += courantA.getValeur() * courantB.getValeur();
                    break;
                }

                if (courantB.getIndice() > courantA.getIndice()) {
                    break;
                }

                courantB = courantB.getSuiv();
            }

            courantA = courantA.getSuiv();
        }

        return produit;
    }

    /**
     * Affiche le vecteur sous forme de liste d'indices et valeurs
     */
    public void afficher() {
        if (tete == null) {
            System.out.println("Vecteur vide");
            return;
        }

        System.out.println("Vecteur creux :");
        System.out.println("Indice\tValeur");

        Maillon courant = tete;
        while (courant != null) {
            System.out.println(courant.getIndice() + "\t" + courant.getValeur());
            courant = courant.getSuiv();
        }
    }

    /**
     * Affiche le vecteur sous forme complète avec les zéros
     * 
     * @param taille la taille totale du vecteur
     */
    public void afficherComplet(int taille) {
        System.out.println("Vecteur complet :");
        System.out.print("(");

        Maillon courant = tete;
        // int indiceActuel = 0;

        for (int i = 0; i < taille; i++) {
            if (courant != null && courant.getIndice() == i) {
                System.out.print(courant.getValeur());
                courant = courant.getSuiv();
            } else {
                System.out.print("0");
            }

            if (i < taille - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(")");
    }
}
