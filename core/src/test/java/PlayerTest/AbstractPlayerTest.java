package PlayerTest;

import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.PlayerStates;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class AbstractPlayerTest {
    GreenPlayer greenPlayer = new GreenPlayer();

    @Test
    public void createPlayer(){
        greenPlayer.createPlayer();
        assertEquals(greenPlayer.getStateOfPlayer(), PlayerStates.IDLE);
    }

    @Test
    public void playerUpdate(){
        greenPlayer.getBody().accelerate(1,1);
        greenPlayer.playerUpdate(1);
        assertTrue(greenPlayer.getBody().getXPosition() == 3.7 || greenPlayer.getBody().getYPosition() == 0);
    }

    @Test
    public void playerState(){
        greenPlayer.playerState();
        assertEquals(PlayerStates.WALKING, greenPlayer.getStateOfPlayer());
    }

    @Test
    public void playerMove(){
        greenPlayer.getBody().setMovementSpeed(1);
        greenPlayer.playerMove(1);
        assertTrue(greenPlayer.getBody().getXPosition() == 1 || greenPlayer.getBody().getYPosition() == 1);
    }



    @Test
    public void inputKeyDownW(){
        greenPlayer.inputKeyDown(51);
        assertTrue(greenPlayer.getBody().getSpeedY() == 69);
    }

    @Test
    public void inputKeyDownS(){
        greenPlayer.inputKeyDown(47);
        assertTrue(greenPlayer.getBody().getSpeedY() == -60);
    }

    @Test
    public void inputKeyDownSpace(){
        greenPlayer.inputKeyDown(62);
        assertFalse(greenPlayer.getGun().getBulletsFired().isEmpty());
    }


    @Test
    public void addCollectedGem(){
        greenPlayer.addCollectedGem(2);
        assertTrue(greenPlayer.getGemScore() == 2);
    }

    @Test
    public void getGemScore(){
        assertTrue(greenPlayer.getGemScore() == 0);
    }

    @Test
    public void react(){
        greenPlayer.react();
        assertEquals(PlayerStates.DEAD, greenPlayer.getStateOfPlayer());
    }

}
