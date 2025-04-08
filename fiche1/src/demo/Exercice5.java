package fiche1.src.demo;

import fiche1.src.exercice5.*;
import utils.Utilitaires;

/**
 * Pour tester les fonctionnalités des intervalles d'entiers
 */
public class Exercice5 {
    private IntervOuvert io;
    private IntervFerme if_;

    public void afficherEtTraiter() {
        boolean continuer = true;

        while (continuer) {
            Utilitaires.clearScreen();
            afficherMenu();
            int choix = Utilitaires.lireEntier();
            traiterChoix(choix);

            if (choix != 0) {
                System.out.println("\nAppuyez sur Entrée pour continuer...");
                Utilitaires.attendreEntree();
            }
            continuer = (choix != 0);
        }
    }

    private void afficherMenu() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║           EXERCICE 5 - INTERVALLES D'ENTIERS       ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║  1. Créer un intervalle ouvert                     ║");
        System.out.println("║  2. Créer un intervalle fermé                      ║");
        System.out.println("║  3. Tester si un nombre est dans l'intervalle      ║");
        System.out.println("║  4. Tester si l'intervalle est vide                ║");
        System.out.println("║  5. Créer et tester une intersection               ║");
        System.out.println("║  0. Retour au menu principal                       ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.print("Votre choix : ");
    }

    private void traiterChoix(int choix) {
        switch (choix) {
            case 1:
                creerIntervOuvert();
                break;
            case 2:
                creerIntervFerme();
                break;
            case 3:
                testerAppartenance();
                break;
            case 4:
                testerVide();
                break;
            case 5:
                testerIntersection();
                break;
            case 0:
                break;
            default:
                System.out.println("Choix invalide !");
        }
    }

    private void creerIntervOuvert() {
        System.out.print("Borne inférieure : ");
        int bInf = Utilitaires.lireEntier();
        System.out.print("Borne supérieure : ");
        int bSup = Utilitaires.lireEntier();
        io = new IntervOuvert(bInf, bSup);
        System.out.println("Intervalle ouvert créé : ]" + bInf + "," + bSup + "[");
    }

    private void creerIntervFerme() {
        System.out.print("Borne inférieure : ");
        int bInf = Utilitaires.lireEntier();
        System.out.print("Borne supérieure : ");
        int bSup = Utilitaires.lireEntier();
        if_ = new IntervFerme(bInf, bSup);
        System.out.println("Intervalle fermé créé : [" + bInf + "," + bSup + "]");
    }

    private void testerAppartenance() {
        System.out.print("Nombre à tester : ");
        int n = Utilitaires.lireEntier();
        if (io != null)
            System.out.println("Dans l'intervalle ouvert : " + io.estDans(n));
        if (if_ != null)
            System.out.println("Dans l'intervalle fermé : " + if_.estDans(n));
    }

    private void testerVide() {
        if (io != null)
            System.out.println("Intervalle ouvert est vide : " + io.estVide());
        if (if_ != null)
            System.out.println("Intervalle fermé est vide : " + if_.estVide());
    }

    private void testerIntersection() {
        if (io != null) {
            System.out.println("Création du deuxième intervalle ouvert pour l'intersection");
            System.out.print("Borne inférieure : ");
            int bInf = Utilitaires.lireEntier();
            System.out.print("Borne supérieure : ");
            int bSup = Utilitaires.lireEntier();
            IntervOuvert io2 = new IntervOuvert(bInf, bSup);
            IntervOuvert intersection = io.intersection(io2);
            System.out.println("Intersection créée");
            System.out.print("Tester un nombre dans l'intersection : ");
            int n = Utilitaires.lireEntier();
            System.out.println("Le nombre est dans l'intersection : " + intersection.estDans(n));
        } else {
            System.out.println("Créez d'abord un intervalle ouvert !");
        }
    }
}