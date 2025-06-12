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
    /**
     * Makes it so that the Control screen is able to run in the Main class
     * @param game game is from the Main.java and it was calls this class
     */
    public ControlScreen(Main game) {
        this.game = game;
    }
    /**
     * Loads all of the fonts by reading from a fnt
     * Loads all of the textures from a png
     * Scale all of the text how ever the deveolper wants
     */
    @Override
    public void show() {
        
        font = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        background = new Texture("background.png");
        font.getData().scale(0);
    }
    
    /**
     * Render the screen when provoked
     * @param f 
     */
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

    /**
     * Resize the screen when needed
     * @param i Width of the screen
     * @param i1 Length of the screen
     */
    @Override
    public void resize(int i, int i1) {
    }
    
    /**
     *  Will pause the screen
     */
    @Override
    public void pause() {
    }

    /**
     * Will resume the screen if paused
     */
    @Override
    public void resume() {
    }
    /**
     * Will hide screen elements.
     */
    @Override
    public void hide() {
        
    }
    /**
     * Dispose of the screen when switching screens
     */
    @Override
    public void dispose() {
        game.spriteBatch.dispose();
        font.dispose();
        background.dispose();
    }
    
}
