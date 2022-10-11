import com.grupp28gdx.game.Model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class PositionTest {

    Position position = new Position(0, 0);


    @Test
    public void getXPosition() {
        assertTrue(position.getXPosition() == 0);
    }

    @Test
    public void getYPosition() {
        assertTrue(position.getYPosition() == 0);
    }

    @Test
    public void getForceX() {
        assertTrue(position.getForceX() == 0);
    }

    @Test
    public void getForceY() {
        assertTrue(position.getForceY() == 0);

    }

    @Test
    public void getMovementSpeed() {
        assertTrue(position.getMovementSpeed() == 0);
    }


    @Test
    public void setXPosition() {
        position.setXPosition(5);
        assertTrue(position.getXPosition() == 5);
    }

    @Test
    public void setYPosition() {
        position.setYPosition(7);
        assertTrue(position.getYPosition() == 7);
    }

    @Test
    public void setForceX() {
        position.setForceX(5);
        assertTrue(position.getForceX() == 5);
    }

    @Test
    public void setForceY() {
        position.setForceY(8);
        assertTrue(position.getForceY() == 8);
    }

    @Test
    public void setMovementSpeed() {
        position.setMovementSpeed(700);
        assertTrue(position.getMovementSpeed() == 700);
    }
}
