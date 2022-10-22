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
        assertTrue(greenPlayer.getBody().speedY == 69);
    }

    @Test
    public void playerMove(){
         greenPlayer.getBody().move(1, 2);
         assertTrue(greenPlayer.getBody().getXPosition() == 1 || greenPlayer.getBody().getYPosition() == 2);
    }

    @Test
    public void playerState(){
        greenPlayer.playerState();
        assertEquals( PlayerStates.WALKING, greenPlayer.getStateOfPlayer());
    }



}
