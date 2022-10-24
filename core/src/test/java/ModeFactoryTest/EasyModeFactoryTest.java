package ModeFactoryTest;

import com.grupp28gdx.game.Model.Factories.EasyModeFactory;
import com.grupp28gdx.game.Model.Factories.ModeFactory;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EasyModeFactoryTest {
    ModeFactory easyFactory = new EasyModeFactory();

    @Test
    public void createPlayerTest() {
        Player tempPlayer = easyFactory.createPlayer();
        assertNotNull(tempPlayer);
    }

    @Test
    public void createGemstoneTest() {
        Gemstone tempGemstone = easyFactory.createGemstone(1, 1, 1);
        assertNotNull(tempGemstone);
    }

    @Test
    public void createObstacleTest() {
        Obstacle tempObstacle = easyFactory.createObstacle(1, 1, 1);
        assertNotNull(tempObstacle);
    }
}
