package com.grupp28gdx.game.Model;

/**
 * This is the medium coin. When the player catches this coin it gains the default amount of points.
 * There are three types of coins in total in the game to catch.
 */
public class MediumGemstone implements Gemstone {
    private Position position;
    private float sideLength;
    private int points;

    public MediumGemstone() {
        points = 30;
        sideLength = 5;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    /**
     * A method which creates an instance of the class SmallGemstone
     * @return SmallGemstone
     */
    @Override
    public Gemstone createCoin() {
        Gemstone gemstone = new MediumGemstone();
        return gemstone;
    }


    /**
     * Method that updates the attribute GemCounter in the player class
     * @param player
     */
    public void updateGemCounter(Player player){
        player.setGemCounter(player.getGemCounter() + this.points);

    }


    /**
     * Returns the side length of the gemstone instance
     * @return sideLength
     */

    public float getSideLength() {
        return this.sideLength;
    }
}