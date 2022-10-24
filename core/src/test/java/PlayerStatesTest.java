import com.grupp28gdx.game.Model.PlayerGroup.PlayerStates;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PlayerStatesTest {

    @Test
    public void toStringTest(){
        assertEquals("dead", PlayerStates.DEAD.toString());
    }
}
