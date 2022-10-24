package ModeFactoryTest;

import com.grupp28gdx.game.Model.Factories.HardModeFactory;
import com.grupp28gdx.game.Model.Factories.ModeFactory;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import com.grupp28gdx.game.Model.ObstacleGroup.DestroyableObstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.PermanentObstacle;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HardModeFactoryTest {
    ModeFactory hardFactory = new HardModeFactory();

    @Test
    public void createPlayerTest() {
        Player tempPlayer = hardFactory.createPlayer();
        assertNotNull(tempPlayer);
    }

    @Test
    public void createGemstoneTest() {
        Gemstone tempGemstone = hardFactory.createGemstone(1, 1, 1);
        assertNotNull(tempGemstone);
    }


    @Test
    public void createObstacleTest() {
        Obstacle tempObstacle = hardFactory.createObstacle(1, 1, 1);
        assertNotNull(tempObstacle);
    }
}
