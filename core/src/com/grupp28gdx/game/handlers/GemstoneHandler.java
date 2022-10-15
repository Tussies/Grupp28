package com.grupp28gdx.game.handlers;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;

public class GemstoneHandler extends SpawnHandler{

    protected Array<Gemstone> itemArray = new Array<>();

    public Array<Gemstone> getGem(){
        return itemArray;
    }

    @Override
    public void generate(float posX, float posY) {
        int n = 1 - numberOfSpawnableItems + 1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum) {
            case 1:
                System.out.println("Small gem added to array");
                itemArray.add(new SmallGemstone());
                break;
            case 2:
                System.out.println("Medium gem added to array");
                itemArray.add(new MediumGemstone());
                break;
            case 3:
                System.out.println("Big gem added to array");
                itemArray.add(new BigGemstone());
                break;
        }
    }

    @Override
    public void update(float posX, float posY) {

    }
}
