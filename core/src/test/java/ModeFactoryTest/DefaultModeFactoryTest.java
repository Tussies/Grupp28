package ModeFactoryTest;

import com.grupp28gdx.game.Model.Factories.DefaultModeFactory;
import com.grupp28gdx.game.Model.Factories.ModeFactory;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DefaultModeFactoryTest {
    ModeFactory defaultFactory = new DefaultModeFactory();

    @Test
    public void createPlayerTest() {
        Player tempPlayer = defaultFactory.createPlayer();
assertNotNull(tempPlayer);    }

    @Test
    public void createGemstoneTest() {
        Gemstone tempGemstone = defaultFactory.createGemstone(1, 1, 1);
        assertNotNull(tempGemstone);
    }

    @Test
    public void createObstacleTest() {
        Obstacle tempObstacle = defaultFactory.createObstacle(1, 1, 1);
        assertNotNull(tempObstacle);
    }

}
