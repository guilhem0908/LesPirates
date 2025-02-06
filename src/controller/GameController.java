package controller;

import model.Carte;
import model.Jeu;
import model.Joueur;
import view.ConsoleView;

/**
 * Classe contrôleur qui gère la boucle de jeu et les interactions entre le modèle et la vue.
 */
public class GameController {
    private Jeu jeu;
    private ConsoleView view;

    public GameController(Jeu jeu, ConsoleView view) {
        this.jeu = jeu;
        this.view = view;
    }

    /**
     * Démarre la partie et exécute la boucle de jeu.
     */
    public void demarrerJeu() {
        Joueur joueurActif = jeu.getJoueur1();
        Joueur joueurAdverse = jeu.getJoueur2();

        while (!jeu.partieTerminee()) {
            view.afficherEtatJoueur(joueurActif);
            view.afficherEtatJoueur(joueurAdverse);

            // Le joueur actif pioche une carte
            Carte cartePiochee = jeu.piocherCarte();
            if (cartePiochee != null) {
                joueurActif.ajouterCarteALaMain(cartePiochee);
                view.afficherMessage(joueurActif.getNom() + " pioche une carte : " + cartePiochee.getNom());
            } else {
                view.afficherMessage("Le deck est épuisé !");
            }

            // Le joueur actif choisit la carte à jouer
            int indexCarte = view.demanderChoixCarte(joueurActif);
            if (indexCarte >= 0 && indexCarte < joueurActif.getMain().size()) {
                Carte carteChoisie = joueurActif.getMain().get(indexCarte);
                joueurActif.jouerCarte(carteChoisie, joueurAdverse);
                view.afficherMessage(joueurActif.getNom() + " joue la carte : " + carteChoisie.getNom());
            } else {
                view.afficherMessage("Choix invalide !");
            }

            // Si la partie est terminée, sortir de la boucle
            if (jeu.partieTerminee()) {
                break;
            }

            // Inverser les rôles pour le tour suivant
            Joueur temp = joueurActif;
            joueurActif = joueurAdverse;
            joueurAdverse = temp;
        }

        Joueur gagnant = jeu.determinerGagnant();
        if (gagnant != null) {
            view.afficherGagnant(gagnant);
        } else {
            view.afficherMessage("Match nul !");
        }
    }
}
