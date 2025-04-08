package fiche2.src.exercice4;

/**
 * Implémentation d'un polynôme sous forme de liste chaînée
 * Seuls les termes avec des coefficients non nuls sont stockés
 * Les termes sont maintenus triés par ordre décroissant des degrés
 */
public class Polynome {
    /** Référence vers le premier terme du polynôme */
    private Maillon tete;

    /**
     * Structure interne représentant un terme du polynôme
     * Chaque terme contient un coefficient et un degré
     */
    private static class Maillon {
        private int coefficient;
        private int degre;
        private Maillon suiv;

        /**
         * Constructeur de maillon
         * @param coefficient le coefficient du terme
         * @param degre le degré du terme
         * @throws IllegalArgumentException si le coefficient est nul
         */
        public Maillon(int coefficient, int degre) {
            if (coefficient == 0) {
                throw new IllegalArgumentException("Le coefficient ne peut pas être nul");
            }
            this.coefficient = coefficient;
            this.degre = degre;
            this.suiv = null;
        }

        // Add getters to avoid direct field access
        public int getCoefficient() { return coefficient; }
        public int getDegre() { return degre; }
        public Maillon getSuiv() { return suiv; }
    }

    /**
     * Ajoute ou met à jour un terme dans le polynôme
     * Si un terme du même degré existe déjà, les coefficients sont additionnés
     * Si la somme des coefficients est nulle, le terme est supprimé
     * 
     * @param coefficient le coefficient du terme à ajouter
     * @param degre le degré du terme à ajouter
     */
    public void ajouterTerme(int coefficient, int degre) {
        if (coefficient == 0) {
            return; // On ignore les termes avec coefficient 0
        }

        Maillon nouveau = new Maillon(coefficient, degre);

        // Liste vide ou insertion en tête si le degré est plus grand
        if (tete == null || degre > tete.degre) {
            nouveau.suiv = tete;
            tete = nouveau;
            return;
        }

        // Mise à jour du coefficient si le degré existe déjà
        if (degre == tete.degre) {
            int nouveauCoeff = tete.coefficient + coefficient;
            if (nouveauCoeff == 0) {
                tete = tete.suiv; // Suppression si somme = 0
            } else {
                tete.coefficient = nouveauCoeff;
            }
            return;
        }

        // Insertion au bon endroit (liste triée par degré décroissant)
        Maillon courant = tete;
        while (courant.suiv != null && courant.suiv.degre > degre) {
            courant = courant.suiv;
        }

        if (courant.suiv != null && courant.suiv.degre == degre) {
            int nouveauCoeff = courant.suiv.coefficient + coefficient;
            if (nouveauCoeff == 0) {
                courant.suiv = courant.suiv.suiv;
            } else {
                courant.suiv.coefficient = nouveauCoeff;
            }
        } else {
            nouveau.suiv = courant.suiv;
            courant.suiv = nouveau;
        }
    }

    /**
     * Calcule la dérivée du polynôme
     * Applique la règle : d/dx(ax^n) = anx^(n-1)
     * 
     * @return un nouveau polynôme représentant la dérivée
     */
    public Polynome derivee() {
        Polynome resultat = new Polynome();
        Maillon courant = tete;
        
        while (courant != null) {
            if (courant.degre > 0) {
                // Règle de dérivation : nx^n -> nx^(n-1)
                resultat.ajouterTerme(
                    courant.coefficient * courant.degre, 
                    courant.degre - 1
                );
            }
            courant = courant.suiv;
        }
        
        return resultat;
    }

    /**
     * Calcule la dérivée k-ième du polynôme
     * 
     * @param k l'ordre de la dérivée à calculer
     * @return un nouveau polynôme représentant la dérivée k-ième
     * @throws IllegalArgumentException si k est négatif
     */
    public Polynome deriveeKieme(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("L'ordre de la dérivée doit être positif ou nul");
        }

        if (k == 0) {
            return this.copie();
        }

        // Fix: Create a copy before applying derivatives
        Polynome resultat = this.copie();
        for (int i = 0; i < k; i++) {
            resultat = resultat.derivee();
        }
        return resultat;
    }

    /**
     * Crée une copie profonde du polynôme actuel
     * 
     * @return un nouveau polynôme identique à l'actuel
     */
    private Polynome copie() {
        Polynome copie = new Polynome();
        Maillon courant = tete;
        while (courant != null) {
            copie.ajouterTerme(courant.coefficient, courant.degre);
            courant = courant.suiv;
        }
        return copie;
    }

    /**
     * Affiche le polynôme sous forme standard
     * Format: ax^n + bx^(n-1) + ... + kx + m
     * Les termes de coefficient 1 sont simplifiés (x au lieu de 1x)
     * Les termes de degré 0 n'affichent que le coefficient
     */
    public void afficher() {
        if (tete == null) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Maillon courant = tete;
        boolean premier = true;

        while (courant != null) {
            // Fix: Use getters instead of direct field access
            if (courant.getCoefficient() > 0 && !premier) {
                sb.append(" + ");
            } else if (courant.getCoefficient() < 0) {
                sb.append(" - ");
            }

            int coeff = Math.abs(courant.getCoefficient());
            if (coeff != 1 || courant.getDegre() == 0) {
                sb.append(coeff);
            }

            if (courant.getDegre() > 0) {
                sb.append("x");
                if (courant.getDegre() > 1) {
                    sb.append("^").append(courant.getDegre());
                }
            }

            premier = false;
            courant = courant.getSuiv();
        }

        System.out.println(sb.toString());
    }
}
