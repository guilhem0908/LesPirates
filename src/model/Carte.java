package model;

/**
 * Classe abstraite représentant une carte du jeu.
 */
public abstract class Carte {
    private String nom;

    public Carte(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Méthode abstraite qui applique l’effet de la carte.
     *
     * @param joueurCible Le joueur ciblé par la carte (peut être l’adversaire).
     * @param joueurActif Le joueur qui joue la carte.
     */
    public abstract void appliquerEffet(Joueur joueurCible, Joueur joueurActif);
}
