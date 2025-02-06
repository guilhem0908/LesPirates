package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe gérant la logique du jeu.
 */
public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private List<Carte> deck;
    private int indexCarteProchaine;

    public Jeu(Joueur joueur1, Joueur joueur2, List<Carte> deck) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        // On crée une copie du deck et on le mélange
        this.deck = new ArrayList<>(deck);
        Collections.shuffle(this.deck);
        this.indexCarteProchaine = 0;

        // Distribution initiale : 4 cartes à chaque joueur
        for (int i = 0; i < 4; i++) {
            joueur1.ajouterCarteALaMain(piocherCarte());
            joueur2.ajouterCarteALaMain(piocherCarte());
        }
    }

    /**
     * Permet de piocher une carte dans le deck.
     *
     * @return La carte piochée ou null si le deck est épuisé.
     */
    public Carte piocherCarte() {
        if (indexCarteProchaine < deck.size()) {
            return deck.get(indexCarteProchaine++);
        }
        return null;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    /**
     * Vérifie si la partie est terminée.
     *
     * @return true si l’un des joueurs n’est plus vivant ou a atteint l’objectif de popularité.
     */
    public boolean partieTerminee() {
        return !joueur1.estVivant() || !joueur2.estVivant() || joueur1.aGagne() || joueur2.aGagne();
    }

    /**
     * Détermine le gagnant de la partie.
     *
     * @return Le joueur gagnant ou null en cas de match nul.
     */
    public Joueur determinerGagnant() {
        if (joueur1.aGagne() || !joueur2.estVivant())
            return joueur1;
        if (joueur2.aGagne() || !joueur1.estVivant())
            return joueur2;
        return null;
    }
}
