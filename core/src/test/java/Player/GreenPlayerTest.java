package Player;

import com.grupp28gdx.game.Model.GreenPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class GreenPlayerTest {
    GreenPlayer greenPlayer = new GreenPlayer();

    @Test
    public void getLivesTest(){
        assertTrue(greenPlayer.getLives() == 3);
    }

    @Test
    public void setLivesTest(){
        greenPlayer.setLives(2);
        assertTrue(greenPlayer.getLives() == 2);
    }
    //@TODO
    @Test
    public void collisionGroundBeginTest(){
        greenPlayer.collisionGroundBegin();

    }

    @Test
    public void getGemCounterTest(){
        assertTrue(greenPlayer.getGemCounter() == 0);
    }

    @Test
    public void setGemCounterTest(){
        greenPlayer.setGemCounter(2);
        assertTrue(greenPlayer.getGemCounter() == 2);
    }
}
