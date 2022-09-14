package com.grupp28gdx.game.render;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class RenderController {

    public void render(SpriteBatch sb, Texture texture, int x, int y){
        sb.begin();
        sb.draw(texture,x,y);
        sb.end();
    }

    public void render(SpriteBatch sb, Texture texture,int x,int y,int screenWith,int screenHeight){
        sb.begin();
        sb.draw(texture,x,y,screenWith,screenHeight);
        sb.end();
    }

    public void render(SpriteBatch sb, Texture texture,float x,float y,float screenWith,float screenHeight){
        sb.begin();
        sb.draw(texture,x,y,screenWith,screenHeight);
        sb.end();
    }

    public void debugRender(Box2DDebugRenderer b2ddr, World world, OrthographicCamera cam, float pixelsPerMeter){
        b2ddr.render(world, cam.combined.scl(pixelsPerMeter));

    }
}
