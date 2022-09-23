package com.grupp28gdx.game.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class RenderController {
    private SpriteBatch sb;
    public RenderController(){
        sb = new SpriteBatch();
    }

    public void render(Texture texture, int x, int y){
        sb.begin();
        sb.draw(texture,x,y);
        sb.end();
    }

    public void render(Texture texture,int x,int y,int screenWith,int screenHeight){
        sb.begin();
        sb.draw(texture,x,y,screenWith,screenHeight);
        sb.end();
    }

    public void render(Texture texture,float x,float y,float screenWith,float screenHeight){
        sb.begin();
        sb.draw(texture,x,y,screenWith,screenHeight);
        sb.end();
    }

    public void debugRender(Box2DDebugRenderer b2ddr, World world, OrthographicCamera cam, float pixelsPerMeter){
        b2ddr.render(world, cam.combined.scl(pixelsPerMeter));

    }

    public void updateCamera(Camera cam, Vector3 position){
        cam.position.set(position);
        cam.update();
    }

    public void setProjectionMatrix(Matrix4 combined) {
        sb.setProjectionMatrix(combined);
    }

    public void updateScore(int score){
        sb.begin();
        sb.end();
    }

    public void render(Hud hud) {
        sb.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }
}
