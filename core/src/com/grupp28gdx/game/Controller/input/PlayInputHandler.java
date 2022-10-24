package com.grupp28gdx.game.Controller.input;

import com.grupp28gdx.game.Model.PlayerGroup.Player;

/**
 * PlayInputHandler is an input handler that takes the input of a user in the play state, e.g. when the user
 * presses the key used for jumping, up or w.
 */
public class PlayInputHandler extends InputHandler {
    private Player player;

    /**
     * Constructor for PlayInputHandler.
     * @param player instance of player used in this class.
     */
    public PlayInputHandler(Player player){
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        player.inputKeyDown(keycode);
        return false;

        /** Called when a key was pressed.
         *
         * @param keycode one of the constants in {@link Input.Keys}
         * @return whether the input was processed */
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;

        /** Called when a key was released.
         *
         * @param keycode one of the constants in {@link Input.Keys}
         * @return whether the input was processed */
    }

    @Override
    public boolean keyTyped(char character) {
        return false;

        /**
         * Called when a key was typed.
         * @param character The character
         * @return whether the input was processed
         */
    }
}
