package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un joueur dans le jeu.
 */
public class Joueur {
    private String nom;
    private int pointsDeVie;
    private int popularite;
    private List<Carte> main;

    public static final int MAX_VIE = 5;
    public static final int OBJECTIF_POPULARITE = 5;

    public Joueur(String nom) {
        this.nom = nom;
        this.pointsDeVie = MAX_VIE;
        this.popularite = 0;
        this.main = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getPopularite() {
        return popularite;
    }

    public List<Carte> getMain() {
        return main;
    }

    /**
     * Ajoute une carte à la main du joueur.
     *
     * @param carte La carte à ajouter.
     */
    public void ajouterCarteALaMain(Carte carte) {
        main.add(carte);
    }

    /**
     * Le joueur joue une carte de sa main.
     *
     * @param carte La carte choisie.
     * @param adversaire L'adversaire ciblé.
     */
    public void jouerCarte(Carte carte, Joueur adversaire) {
        carte.appliquerEffet(adversaire, this);
        main.remove(carte);
    }

    /**
     * Ajoute des points de popularité.
     *
     * @param points Le nombre de points à ajouter.
     */
    public void ajouterPopularite(int points) {
        popularite += points;
    }

    /**
     * Applique des dégâts (perte de points de vie).
     *
     * @param degats Le nombre de points de vie à soustraire.
     */
    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        if(pointsDeVie < 0)
            pointsDeVie = 0;
    }

    /**
     * Vérifie si le joueur a atteint l'objectif de popularité.
     *
     * @return true si le joueur a gagné en popularité, sinon false.
     */
    public boolean aGagne() {
        return popularite >= OBJECTIF_POPULARITE;
    }

    /**
     * Vérifie si le joueur est toujours en vie.
     *
     * @return true si le joueur a encore des points de vie, sinon false.
     */
    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}
