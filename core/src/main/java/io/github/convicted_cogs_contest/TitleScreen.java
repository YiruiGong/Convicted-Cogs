package io.github.convicted_cogs_contest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** First screen of the application. Displayed after the application is created. */
public class TitleScreen extends ApplicationAdapter {
    SpriteBatch batch;
    Texture Cog;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        Cog = new Texture("cog.png");
    }

    @Override
    public void render() {
        // Draw your screen here. "delta" is the time since last render in seconds.
        Gdx.gl.glClearColor(-1.f, 1.f, 1.f, -1.f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(Cog, 100, 100);
        batch.end();
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        batch.dispose();
        Cog.dispose();
    }
}