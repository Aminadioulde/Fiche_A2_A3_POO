/**
 * Classe principale du projet qui permet de choisir entre les fiches
 * d'exercices
 * 
 * @version 1.0
 */
public class Main {
    /**
     * Méthode principale du programme
     * 
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        // Vérifier si l'argument "test" est présent pour lancer les tests statiques
        Menu menu = new Menu();
        if (args.length > 0 && args[0].equalsIgnoreCase("test")) {
            System.out.println("Lancement des tests statiques...");
            menu.afficherMenuTestsStatiques();
        } else {
            System.out.println("Démarrage du programme...");
            menu.afficherEtTraiter();
        }
    }
}
