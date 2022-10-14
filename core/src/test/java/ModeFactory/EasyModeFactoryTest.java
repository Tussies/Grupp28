package ModeFactory;

import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class EasyModeFactoryTest {
    ModeFactory easyFactory = new EasyModeFactory();

    @Test
    public void createPlayerTest(){
        Player tempPlayer = easyFactory.createPlayer();
        assertEquals(tempPlayer.getClass(), OrangePlayer.class);
    }

    @Test
    public void createGemstoneTest(){
        Gemstone tempGemstone = easyFactory.createGemstone();
        assertEquals(tempGemstone.getClass(), BigGemstone.class);
    }

    @Test
    public void createObstacleTest(){
        Obstacle tempObstacle = easyFactory.createObstacle(1,1);
        assertEquals(tempObstacle.getClass(), PermanentObstacle.class);
    }
}
