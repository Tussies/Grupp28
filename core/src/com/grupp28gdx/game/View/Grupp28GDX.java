package com.grupp28gdx.game.View;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.grupp28gdx.game.View.states.GameStateManager;
import com.grupp28gdx.game.View.states.MenuState;


public class Grupp28GDX extends ApplicationAdapter {
	private GameStateManager gsm;

	@Override
	public void create () {

		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));

	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();
	}

}
