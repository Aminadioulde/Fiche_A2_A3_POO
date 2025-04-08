package fiche1.src.exercice3;
/**
 * Classe permettant de manipuler de grands entiers sous forme de liste chaînée.
 * Chaque chiffre est stocké dans un nœud, avec le chiffre le plus significatif en fin de liste.
 */
public class GrandInt {
    private final int chiffre;
    private final GrandInt suite; // Partie suivante du nombre
       /**
     * Constructeur privé pour créer un GrandInt à partir d'un chiffre et d'un GrandInt existant.
     * @param chiffre Chiffre actuel.
     * @param suite Suite du nombre représenté sous forme de GrandInt.
     */
    private GrandInt(int chiffre, GrandInt suite) {
        this.chiffre = chiffre;
        this.suite = suite;
    }
     /**
     * Constructeur public qui convertit un entier en GrandInt.
     * @param nombre Entier à convertir.
     */
    public GrandInt(int nombre) {
        if (nombre == 0) {
            this.chiffre = 0;
            this.suite = null;
        } else {
            this.chiffre = nombre % 10; // Dernier chiffre du nombre
            this.suite = (nombre / 10 == 0) ? null : new GrandInt(nombre / 10); // Suite du nombre
        }
    }
    /**
     * Retourne une représentation sous forme de chaîne du GrandInt.
     * @return Représentation textuelle du GrandInt.
     */
    @Override
    public String toString() {
        if (suite != null) {
            return suite.toString() + chiffre;
        } else {
            return String.valueOf(chiffre);
        }
    }
     /**
     * Retourne le nombre de chiffres du GrandInt.
     * @return Nombre de chiffres.
     */
    public int nombreDeChiffres() {
        if (suite == null) {
            return 1;
        } else {
            return 1 + suite.nombreDeChiffres();
        }
    }
       /**
     * Méthode main pour tester la classe GrandInt.
     */
    public static void main(String[] args) {
        GrandInt grandInt = new GrandInt(123);
        System.out.println("GrandInt: " + grandInt.toString());
        System.out.println("Nombre de chiffres: " + grandInt.nombreDeChiffres());
    }
}
    