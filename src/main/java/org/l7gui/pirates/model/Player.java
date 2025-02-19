package org.l7gui.pirates.model;

public class Player {
    private final String name;
    private int hp = 5;

    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setHp(int hp) { this.hp = hp; }
    public int getHp() { return hp; }
}
