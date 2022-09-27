package com.grupp28gdx.game.Model;

/**
 * This is where all objects of the world will be placed and updated. Also the game loop.
 */
public class World implements Runnable {
    private Thread thread;
    private int fps;
    private double timePerTick;

    public boolean running = false;
    public double delta;
    public long timeNow;
    public long lastTime;
    public long timer;
    public int ticks;

    public static void main(String[] args) {
    }

    @Override
    public void run() {
        fps = 60;
        timePerTick = 1000000000 / fps;
        delta = 0;
        lastTime = System.nanoTime();
        timer = 0;
        ticks = 0;

        while(running) {
            timeNow = System.nanoTime();
            delta += (timeNow - lastTime) / timePerTick;
            timer += timeNow - lastTime;
            lastTime = timeNow;
            if(delta >= 1) {
                update();
                //render(); (vi har inte denna än men den skall ligga här)
                ticks++;
                delta--;
            }
            if(timer >= 1000000000) {
                ticks = 0;
                timer = 0;
            }
        }

        stop();

        System.out.println("Thread has ended");
    }

    public synchronized void start() {

        if(running == true) {
            return;
        }
        running = true;

        thread = new Thread(this);

        thread.start();
    }

    public synchronized void stop() {
        if(running == false) {
            return;
        }
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        //skall uppdatera alla variabler sen
    }
}
