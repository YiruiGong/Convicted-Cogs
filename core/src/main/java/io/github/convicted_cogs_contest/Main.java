/*
Sahadad Ewaz & Yirui Gong
*/
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Main extends Game {
    //Set up public Attributes 
    public SpriteBatch spriteBatch;
    private int screen;
    private TitleScreen titleScreen = new TitleScreen(this);;
    private ControlScreen controlScreen = new ControlScreen(this);;
    private GameScreen gameScreen = new GameScreen(this);
    private WinScreen winScreen = new WinScreen(this);;
    private boolean win;
    public ArrayList<User> users;
    
    /**
     * initialize variables and load the title screen
     */
    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        this.setScreen(titleScreen);
        screen = 1;
    }
    /**
     * render the input,logic and draw methods
     */
    @Override
    public void render() {
        super.render();
        screenSwitch();
    }
    /**
     * allows the user to switch screen when clicking on a certain spot on a certain screen or by pressing a button
     */
    public void screenSwitch() {
        if (screen == 1) {
            //When the user is on the title screen and presses space bar the user will go to the fight screen
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && getScreen() instanceof TitleScreen) {
                this.setScreen(gameScreen);
                screen = 3;
                
                //if the user is on the title screen and left clicks they will go to the control screen
            } else if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && getScreen() instanceof TitleScreen) {
                this.setScreen(controlScreen);
                screen = 2;
            }

            //If the user is on the Control menu and want to return to the title screen
        } else if (screen == 2) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && getScreen() instanceof ControlScreen) {
                this.setScreen(titleScreen);
                screen = 1;

            }
        }
        //if the user is on the fight screen and on of the characters reaches 0 hit point display the win screen
        else if (screen == 3) {
            
            boolean win = gameScreen.getWin();
            if (win == true) {
                screen = 4;
                winScreen.setRestart(true);
                this.setScreen(winScreen);
            }
            //If the user is on the Win screen and want to return to the title screen they user will click
        } else if (screen == 4) { 
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && getScreen() instanceof WinScreen) {
                this.setScreen(titleScreen);
                screen = 1;
            }
            //if the user is on the win screen and want to rematch then the user will have to press a key R 
            if (Gdx.input.isKeyPressed(Input.Keys.R) && getScreen() instanceof WinScreen) {
                screen = 3;
                win = false;
                this.setScreen(gameScreen);
            }
            
        }
    }
    /**
     * Get the font/text and images
     * @return spriteBatch
     */
    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }
    /**
     * Set the font/text and images
     * @param spriteBatch 
     */
    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }
    /**
     * set the screen
     * @param screen 
     */
    public void setScreen(int screen) {
        this.screen = screen;
    }
    /**
     * get the title screen
     * @return titlescreen
     */
    public TitleScreen getTitleScreen() {
        return titleScreen;
    }
    /**
     * set the title screen
     * @param titleScreen 
     */
    public void setTitleScreen(TitleScreen titleScreen) {
        this.titleScreen = titleScreen;
    }
    /**
     * get the control screen
     * @return control screen
     */
    public ControlScreen getControlScreen() {
        return controlScreen;
    }
    /**
     * set the control screen
     * @param controlScreen 
     */
    public void setControlScreen(ControlScreen controlScreen) {
        this.controlScreen = controlScreen;
    }
    /**
     * get the game screen
     * @return gameScreen
     */
    public GameScreen getGameScreen() {
        return gameScreen;
    }
    /**
     * set the game screen
     * @param gameScreen 
     */
    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }
    /**
     * Get win screen
     * @return winScreen
     */
    public WinScreen getWinScreen() {
        return winScreen;
    }
    /**
     * Set win screen when activated
     * @param winScreen 
     */
    public void setWinScreen(WinScreen winScreen) {
        this.winScreen = winScreen;
    }
    /**
     * Gets a win when health is 0
     * @return win
     */
    public boolean isWin() {
        return win;
    }
    /**
     * Sets the win for one person
     * @param win 
     */
    public void setWin(boolean win) {
        this.win = win;
    }
    /**
     * Get users from array list
     * @return 
     */
    public ArrayList<User> getUsers() {
        return users;
    }
    /**
     * Set users from array list
     * @param users 
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
