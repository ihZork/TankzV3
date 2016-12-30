package ru.tankz.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;

/**
 * Created by ihzork on 29.12.16.
 */

public class ResearchScreen implements Screen, InputProcessor {

    final Game game;

    OrthographicCamera guiCam;
    Sprite sprite;
    SpriteBatch batcher;
    Ray collisionRay;
    BoundingBox collisionImage;

    public ResearchScreen(Game game) {

        this.game = game;
        sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));

        sprite.setPosition(150,150);
        collisionImage = new BoundingBox();
        collisionImage.set(new Vector3(sprite.getX(),sprite.getY(),-10),
                           new Vector3(sprite.getX() + sprite.getWidth(),
                                       sprite.getY() + sprite.getHeight(), 10));


        guiCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        guiCam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        batcher = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        guiCam.update();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batcher.begin();
        batcher.draw(sprite,sprite.getX(),sprite.getY());

        batcher.end();

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


        collisionRay= guiCam.getPickRay(screenX, screenY);
        if (Intersector.intersectRayBoundsFast(collisionRay, collisionImage)) {
            game.setScreen(new ShopScreen(game));
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