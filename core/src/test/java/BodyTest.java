import com.grupp28gdx.game.Model.Body;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class BodyTest {
    Body tempBody = new Body(1, 1);

    @Test
    public void getXPositionTest(){
        assertTrue(tempBody.getXPosition() == 1);
    }

    @Test
    public void getYPositionTest(){
        assertTrue(tempBody.getYPosition() == 1);
    }

    @Test
    public void setXPositionTest(){
        tempBody.setXPosition(15);
        assertTrue(tempBody.getXPosition() == 15);
    }

    @Test
    public void setYPositionTest(){
        tempBody.setYPosition(22);
        assertTrue(tempBody.getYPosition() == 22);
    }

    @Test
    public void getForceXTest(){
        assertTrue(tempBody.getForceX() == 0);
    }

    @Test
    public void getForceYTest(){
        assertTrue(tempBody.getForceY() == 0);
    }

    @Test
    public void getMovementSpeedTest(){
        assertTrue(tempBody.getMovementSpeed() == 0);
    }

    @Test
    public void setMovementSpeedTest(){
        tempBody.setMovementSpeed(4);
        assertTrue(tempBody.getMovementSpeed() == 4);
    }

/*    @Test
    public void getSpeedYTest(){
        assertTrue(tempBody.getSpeedY() == 0);
    }

    @Test
    public void accelerateTest(){
        tempBody.accelerate(5,3);
        assertTrue(tempBody.getMovementSpeed() == 5 || tempBody.getSpeedY() == 3); //Confusing name getMovementSpeed
    }*/

    @Test
    public void moveTest(){
        tempBody.move(1,2);
        Assertions.assertTrue(tempBody.getXPosition() == 2 || tempBody.getYPosition() == 3);

    }

    @Test
    public void getHeightTest(){
        Assertions.assertEquals(0, tempBody.getHeight());
    }

    @Test
    public void getWidthTest(){
        Assertions.assertEquals(0, tempBody.getWidth());
    }

    /*@Test
    public void getGravityTest(){
        Assertions.assertEquals(-1.0f,tempBody.gravity);
    }*/

    @Test
    public void setSpeedYTest(){
        tempBody.setForceX(1);
        Assertions.assertEquals(1,tempBody.getSpeedY());
    }

}
