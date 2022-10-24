package ObstacleGroupTest;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.DestroyableObstacle;
import com.grupp28gdx.game.Model.Obstacle;
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

    @Test
    public void getWidth() {
        assertEquals(1f, destroyObst.getWidth(), 0.0);
    }

    @Test
    public void getHeight() {
        assertEquals(1.9f, destroyObst.getHeight(), 0.0);
    }


}
