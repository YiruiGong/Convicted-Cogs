/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    private GameScreen g;
    private WinScreen w;
    private boolean winScreenRun;
    private FileWriter myWriter;
    private boolean win;
    public ArrayList<User> users;
    private boolean restart;

    @Override
    public void create() {
        //initialize variables and load the title screen
        spriteBatch = new SpriteBatch();
        this.setScreen(new TitleScreen(this));
        screen = 1;
        winScreenRun = false;
        restart = true;
 
    }

    @Override
    public void render() {
        //render the input,logic and draw methods
        super.render();
        input();
        logic();
        draw();
    }

    public void input() {
//        System.out.println("X Val: " + Gdx.input.getX());
//        System.out.println("Y Val: " + Gdx.input.getY());
        if (screen == 1) {
            //When the user is on the title screen and presses space bar the user will go to the fight screen
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && getScreen() instanceof TitleScreen) {
                g = new GameScreen(this);
                this.setScreen(g);
                screen = 3;
                
                //if the user is on the title screen and left clicks on a certain spot they will go to the control screen
            } else if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > 680 && Gdx.input.getX() < 1380 && Gdx.input.getY() < 610 && Gdx.input.getY() > 530 && getScreen() instanceof TitleScreen) {
                this.setScreen(new ControlScreen(this));
                screen = 2;
            }

            //If the user is on the Control menu and want to return to the title screen
        } else if (screen == 2) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > 670 && Gdx.input.getX() < 1500 && Gdx.input.getY() < 610 && Gdx.input.getY() > 550 && getScreen() instanceof ControlScreen) {
                this.setScreen(new TitleScreen(this));
                screen = 1;

            }
        }
        //if the user is on the fight screen and on of the characters reaches 0 hit point display the win screen
        else if (screen == 3) {
            
            boolean win = g.getWin();
            if (win == true) {
                screen = 4;
                w = new WinScreen(this, users);
                this.setScreen(w);
            }
            //If the user is on the Win screen and want to return to the title screen they user will click on a certain spot
        } else if (screen == 4) { 
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)&& Gdx.input.getX() > 100 && Gdx.input.getX() < 400 && Gdx.input.getY() < 630 && Gdx.input.getY() > 580 && getScreen() instanceof WinScreen) {
                this.setScreen(new TitleScreen(this));
                screen = 1;
            }
            //if the user is on the win screen and want to rematch then the user will have to press a button to rematch
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)&& Gdx.input.getX() > 1000 && Gdx.input.getX() < 1500 && Gdx.input.getY() < 630 && Gdx.input.getY() > 580 && getScreen() instanceof WinScreen) {
                g = new GameScreen(this);
                screen = 3;
                win = false;
                this.setScreen(g);
            }
            
        }
    }

    public void logic() {

    }

    public void draw() {

    }

}

