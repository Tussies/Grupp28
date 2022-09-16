package com.grupp28gdx.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.grupp28gdx.game.states.PlayState;

public class MenuInputHandler extends InputHandler {
    public static int checkInputX(){
        return Gdx.input.getX();
    }
    public static int checkInputY(){
        return Gdx.input.getY();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;

        /** Called when a finger was lifted or a mouse button was released. The button parameter will be {@link Buttons#LEFT} on iOS.
         * @param pointer the pointer for the event.
         * @param button the button
         * @return whether the input was processed */
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;

        /** Called when the touch gesture is cancelled. Reason may be from OS interruption to touch becoming a large surface such as
         * the user cheek). Relevant on Android and iOS only. The button parameter will be {@link Buttons#LEFT} on iOS.
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

        /** Called when the mouse wheel was scrolled. Will not be called on iOS.
         * @param amountX the horizontal scroll amount, negative or positive depending on the direction the wheel was scrolled.
         * @param amountY the vertical scroll amount, negative or positive depending on the direction the wheel was scrolled.
         * @return whether the input was processed. */
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
