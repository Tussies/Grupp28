import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestPlayer {
    World testWorld = new World(new Vector2(0, -9.8f), true);
    Player playerObject = new Player(testWorld);

    @Test
    public void testGetForceX(){

        assertTrue(playerObject.getForceX() == 0);
    }

    @Test
    public void testGetForceY(){

        assertTrue(playerObject.getForceY() == 0);
    }

    @Test
    public void testInputActionDown(){
        int pressedKey = 19;
        playerObject.getX_direction();
    //assertArrayEquals(new Body(), testPlayer);

    }
}
