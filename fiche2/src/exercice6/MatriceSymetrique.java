package fiche2.src.exercice6;

/**
 * Implémentation de matrices symétriques
 */
public class MatriceSymetrique {
    /**
     * Constante pour la taille maximale des matrices
     */
    public static final int NMAX = 100;

    /**
     * Type pour les matrices carrées
     */
    public static class MatCarree {
        private double[][] elements;
        private int taille;

        /**
         * Constructeur
         * 
         * @param taille la taille de la matrice
         */
        public MatCarree(int taille) {
            if (taille > NMAX) {
                throw new IllegalArgumentException("La taille de la matrice ne peut pas dépasser " + NMAX);
            }

            this.taille = taille;
            this.elements = new double[taille][taille];
        }

        /**
         * Getter pour un élément de la matrice
         * 
         * @param i l'indice de ligne
         * @param j l'indice de colonne
         * @return l'élément à la position (i,j)
         */
        public double getElement(int i, int j) {
            return elements[i][j];
        }

        /**
         * Setter pour un élément de la matrice
         * 
         * @param i      l'indice de ligne
         * @param j      l'indice de colonne
         * @param valeur la nouvelle valeur
         */
        public void setElement(int i, int j, double valeur) {
            elements[i][j] = valeur;
        }

        /**
         * Getter pour la taille de la matrice
         * 
         * @return la taille
         */
        public int getTaille() {
            return taille;
        }
    }

    /**
     * Vérifie si une matrice est symétrique
     * 
     * @param m la matrice à vérifier
     * @return true si la matrice est symétrique, false sinon
     */
    public static boolean symetrique(MatCarree m) {
        int n = m.getTaille();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (m.getElement(i, j) != m.getElement(j, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Construit la représentation compacte d'une matrice symétrique
     * 
     * @param m la matrice à compacter
     * @param n la taille de la matrice
     * @return la représentation compacte, ou null si la matrice n'est pas
     *         symétrique
     */
    public static double[] symCompacte(MatCarree m, int n) {
        if (!symetrique(m)) {
            return null;
        }

        // Nombre d'éléments dans la représentation compacte
        int nbElements = (n * (n + 1)) / 2;
        double[] compact = new double[nbElements];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                compact[index++] = m.getElement(i, j);
            }
        }

        return compact;
    }

    /**
     * Accède à un élément de la matrice à partir de sa représentation compacte
     * 
     * @param c la représentation compacte
     * @param n la taille de la matrice
     * @param i l'indice de ligne
     * @param j l'indice de colonne
     * @return l'élément à la position (i,j)
     */
    public static double acces(double[] c, int n, int i, int j) {
        // Si i > j, on utilise la symétrie
        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        // Calcul de l'indice dans le tableau compact
        int index = (i * (2 * n - i - 1)) / 2 + j;

        return c[index];
    }

    /**
     * Traite une ligne de la matrice symétrique
     * 
     * @param c la représentation compacte
     * @param n la taille de la matrice
     * @param i l'indice de la ligne à traiter
     */
    public static void traiterLigne(double[] c, int n, int i) {
        System.out.print("Ligne " + i + " : ");

        for (int j = 0; j < n; j++) {
            double valeur = acces(c, n, i, j);
            traiterCoef(valeur);
            System.out.print(" ");
        }

        System.out.println();
    }

    /**
     * Traite un coefficient de la matrice
     * 
     * @param x le coefficient à traiter
     */
    public static void traiterCoef(double x) {
        System.out.print(x);
    }

    /**
     * Affiche la matrice symétrique
     * 
     * @param c la représentation compacte
     * @param n la taille de la matrice
     */
    public static void afficher(double[] c, int n) {
        System.out.println("Matrice symétrique " + n + "x" + n + " :");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(acces(c, n, i, j) + "\t");
            }
            System.out.println();
        }
    }
}
