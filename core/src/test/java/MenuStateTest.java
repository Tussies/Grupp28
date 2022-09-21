import com.grupp28gdx.game.states.GameStateManager;
import com.grupp28gdx.game.states.MenuState;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;

public class MenuStateTest {
    GameStateManager testGsm = new GameStateManager();
    MenuState testMenu = new MenuState(testGsm);

    @Test
    public void disposeTest(){
        testMenu.dispose();

        assertNull(testMenu.getClass());
    }
}
