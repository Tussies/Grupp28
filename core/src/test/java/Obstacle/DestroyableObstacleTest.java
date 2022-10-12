package Obstacle;

import com.grupp28gdx.game.Model.DestroyableObstacle;
import com.grupp28gdx.game.Model.Obstacle;
import com.grupp28gdx.game.Model.ObstacleColor;
import com.grupp28gdx.game.Model.ObstacleShape;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DestroyableObstacleTest {
    Obstacle destroyable = new DestroyableObstacle();

    @Test
    public void createObstacleTest(){
        Obstacle tempObs = destroyable.createObstacle(2 , 4);
        assertEquals(tempObs.getClass(), DestroyableObstacle.class);
    }

    @Test
    public void getShapeTest(){

     assertEquals(destroyable.getShape(), ObstacleShape.SQUARE);
    }

    @Test
    public void getColorTest(){
        assertEquals(destroyable.getColor(), ObstacleColor.BLUE);
    }

}
