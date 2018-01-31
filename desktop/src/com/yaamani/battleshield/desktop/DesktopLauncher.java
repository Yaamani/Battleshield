package com.yaamani.battleshield.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.yaamani.battleshield.BattleshieldGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		//16:9
		config.width = 800;
		config.height = 450;

		new LwjglApplication(new BattleshieldGame(), config);
	}
}
