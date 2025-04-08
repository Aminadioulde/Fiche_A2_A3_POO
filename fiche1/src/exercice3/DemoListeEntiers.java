package fiche1.exercice3;

import java.util.Scanner;

/**
 * Classe de démonstration pour l'exercice 3
 * @author v0
 */
public class DemoListeEntiers {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ListeEntiers liste1 = null;
        ListeEntiers liste2 = null;
        boolean continuer = true;
        
        System.out.println("===== Exercice 3: Traitement de listes chaînées =====");
        
        while (continuer) {
            System.out.println("\nMenu:");
            System.out.println("1. Créer la liste 1");
            System.out.println("2. Créer la liste 2");
            System.out.println("3. Afficher la liste 1");
            System.out.println("4. Afficher la liste 2");
            System.out.println("5. Tester l'égalité des listes");
            System.out.println("6. Concaténer les listes (dans une troisième liste)");
            System.out.println("7. Concaténer les listes (sans créer une troisième liste)");
            System.out.println("0. Retour au menu de la fiche 1");
            System.out.print("Votre choix : ");
            
            int choix = lireEntier();
            
            switch (choix) {
                case 1:
                    liste1 = ListeEntiers.creerListe();
                    System.out.println("Liste 1 créée.");
                    break;
                case 2:
                    liste2 = ListeEntiers.creerListe();
                    System.out.println("Liste 2 créée.");
                    break;
                case 3:
                    if (liste1 != null) {
                        liste1.afficher();
                    } else {
                        System.out.println("La liste 1 n'a pas encore été créée.");
                    }
                    break;
                case 4:
                    if (liste2 != null) {
                        liste2.afficher();
                    } else {
                        System.out.println("La liste 2 n'a pas encore été créée.");
                    }
                    break;
                case 5:
                    if (liste1 != null && liste2 != null) {
                        if (liste1.estEgal(liste2)) {
                            System.out.println("Les listes sont égales.");
                        } else {
                            System.out.println("Les listes sont différentes.");
                        }
                    } else {
                        System.out.println("Les deux listes doivent être créées d'abord.");
                    }
                    break;
                case 6:
                    if (liste1 != null && liste2 != null) {
                        ListeEntiers liste3 = liste1.concatener(liste2);
                        System.out.println("Listes concaténées dans une nouvelle liste :");
                        liste3.afficher();
                    } else {
                        System.out.println("Les deux listes doivent être créées d'abord.");
                    }
                    break;
                case 7:
                    if (liste1 != null && liste2 != null) {
                        liste1.concatenerSansCopie(liste2);
                        System.out.println("Liste 2 concaténée à la liste 1 :");
                        liste1.afficher();
                    } else {
                        System.out.println("Les deux listes doivent être créées d'abord.");
                    }
                    break;
                case 0:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
    
    /**
     * Lit un entier depuis l'entrée standard avec gestion des erreurs
     * @return l'entier saisi
     */
    private static int lireEntier() {
        int valeur = 0;
        boolean valide = false;
        
        while (!valide) {
            try {
                valeur = Integer.parseInt(scanner.nextLine().trim());
                valide = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Veuillez saisir un nombre : ");
            }
        }
        
        return valeur;
    }
}

