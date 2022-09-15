import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.states.GameStateManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import com.grupp28gdx.game.states.PlayState;
import com.grupp28gdx.game.states.*;
import com.grupp28gdx.game.states.GameStateManager;

import static org.junit.Assert.*;


public class TestPlayState {

    GameStateManager testGsm = new GameStateManager();
    PlayState testPlayState = new PlayState(testGsm);


    @Test
    public void testCreatePlayer(){
        Body testBody = testPlayState.createPlayer();

        assertArrayEquals(new Body, testBody);
    }

    @Test
    public void testCreateGround(){
        Body testGround = testPlayState.createGround();

        assertArrayEquals(new Body() , testGround);

    }

}

