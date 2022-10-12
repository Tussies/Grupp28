package ModeFactory;

import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DefaultModeFactoryTest {
    ModeFactory defaultFactory = new DefaultModeFactory();

    @Test
    public void createPlayerTest(){
        Player tempPlayer = defaultFactory.createPlayer();
        assertEquals(tempPlayer.getClass(), GreenPlayer.class);
    }

    @Test
    public void createGemstoneTest(){
        Gemstone tempGemstone = defaultFactory.createGemstone();
        assertEquals(tempGemstone.getClass(), MediumGemstone.class);
    }

    @Test
    public void createObstacleTest(){
        Obstacle tempObstacle = defaultFactory.createObstacle(1,1);
        assertEquals(tempObstacle.getClass(), WallObstacle.class);
    }
}
