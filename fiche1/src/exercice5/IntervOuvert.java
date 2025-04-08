package fiche1.src.exercice5;

/**
 * Classe représentant un intervalle ouvert d'entiers ]bInf,bSup[.
 * Un intervalle ouvert n'inclut pas ses bornes.
 */
public class IntervOuvert {
    /** Borne inférieure de l'intervalle (non incluse) */
    protected int bInf;
    /** Borne supérieure de l'intervalle (non incluse) */
    protected int bSup;
    /** Nombre d'éléments dans l'intervalle */
    protected int card;

    /**
     * Constructeur d'un intervalle ouvert.
     * @param bInf la borne inférieure de l'intervalle (non incluse)
     * @param bSup la borne supérieure de l'intervalle (non incluse)
     */
    public IntervOuvert(int bInf, int bSup) {
        this.bInf = bInf;
        this.bSup = bSup;
        this.card = (bSup - bInf - 1) > 0 ? (bSup - bInf - 1) : 0;
    }

    /**
     * Vérifie si l'intervalle est vide.
     * Un intervalle ouvert est vide si bInf >= bSup-1
     * @return true si l'intervalle est vide, false sinon
     */
    public boolean estVide() {
        return bInf >= bSup - 1;
    }

    /**
     * Vérifie si un nombre appartient à l'intervalle.
     * @param n le nombre à tester
     * @return true si n est strictement compris entre bInf et bSup, false sinon
     */
    public boolean estDans(int n) {
        return n > bInf && n < bSup;
    }

    /**
     * Vérifie si cet intervalle contient entièrement l'intervalle passé en paramètre.
     * @param I l'intervalle à tester
     * @return true si l'intervalle I est contenu dans l'intervalle courant, false sinon
     */
    public boolean contient(IntervOuvert I) {
        return this.bInf <= I.bInf && this.bSup >= I.bSup;
    }

    /**
     * Calcule l'intersection de deux intervalles.
     * @param I l'intervalle avec lequel calculer l'intersection
     * @return un nouvel intervalle représentant l'intersection
     */
    public IntervOuvert intersection(IntervOuvert I) {
        int newBInf = Math.max(this.bInf, I.bInf);
        int newBSup = Math.min(this.bSup, I.bSup);
        return new IntervOuvert(newBInf, newBSup);
    }
}