package model;

/**
 * Carte d'attaque : lorsqu’elle est jouée, elle inflige des dégâts (perte de vie) à l’adversaire.
 */
public class CarteAttaque extends Carte {
    private int degats;

    public CarteAttaque(String nom, int degats) {
        super(nom);
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }

    @Override
    public void appliquerEffet(Joueur joueurCible, Joueur joueurActif) {
        // La carte d'attaque affecte le joueur adverse.
        joueurCible.subirDegats(degats);
    }
}
