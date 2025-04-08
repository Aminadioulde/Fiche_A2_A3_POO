
import fiche2.src.MenuFiche2;
import utils.Utilitaires;

/**
 * Menu principal permettant de choisir entre les différentes fiches d'exercices
 */
public class Menu {

    /**
     * Constructeur par défaut
     */
    public Menu() {
    }

    /**
     * Affiche et traite le menu principal
     */
    public void afficherEtTraiter() {
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║         MENU PRINCIPAL         ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║  1. Fiche 1                    ║");
            System.out.println("║  2. Fiche 2                    ║");
            System.out.println("║  0. Quitter                    ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    // TODO: implement fiche1 menu
                    break;
                case 2:
                    MenuFiche2.afficherEtTraiter();
                    break;
                case 0:
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

    }

    /**
     * Affiche et traite le menu des tests statiques
     */
    public void afficherMenuTestsStatiques() {
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║         MENU PRINCIPAL         ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║  1. Fiche 1                    ║");
            System.out.println("║  2. Fiche 2                    ║");
            System.out.println("║  0. Quitter                    ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Votre choix : ");

            int choix = Utilitaires.lireEntier();

            switch (choix) {
                case 1:
                    // TODO: implement fiche1 menu
                    break;
                case 2:
                    MenuFiche2.afficherMenuTestsStatiques();
                    break;
                case 0:
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

    }

}
