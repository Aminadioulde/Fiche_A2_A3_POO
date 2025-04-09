package fiche1.src.exercice1;

public class Liste {
    //  Attribut de type String(valeur stockée)
    private String valeur;
    //  Attribut de type Liste (suite: le reste de la liste)
    private Liste suite;

      //  Constructeur liste d'une seule valeur
    public Liste(String valeur) {
        this.valeur = valeur;
        this.suite = null;
    }

     // Constructeur liste d'une valeur et reste de la liste
    public Liste(String valeur, Liste suite) {
        this.valeur = valeur;
        this.suite = suite;
    }

    //  Ajouter une liste à la fin
    public void append(Liste l) {
        Liste current = this;
        while (current.suite != null) {
            current = current.suite;
        }
        current.suite = l;
    }

     // supprimer inferieur
    public Liste supprimerInferieur() {
        if (this.suite == null) {
            return null;
        }

        String pivot = this.valeur;
        Liste teteSuppr = null;
        Liste finSuppr = null;
        
        Liste precedent = this;
        Liste courant = this.suite;

        while (courant != null) {
            if (courant.valeur.compareTo(pivot) < 0) {
                // Retirer le maillon de la liste principale
                precedent.suite = courant.suite;

                // Ajouter à la liste des supprimés
                if (teteSuppr == null) {
                    teteSuppr = new Liste(courant.valeur);
                    finSuppr = teteSuppr;
                } else {
                    finSuppr.suite = new Liste(courant.valeur);
                    finSuppr = finSuppr.suite;
                }

                courant = precedent.suite;
            } else {
                precedent = courant;
                courant = courant.suite;
            }
        }

        return teteSuppr;
    }

      // quicksort
    public Liste quicksort() {
        if (this.suite == null) {
            return this;
        }

        Liste inferieurs = this.supprimerInferieur();
        Liste superieurs = this.suite;

        Liste trieInferieurs = (inferieurs != null) ? inferieurs.quicksort() : null;
        Liste trieSuperieurs = (superieurs != null) ? superieurs.quicksort() : null;

        Liste resultat = new Liste(this.valeur);
        if (trieSuperieurs != null) {
            resultat.suite = trieSuperieurs;
        }

        if (trieInferieurs != null) {
            Liste finInferieurs = trieInferieurs;
            while (finInferieurs.suite != null) {
                finInferieurs = finInferieurs.suite;
            }
            finInferieurs.suite = resultat;
            return trieInferieurs;
        } else {
            return resultat;
        }
    }

    public void afficher() {
        Liste current = this;
        while (current != null) {
            System.out.print(current.valeur + " -> ");
            current = current.suite;
        }
        System.out.println("null");
    }
}