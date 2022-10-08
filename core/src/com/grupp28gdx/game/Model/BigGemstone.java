package com.grupp28gdx.game.Model;


/**
 * This is the big coin. When the player catches this coin it gains x/3 the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class BigGemstone implements Gemstone {
    private Position position;
    private float sideLength;
    private int points;

    public BigGemstone() {
        this.points = 10;
        this.sideLength = 10;
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
        Gemstone gemstone = new BigGemstone();
        return gemstone;
    }

    /**
     * Method that updates the attribute GemCounter in the player class
     * @param player
     */
    @Override
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
