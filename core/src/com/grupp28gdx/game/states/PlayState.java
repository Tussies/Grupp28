package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class PlayState extends State {

    Box2DDebugRenderer debugRenderer;
    private World world;
    private Body ground;
    private Body player;
    private Texture background;
    private Vector2 backgroundPosition1, backgroundPosition2;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        background = new Texture("nebulaset1.png");
        backgroundPosition1 = new Vector2(cam.position.x - cam.viewportWidth/2, -300);
        backgroundPosition2 = new Vector2((cam.position.x - cam.viewportWidth/2) + background.getWidth(), -300);
        world = new World(new Vector2(0, -9.8f), true);
        player = createPlayer();
        ground = createGround();

        debugRenderer = new Box2DDebugRenderer();

        cam.setToOrtho(false, w/2, h/2);
    }

    private void updateBackground() {
        if(cam.position.x - (cam.viewportWidth / 2) > backgroundPosition1.x + background.getWidth())
            backgroundPosition1.add(background.getWidth() * 2, 0);
        if(cam.position.x - (cam.viewportWidth / 2) > backgroundPosition2.x + background.getWidth())
            backgroundPosition2.add(background.getWidth() * 2, 0);
    }

    public Body createPlayer() {
        Body playerBody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0,0);
        def.fixedRotation = true;
        playerBody = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(30/pixelsPerMeter, 30/pixelsPerMeter);

        playerBody.createFixture(shape, 1.0f);
        shape.dispose();
        return playerBody;
    }

    public Body createGround() {
        BodyDef definition = new BodyDef();
        definition.type = BodyDef.BodyType.StaticBody;
        definition.position.set(0,0);
        definition.fixedRotation = true;
        ground = world.createBody(definition);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(10000/pixelsPerMeter, 30/pixelsPerMeter);

        ground.createFixture(shape, 1.0f);
        shape.dispose();

        return ground;
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float delta) {
        world.step(1/60f, 6,2);
        updateBackground();
        inputUpdate(delta);
        cameraUpdate(delta);
    }

    public void inputUpdate(float delta) {
        int horizontalForce = 0;
        player.applyForceToCenter(1000, 0, false);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            horizontalForce -= 1;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            horizontalForce += 1;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            player.applyForceToCenter(0,600, false);
        }

        player.setLinearVelocity(horizontalForce * 5, player.getLinearVelocity().y);
    }

    public void cameraUpdate(float delta) {
        Vector3 position = cam.position;
        position.x = player.getPosition().x * pixelsPerMeter;
        position.y = player.getPosition().y * pixelsPerMeter;

        cam.position.set(position);

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0f, 0f, 0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(Gdx.graphics.getDeltaTime());
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, backgroundPosition1.x, backgroundPosition1.y);
        sb.draw(background, backgroundPosition2.x, backgroundPosition2.y);
        sb.end();

        debugRenderer.render(world, cam.combined.scl(pixelsPerMeter));
    }

    @Override
    public void dispose() {
        world.dispose();
        debugRenderer.dispose();
    }
}
