package GemstoneTest;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MediumGemstoneTest {
    MediumGemstone mediumGemstone = new MediumGemstone(1,1,1);
    @Test
    public void createMediumGemstone(){
        Gemstone tempStone = mediumGemstone.createGemstone(1,1,1);
        assertTrue(tempStone instanceof MediumGemstone);
    }
    @Test
    public void getId(){
        assertTrue(mediumGemstone.getId() == 1);

    }

    @Test
    public void getValue(){
        assertTrue(mediumGemstone.getValue() == 5);
    }

    @Test
    public void getBody(){
        assertTrue(mediumGemstone.getBody() instanceof Body);
    }


}
