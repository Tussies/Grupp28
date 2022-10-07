package com.grupp28gdx.game.Model;

public class Boosters {

    public Boosters() {
    }

    public void setCoinMultiplier(int coinMultiplier) {

    }

    public void setJumpHigher(int jumpHigher, Player player) {

    }

    public void setRunFaster(int speedMultiplier, Position position) {
        position.setMovementSpeed(position.getMovementSpeed()*speedMultiplier);
    }

    public void moreLives(int numberOfAddedLives, Player player) {
        player.setLives(player.getLives() + numberOfAddedLives);
    }
}
