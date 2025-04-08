package fiche1.exercice4;

/**
 * Implémentation d'un polynôme sous forme de liste chaînée
 * @author v0
 */
public class Polynome {
    /**
     * Structure de maillon pour le polynôme
     */
    public static class Maillon {
        private int coefficient;
        private int degre;
        private Maillon suiv;
        
        /**
         * Constructeur de maillon
         * @param coefficient le coefficient du terme
         * @param degre le degré du terme
         */
        public Maillon(int coefficient, int degre) {
            this.coefficient = coefficient;
            this.degre = degre;
            this.suiv = null;
        }
        
        /**
         * Getter pour le coefficient
         * @return le coefficient
         */
        public int getCoefficient() {
            return coefficient;
        }
        
        /**
         * Setter pour le coefficient
         * @param coefficient le nouveau coefficient
         */
        public void setCoefficient(int coefficient) {
            this.coefficient = coefficient;
        }
        
        /**
         * Getter pour le degré
         * @return le degré
         */
        public int getDegre() {
            return degre;
        }
        
        /**
         * Setter pour le degré
         * @param degre le nouveau degré
         */
        public void setDegre(int degre) {
            this.degre = degre;
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
    public Polynome() {
        this.tete = null;
    }
    
    /**
     * Ajoute un terme au polynôme
     * @param coefficient le coefficient du terme
     * @param degre le degré du terme
     */
    public void ajouterTerme(int coefficient, int degre) {
        if (coefficient == 0) {
            return; // On n'ajoute pas les termes avec coefficient 0
        }
        
        Maillon nouveau = new Maillon(coefficient, degre);
        
        if (tete == null) {
            tete = nouveau;
            return;
        }
        
        // Insertion en tête si le degré est plus grand
        if (degre > tete.getDegre()) {
            nouveau.setSuiv(tete);
            tete = nouveau;
            return;
        }
        
        // Mise à jour du coefficient si le degré existe déjà
        if (degre == tete.getDegre()) {
            tete.setCoefficient(tete.getCoefficient() + coefficient);
            if (tete.getCoefficient() == 0) {
                tete = tete.getSuiv(); // Suppression si le coefficient devient 0
            }
            return;
        }
        
        // Insertion au bon endroit dans la liste (triée par degré décroissant)
        Maillon courant = tete;
        while (courant.getSuiv() != null && courant.getSuiv().getDegre() > degre) {
            courant = courant.getSuiv();
        }
        
        if (courant.getSuiv() != null && courant.getSuiv().getDegre() == degre) {
            // Le degré existe déjà, on met à jour le coefficient
            courant.getSuiv().setCoefficient(courant.getSuiv().getCoefficient() + coefficient);
            if (courant.getSuiv().getCoefficient() == 0) {
                courant.setSuiv(courant.getSuiv().getSuiv()); // Suppression si le coefficient devient 0
            }
        } else {
            // Insertion d'un nouveau terme
            nouveau.setSuiv(courant.getSuiv());
            courant.setSuiv(nouveau);
        }
    }
    
    /**
     * Calcule la dérivée du polynôme
     * @return la dérivée du polynôme
     */
    public Polynome derivee() {
        Polynome resultat = new Polynome();
        
        Maillon courant = tete;
        while (courant != null) {
            if (courant.getDegre() > 0) {
                resultat.ajouterTerme(courant.getCoefficient() * courant.getDegre(), courant.getDegre() - 1);
            }
            courant = courant.getSuiv();
        }
        
        return resultat;
    }
    
    /**
     * Calcule la dérivée k-ième du polynôme
     * @param k l'ordre de la dérivée
     * @return la dérivée k-ième du polynôme
     */
    public Polynome deriveeKieme(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("L'ordre de la dérivée doit être positif ou nul");
        }
        
        if (k == 0) {
            // Copie du polynôme
            Polynome copie = new Polynome();
            Maillon courant = tete;
            while (courant != null) {
                copie.ajouterTerme(courant.getCoefficient(), courant.getDegre());
                courant = courant.getSuiv();
            }
            return copie;
        }
        
        Polynome resultat = this;
        for (int i = 0; i < k; i++) {
            resultat = resultat.derivee();
        }
        
        return resultat;
    }
    
    /**
     * Affiche le polynôme
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

