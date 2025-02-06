package model;

/**
 * Carte de popularité : lorsqu’elle est jouée, elle augmente le nombre de points de popularité du joueur actif.
 */
public class CartePopularite extends Carte {
    private int pointsPopularite;

    public CartePopularite(String nom, int pointsPopularite) {
        super(nom);
        this.pointsPopularite = pointsPopularite;
    }

    public int getPointsPopularite() {
        return pointsPopularite;
    }

    @Override
    public void appliquerEffet(Joueur joueurCible, Joueur joueurActif) {
        // La carte de popularité s'applique sur le joueur actif.
        joueurActif.ajouterPopularite(pointsPopularite);
    }
}
