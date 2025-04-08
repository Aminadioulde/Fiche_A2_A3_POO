package fiche2.src.exercice8;

/**
 * Implémentation d'un index alphabétique à l'aide d'un ABR et de LCB
 */
public class IndexABR {
    /**
     * Structure de maillon pour la liste chaînée bidirectionnelle
     */
    public static class Maillon {
        private int numero;
        private Maillon suiv;
        private Maillon prec;

        /**
         * Constructeur de maillon
         * 
         * @param numero le numéro de page
         */
        public Maillon(int numero) {
            this.numero = numero;
            this.suiv = null;
            this.prec = null;
        }

        /**
         * Getter pour le numéro
         * 
         * @return le numéro de page
         */
        public int getNumero() {
            return numero;
        }

        /**
         * Setter pour le numéro
         * 
         * @param numero le nouveau numéro de page
         */
        public void setNumero(int numero) {
            this.numero = numero;
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

    /**
     * Structure pour la liste chaînée bidirectionnelle
     */
    public static class LCB {
        private Maillon tete;
        private Maillon queue;

        /**
         * Constructeur par défaut
         */
        public LCB() {
            this.tete = null;
            this.queue = null;
        }

        /**
         * Getter pour la tête
         * 
         * @return la tête de la liste
         */
        public Maillon getTete() {
            return tete;
        }

        /**
         * Setter pour la tête
         * 
         * @param tete la nouvelle tête
         */
        public void setTete(Maillon tete) {
            this.tete = tete;
        }

        /**
         * Getter pour la queue
         * 
         * @return la queue de la liste
         */
        public Maillon getQueue() {
            return queue;
        }

        /**
         * Setter pour la queue
         * 
         * @param queue la nouvelle queue
         */
        public void setQueue(Maillon queue) {
            this.queue = queue;
        }

        /**
         * Vérifie si la liste est vide
         * 
         * @return true si la liste est vide, false sinon
         */
        public boolean estVide() {
            return tete == null;
        }

        /**
         * Calcule la taille de la liste
         * 
         * @return le nombre d'éléments dans la liste
         */
        public int taille() {
            int compteur = 0;
            Maillon courant = tete;

            while (courant != null) {
                compteur++;
                courant = courant.getSuiv();
            }

            return compteur;
        }
    }

    /**
     * Structure de nœud pour l'arbre binaire de recherche
     */
    public static class Noeud {
        private String nom;
        private LCB numeros;
        private Noeud gauche;
        private Noeud droite;

        /**
         * Constructeur de nœud
         * 
         * @param nom le nom propre
         */
        public Noeud(String nom) {
            this.nom = nom;
            this.numeros = new LCB();
            this.gauche = null;
            this.droite = null;
        }

        /**
         * Getter pour le nom
         * 
         * @return le nom propre
         */
        public String getNom() {
            return nom;
        }

        /**
         * Setter pour le nom
         * 
         * @param nom le nouveau nom propre
         */
        public void setNom(String nom) {
            this.nom = nom;
        }

        /**
         * Getter pour les numéros
         * 
         * @return la liste des numéros de page
         */
        public LCB getNumeros() {
            return numeros;
        }

        /**
         * Setter pour les numéros
         * 
         * @param numeros la nouvelle liste des numéros de page
         */
        public void setNumeros(LCB numeros) {
            this.numeros = numeros;
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
    public IndexABR() {
        this.racine = null;
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
     * Ajoute un numéro de page à une liste chaînée bidirectionnelle
     * 
     * @param num     le numéro à ajouter
     * @param numeros la liste des numéros
     * @return la liste modifiée
     */
    public static LCB ajoutNumero(int num, LCB numeros) {
        // Vérification si la liste est vide
        if (numeros.getTete() == null) {
            Maillon nouveau = new Maillon(num);
            numeros.setTete(nouveau);
            numeros.setQueue(nouveau);
            return numeros;
        }

        // Vérification si le numéro existe déjà
        Maillon courant = numeros.getTete();
        while (courant != null) {
            if (courant.getNumero() == num) {
                return numeros; // Le numéro existe déjà
            }
            courant = courant.getSuiv();
        }

        // Insertion en tête si le numéro est plus petit que le premier
        if (num < numeros.getTete().getNumero()) {
            Maillon nouveau = new Maillon(num);
            nouveau.setSuiv(numeros.getTete());
            numeros.getTete().setPrec(nouveau);
            numeros.setTete(nouveau);
            return numeros;
        }

        // Insertion en queue si le numéro est plus grand que le dernier
        if (num > numeros.getQueue().getNumero()) {
            Maillon nouveau = new Maillon(num);
            nouveau.setPrec(numeros.getQueue());
            numeros.getQueue().setSuiv(nouveau);
            numeros.setQueue(nouveau);
            return numeros;
        }

        // Insertion au milieu
        courant = numeros.getTete();
        while (courant.getSuiv() != null && courant.getSuiv().getNumero() < num) {
            courant = courant.getSuiv();
        }

        Maillon nouveau = new Maillon(num);
        nouveau.setSuiv(courant.getSuiv());
        nouveau.setPrec(courant);
        courant.getSuiv().setPrec(nouveau);
        courant.setSuiv(nouveau);

        return numeros;
    }

    /**
     * Ajoute un nom propre et ses numéros de page à l'index
     * 
     * @param nom    le nom propre
     * @param t      le tableau des numéros de page
     * @param nombre le nombre de numéros
     * @param a      l'arbre binaire de recherche
     * @return l'arbre modifié
     */
    public static IndexABR ajoutNomPropre(String nom, int[] t, int nombre, IndexABR a) {
        if (a.getRacine() == null) {
            // Arbre vide
            Noeud nouveau = new Noeud(nom);
            a.setRacine(nouveau);

            // Ajout des numéros de page
            for (int i = 0; i < nombre; i++) {
                ajoutNumero(t[i], nouveau.getNumeros());
            }

            return a;
        }

        // Insertion dans l'arbre
        a.setRacine(ajoutNomPropreRecursif(nom, t, nombre, a.getRacine()));

        return a;
    }

    /**
     * Fonction récursive pour ajouter un nom propre
     * 
     * @param nom    le nom propre
     * @param t      le tableau des numéros de page
     * @param nombre le nombre de numéros
     * @param noeud  le nœud courant
     * @return le nœud modifié
     */
    private static Noeud ajoutNomPropreRecursif(String nom, int[] t, int nombre, Noeud noeud) {
        if (noeud == null) {
            // Création d'un nouveau nœud
            Noeud nouveau = new Noeud(nom);

            // Ajout des numéros de page
            for (int i = 0; i < nombre; i++) {
                ajoutNumero(t[i], nouveau.getNumeros());
            }

            return nouveau;
        }

        int comparaison = nom.compareTo(noeud.getNom());

        if (comparaison < 0) {
            // Insertion à gauche
            noeud.setGauche(ajoutNomPropreRecursif(nom, t, nombre, noeud.getGauche()));
        } else if (comparaison > 0) {
            // Insertion à droite
            noeud.setDroite(ajoutNomPropreRecursif(nom, t, nombre, noeud.getDroite()));
        } else {
            // Le nom existe déjà, on ajoute les numéros de page
            for (int i = 0; i < nombre; i++) {
                ajoutNumero(t[i], noeud.getNumeros());
            }
        }

        return noeud;
    }

    /**
     * Supprime un numéro de page pour un nom donné
     * 
     * @param nom    le nom propre
     * @param numero le numéro de page à supprimer
     * @param a      l'arbre binaire de recherche
     * @return l'arbre modifié
     */
    public static IndexABR supprimerNumero(String nom, int numero, IndexABR a) {
        if (a.getRacine() == null) {
            return a; // Arbre vide
        }

        // Recherche du nœud correspondant au nom
        Noeud noeud = rechercherNom(a.getRacine(), nom);

        if (noeud == null) {
            return a; // Nom non trouvé
        }

        // Suppression du numéro de page
        LCB numeros = noeud.getNumeros();

        // Cas spécial : suppression en tête
        if (numeros.getTete() != null && numeros.getTete().getNumero() == numero) {
            numeros.setTete(numeros.getTete().getSuiv());
            if (numeros.getTete() != null) {
                numeros.getTete().setPrec(null);
            } else {
                numeros.setQueue(null); // La liste devient vide
            }
            return a;
        }

        // Cas spécial : suppression en queue
        if (numeros.getQueue() != null && numeros.getQueue().getNumero() == numero) {
            numeros.setQueue(numeros.getQueue().getPrec());
            if (numeros.getQueue() != null) {
                numeros.getQueue().setSuiv(null);
            } else {
                numeros.setTete(null); // La liste devient vide
            }
            return a;
        }

        // Suppression au milieu
        Maillon courant = numeros.getTete();
        while (courant != null && courant.getNumero() != numero) {
            courant = courant.getSuiv();
        }

        if (courant != null) {
            courant.getPrec().setSuiv(courant.getSuiv());
            courant.getSuiv().setPrec(courant.getPrec());
        }

        return a;
    }

    /**
     * Recherche un nœud par son nom
     * 
     * @param noeud le nœud courant
     * @param nom   le nom à rechercher
     * @return le nœud correspondant, ou null s'il n'existe pas
     */
    private static Noeud rechercherNom(Noeud noeud, String nom) {
        if (noeud == null) {
            return null;
        }

        int comparaison = nom.compareTo(noeud.getNom());

        if (comparaison == 0) {
            return noeud;
        } else if (comparaison < 0) {
            return rechercherNom(noeud.getGauche(), nom);
        } else {
            return rechercherNom(noeud.getDroite(), nom);
        }
    }

    /**
     * Supprime un nom propre de l'index
     * 
     * @param nom le nom propre à supprimer
     * @param a   l'arbre binaire de recherche
     * @return l'arbre modifié
     */
    public static IndexABR supprimerNom(String nom, IndexABR a) {
        if (a.getRacine() == null) {
            return a; // Arbre vide
        }

        a.setRacine(supprimerNomRecursif(nom, a.getRacine()));

        return a;
    }

    /**
     * Fonction récursive pour supprimer un nom propre
     * 
     * @param nom   le nom propre à supprimer
     * @param noeud le nœud courant
     * @return le nœud modifié
     */
    private static Noeud supprimerNomRecursif(String nom, Noeud noeud) {
        if (noeud == null) {
            return null;
        }

        int comparaison = nom.compareTo(noeud.getNom());

        if (comparaison < 0) {
            noeud.setGauche(supprimerNomRecursif(nom, noeud.getGauche()));
        } else if (comparaison > 0) {
            noeud.setDroite(supprimerNomRecursif(nom, noeud.getDroite()));
        } else {
            // Nœud trouvé, suppression

            // Cas 1 : Nœud feuille
            if (noeud.getGauche() == null && noeud.getDroite() == null) {
                return null;
            }

            // Cas 2 : Nœud avec un seul fils
            if (noeud.getGauche() == null) {
                return noeud.getDroite();
            }
            if (noeud.getDroite() == null) {
                return noeud.getGauche();
            }

            // Cas 3 : Nœud avec deux fils
            // Recherche du successeur (le plus petit élément dans le sous-arbre droit)
            Noeud successeur = trouverMinimum(noeud.getDroite());

            // Copie des données du successeur dans le nœud à supprimer
            noeud.setNom(successeur.getNom());
            noeud.setNumeros(successeur.getNumeros());

            // Suppression du successeur
            noeud.setDroite(supprimerNomRecursif(successeur.getNom(), noeud.getDroite()));
        }

        return noeud;
    }

    /**
     * Trouve le nœud avec la valeur minimale dans un sous-arbre
     * 
     * @param noeud la racine du sous-arbre
     * @return le nœud avec la valeur minimale
     */
    private static Noeud trouverMinimum(Noeud noeud) {
        Noeud courant = noeud;

        while (courant.getGauche() != null) {
            courant = courant.getGauche();
        }

        return courant;
    }

    /**
     * Recherche les occurrences d'un nom propre
     * 
     * @param nom le nom propre à rechercher
     * @return un tableau des numéros de page, ou null si le nom n'existe pas
     */
    public int[] rechercherOccurrences(String nom) {
        Noeud noeud = rechercherNom(racine, nom);

        if (noeud == null) {
            return null;
        }

        LCB numeros = noeud.getNumeros();
        int taille = numeros.taille();
        int[] resultat = new int[taille];

        Maillon courant = numeros.getTete();
        for (int i = 0; i < taille; i++) {
            resultat[i] = courant.getNumero();
            courant = courant.getSuiv();
        }

        return resultat;
    }

    /**
     * Affiche l'index alphabétique
     */
    public void afficherIndex() {
        System.out.println("Index alphabétique :");
        System.out.println("Nom\tPages");
        afficherIndexRecursif(racine);
    }

    /**
     * Fonction récursive pour afficher l'index
     * 
     * @param noeud le nœud courant
     */
    private void afficherIndexRecursif(Noeud noeud) {
        if (noeud == null) {
            return;
        }

        // Parcours infixe pour afficher les noms par ordre alphabétique
        afficherIndexRecursif(noeud.getGauche());

        System.out.print(noeud.getNom() + "\t");

        // Affichage des numéros de page
        Maillon courant = noeud.getNumeros().getTete();
        while (courant != null) {
            System.out.print(courant.getNumero());
            if (courant.getSuiv() != null) {
                System.out.print(", ");
            }
            courant = courant.getSuiv();
        }

        System.out.println();

        afficherIndexRecursif(noeud.getDroite());
    }

    /**
     * Calcule la hauteur de l'arbre
     * 
     * @return la hauteur de l'arbre
     */
    public int hauteur() {
        return hauteurRecursif(racine);
    }

    /**
     * Fonction récursive pour calculer la hauteur d'un sous-arbre
     * 
     * @param noeud la racine du sous-arbre
     * @return la hauteur du sous-arbre
     */
    private int hauteurRecursif(Noeud noeud) {
        if (noeud == null) {
            return -1;
        }

        int hauteurGauche = hauteurRecursif(noeud.getGauche());
        int hauteurDroite = hauteurRecursif(noeud.getDroite());

        return 1 + Math.max(hauteurGauche, hauteurDroite);
    }

    /**
     * Compte le nombre de nœuds dans l'arbre
     * 
     * @return le nombre de nœuds
     */
    public int nombreNoeuds() {
        return nombreNoeudsRecursif(racine);
    }

    /**
     * Fonction récursive pour compter le nombre de nœuds dans un sous-arbre
     * 
     * @param noeud la racine du sous-arbre
     * @return le nombre de nœuds
     */
    private int nombreNoeudsRecursif(Noeud noeud) {
        if (noeud == null) {
            return 0;
        }

        return 1 + nombreNoeudsRecursif(noeud.getGauche()) + nombreNoeudsRecursif(noeud.getDroite());
    }

    /**
     * Crée un index d'exemple
     * 
     * @return l'index créé
     */
    public static IndexABR creerIndexExemple() {
        IndexABR index = new IndexABR();

        // Ajout de "Fatou" avec les pages 110, 250, 300
        int[] pagesFatou = { 110, 250, 300 };
        index = ajoutNomPropre("Fatou", pagesFatou, 3, index);

        // Ajout de "Mamadou" avec les pages 3, 14, 101
        int[] pagesMamadou = { 3, 14, 101 };
        index = ajoutNomPropre("Mamadou", pagesMamadou, 3, index);

        // Ajout de "Ousseynou" avec les pages 11, 50
        int[] pagesOusseynou = { 11, 50 };
        index = ajoutNomPropre("Ousseynou", pagesOusseynou, 2, index);

        // Ajout de "Pierre" avec les pages 3, 7, 100, 287
        int[] pagesPierre = { 3, 7, 100, 287 };
        index = ajoutNomPropre("Pierre", pagesPierre, 4, index);

        // Ajout de "Soda" avec les pages 6, 10, 34, 66, 98
        int[] pagesSoda = { 6, 10, 34, 66, 98 };
        index = ajoutNomPropre("Soda", pagesSoda, 5, index);

        return index;
    }
}
