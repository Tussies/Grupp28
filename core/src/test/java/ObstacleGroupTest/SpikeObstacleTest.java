package ObstacleGroupTest;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Obstacle;
import com.grupp28gdx.game.Model.SpikeObstacle;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SpikeObstacleTest {

    SpikeObstacle spikeObs = new SpikeObstacle(1,1,1);

    @Test
    public void createObstacle() {
        Obstacle temp = spikeObs.createObstacle(1, 1, 1);
        assertTrue(temp instanceof Obstacle);
    }

    @Test
    public void getBody() {
        assertTrue(spikeObs.getBody() instanceof Body);
    }

    @Test
    public void getId() {
        assertTrue(spikeObs.getId() == 1);
    }

    @Test
    public void getWidth() {
        assertTrue(spikeObs.getWidth() == 1f);
    }

    @Test
    public void getHeight() {
        assertTrue(spikeObs.getHeight() == 1.9f);
    }


}
