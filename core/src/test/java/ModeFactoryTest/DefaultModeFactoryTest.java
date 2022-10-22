package ModeFactoryTest;

import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DefaultModeFactoryTest {
    ModeFactory defaultFactory = new DefaultModeFactory();

    @Test
    public void createPlayerTest(){
        Player tempPlayer = defaultFactory.createPlayer();
        assertEquals(tempPlayer.getClass(), GreenPlayer.class);
    }

    @Test
    public void createGemstoneTest(){
        Gemstone tempGemstone = defaultFactory.createGemstone(1,1,1);
        assertEquals(tempGemstone.getClass(), MediumGemstone.class);
    }

}