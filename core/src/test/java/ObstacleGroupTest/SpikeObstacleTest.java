package ObstacleGroupTest;

import com.grupp28gdx.game.Model.Obstacle;
import com.grupp28gdx.game.Model.SpikeObstacle;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SpikeObstacleTest {
    SpikeObstacle spikeObs = new SpikeObstacle(1, 1, 1);

    @Test
    public void createObstacle() {
        Obstacle temp = spikeObs.createObstacle(1, 1, 1);
        assertNotNull(temp);
    }

    @Test
    public void getBody() {
        assertNotNull(spikeObs.getBody());
    }

    @Test
    public void getId() {
        assertEquals(1, spikeObs.getId());
    }

    @Test
    public void getWidth() {
        assertEquals(1f, spikeObs.getWidth(), 0.0);
    }

    @Test
    public void getHeight() {
        assertEquals(1.9f, spikeObs.getHeight(), 0.0);
    }


}
