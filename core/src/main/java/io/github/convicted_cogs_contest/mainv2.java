package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class mainv2 extends Game {

    SpriteBatch spriteBatch;
    FitViewport viewport;
    Character sol1;

    @Override
    public void create() {
        //setScreen(new Titlev2(this));
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(1600, 900);
        sol1 = new Character(spriteBatch);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    public void input() {
        
        float delta = Gdx.graphics.getDeltaTime();

//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            sol1.getSprite().translateX(sol1.getSpeed() * delta);
//        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            sol1.getSprite().translateX(-sol1.getSpeed() * delta);
//        }
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
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        float worldHeight = viewport.getWorldHeight();
        float worldWidth = viewport.getWorldWidth();

        spriteBatch.draw(sol1.getTexture(), 0, 0);

        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }

}
