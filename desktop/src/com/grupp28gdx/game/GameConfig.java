package com.grupp28gdx.game;

//<<external>>
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class GameConfig {

    private static Lwjgl3ApplicationConfiguration appConfig = null;

    GameConfig(){
        appConfig = new Lwjgl3ApplicationConfiguration();
        appConfig.setForegroundFPS(60);
        appConfig.setTitle("Grupp28_GDX1337");
        appConfig.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
    }

    public static Lwjgl3ApplicationConfiguration getInstance(){

        if(appConfig == null){
            appConfig = new Lwjgl3ApplicationConfiguration();
        }
        return appConfig;
    }

}
