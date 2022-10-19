package com.grupp28gdx.game.handlers;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Controller.GemstoneAdapter;
import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.render.RenderController;

public class GemstoneHandler extends SpawnHandler{

    protected Array<GemstoneAdapter> itemArray = new Array<>();
    protected World world;
    protected RenderController rc;
    protected ModeFactory modeFactory;
    protected int id = 0;

    public GemstoneHandler(World world, RenderController rc, ModeFactory modeFactory){
        this.world = world;
        this.rc = rc;
        this.modeFactory = modeFactory;
    }

    public Array<GemstoneAdapter> getGem(){
        return itemArray;
    }

    @Override
    public void generate(float posX, float posY) {
        id += 1;
        itemArray.add(new GemstoneAdapter(world,modeFactory,posX,posY,rc,id));
    }

    @Override
    public void update(float posX, float posY) {
        if (posX % 7 == 0 && posX>15) {
            if (itemArray.isEmpty()) {
                generate(posX+ 10 + rand.nextInt()%5, posY+1);
            } else if (!((itemArray.get(itemArray.size - 1).getGemstoneData().getPosition().getXPosition() >= posX+5) && (itemArray.get(itemArray.size - 1).getGemstoneData().getPosition().getXPosition() <= posX+10))) {
                generate(posX+10+ rand.nextInt()%5, posY+1);
            }
            if(itemArray.size != 1){
                while (itemArray.get(0).getGemstoneData().getPosition().getXPosition() - posX <= -7) {
                    itemArray.get(0).destroyBody();
                    itemArray.removeIndex(0);
                    if(itemArray.size == 1) {break;}
                }
            }
        }
    }

    @Override
    public void react(int id){
        System.out.println(id);
    }
}
