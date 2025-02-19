package org.l7gui.pirates.view;

import java.util.Scanner;

public class ConsoleView implements IView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayWelcome() {
        System.out.println("""
        ==========================================
         🦜 Bienvenue dans le jeu des Pirates 🏴‍☠️
        ==========================================
        """);
    }

    public String getPlayerName(int playerNumber) {
        System.out.print("Entrez le nom du joueur " + playerNumber + " : ");
        return scanner.nextLine().trim();
    }
}
