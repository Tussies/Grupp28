package Player;

import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
//import com.grupp28gdx.game.Model.StateOfPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GreenPlayerTest {
    GreenPlayer greenPlayer = new GreenPlayer();


    @Test
    public void createPlayerTest() {
        greenPlayer.createPlayer();
        assertEquals(greenPlayer.getClass(), GreenPlayer.class);
    }

    @Test
    public void playerUpdateTest() {
        greenPlayer.body.accelerate(1,1);
        greenPlayer.playerUpdate(1f); // deltaTime 1/60
        assertTrue(greenPlayer.body.getXPosition() == 3f || greenPlayer.body.getYPosition() == 1f);

    }


    @Test //INTE KLAR
    public void collisionGroundBeginTest() {
        greenPlayer.collisionGroundBegin();
        assertEquals(greenPlayer.getStateOfPlayer(), "IDLE");

    }

    //collisionGround end INTE KLAR


    @Test
    public void inputKeyDownWButton(){
        greenPlayer.inputKeyDown(51); //INTE KLAR
        assertEquals(greenPlayer.getStateOfPlayer(), "JUMPING");
    }

    @Test
    public void inputKeyDownAButton(){
        greenPlayer.inputKeyDown(29); //????

    }

    @Test
    public void inputKeyDown(){ //INTE KLAR

    }

    @Test
    public void setStateOfPlayerTest(){ //StateOFPlayer not public? how find enum?
    //greenPlayer.setStateOfPlayer(StateOfPlayer.WALKING);
    }

    @Test
    public void getLivesTest() {
        assertTrue(greenPlayer.getLives() == 3);
    }

    @Test
    public void setLivesTest() {
        greenPlayer.setLives(2);
        assertTrue(greenPlayer.getLives() == 2);
    }
}
