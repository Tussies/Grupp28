package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Model.PlayerGroup.Player;

public class Boosters {

    public Boosters() {
    }

    public void setCoinMultiplier(int coinMultiplier) {

    }

    public void setJumpHigher(int jumpHigher, Player player) {

    }

    public void setRunFaster(int speedMultiplier, Body body) {
        body.setMovementSpeed(body.getMovementSpeed()*speedMultiplier);
    }

    public void moreLives(int numberOfAddedLives, Player player) {
        player.setLives(player.getLives() + numberOfAddedLives);
    }
}
