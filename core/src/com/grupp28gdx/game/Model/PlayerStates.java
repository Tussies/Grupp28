package com.grupp28gdx.game.Model;

/**
 * This is all the states a player can have.
 */
public enum StateOfPlayer{
    IDLE("idle"),
    WALKING("walking"),
    JUMPING("jumping"),
    FALLING("falling"),
    RUNNING("running"),
    DEAD("dead")
    ;

    public final String text;

    StateOfPlayer(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    /*enum StateOfPlayerDirection{
    LEFT,
    RIGHT*/
}
