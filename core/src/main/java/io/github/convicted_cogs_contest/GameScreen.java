package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import java.util.ArrayList;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class GameScreen implements Screen {

    FitViewport viewport;
    Character sol1;
    Character sol2;

    Main game;

    public GameScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        //setScreen(new Titlev2(this));
        viewport = new FitViewport(1600, 900);
        ArrayList<Animation> movement1 = new ArrayList<Animation>();
        movement1.add(new Animation("idle.png", 8, 144, 283, -14));
        movement1.add(new Animation("walkforward.png", 10, 214, 286, -80));
        movement1.add(new Animation("walkbackward.png", 8, 213, 286, -80));
        ArrayList<Animation> movement2 = new ArrayList<Animation>();
        movement2.add(new Animation("idle2.png", 8, 144, 283, -14));
        movement2.add(new Animation("walkbackward2.png", 8, 213, 286, -80));
        movement2.add(new Animation("walkbackward2.png", 8, 213, 286, -80));

        sol1 = new Character(game.spriteBatch, movement1);
        sol2 = new Character(game.spriteBatch, movement2);
        sol2.move(600, 0);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float f) {
        input();
        logic();
        draw();
    }

    public void input() {

        float delta = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            sol1.moveForward();
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            sol1.moveBackward();
        } else {
            sol1.notMove();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            sol2.moveForward();
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            sol2.moveBackward();
        } else {
            sol2.notMove();
        }
    }

    public void logic() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

//        float character1Width = sol1.getWidth();
//        float character1Height = sol1.getHeight();
        //character1Sprite.setX(MathUtils.clamp(character1Sprite.getX(), 0, worldWidth - character1Width));
        
    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();

        float worldHeight = viewport.getWorldHeight();
        float worldWidth = viewport.getWorldWidth();

        sol1.draw();
        sol2.draw();
        
        game.spriteBatch.end();
    }

    @Override
    public void dispose() {

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

}
