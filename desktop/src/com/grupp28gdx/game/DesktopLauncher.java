package com.grupp28gdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.grupp28gdx.game.Grupp28GDX;

/**
 * This class is responsible for the game launching. Here you will find the main method of the program.
 */
// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		GameConfig config = new GameConfig();
		new Lwjgl3Application(new Grupp28GDX(), config.getInstance());
	}
}
