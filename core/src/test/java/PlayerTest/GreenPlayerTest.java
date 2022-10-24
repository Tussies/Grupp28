package PlayerTest;

import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
//import com.grupp28gdx.game.Model.StateOfPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.PlayerStates;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GreenPlayerTest {
    GreenPlayer greenPlayer = new GreenPlayer();


    @Test
    public void jump(){
        greenPlayer.jump();
        assertTrue(greenPlayer.getBody().getSpeedY() == 69);
    }

    @Test
    public void playerMove(){
         greenPlayer.playerMove(1);
         assertTrue(greenPlayer.getBody().getXPosition() == 2.7f && greenPlayer.getBody().getYPosition() == 0);
    }

    @Test
    public void playerState(){
        greenPlayer.playerState();
        assertEquals( PlayerStates.WALKING, greenPlayer.getStateOfPlayer());
    }



}
