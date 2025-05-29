package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    Texture mapImage;
    SpriteBatch spriteBatch;
    FitViewport viewport;
    @Override
    public void create() {
//        setScreen(new TitleScreen());
//        spriteBatch = new SpriteBatch();
//        viewport = new FitViewport(8, 5);
//        mapImage = new Texture("map.png");
    }
}