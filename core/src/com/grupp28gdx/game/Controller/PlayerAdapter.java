package com.grupp28gdx.game.Controller;

import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.View.PlayerView;

public class PlayerAdapter {
    private PlayerView playerView;
    private Player playerModel;

    public PlayerAdapter(Player playerModel, PlayerView playerView) {
        this.playerModel = playerModel;
        this.playerView = playerView;
    }

}
