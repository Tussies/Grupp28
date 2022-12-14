package com.grupp28gdx.game.Model.PlayerGroup;

/**
 * This is the hardest player a user can choose. It runs faster and has less lives
 * than the default GreenPlayer. It inherits the rest of its functionality from GreenPlayer.
 */
public class PurplePlayer extends AbstractPlayer implements Player {
    private int jumps;
    private float friction;

    public PurplePlayer() {
        jumps = 0;
        friction = 0.3f;
        super.createPlayer();
        this.body.setMovementSpeed(4);
    }

    @Override
    public void jump (){
        if (body.y <= 1.2f) {
            jumps = 0;
        }

        if (body.speedY < 0.01 && jumps < 2) {
            playerState = PlayerStates.JUMPING;
            jumps++;
            body.speedY = 50;
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
            playerState = PlayerStates.RUNNING;
        }
    }
}