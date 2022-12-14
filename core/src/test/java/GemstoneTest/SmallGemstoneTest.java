package GemstoneTest;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmallGemstoneTest {
    SmallGemstone smallGemstone = new SmallGemstone(1,1,1);
    @Test
    public void createSmallGemstone(){
        Gemstone tempStone = smallGemstone.createGemstone(1,1,1);
        assertTrue(tempStone instanceof SmallGemstone);
    }
    @Test
    public void getId(){
        assertTrue(smallGemstone.getId() == 1);

    }

    @Test
    public void getValue(){
        assertTrue(smallGemstone.getValue() == 10);
    }

    @Test
    public void getBody(){
        assertTrue(smallGemstone.getBody() instanceof Body);
    }


}
