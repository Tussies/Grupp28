package com.grupp28gdx.game;

//<<external>>
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		GameConfig config = new GameConfig();
		new Lwjgl3Application(new Grupp28GDX(), config.getInstance());

	}
}
