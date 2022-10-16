package com.grupp28gdx.game.Model.PlayerGroup;

import com.grupp28gdx.game.Model.Body;

/**
 * This player is the default player. How fast this player runs, how high it jumps and how many
 * lives it has is the original and default settings for a Player.
 * The body variable is a Body object put in the GreenPlayer class by composition, determines all
 * movement, force, speed, etc. of the Player object.
 * @see Body
 *
 */
public class GreenPlayer extends AbstractPlayer implements Player {

    private int lives;
    private int jumps;
    private float friction;

    public GreenPlayer() {
        lives = 3;
        jumps = 0;
        friction = 0.3f;
        super.createPlayer();
        this.body.setMovementSpeed(7);
    }

    @Override
    public void jump (){
        if (body.y <= 1) {
            jumps = 0;
        }

        if (body.speedY < 0.01 && jumps < 2) {
            playerState = PlayerStates.JUMPING;
            jumps++;
            body.speedY = 60;
            body.accelerate(0, body.gravity);
        }
    }

    @Override
    public void playerMove(float deltaTime) {
        body.move(body.getMovementSpeed()*deltaTime, body.speedY*deltaTime*friction);
    }

    @Override
    public void playerState() {
        if(body.y <= 1){
            playerState = PlayerStates.WALKING;
        }
    }
}

