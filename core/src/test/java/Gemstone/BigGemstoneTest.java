package Gemstone;

import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class BigGemstoneTest {
    BigGemstone bigGemstone = new BigGemstone(1,1);

    @Test
    public void createBigGemstone(){
        Gemstone tempStone = bigGemstone.createGemstone(1,1);
        assertTrue(tempStone.getClass() == BigGemstone.class);
    }
    @Test
    public void updateGemCounter(){

    }
    @Test
    public void getSideLength(){
        assertTrue(bigGemstone.getSideLength() == 10);
    }



}
