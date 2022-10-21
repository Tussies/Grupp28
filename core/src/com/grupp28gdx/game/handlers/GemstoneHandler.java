package com.grupp28gdx.game.handlers;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.render.RenderView;

/**
 * This class is used to generate gemstones and make them spawn in the game.
 */
public class GemstoneHandler extends SpawnHandler{

    protected Array<Gemstone> itemArray = new Array<>();
    protected ModeFactory modeFactory;
    protected int id = 0;

    public GemstoneHandler(ModeFactory modeFactory){
        this.modeFactory = modeFactory;
    }

    /**
     * Method to getting gemstones.
     * @return itemArray an itemArray of all gemstones.
     */
    public Array<Gemstone> getGem(){

        return itemArray;
    }

    /**
     * Method used to generate the gems, adds them to Array itemArray.
     * @param posX
     * @param posY
     */
    @Override
    public void generate(float posX, float posY) {
        id += 1;
        itemArray.add(modeFactory.createGemstone(posX,posY,id));
    }

    /**
     * Method that updates the gemstone spawning.
     * Calls on generate method when itemArray is empty, and destroys gemstone object when it has passed the camera scope.
     * @param posX
     * @param posY
     */
    @Override
    public void update(float posX, float posY) {
        if (posX % 7 == 0 && posX>15) {
            if (itemArray.isEmpty()) {
                generate(posX+ 10 + rand.nextInt()%5, posY + 3 + (rand.nextInt()%2));
            } else if (!((itemArray.get(itemArray.size - 1).getPosition().getXPosition() >= posX+10) && (itemArray.get(itemArray.size - 1).getPosition().getXPosition() <= posX+15))) {
                generate(posX+10+ rand.nextInt()%5, posY + 3 + (rand.nextInt()%2));
            }

            if(itemArray.size != 1){
                while (itemArray.get(0).getPosition().getXPosition() - posX <= -7) {
                    itemArray.removeIndex(0);
                    if(itemArray.size == 1) {break;}
                }
            }
        }
    }

    @Override
    public void react(int id){

        for (int i=0; i < itemArray.size-1 ; i++){
            if (itemArray.get(i).getId() == id){
                itemArray.removeIndex(i);
            }
        }
    }
}
