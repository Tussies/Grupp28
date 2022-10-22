package ObstacleGroupTest;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.DestroyableObstacle;
import com.grupp28gdx.game.Model.Obstacle;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DestroyableObstacleTest {

    DestroyableObstacle destroyObst = new DestroyableObstacle(2, 2, 1);

    @Test
    public void createObstacle() {
        Obstacle temp = destroyObst.createObstacle(1, 1, 1);
        assertTrue(temp instanceof Obstacle);
    }

    @Test
    public void getBody() {
        assertTrue(destroyObst.getBody() instanceof Body);
    }

    @Test
    public void getId() {
        assertTrue(destroyObst.getId() == 1);
    }

    @Test
    public void getWidth() {
        assertTrue(destroyObst.getWidth() == 1f);
    }

    @Test
    public void getHeight() {
        assertTrue(destroyObst.getHeight() == 1.9f);
    }


}
