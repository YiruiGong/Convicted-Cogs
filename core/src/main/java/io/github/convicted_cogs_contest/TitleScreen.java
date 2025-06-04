/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Administrator
 */
public class TitleScreen implements Screen{
    BitmapFont font;
    BitmapFont toControlScreen;
    BitmapFont toFightScreen;
    Texture Cog;
    Texture background;
    
   
    Main game;
    
    public TitleScreen(Main game) {
        this.game = game;
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        game.spriteBatch.dispose();
        Cog.dispose();
        background.dispose();
        font.dispose();
        toFightScreen.dispose();
        toControlScreen.dispose();
    }

    @Override
    public void show() {
        Cog = new Texture("cog.png");
        background = new Texture("background.png");
        font = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        toControlScreen = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        toFightScreen = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        font.getData().scale(0);
        toControlScreen.getData().scale(0);
        toFightScreen.getData().scale(0);    }

    @Override
    public void render(float f) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.spriteBatch.begin();
        game.spriteBatch.draw(background, 0, 0);
        game.spriteBatch.draw(Cog, 100, 100);
        Gdx.gl.glClearColor(0.3f,0,0,1);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        font.draw(game.spriteBatch, "Convicted Cogs Contest",800,450);
        toFightScreen.draw(game.spriteBatch, "Press space bar to Continue", 800, 200);
        toControlScreen.draw(game.spriteBatch, "Click here to go to controls", 800, 100);
        
        game.spriteBatch.end();    
    }

    @Override
    public void resize(int i, int i1) {
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
