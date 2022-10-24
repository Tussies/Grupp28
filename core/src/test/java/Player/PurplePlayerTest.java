package Player;


import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;
//import com.grupp28gdx.game.Model.StateOfPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PurplePlayerTest {
    PurplePlayer purplePlayer = new PurplePlayer();


    @Test
    public void createPlayerTest() {
        purplePlayer.createPlayer();
        assertEquals(purplePlayer.getClass(), PurplePlayer.class);
    }

    @Test
    public void playerUpdateTest() { // UPPDATERAR INTE POSITION RÄTT
        purplePlayer.body.accelerate(1,1);
       // purplePlayer.playerUpdate(1f); // deltaTime 1/60
        assertTrue(purplePlayer.body.getXPosition() == 3f || purplePlayer.body.getYPosition() == 1f);

    }


    @Test //INTE KLAR
    public void collisionGroundBeginTest() {
        float y  = 1;
        purplePlayer.collisionGroundBegin();
        assertEquals(purplePlayer.getStateOfPlayer(), "IDLE");

    }

    //collisionGround end INTE KLAR


    @Test
    public void inputKeyDownWButton(){
        purplePlayer.inputKeyDown(51); //INTE KLAR
        assertEquals(purplePlayer.getStateOfPlayer(), "JUMPING");
    }

    @Test
    public void inputKeyDownAButton(){
        purplePlayer.inputKeyDown(29); //????

    }

    @Test
    public void inputKeyDown(){ //INTE KLAR

    }

    @Test
    public void setStateOfPlayerTest(){ //StateOFPlayer not public? how find enum?
       // purplePlayer.setStateOfPlayer(StateOfPlayer.JUMPING);

    }
}
