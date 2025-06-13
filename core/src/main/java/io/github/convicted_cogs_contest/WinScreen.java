/*

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
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class WinScreen implements Screen {
    //Private Attributes such as fonts and a texture
    private BitmapFont font;
    private Texture background;
    private BitmapFont leaderboard;
    private boolean restart;
    private ArrayList<User> users;
    private Main game;
    private File file;

    /**
     * Constructor to make the screen run
     * @param game 
     */
    public WinScreen(Main game) {
        this.game = game;
    }
    
    /**
     * Load Fonts and textures
     * Scale the size of the fonts
     * create an Array List of user 
     */
    @Override
    public void show() {
        background = new Texture("background.png");
        font = new BitmapFont(Gdx.files.internal("ggstFont.fnt"));
        leaderboard = new BitmapFont();
        font.getData().scale(0);
        leaderboard.getData().scale(1);
        //create display and users to store user names
        users = new ArrayList<User>();
        //file = new File("src/main/java/io/github/convicted_cogs_contest/winners.txt");
        file = new File(System.getProperty("user.home") + "/winners.txt");
        //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        restart = true;
    }

    
    /**
     * method to load the leader board by reading from a file and write the same file 
     */
    public void loadLeaderboard() {
        readFile();
        String name = JOptionPane.showInputDialog("Enter Winner's Name:");
        int userIndex = searchArray(name);
        if (userIndex == -1) {
            users.add(new User(name, 1));
        } else {
            users.get(userIndex).addWinNum(1);
        }
        users = quickSortFile(users, 0, users.size() - 1);
        writeFile();
    }
    
    /**
     * Method to write a file
     */
    public void writeFile() {
        try {
            new FileWriter(System.getProperty("user.home") + "/winners.txt", false).close();
            FileWriter winnerWriter = new FileWriter(file);
            for (int i = 0; i < users.size(); i++) {
                winnerWriter.write(users.get(i).getName() + "\n" + users.get(i).getWinNum() + "\n");

            }
            winnerWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    /**
     * Method to read from the winners.txt file 
     */
    public void readFile() {
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

    /**
     * Method to search for a user in the winners.txt
     * @param name when the user enters their name it will search for their name 
     * @return either an int i or -1
     */
    public int searchArray(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<User> quickSortFile(ArrayList<User> items, int start, int end) {
        // Base case for recursion:
        // The recursion will stop when the partition contains a single item
        if (start >= end) {
            return items;
            
        } // Otherwise recursively call the function
        else {
            int pivotValue = items.get(start).getWinNum(); // Set to first item in the partition
            int lowMark = start + 1; // Set to second position in the partition
            int highMark = end; // Set to last position in the partition
            User temp;
            boolean finished = false;

            // Repeat until low and high values have been swapped as needed
            while (finished == false) {
                // Move the left pivot
                while (lowMark <= highMark && items.get(lowMark).getWinNum() >= pivotValue) {
                    lowMark = lowMark + 1; // Increment lowMark
                }

                // Move the right pivot
                while (items.get(highMark).getWinNum() <= pivotValue && highMark >= lowMark) {
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
            quickSortFile(items, start, highMark - 1);

            // Recursive call on the right partition
            quickSortFile(items, highMark + 1, end);

            return items;
        }
    }
    /**
     * render the Textures and Fonts 
     * @param a a variable that decides either if the screen is rendered or not
     */
    @Override
    public void render(float a) {
        String display = "";
        for (int i = 0; i < users.size(); i ++) {
            display += users.get(i).toString() + "\n";
        }
        game.spriteBatch.begin();

        game.spriteBatch.draw(background, 0, 0);
        font.draw(game.spriteBatch, "You Win!", 600, 800);
        font.draw(game.spriteBatch, "Leaderboard", 100, 700);
        font.draw(game.spriteBatch, "Click to Return To Main Menu", 50, 200);
        font.draw(game.spriteBatch, "Press R To Rematch", 900, 100);
        leaderboard.draw(game.spriteBatch, "Game Made By:\nYirui Gong\nThomas Filsinger\nSahadad Ewaz", 800, 500);

        leaderboard.draw(game.spriteBatch, display, 100, 600);
        game.spriteBatch.end();
        //When  winner screen shows up user will be prompted with a JOptionPane where the write method will run
        if (restart == true) {
            users = new ArrayList<User>();
            loadLeaderboard();
            restart = false;
        }
    }

    /**
     * Resize the screen when needed
     * @param i width of the screen
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
     * 
     * @param restart to check if restart is true or false
     */
    public void setRestart(boolean restart) {
        this.restart = restart;
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
