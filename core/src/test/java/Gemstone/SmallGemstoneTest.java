package Gemstone;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class SmallGemstoneTest {
    SmallGemstone smallGemstone = new SmallGemstone();

    @Test
    public void createSmallGemstoneTest() {
        Gemstone tempStone = smallGemstone.createGemstone();
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
