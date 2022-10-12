package Player;

import com.grupp28gdx.game.Model.GreenPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GreenPlayerTest {
    GreenPlayer greenPlayer = new GreenPlayer();


    @Test
    public void createPlayerTest() {
        greenPlayer.createPlayer();
        assertEquals(greenPlayer.getStateOfPlayer(), "IDLE");
    }

    @Test  //speedY är 1???
    public void playerUpdateTest() {
        greenPlayer.body.accelerate(1,1);
        greenPlayer.playerUpdate(1f);
        assertTrue(greenPlayer.body.getXPosition() == 2f || greenPlayer.body.getYPosition() == 1f);

    }


    @Test
    public void collisionGroundBeginTest() {
        greenPlayer.collisionGroundBegin();
        assertEquals(greenPlayer.getStateOfPlayer(), "IDLE");

    }


    @Test
    public void inputKeyDownWButton(){
        greenPlayer.inputKeyDown(51);
        assertEquals(greenPlayer.getStateOfPlayer(), "JUMPING");
    }

    @Test
    public void inputKeyDownAButton(){
        greenPlayer.inputKeyDown(29); //????

    }

    @Test
    public void inputKeyDown(){

    }

    @Test
    public void setStateOfPlayerTest(){

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
