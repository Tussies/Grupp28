package com.grupp28gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Grupp28GDX extends ApplicationAdapter {
	ShapeRenderer ground;

	@Override
	public void create () {
		ground = new ShapeRenderer();
	}

	@Override
	public void render () {
		ground.begin(ShapeRenderer.ShapeType.Filled);
		ground.setColor(0, 1, 0, 1);
		ground.rect(Gdx.graphics.getWidth()/2, 0, Gdx.graphics.getWidth(), 50);
		ground.end();
	}
}
