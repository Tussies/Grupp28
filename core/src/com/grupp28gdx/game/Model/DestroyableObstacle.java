package com.grupp28gdx.game.Model;

public class DestroyableObstacle implements ObstacleFactory{
    private String typeOfObstacle;
    private int obstacleDifficulty;
    private Position position;

    public DestroyableObstacle() {
        obstacleDifficulty = 1;
        position = new Position(0,0);
        position.setXPosition(0);
        position.setYPosition(0);
    }
}