package com.grupp28gdx.game.states;

import java.util.Stack;

/**
 * Manages the states in the game. Is used when switching between states in the game.
 * The states are in a stack that we change the order of when we want another state to be used.
 */
public class GameStateManager {
    private Stack<State> states;
    public GameStateManager(){
        states = new Stack<State>();
    }

    /**
     * Pushes state to the front of the stack, to be used.
     * @param state
     */
    public void push(State state){
        states.push(state);
    }

    /**
     * Pops the state on the top of the stack to make it not in use anymore.
     */
    public void pop(){
        states.pop();
    }

    /**
     * Sets the state by popping the old state and pushing the new state that will be used.
     * @param state
     */
    public void set(State state){
        states.pop();
        states.push(state);
    }

    /**
     * Updates the states stack.
     * @param dt
     */
    public void update(float dt){
        states.peek().update(dt);
    }

    /**
     * Renders the states stack.
     */
    public void render() {
        states.peek().render();
    }

}
