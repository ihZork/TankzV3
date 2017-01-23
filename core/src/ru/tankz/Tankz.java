package ru.tankz;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.tankz.Screens.SplashScreen;

public class Tankz extends Game {
	//public SplashScreen game;

	public static final String LOG = Tankz.class.getSimpleName();
	// whether we are in development mode
	public static final boolean DEV_MODE = false;
	// a libgdx helper class that logs the current FPS each second
	private FPSLogger fpsLogger;
	@Override
	public void create () {
		//Settings.load();
		//Assets.load();
		setScreen(new SplashScreen(this));
		//setScreen(new GameScreen(this,2));
		//setScreen( new SplashScreen( this ) );
		//fpsLogger = new FPSLogger();
	}
	@Override
	public void resize(int width, int height) {
		super.resize( width, height );
		Gdx.app.log( Tankz.LOG, "Resizing game to: " + width + " x " + height );


      /*  // show the splash screen when the game is resized for the first time;
        // this approach avoids calling the screen's resize method repeatedly
        if( getScreen() == null ) {
            if( DEV_MODE ) {
               // setScreen( new LevelScreen( this, 0 ) );
            } else {
             setScreen( new SplashScreen( this ) );
             // setScreen( new GameScreen(  ) );
            }
        }*/
	}
	@Override
	public void render() {
		super.render();
		//fpsLogger.log();
	}


	@Override
	public void dispose () {
		super.dispose();

		getScreen().dispose();
	}


	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}




}
