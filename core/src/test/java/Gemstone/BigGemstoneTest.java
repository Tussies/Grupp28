package Gemstone;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BigGemstoneTest {
    BigGemstone bigGemstone = new BigGemstone(1,1,1);

    @Test
    public void createBigGemstone(){
        Gemstone tempStone = bigGemstone.createGemstone(1,1,1);
        assertTrue(tempStone instanceof BigGemstone);
    }
    @Test
    public void getId(){
        assertTrue(bigGemstone.getId() == 1);

    }

    @Test
    public void getValue(){
        assertTrue(bigGemstone.getValue() == 1);
    }
    @Test
    public void getWidth(){
        assertTrue(bigGemstone.getWidth() == 0.75f);
    }

    @Test
    public void getHeight(){
        assertTrue(bigGemstone.getHeight() == 0.75f);
    }
    @Test
    public void getVectorListX(){
        ArrayList<Float> testList = new ArrayList(){{
            add(1.0f);
            add(1.0f);
            add(1.25f);
            add(1.5f);
            add(1.75f);
            add(1.75f);
            add(1.5f);
            add(1.25f);
        }};
        assertEquals(testList, bigGemstone.getVectorListX());
    }

    @Test
    public void getVectorListY(){
        ArrayList<Float> testList = new ArrayList(){{
            add(1.25f);
            add(1.5f);
            add(1.75f);
            add(1.75f);
            add(1.5f);
            add(1.25f);
            add(1.0f);
            add(1.0f);
        }};
        assertEquals(testList, bigGemstone.getVectorListY());
    }

    @Test
    public void getBody(){
        assertTrue(bigGemstone.getBody() instanceof Body);
    }


}
