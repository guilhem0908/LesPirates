package org.l7gui.pirates.controller;

import org.l7gui.pirates.view.IView;
import org.l7gui.pirates.model.GameModel;

public class GameController {
    private final IView view;
    private final GameModel model;

    public GameController(IView view, GameModel model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        view.displayWelcome();
        String name1 = view.getPlayerName(1);
        String name2 = view.getPlayerName(2);
        model.initPlayers(name1, name2);
    }
}
