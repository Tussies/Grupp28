package com.grupp28gdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.World;
import com.grupp28gdx.game.input.PlayInputHandler;
import com.grupp28gdx.game.render.Hud;
import com.grupp28gdx.game.render.RenderController;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

/**
 * This class is the play state, which is used for showing the play-state of the game in the view.
 * The play-state shows the actual game that the user plays.
 */
public class PlayState extends State {
    private PlayInputHandler playInput;

    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private OrthographicCamera cam;
    private Hud hud;
    private World gameWorld;


    private RenderController renderController;

    public PlayState(GameStateManager gsm, int difficulty) {
        super(gsm);
        gameWorld = new World(difficulty);
        cam = new OrthographicCamera();

        rv.renderMusic();

        cam.setToOrtho(false, w/2, h/2);

        hud = new Hud();
        this.playInput = new PlayInputHandler(gameWorld.getPlayer());
        setInputProcessor(playInput);
        renderController = new RenderController(rv);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float delta) {
        gameWorld.update(delta);

        hud.updateScore(Math.round(gameWorld.getPlayer().getBody().getXPosition()) + gameWorld.getPlayer().getGemScore() );
        hud.updateGemScore(gameWorld.getPlayer().getGemScore());

        if(Gdx.input.isKeyPressed(41)) {
            gsm.set(new MenuState(gsm));
            rv.musicStop();
        }

        cameraUpdate(gameWorld.getPlayer());

    }

    private void cameraUpdate(Player player) {
        Vector3 position = cam.position;
        position.x = player.getBody().getXPosition()*pixelsPerMeter*2;
        position.y = player.getBody().getYPosition()*pixelsPerMeter*2;
        rv.updateCamera(cam,position);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(Gdx.graphics.getDeltaTime());
        rv.setProjectionMatrix(cam.combined);
        renderController.update(gameWorld.getPlayer(),gameWorld.getObstacleHandler(),gameWorld.getGemstoneHandler());
        rv.render(hud);



    }
    @Override
    public void dispose() {
        renderController.dispose();
    }
}
