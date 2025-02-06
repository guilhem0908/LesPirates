package app;

import java.util.ArrayList;
import java.util.List;
import model.Carte;
import model.CartePopularite;
import model.Jeu;
import model.Joueur;
import view.ConsoleView;
import controller.GameController;

/**
 * Point d'entrée de l'application.
 */
public class Main {
    public static void main(String[] args) {
        // Création des joueurs
        Joueur joueur1 = new Joueur("Jack le Borgne");
        Joueur joueur2 = new Joueur("Bill Jambe-de-Bois");

        // Construction du deck de cartes (ici uniquement des cartes de popularité)
        List<Carte> deck = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            deck.add(new CartePopularite("Carte Popularité " + (i + 1), 1));
        }

        // Initialisation du jeu
        Jeu jeu = new Jeu(joueur1, joueur2, deck);
        ConsoleView view = new ConsoleView();
        GameController controller = new GameController(jeu, view);

        // Démarrer la partie
        controller.demarrerJeu();
    }
}
