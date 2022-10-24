package com.grupp28gdx.game.Controller.input;

import com.grupp28gdx.game.Model.PlayerGroup.Player;

public class PlayInputHandler extends InputHandler {
    private Player player;
    public PlayInputHandler(Player player){
        this.player = player;
    }
    @Override
    public boolean keyDown(int keycode) {
        player.inputKeyDown(keycode);
        return false;

        /** Called when a key was released
         *
         * @param keycode one of the constants in {@link Input.Keys}
         * @return whether the input was processed */
    }

    @Override
    public boolean keyUp(int keycode) {
        player.inputKeyUp(keycode);
        return false;

        /** Called when a key was typed
         *
         * @param character The character
         * @return whether the input was processed */
    }

    @Override
    public boolean keyTyped(char character) {
        return false;

        /** Called when the screen was touched or a mouse button was pressed. The button parameter will be {@link Buttons#LEFT} on iOS.
         * @param screenX The x coordinate, origin is in the upper left corner
         * @param screenY The y coordinate, origin is in the upper left corner
         * @param pointer the pointer for the event.
         * @param button the button
         * @return whether the input was processed */
    }
}