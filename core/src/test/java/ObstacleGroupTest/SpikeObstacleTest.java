package ObstacleGroupTest;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.SpikeObstacle;
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



}
