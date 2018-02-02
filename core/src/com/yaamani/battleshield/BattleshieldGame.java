package com.yaamani.battleshield;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.yaamani.battleshield.Utilities.Constants.*;


public class BattleshieldGame extends ApplicationAdapter {

    public static final String TAG = BattleshieldGame.class.getSimpleName();


    private Viewport viewport;

    private Stage stage;

	@Override
	public void create () {
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        stage.addActor(new MyActor());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        viewport.update(width, height, true);

        Gdx.graphics.setTitle("Resolution = " + width + "*" + height + " | Aspect Ratio = " + ratio(width, height)); //I think I'm gonna need that
        //Gdx.graphics.setWindowedMode(1000, 1000); //This is the code to change window size.
    }

    @Override
	public void render () {
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.act();
        stage.draw();
	}
	
	@Override
	public void dispose () {
        stage.dispose();
	}

    //The next 2 methods for calculating the aspect ratio. from (https://codereview.stackexchange.com/a/26698)
	private int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    private String ratio(int a, int b) {
        final int gcd = gcd(a,b);
        return a/gcd + ":" + b/gcd;
    }

    private class MyActor extends Actor {
	    private MyActor() {
	        setDebug(true);
        }

        @Override
        public void drawDebug(ShapeRenderer shapes) {
            shapes.set(ShapeRenderer.ShapeType.Line);
            shapes.setColor(Color.SKY);
            shapes.rect(0, 0, WORLD_SIZE, WORLD_SIZE);

            shapes.set(ShapeRenderer.ShapeType.Filled);
            shapes.setColor(Color.WHITE);
            shapes.circle(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, TURRET_SIZE);

            super.drawDebug(shapes);
        }
    }
}
