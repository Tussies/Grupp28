package PlayerTest;


import com.grupp28gdx.game.Model.PlayerGroup.PlayerStates;
import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;
//import com.grupp28gdx.game.Model.StateOfPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PurplePlayerTest {
    PurplePlayer purplePlayer = new PurplePlayer();


    @Test
    public void jump(){
        purplePlayer.jump();
        assertTrue(purplePlayer.getBody().speedY == 69);
    }

    @Test
    public void playerMove(){
        purplePlayer.getBody().move(1, 2);
        assertTrue(purplePlayer.getBody().getXPosition() == 1 || purplePlayer.getBody().getYPosition() == 2);
    }

    @Test
    public void playerState(){
        purplePlayer.playerState();
        assertEquals( PlayerStates.WALKING, purplePlayer.getStateOfPlayer());
    }
}
