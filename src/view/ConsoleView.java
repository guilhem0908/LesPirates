package view;

import java.util.Scanner;
import model.Joueur;
import model.Carte;
import model.Jeu;

/**
 * Classe gérant l'affichage en console et les interactions avec l'utilisateur.
 */
public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Affiche un message à l'écran.
     *
     * @param message Le message à afficher.
     */
    public void afficherMessage(String message) {
        System.out.println(message);
    }

    /**
     * Affiche la main du joueur et demande le choix de la carte à jouer.
     *
     * @param joueur Le joueur qui doit choisir une carte.
     * @return L'indice de la carte choisie dans la main.
     */
    public int demanderChoixCarte(Joueur joueur) {
        afficherMessage("\nMain de " + joueur.getNom() + " :");
        int i = 1;
        for (Carte carte : joueur.getMain()) {
            afficherMessage(i + ". " + carte.getNom());
            i++;
        }
        afficherMessage("Choisissez le numéro de la carte à jouer : ");
        int choix = scanner.nextInt();
        return choix - 1;
    }

    /**
     * Affiche l'état (vie et popularité) d'un joueur.
     *
     * @param joueur Le joueur dont on affiche l'état.
     */
    public void afficherEtatJoueur(Joueur joueur) {
        afficherMessage(joueur.getNom() + " : Vie = " + joueur.getPointsDeVie() + ", Popularité = " + joueur.getPopularite());
    }

    /**
     * Affiche le gagnant de la partie.
     *
     * @param gagnant Le joueur gagnant.
     */
    public void afficherGagnant(Joueur gagnant) {
        afficherMessage("\nLe gagnant est : " + gagnant.getNom());
    }
}
