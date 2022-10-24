package ObstacleGroupTest;

import com.grupp28gdx.game.Model.ObstacleGroup.DestroyableObstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestroyableObstacleTest {

    DestroyableObstacle destroyObst = new DestroyableObstacle(2, 2, 1);

    @Test
    public void createObstacle() {
        Obstacle temp = destroyObst.createObstacle(1, 1, 1);
        assertNotNull(temp);
    }

    @Test
    public void getBody() {
        assertNotNull(destroyObst.getBody());
    }

    @Test
    public void getId() {
        assertEquals(1, destroyObst.getId());
    }

}
