package Player;

import com.grupp28gdx.game.Model.GreenPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
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
    /*
    @Test
    public void collisionGroundBeginTest(){
        greenPlayer.collisionGroundBegin();
        assertTrue(greenPlayer.);
    }
/*
    @Test
    public void jumpTestUp(){
        greenPlayer.inputKeyDown(51);
        greenPlayer.jump();
        assertTrue(greenPlayer.getVelocityY() == 0.17f);
    }
    @Test
    public void getStateOfPlayerTest(){
        greenPlayer.setStateOfPlayer("jumping");
        assertEquals(greenPlayer.getStateOfPlayer(), "jumping");
    }

    @Test
    public void getGemCounterTest(){
        assertTrue(greenPlayer.getGemCounter() == 0);
    }

    @Test
    public void setGemCounterTest(){
        greenPlayer.setGemCounter(2);
        assertTrue(greenPlayer.getGemCounter() == 2);
    }*/
}
