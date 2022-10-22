package PlayerTest;


import com.grupp28gdx.game.Model.PlayerGroup.OrangePlayer;
import com.grupp28gdx.game.Model.PlayerGroup.PlayerStates;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrangePlayerTest {
    OrangePlayer orangePlayer = new OrangePlayer();


    @Test
    public void jump(){
        orangePlayer.jump();
        assertTrue(orangePlayer.getBody().speedY == 69);
    }

    @Test
    public void playerMove(){
        orangePlayer.getBody().move(1, 2);
        assertTrue(orangePlayer.getBody().getXPosition() == 1 || orangePlayer.getBody().getYPosition() == 2);
    }

    @Test
    public void playerState(){
        orangePlayer.playerState();
        assertEquals( PlayerStates.WALKING, orangePlayer.getStateOfPlayer());
    }
}
