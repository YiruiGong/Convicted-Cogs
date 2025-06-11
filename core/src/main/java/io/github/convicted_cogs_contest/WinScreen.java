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
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class WinScreen implements Screen {

    //Private Attributes such as fonts and a texture
    private BitmapFont Win;
    private BitmapFont Player1Win;
    private BitmapFont Player2Win;
    private BitmapFont ReturnToMainMenu;
    private BitmapFont Rematch;
    private BitmapFont Credits;
    private Texture background;
    private String name = "";
    private BitmapFont winner;
    private FileWriter winnerWriter;
    private boolean restart;
    private String display;
    private ArrayList<User> users;
    private Main game;
    
    //Contructor to make the screen run
    public WinScreen(Main game, ArrayList<User> users) {
        this.game = game;
        //winnerWriter = w;
    }

    @Override
    public void show() {
        System.out.println("a");
        //Load Fonts and textures
        background = new Texture("background.png");
        Win = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        Player1Win = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        Player2Win = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        ReturnToMainMenu = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        Rematch = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        Credits = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        winner = new BitmapFont();
        restart = true;
        //Scale the size of the fonts
        Win.getData().scale(0);
        Player1Win.getData().scale(0);
        Player2Win.getData().scale(0);
        ReturnToMainMenu.getData().scale(0);
        Rematch.getData().scale(0);
        Credits.getData().scale(0);
        //create display and users to store user names
        display = "";
        users = new ArrayList<User>();
    }
    
    //Contructor to write the user into the file 
    public void write() {
        name = JOptionPane.showInputDialog("Enter Winner's Name:");
        int a = search();
        if (a == -1) {
            try {
                winnerWriter = new FileWriter("src/io.github.convicted_cogs_contest/winners.txt");
                for (int i = 0; i < users.size(); i++) {
                    if (i != users.size() - 1) {
                        winnerWriter.write(users.get(i).getName() + "\n" + users.get(i).wins + "\n");
                    }
                    winnerWriter.write(users.get(i).getName() + "\n" + users.get(i).wins);

                }
                winnerWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
    
    //Method ot read from the winners.txt file 
    public void read() {
        try {
            InputStream f = WinScreen.class.getResourceAsStream("winners.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                users.add(new User(s.nextLine(), Integer.parseInt(s.nextLine())));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    //Method to search for a user in the winners.txt
    public int search() {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName() == name) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void render(float a) {
        //render the Textures and Fonts 

        game.spriteBatch.begin();

        game.spriteBatch.draw(background, 0, 0);
        Win.draw(game.spriteBatch, "You Win!", 800, 700);
        ReturnToMainMenu.draw(game.spriteBatch, "Main Menu", 100, 200);
        Rematch.draw(game.spriteBatch, "Rematch", 1200, 200);
        Credits.draw(game.spriteBatch, "Game made by:\nYirui Gong\nThomas Filsinger\nSahadad Ewaz", 800, 500);

        winner.draw(game.spriteBatch, display, 100, 400);
        game.spriteBatch.end();
        //When  winner screen shows up user will be prompted with a JOptionPane where the write method will run
        if (restart == true) {
            write();
            restart = false;
        }
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
