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
    public void getVectorListX(){
        ArrayList<Float> testList = new ArrayList(){{
            add(1.0f);
            add(1.0f);
            add(1.15f);
            add(1.3f);
            add(1.45f);
            add(1.45f);
            add(1.3f);
            add(1.15f);
        }};
        assertEquals(testList, mediumGemstone.getVectorListX());
    }

    @Test
    public void getVectorListY(){
        ArrayList<Float> testList = new ArrayList(){{
            add(1.15f);
            add(1.3f);
            add(1.45f);
            add(1.45f);
            add(1.3f);
            add(1.15f);
            add(1.0f);
            add(1.0f);
        }};
        assertEquals(testList, mediumGemstone.getVectorListY());
    }

    @Test
    public void getBody(){
        assertTrue(mediumGemstone.getPosition() instanceof Body);
    }


}
