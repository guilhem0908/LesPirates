package test.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Joueur;
import model.CartePopularite;
import model.CarteAttaque;

public class JoueurTest {
    private Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur("Capitaine Jack");
    }

    @Test
    public void testAjouterPopularite() {
        int initialPopularite = joueur.getPopularite();
        joueur.ajouterPopularite(2);
        assertEquals(initialPopularite + 2, joueur.getPopularite());
    }

    @Test
    public void testSubirDegats() {
        int initialVie = joueur.getPointsDeVie();
        joueur.subirDegats(2);
        assertEquals(initialVie - 2, joueur.getPointsDeVie());
    }

    @Test
    public void testGagner() {
        joueur.ajouterPopularite(5);
        assertTrue(joueur.aGagne());
    }
}
