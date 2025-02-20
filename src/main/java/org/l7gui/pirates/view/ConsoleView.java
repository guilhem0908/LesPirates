package org.l7gui.pirates.view;

import java.util.Scanner;

public class ConsoleView implements IView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayWelcome() {
        System.out.print("""
        ============================================
          🦜 Bienvenue dans le jeu des Pirates 🏴‍☠️
        ============================================
        📖 Règles du jeu:
        2 joueurs, 4 cartes et 5 pv chacun
        Chaque tour : pioche 1 carte, joue 1 carte:
          - Popularité : ajoute-la à ta zone.
          - Attaque : joue-la sur ton adversaire.
        Objectif : 5 popularités ou survivre.
        ============================================
        Appuyez sur Entrée pour commencer...""");
        scanner.nextLine();
    }

    @Override
    public String getPlayerName(int playerNumber) {
        System.out.print("Entrez le nom du joueur " + playerNumber + " : ");
        return scanner.nextLine().trim();
    }
}
