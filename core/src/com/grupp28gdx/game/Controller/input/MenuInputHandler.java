package com.grupp28gdx.game.Controller.input;

import com.badlogic.gdx.Gdx;

/**
 * MenuInputHandler is an input handler that takes the input of a user in the menu state. This can be in the form of
 * clicking on buttons on the menu, or hovering over a button.
 */
public class MenuInputHandler extends InputHandler {
    /**
     * Checks the mouse's X position.
     * @return the X position in format int
     */
    public static int checkInputX(){
        return Gdx.input.getX();
    }
    /**
     * Checks the mouse's Y position.
     * @return the Y position in format int
     */
    public static int checkInputY(){
        return Gdx.input.getY();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;

        /** Called when the screen was touched or a mouse button was pressed. The button parameter will be {@link Buttons#LEFT} on iOS.
         * @param screenX The x coordinate, origin is in the upper left corner
         * @param screenY The y coordinate, origin is in the upper left corner
         * @param pointer the pointer for the event.
         * @param button the button
         * @return whether the input was processed */
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;

        /** Called when a finger was lifted or a mouse button was released. The button parameter will be {@link Buttons#LEFT} on iOS.
         * @param pointer the pointer for the event.
         * @param button the button
         * @return whether the input was processed */
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;

        /** Called when the mouse was moved without any buttons being pressed. Will not be called on iOS.
         * @return whether the input was processed */
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;

        /** Called when the touch gesture is cancelled. Reason may be from OS interruption to touch becoming a large surface such as
         * the user cheek). Relevant on Android and iOS only. The button parameter will be {@link Buttons#LEFT} on iOS.
         * @param pointer the pointer for the event.
         * @param button the button
         * @return whether the input was processed */
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;

        /** Called when the mouse wheel was scrolled. Will not be called on iOS.
         * @param amountX the horizontal scroll amount, negative or positive depending on the direction the wheel was scrolled.
         * @param amountY the vertical scroll amount, negative or positive depending on the direction the wheel was scrolled.
         * @return whether the input was processed. */
    }
}
