/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class ControlScreen implements Screen {
    //Private Attributes such as fonts and a texture
    private BitmapFont font;
    private Texture background;
    
    Main game;
    //Makes it so that the Control screen is able to run in the Main class
    public ControlScreen(Main game) {
        this.game = game;
    }
    
    @Override
    public void show() {
        //Loads all of the fonts by reading from a fnt
        font = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        background = new Texture("background.png");
        //Scale all of the text how ever the deveolper wants
        font.getData().scale(0);
    }

    @Override
    public void render(float f) {
        //Display background and text onto the screen
        game.spriteBatch.begin();
        game.spriteBatch.draw(background, 0, 0);
        font.draw(game.spriteBatch, "Controls", 650, 800);
        font.draw(game.spriteBatch, "Move: WASD \nPunch: F\nKick: G\nMove Backward \n to block",333, 700);
        font.draw(game.spriteBatch, "Move: Arrow keys \nPunch: N\nKick: M\nMove backward \n to block",866, 700);
        font.draw(game.spriteBatch, "Return to main screen",800, 200);
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

    @Override
    public void dispose() {
        //Dispose of the screen when switching screens
        game.spriteBatch.dispose();
        font.dispose();
        background.dispose();
    }
    
}
