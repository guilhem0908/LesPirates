package model;

/**
 * Carte spéciale : peut combiner plusieurs effets, par exemple augmenter la popularité et infliger des dégâts.
 */
public class CarteSpeciale extends Carte {
    private int pointsPopularite;
    private int degats;

    public CarteSpeciale(String nom, int pointsPopularite, int degats) {
        super(nom);
        this.pointsPopularite = pointsPopularite;
        this.degats = degats;
    }

    @Override
    public void appliquerEffet(Joueur joueurCible, Joueur joueurActif) {
        // Exemple d'effet spécial : le joueur actif gagne en popularité et l'adversaire subit des dégâts.
        joueurActif.ajouterPopularite(pointsPopularite);
        joueurCible.subirDegats(degats);
    }
}
