package com.grupp28gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.grupp28gdx.game.states.GameStateManager;
import com.grupp28gdx.game.states.MenuState;
import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;


public class Grupp28GDX extends ApplicationAdapter {
	private GameStateManager gsm;
	private SpriteBatch batch;
	Box2DDebugRenderer debugRenderer;
	private OrthographicCamera camera;
	private World world;
	private Body ground;
	private Texture background;
	private Vector2 backgroundPosition1, backgroundPosition2;

	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w/2, h/2);

		world = new World(new Vector2(0, -9.8f), true);
		ground = createGround();
		background = new Texture("nebulaset1.png");
		backgroundPosition1 = new Vector2(camera.position.x - camera.viewportWidth / 2, 0);
		backgroundPosition2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + background.getWidth(), 0);

		debugRenderer = new Box2DDebugRenderer();

		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));


	}

	public Body createGround() {
		BodyDef definition = new BodyDef();
		definition.type = BodyDef.BodyType.StaticBody;
		definition.position.set(0,0);
		definition.fixedRotation = true;
		ground = world.createBody(definition);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(200/pixelsPerMeter, 30/pixelsPerMeter);

		ground.createFixture(shape, 1.0f);
		shape.dispose();

		return ground;
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width/2, height/2);
	}

	public void update(float delta) {
		world.step(1/60f, 6,2);

		cameraUpdate(delta);
	}

	public void cameraUpdate(float delta) {
		Vector3 position = camera.position;
		position.x = ground.getPosition().x * pixelsPerMeter;
		position.y = ground.getPosition().y * pixelsPerMeter;

		camera.position.set(position);

		camera.update();
	}


	@Override
	public void render () {

		//To get to main starting screen uncomment and comment the section below instead.
/*		update(Gdx.graphics.getDeltaTime());

		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(background, backgroundPosition1.x, backgroundPosition1.y);
		sb.draw(background, backgroundPosition2.x, backgroundPosition2.y);
		sb.end();

		Gdx.gl.glClearColor(0f, 0f, 0f,1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		debugRenderer.render(world, camera.combined.scl(pixelsPerMeter));*/

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	@Override
	public void dispose() {
		world.dispose();
		debugRenderer.dispose();
}   }
