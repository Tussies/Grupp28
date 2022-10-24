import com.grupp28gdx.game.Model.Factories.DefaultModeFactory;
import com.grupp28gdx.game.Model.World;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class WorldTest {

    private World world = new World(2);

    @Test
    public void setUpGameTest() {
        world.setupGame(2);
        assertNotNull(world.getPlayer());
    }

    @Test
    public void update(){
        world.getPlayer().getBody().accelerate(1,0);
        world.update(1f);
        assertTrue(1 == world.getPlayer().getBody().getYPosition());
    }

    @Test
    public void setFactoriesTest(){
        assertNotNull(world.setFactories(1));

    }

    @Test
    public void getObstacleHandler(){
        assertNotNull(world.getObstacleHandler());
    }

    @Test
    public void getGemstoneHandler(){
        assertNotNull(world.getGemstoneHandler());
    }
}
