package Gemstone;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import com.grupp28gdx.game.Model.PurplePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class SmallGemstoneTest {
    SmallGemstone smallGemstone = new SmallGemstone();
    PurplePlayer playerTemp = new PurplePlayer();

    @Test
    public void createSmallGemstoneTest() {
        Gemstone tempStone = smallGemstone.createGemstone();
        assertTrue(tempStone.getClass() == SmallGemstone.class);

    }

    @Test
    public void updateGemstoneCounterTest() {
        smallGemstone.updateGemCounter(playerTemp);
        assertTrue(playerTemp.getGemCounter() == 60);
    }

    @Test
    public void getSideLengthTest() {
        assertTrue(smallGemstone.getSideLength() == 2);
    }
}
