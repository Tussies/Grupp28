package com.grupp28gdx.game.Model.PlayerGroup;

/**
 * This is the easiest player. It runs slower, jumps higher and has more lives
 * than the default GreenPlayer. It inherits the rest of its functionality from GreenPlayer.
 */
public class OrangePlayer extends AbstractPlayer implements Player {
    private int lives;
    private float friction;

    public OrangePlayer() {
        lives = 3;
        friction = 0.1f;
        super.createPlayer();
        this.body.setMovementSpeed(3);
    }

    @Override
    public void jump (){
        if (body.speedY < 0.01 && body.y <= 8) {
            playerState = PlayerStates.JUMPING;
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