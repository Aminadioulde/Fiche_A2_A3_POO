package utils;

import java.util.Scanner;

/**
 * Classe utilitaire contenant des méthodes communes
 */
public class Utilitaires {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Lit un entier depuis l'entrée standard avec gestion des erreurs
     * 
     * @return l'entier saisi
     */
    public static int lireEntier() {
        int valeur = 0;
        boolean valide = false;

        while (!valide) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Entrée vide. Veuillez saisir un nombre : ");
                    continue;
                }
                valeur = Integer.parseInt(input);
                valide = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Veuillez saisir un nombre : ");
            }
        }

        return valeur;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Lit un nombre à virgule flottante depuis l'entrée standard avec gestion des
     * erreurs
     * 
     * @return le nombre saisi
     */
    public static float lireFlottant() {
        float valeur = 0;
        boolean valide = false;

        while (!valide) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Entrée vide. Veuillez saisir un nombre : ");
                    continue;
                }
                valeur = Float.parseFloat(input);
                valide = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Veuillez saisir un nombre : ");
            }
        }

        return valeur;
    }

    /**
     * Lit un nombre à virgule flottante double précision depuis l'entrée standard
     * avec gestion des erreurs
     * 
     * @return le nombre saisi
     */
    public static double lireDouble() {
        double valeur = 0;
        boolean valide = false;

        while (!valide) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Entrée vide. Veuillez saisir un nombre : ");
                    continue;
                }
                valeur = Double.parseDouble(input);
                valide = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Veuillez saisir un nombre : ");
            }
        }

        return valeur;
    }

    /**
     * Lit une chaîne de caractères depuis l'entrée standard avec gestion des
     * erreurs
     * 
     * @return la chaîne lue (non vide)
     */
    public static String lireChaine() {
        String valeur = "";
        boolean valide = false;

        while (!valide) {
            valeur = scanner.nextLine().trim();
            if (valeur.isEmpty()) {
                System.out.print("Entrée vide. Veuillez saisir une chaîne : ");
                continue;
            }
            valide = true;
        }

        return valeur;
    }

    /**
     * 
     * 
     * /**
     * Attend que l'utilisateur appuie sur Entrée pour continuer
     */
    public static void attendreEntree() {
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }
}
