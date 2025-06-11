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
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;

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
    private JFileChooser fileChooser;
    private File file;

    //Contructor to make the screen run
    public WinScreen(Main game, ArrayList<User> users) {
        this.game = game;
        //winnerWriter = w;
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
        fileChooser = new JFileChooser();
        //file = new File("src/main/java/io/github/convicted_cogs_contest/winners.txt");
        file = new File(System.getProperty("user.home") + "/winners.txt");
        //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    }

    //Contructor to write the user into the file 
    public void write() {
        read();
        name = JOptionPane.showInputDialog("Enter Winner's Name:");
        int a = search();
        if (a == -1) {
            users.add(new User(name, 1));
            System.out.println("b");
        } else {
            users.get(a).addWins(1);
        }
        users = quickSort(users, 0, users.size() - 1);
        try {
            new FileWriter(System.getProperty("user.home") + "/winners.txt", false).close();
            winnerWriter = new FileWriter(file);
            for (int i = 0; i < users.size(); i++) {
                winnerWriter.write(users.get(i).getName() + "\n" + users.get(i).wins + "\n");

            }
            winnerWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //Method ot read from the winners.txt file 
    public void read() {
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                users.add(new User(s.nextLine(), Integer.parseInt(s.nextLine())));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (NoSuchElementException a) {
            return;
        }
    }

    //Method to search for a user in the winners.txt
    public int search() {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<User> quickSort(ArrayList<User> items, int start, int end) {
        // Base case for recursion:
        // The recursion will stop when the partition contains a single item
        if (start >= end) {
            System.out.println("s");
            return items;
            
        } // Otherwise recursively call the function
        else {
            int pivotValue = items.get(start).getWins(); // Set to first item in the partition
            int lowMark = start + 1; // Set to second position in the partition
            int highMark = end; // Set to last position in the partition
            User temp;
            boolean finished = false;

            // Repeat until low and high values have been swapped as needed
            while (finished == false) {
                // Move the left pivot
                while (lowMark <= highMark && items.get(lowMark).getWins() >= pivotValue) {
                    lowMark = lowMark + 1; // Increment lowMark
                }

                // Move the right pivot
                while (items.get(highMark).getWins() <= pivotValue && highMark >= lowMark) {
                    highMark = highMark - 1; // Decrement highMark
                }

                // Check that the low mark doesn't overlap with the high mark
                if (lowMark < highMark) {
                    // Swap the values at lowMark and highMark
                    temp = items.get(lowMark);
                    items.set(lowMark, items.get(highMark));
                    items.set(highMark, temp);
                } // Otherwise end the loop
                else {
                    finished = true;
                }
            }

            // Swap the pivot value and the value at highMark
            temp = items.get(start);
            items.set(start, items.get(highMark));
            items.set(highMark, temp);

            // Recursive call on the left partition
            quickSort(items, start, highMark - 1);

            // Recursive call on the right partition
            quickSort(items, highMark + 1, end);

            return items;
        }
    }

    @Override
    public void render(float a) {
        //render the Textures and Fonts 
        display = "";
        for (int i = 0; i < users.size(); i ++) {
            display += users.get(i).toString() + "\n";
        }
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
