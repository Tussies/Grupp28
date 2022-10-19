package Gemstone;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class MediumGemstoneTest {
    MediumGemstone mediumGemstone = new MediumGemstone(1,1,1);
    GreenPlayer playerTemp = new GreenPlayer();

    @Test
    public void createMediumGemstoneTest() {
        Gemstone gemstoneTemp = mediumGemstone.createGemstone(1, 1,1);
        assertTrue(gemstoneTemp.getClass() == MediumGemstone.class);

    }

    @Test
    public void updateGemstoneCounterTest() {

    }

    @Test
    public void getSideLengthTest() {
        assertTrue(mediumGemstone.getSideLength() == 5);
    }


}
