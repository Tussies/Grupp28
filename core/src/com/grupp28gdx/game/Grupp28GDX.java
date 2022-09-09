package com.grupp28gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.States.GameStateManager;
import com.grupp28gdx.game.States.MenuState;

public class Grupp28GDX extends ApplicationAdapter {
	private GameStateManager gsm;
	private SpriteBatch batch;
	ShapeRenderer ground;

	@Override
	public void create () {
		ground = new ShapeRenderer();
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		//To get to main menu starting screen uncomment and comment the section below instead.
		ground.begin(ShapeRenderer.ShapeType.Filled);
		ground.setColor(0, 1, 0, 1);
		ground.rect(Gdx.graphics.getWidth()/2, 0, Gdx.graphics.getWidth(), 50);
		ground.end();

		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//gsm.update(Gdx.graphics.getDeltaTime());
		//gsm.render(batch);
	}
}
