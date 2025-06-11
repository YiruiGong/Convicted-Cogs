/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 *
 * @author gongm
 */
public class ControlScreen implements Screen {
    //Private Attributes such as fonts and a texture
    private BitmapFont title;
    private BitmapFont ControlP1;
    private BitmapFont ControlP2;
    private BitmapFont exit;
    private Texture background;
    
    Main game;
    //Makes it so that the Control screen is able to run in the Main class
    public ControlScreen(Main game) {
        this.game = game;
    }
    
    @Override
    public void show() {
        //Loads all of the fonts by reading from a fnt
        title = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        ControlP1 = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        ControlP2 = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        exit = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        background = new Texture("background.png");
        //Scale all of the text how ever the deveolper wants
        title.getData().scale(0);
        ControlP1.getData().scale(0);
        ControlP2.getData().scale(0); 
        exit.getData().scale(0);
    }

    @Override
    public void render(float f) {
        //Display background and text onto the screen
        game.spriteBatch.begin();
        game.spriteBatch.draw(background, 0, 0);
        title.draw(game.spriteBatch, "Controls", 800, 800);
        ControlP1.draw(game.spriteBatch, "Move: WASD \nPunch: F\nKick: G\nMove Backward \n to block",533, 700);
        ControlP2.draw(game.spriteBatch, "Move: Arrow keys \nPunch: N\nKick: M\nMove backward \n to block",1066, 700);
        exit.draw(game.spriteBatch, "Return to main screen",800, 200);
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
        title.dispose();
        ControlP1.dispose();
        ControlP2.dispose();
        background.dispose();
        exit.dispose();
    }
    
}
