package Gemstone;

import com.grupp28gdx.game.Model.BigGemstone;
import com.grupp28gdx.game.Model.Gemstone;
import com.grupp28gdx.game.Model.GreenPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class BigGemstoneTest {
    BigGemstone bigGemstone = new BigGemstone();
    GreenPlayer tempPlayer = new GreenPlayer();

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
