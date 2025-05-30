package io.github.convicted_cogs_contest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** First screen of the application. Displayed after the application is created. */
public class TitleScreen extends ApplicationAdapter {
    SpriteBatch batch;
    BitmapFont font;
    BitmapFont toFightScreen;
    Texture Cog;
    
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        Cog = new Texture("cog.png");
        font = new BitmapFont();
        toFightScreen = new BitmapFont();
        font.getData().scale(1f);
        toFightScreen.getData().scale(1f);
    }

    @Override
    public void render() {
        // Draw your screen here. "delta" is the time since last render in seconds.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(Cog, 100, 100);
        Gdx.gl.glClearColor(0.3f,0,0,1);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        font.draw(batch, "Convicted Cogs Contest",800, 450);
        toFightScreen.draw(batch, "Press space bar to Continue", 800, 200);
        batch.end();
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        batch.dispose();
        Cog.dispose();
        font.dispose();
    }
}