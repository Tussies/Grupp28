package com.grupp28gdx.game.Model.PlayerGroup;

/**
 * This is the easiest player. It runs slower, jumps higher and has more lives
 * than the default GreenPlayer. It inherits the rest of its functionality from GreenPlayer.
 */
public class OrangePlayer extends AbstractPlayer implements Player {
    private float friction;
    private int jumps;

    public OrangePlayer() {
        jumps = 0;
        friction = 0.1f;
        super.createPlayer();
        this.body.setMovementSpeed(1.6f);
    }

    @Override
    public void jump (){
        if (body.y <= 1.3f) {
            jumps = 0;
        }

        if (jumps < 4 && body.y < 5) {
            playerState = PlayerStates.JUMPING;
            jumps++;
            body.speedY = 80;
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