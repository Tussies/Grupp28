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
        assertTrue(purplePlayer.getBody().getSpeedY() == 49);
    }

    @Test
    public void playerMove(){
        purplePlayer.playerMove(1f);
        assertTrue(purplePlayer.getBody().getXPosition() == 4.0f && purplePlayer.getBody().getYPosition() == 0.0f);
    }

    @Test
    public void playerState(){
        purplePlayer.playerState();
        assertEquals( PlayerStates.RUNNING, purplePlayer.getStateOfPlayer());
    }
}
