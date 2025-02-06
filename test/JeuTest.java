package test.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import model.Jeu;
import model.Joueur;
import model.Carte;
import model.CartePopularite;

public class JeuTest {
    private Joueur joueur1;
    private Joueur joueur2;
    private List<Carte> deck;
    private Jeu jeu;

    @Before
    public void setUp() {
        joueur1 = new Joueur("Pirate 1");
        joueur2 = new Joueur("Pirate 2");
        deck = new ArrayList<>();

        // Ajout de 20 cartes de popularité dans le deck
        for (int i = 0; i < 20; i++) {
            deck.add(new CartePopularite("Carte Popularité " + (i + 1), 1));
        }

        jeu = new Jeu(joueur1, joueur2, deck);
    }

    @Test
    public void testInitialisationMain() {
        assertEquals(4, joueur1.getMain().size());
        assertEquals(4, joueur2.getMain().size());
    }

    @Test
    public void testPiocherCarte() {
        Carte carte = jeu.piocherCarte();
        assertNotNull(carte);
    }
}
