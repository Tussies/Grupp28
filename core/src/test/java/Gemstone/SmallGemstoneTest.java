package Gemstone;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import com.grupp28gdx.game.Model.PurplePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class SmallGemstoneTest {
    SmallGemstone smallGemstone = new SmallGemstone(1,1);

    @Test
    public void createSmallGemstoneTest() {
        Gemstone tempStone = smallGemstone.createGemstone(1,1);
        assertTrue(tempStone.getClass() == SmallGemstone.class);

    }

    @Test
    public void updateGemstoneCounterTest() {
    }

    @Test
    public void getSideLengthTest() {
        assertTrue(smallGemstone.getSideLength() == 2);
    }
}
