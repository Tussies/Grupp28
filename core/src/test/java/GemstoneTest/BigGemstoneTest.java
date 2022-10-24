package GemstoneTest;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BigGemstoneTest {
    BigGemstone bigGemstone = new BigGemstone(1, 1, 1);

    @Test
    public void createBigGemstone() {
        Gemstone tempStone = bigGemstone.createGemstone(1, 1, 1);
        assertTrue(tempStone instanceof BigGemstone);
    }

    @Test
    public void getId() {
        assertTrue(bigGemstone.getId() == 1);

    }

    @Test
    public void getValue() {
        assertTrue(bigGemstone.getValue() == 1);
    }

    @Test
    public void getBody() {
        assertTrue(bigGemstone.getBody() instanceof Body);
    }


}
