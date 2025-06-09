/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;
//Load imports

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class WinScreen implements Screen {

    //Private Attributes such as fonts and a texture
    BitmapFont Win;
    BitmapFont Player1Win;
    BitmapFont Player2Win;
    BitmapFont ReturnToMainMenu;
    BitmapFont Rematch;
    BitmapFont Credits;
    Texture background;
    String name = "";
    BitmapFont winner;
    FileWriter winnerWriter;

    Main game;

    public WinScreen(Main game, FileWriter w) {
        this.game = game;
        winnerWriter = w;
    }

    @Override
    public void show() {
        //Load Fonts and textures
        background = new Texture("background.png");
        Win = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        Player1Win = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        Player2Win = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        ReturnToMainMenu = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        Rematch = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        Credits = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        winner = new BitmapFont();
            try {
                
                name = JOptionPane.showInputDialog("Enter Winner Name");
                winnerWriter.write(name);
                winnerWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        //Scale the size of the fonts
        Win.getData().scale(0);
        Player1Win.getData().scale(0);
        Player2Win.getData().scale(0);
        ReturnToMainMenu.getData().scale(0);
        Rematch.getData().scale(0);
        Credits.getData().scale(0);
    }

    @Override
    public void render(float a) {
        //render the Textures and Fonts 
        String display = "";
        try {
            File f = new File("winners.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                display += s.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        
        game.spriteBatch.begin();

        game.spriteBatch.draw(background, 0, 0);
        Win.draw(game.spriteBatch, "You Win!", 800, 700);
        ReturnToMainMenu.draw(game.spriteBatch, "Main Menu", 100, 200);
        Rematch.draw(game.spriteBatch, "Rematch", 1500, 200);
        Credits.draw(game.spriteBatch, "Game made by:\nYirui Gong\nThomas Filsinger\nSahadad Ewaz", 800, 500);
        
        winner.draw(game.spriteBatch, display, 100, 400);
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
        Win.dispose();
        Player1Win.dispose();
        Player2Win.dispose();
        background.dispose();
        ReturnToMainMenu.dispose();
        Rematch.dispose();
    }
    
    

}
