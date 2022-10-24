package com.grupp28gdx.game.Controller.handlers;

import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.Factories.ModeFactory;



public class GemstoneHandler extends SpawnHandler{

    /**
     *
     * This class is used to generate gemstones and handles all the position and deletion of all gemstones.
     *
     *
     *  gemstoneArray = An array of gemstone objects
     *  modeFactory = global modeFactory for GemstoneHandler
     *  id = Id that will be given to a gemstone
     * */
    protected Array<Gemstone> gemstoneArray = new Array<>();
    protected ModeFactory modeFactory;
    protected int id = 0;


    /**
     * Constructs the GemstoneHandler
     * @param modeFactory, takes the given ModeFactory so all gemstones will spawn with the same difficulty
     */
    public GemstoneHandler(ModeFactory modeFactory){
        this.modeFactory = modeFactory;

    }

    /**
     * Method to getting gemstones.
     * @return gemstoneArray, an Array of all gemstones.
     */
    public Array<Gemstone> getGem(){

        return gemstoneArray;
    }


    /**
     * Method used to generate the gems, adds them to gemstoneArray.
     * @param posX, given place to spawn gemstone on X position
     * @param posY, given place to spawn gemstone on Y position
     */
    @Override
    public void generate(float posX, float posY) {
        id += 1;
        gemstoneArray.add(modeFactory.createGemstone(posX,posY,id));


    }

    /**
     * Method that updates the gemstone spawning.
     * Calls on generate method when gemstoneArray is empty, and destroys gemstone object when it has passed -7 behind posX.
     * @param posX, given place to determine where to add and remove gemstones based on x
     * @param posY, given place to determine where to add and remove gemstones based on y
     */
    @Override
    public void update(float posX, float posY) {
        if (posX % 7 == 0 && posX>15) {
            if (gemstoneArray.isEmpty()) {
                generate(posX+ 10 + rand.nextInt()%5, posY + 3 + (rand.nextInt()%2));
            } else if (!((gemstoneArray.get(gemstoneArray.size - 1).getPosition().getXPosition() >= posX+10) && (gemstoneArray.get(gemstoneArray.size - 1).getPosition().getXPosition() <= posX+15))) {
                generate(posX+10+ rand.nextInt()%5, posY + 3 + (rand.nextInt()%2));
            }

            if(gemstoneArray.size != 1){
                while (gemstoneArray.get(0).getPosition().getXPosition() - posX <= -7) {
                    gemstoneArray.removeIndex(0);
                    if(gemstoneArray.size == 1) {break;}
                }
            }
        }

    }

    /**
     * When a collision is detected this class will react with the specified object with matching id.
     * @param id, used to locate a specific gemstone
     */
    @Override
    public void react(int id){

        for (int i = 0; i < gemstoneArray.size ; i++){
            if (gemstoneArray.get(i).getId() == id){
                gemstoneArray.removeIndex(i);
            }
        }
    }
}
