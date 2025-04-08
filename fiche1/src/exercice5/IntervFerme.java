package fiche1.src.exercice5;

/**
 * Classe représentant un intervalle fermé d'entiers [bInf,bSup].
 * Un intervalle fermé inclut ses bornes, contrairement à un intervalle ouvert.
 * Cette classe hérite de IntervOuvert et redéfinit certaines méthodes pour
 * prendre en compte l'inclusion des bornes.
 */
public class IntervFerme extends IntervOuvert {
    
    /**
     * Constructeur d'un intervalle fermé.
     * @param bInf la borne inférieure de l'intervalle (incluse)
     * @param bSup la borne supérieure de l'intervalle (incluse)
     */
    public IntervFerme(int bInf, int bSup) {
        super(bInf, bSup);
        this.card = (bSup - bInf + 1) > 0 ? (bSup - bInf + 1) : 0;
    }

    /**
     * Vérifie si l'intervalle est vide.
     * Un intervalle fermé est vide si sa borne inférieure est strictement supérieure
     * à sa borne supérieure.
     * @return true si l'intervalle est vide, false sinon
     */
    @Override
    public boolean estVide() {
        return bInf > bSup;
    }

    /**
     * Vérifie si un nombre appartient à l'intervalle.
     * Dans un intervalle fermé, les bornes sont incluses.
     * @param n le nombre à tester
     * @return true si n appartient à l'intervalle, false sinon
     */
    @Override
    public boolean estDans(int n) {
        return n >= bInf && n <= bSup;
    }
}