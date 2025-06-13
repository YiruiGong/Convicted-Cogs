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
    //Create Private Attributes
    private BitmapFont font;
    private Texture Cog;
    private Texture background;
    
   
    Main game;
    /**
     * Main class is able to use Title Screen
     * @param game 
     */
    public TitleScreen(Main game) {
        this.game = game;
    }
    /**
     * Gets rid of all fonts,images, and textures when provoked
     */
    @Override
    public void dispose() {
        // Destroy screen's assets here.
        game.spriteBatch.dispose();
        Cog.dispose();
        background.dispose();
        font.dispose();
    }
    /**
     * Loads all textures and fonts
     * Scale all of the text to the right size
     */
    @Override
    public void show() {
        Cog = new Texture("cog.png");
        background = new Texture("background.png");
        font = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        font.getData().scale(0);   }
    /**
     * Render all of the textures and fonts for the user to see
     * begin with SpriteBatch.begin and end with spriteBatch.end
     * @param f 
     */
    @Override
    public void render(float f) {
        game.spriteBatch.begin();
        game.spriteBatch.draw(background, 0, 0);
        game.spriteBatch.draw(Cog, 100, 100);
        font.draw(game.spriteBatch, "Convicted Cogs Contest",680,550);
        font.draw(game.spriteBatch, "Press Space Bar to Continue", 680, 300);
        font.draw(game.spriteBatch, "Left Click for Controls", 680, 200);
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
     * Getter, gets the font
     * @return returns the font
     */
    public BitmapFont getFont() {
        return font;
    }
    /**
     * Setter, Sets the font/text
     * @param font text/font that will be outputted to the user 
     */
    public void setFont(BitmapFont font) {
        this.font = font;
    }
    /**
     * getter, gets the image of the cog
     * @return returns cog
     */
    public Texture getCog() {
        return Cog;
    }
    /**
     * Setter, sets the image of the cog
     * @param Cog image of a cog
     */
    public void setCog(Texture Cog) {
        this.Cog = Cog;
    }
    /**
     * Getter, gets the image of the background
     * @return  returns background
     */
    public Texture getBackground() {
        return background;
    }
    /**
     * Setter, Sets the background with this image
     * @param background image of the background
     */
    public void setBackground(Texture background) {
        this.background = background;
    }
    /**
     * getter, gets the main game
     * @return returns the game
     */
    public Main getGame() {
        return game;
    }
    /**
     * Setter, sets the game for the user
     * @param game 
     */
    public void setGame(Main game) {
        this.game = game;
    }
    
    
    
}
