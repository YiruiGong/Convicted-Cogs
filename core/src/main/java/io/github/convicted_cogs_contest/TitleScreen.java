/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 *
 * @author Administrator
 */
public class TitleScreen implements Screen{
    private BitmapFont font;
    private Texture Cog;
    private Texture background;
    
   
    Main game;
    //Main class is able to use Title Screen
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
    }

    @Override
    public void show() {
        //load all textures and fonts
        Cog = new Texture("cog.png");
        background = new Texture("background.png");
        font = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        //Scale all of the text to the right size
        font.getData().scale(0);   }

    @Override
    public void render(float f) {
        //Render all of the textures and fonts for the user to see
        game.spriteBatch.begin();
        game.spriteBatch.draw(background, 0, 0);
        game.spriteBatch.draw(Cog, 100, 100);
        font.draw(game.spriteBatch, "Convicted Cogs Contest",680,550);
        font.draw(game.spriteBatch, "Press Space Bar to Continue", 680, 300);
        font.draw(game.spriteBatch, "Left Click for Controls", 680, 200);
        
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
