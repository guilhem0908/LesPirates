package org.l7gui.pirates.model;

public class GameModel {
    private Player player1;
    private Player player2;

    public void initPlayers(String name1, String name2) {
        player1 = new Player(name1);
        player2 = new Player(name2);
    }

    public String getPlayer1Name() { return player1.getName(); }
    public String getPlayer2Name() { return player2.getName(); }
}
