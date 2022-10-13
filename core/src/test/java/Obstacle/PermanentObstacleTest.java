package Obstacle;

import com.grupp28gdx.game.Model.PermanentObstacle;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PermanentObstacleTest {
    PermanentObstacle permObs = new PermanentObstacle(0 , 0);

    @Test
    public void createShapeTest(){
        //Nope
    }

    @Test
    public void getVectorListXTest(){

        float[] expectedList = new float[]{0, 0, 1, 1};
        assertEquals(permObs.getVectorListX(), expectedList);
    }
}
