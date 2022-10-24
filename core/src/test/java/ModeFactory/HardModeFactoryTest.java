package ModeFactory;

import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import com.grupp28gdx.game.Model.ObstacleGroup.DestroyableObstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class HardModeFactoryTest {
    ModeFactory hardFactory = new HardModeFactory();

    @Test
    public void createPlayerTest(){
        Player tempPlayer = hardFactory.createPlayer();
        assertEquals(tempPlayer.getClass(), PurplePlayer.class);
    }

    @Test
    public void createGemstoneTest(){
        Gemstone tempGemstone = hardFactory.createGemstone(1,1,1);
        assertEquals(tempGemstone.getClass(), SmallGemstone.class);
    }

    @Test
    public void createObstacleTest(){
        Obstacle tempObstacle = hardFactory.createObstacle(1,1,1);
        assertEquals(tempObstacle.getClass(), DestroyableObstacle.class);
    }
}
