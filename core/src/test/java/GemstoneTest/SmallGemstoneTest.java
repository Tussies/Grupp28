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
    public void getVectorListX(){
        ArrayList<Float> testList = new ArrayList(){{
            add(1.0f);
            add(1.0f);
            add(1.06f);
            add(1.12f);
            add(1.18f);
            add(1.18f);
            add(1.12f);
            add(1.06f);
        }};
        assertEquals(testList, smallGemstone.getVectorListX());
    }

    @Test
    public void getVectorListY(){
        ArrayList<Float> testList = new ArrayList(){{
            add(1.06f);
            add(1.12f);
            add(1.18f);
            add(1.18f);
            add(1.12f);
            add(1.06f);
            add(1.0f);
            add(1.0f);
        }};
        assertEquals(testList, smallGemstone.getVectorListY());
    }

    @Test
    public void getBody(){
        assertTrue(smallGemstone.getBody() instanceof Body);
    }


}
