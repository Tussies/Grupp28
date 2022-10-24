package ObstacleGroupTest;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.PermanentObstacle;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PermanentObstacleTest {

    PermanentObstacle permObst = new PermanentObstacle(2, 2, 1);

    @Test
    public void createObstacle() {
        Obstacle temp = permObst.createObstacle(1, 1, 1);
        assertTrue(temp instanceof Obstacle);
    }

    @Test
    public void getBody() {
        assertTrue(permObst.getBody() instanceof Body);
    }

    @Test
    public void getId() {
        assertTrue(permObst.getId() == 1);
    }


}
