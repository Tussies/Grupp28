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
        int n = 1 - numberOfSpawnableItems + 1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum) {
            case 1:
                itemArray.add(new GemstoneAdapter(world,modeFactory,posX,posY,rc));
                System.out.println("Small gem added to array");
        }
    }

    @Override
    public void update(float posX, float posY) {
        if (posX % 5 == 0) {
            if (itemArray.isEmpty()) {
                generate(posX, posY);
            } else if (!(itemArray.get(itemArray.size - 1).getGemstoneData().getPosition().getXPosition() == posX+1)) {
                generate(posX+1, posY);
            }
            System.out.println(posX);
            while (itemArray.get(0).getGemstoneData().getPosition().getXPosition() - posX <= -5) {
                itemArray.get(0).destroyBody();
                itemArray.removeIndex(0);
            }
        }
    }
}
