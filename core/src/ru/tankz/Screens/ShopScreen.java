package ru.tankz.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by ihzork on 29.12.16.
 */

public class ShopScreen implements Screen, InputProcessor {

    final Game game;


    private ModelBatch              modelBatch;
    private PerspectiveCamera       camera;
    private CameraInputController   controller;
    private FrameBuffer             fbo;
    private SpriteBatch             fboBatch;
    TextureRegion                   buffer;
    Stage                           stage;


    OrthographicCamera guiCam;
    Sprite sprite,sprite1;
    SpriteBatch batcher;
    Ray collisionRay;
    BoundingBox collisionImage,collisionImage1;


    public ShopScreen(Game game) {

        this.game = game;

        sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));

        sprite.setPosition(100,100);


        sprite1 = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));

        sprite1.setPosition(400,100);


        collisionImage = new BoundingBox();
        collisionImage.set(new Vector3(sprite.getX(),sprite.getY(),-10),
                           new Vector3(sprite.getX() + sprite.getWidth(),
                           sprite.getY() + sprite.getHeight(), 10));
        collisionImage1 = new BoundingBox();
        collisionImage1.set(new Vector3(sprite1.getX(),sprite1.getY(),-10),
                            new Vector3(sprite1.getX() + sprite1.getWidth(),
                            sprite1.getY() + sprite1.getHeight(), 10));




/*
        guiCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        guiCam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);

*/
        stage = new Stage();
        modelBatch = new ModelBatch();
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(300,150,300);
        camera.lookAt(0f, 0f, 0f);
        camera.near=0.1f;
        camera.far=1300f;
        camera.update();
        controller = new CameraInputController(camera);
        controller.scrollFactor=-2f;



        Image image = new Image(sprite);
        image.setPosition(sprite.getX(),sprite.getY());
        stage.addActor(image);

        image = new Image(sprite1);
        image.setPosition(sprite1.getX(),sprite1.getY());
        stage.addActor(image);


        batcher = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
    }


    public void initializeFBO() {
        if(fbo != null) fbo.dispose();
        fbo = new FrameBuffer(Pixmap.Format.RGBA4444, Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
        // fbo.getColorBufferTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        buffer = new TextureRegion( fbo.getColorBufferTexture());
        buffer.flip(false,true);
        if(fboBatch != null) fboBatch.dispose();
        fboBatch = new SpriteBatch();
    }

    @Override
    public void show() {

        initializeFBO();
    }

    @Override
    public void render(float delta) {


        /*
        guiCam.update();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batcher.begin();
        batcher.draw(sprite,150,150);
        collisionImage.set(new Vector3(sprite.getX(),                sprite.getY(),                -10),
                new Vector3(sprite.getX() + sprite.getWidth(), sprite.getY() + sprite.getHeight(), 10));
        batcher.end();
        */

        fbo.begin();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        camera.update();




        modelBatch.begin(camera);

        modelBatch.end();


        fbo.end();


        fboBatch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        fboBatch.draw(buffer, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        fboBatch.end();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        batcher.dispose();

    }






    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        collisionRay= stage.getCamera().getPickRay(screenX, screenY);
        if (Intersector.intersectRayBoundsFast(collisionRay, collisionImage)) {
            game.setScreen(new ResearchScreen(game));

        }
        if (Intersector.intersectRayBoundsFast(collisionRay, collisionImage1)) {
            game.setScreen(new MenuScreen(game));

        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}