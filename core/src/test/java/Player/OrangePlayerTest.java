package Player;


import com.grupp28gdx.game.Model.PlayerGroup.OrangePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrangePlayerTest {
    OrangePlayer orangePlayer = new OrangePlayer();


    @Test
    public void createPlayerTest() {
        orangePlayer.createPlayer();
        assertEquals(orangePlayer.getClass(), OrangePlayer.class);
    }

    @Test
    public void playerUpdateTest() { //UPPDATERAR INTE RÄTT
        orangePlayer.body.accelerate(1,1);
        orangePlayer.playerUpdate(1f); // deltaTime 1/60
        assertTrue(orangePlayer.body.getXPosition() == 3f || orangePlayer.body.getYPosition() == 1f);

    }


    @Test //INTE KLAR
    public void collisionGroundBeginTest() {
        orangePlayer.collisionGroundBegin();
        assertEquals(orangePlayer.getStateOfPlayer(), "IDLE");

    }

    //collisionGround end INTE KLAR


    @Test
    public void inputKeyDownWButton(){
        orangePlayer.inputKeyDown(51); //INTE KLAR
        assertEquals(orangePlayer.getStateOfPlayer(), "JUMPING");
    }

    @Test
    public void inputKeyDownAButton(){
        orangePlayer.inputKeyDown(29); //????

    }

    @Test
    public void inputKeyDown(){ //INTE KLAR

    }

    @Test
    public void setStateOfPlayerTest(){ //StateOFPlayer not public? how find enum?
       // purplePlayer.setStateOfPlayer(StateOfPlayer.JUMPING);

    }

    @Test
    public void getLivesTest() {
        assertTrue(orangePlayer.getLives() == 5);
    }

    @Test
    public void setLivesTest() {
        orangePlayer.setLives(2);
        assertTrue(orangePlayer.getLives() == 2);
    }
}
