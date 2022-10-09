package Gemstone;

import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GreenPlayer;
import com.grupp28gdx.game.Model.OrangePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class BigGemstoneTest {
    BigGemstone bigGemstone = new BigGemstone();
    OrangePlayer tempPlayer = new OrangePlayer();

    @Test
    public void createBigGemstone(){
        Gemstone tempStone = bigGemstone.createGemstone();
        assertTrue(tempStone.getClass() == BigGemstone.class);
    }
    @Test
    public void updateGemCounter(){
        bigGemstone.updateGemCounter(tempPlayer);
        assertTrue(tempPlayer.getGemCounter() == 10);

    }
    @Test
    public void getSideLength(){
        assertTrue(bigGemstone.getSideLength() == 10);
    }



}
