import com.badlogic.gdx.physics.box2d.Body;
import com.grupp28gdx.game.states.GameStateManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.grupp28gdx.game.states.PlayState;
import com.grupp28gdx.game.states.*;
import com.grupp28gdx.game.states.GameStateManager;

import static org.junit.Assert.*;


public class TestPlayState {
    GameStateManager testGsm = new GameStateManager();
    PlayState testPlaystate = new PlayState(testGsm);


    @Test
    public void testCreatePlayer(){
        Body testBody = testPlaystate.createPlayer();

        assertArrayEquals();
    }

}


