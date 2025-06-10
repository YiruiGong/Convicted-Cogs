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
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Main extends Game {

    public SpriteBatch spriteBatch;
    public int screen;
    public GameScreen g;
    public WinScreen w;
    public boolean winScreenRun;
    public FileWriter myWriter;
    public boolean win;
    public ArrayList<User> users;
    public boolean restart;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        this.setScreen(new TitleScreen(this));
        screen = 1;
        winScreenRun = false;
        restart = true;
        try {
            FileWriter myWriter = new FileWriter("winners.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void render() {
        super.render();
        input();
        logic();
        draw();
    }

    public void input() {
        //System.out.println("X Val: " + Gdx.input.getX());
        //System.out.println("Y Val: " + Gdx.input.getY());
        if (screen == 1) {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && getScreen() instanceof TitleScreen) {
                g = new GameScreen(this);
                

                screen = 3;
            } else if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > 680 && Gdx.input.getX() < 1380 && Gdx.input.getY() < 750 && Gdx.input.getY() > 700 && getScreen() instanceof TitleScreen) {
                this.setScreen(new ControlScreen(this));
                screen = 2;
            }

        } else if (screen == 2) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > 800 && Gdx.input.getX() < 1500 && Gdx.input.getY() < 750 && Gdx.input.getY() > 700 && getScreen() instanceof ControlScreen) {
                this.setScreen(new TitleScreen(this));
                screen = 1;

            }
        } else if (screen == 3) {
            this.setScreen(g);
            boolean win = g.getWin();
            if (win == true) {
                screen = 4;
            }
        } else if (screen == 4) {
            if (winScreenRun == false) {
                w = new WinScreen(this, users);
                winScreenRun = true;
            }
            w.setRestart(restart);
            this.setScreen(w);
            
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                g = new GameScreen(this);
                screen = 3;
                win = false;
                restart = true;
            }
            
        }
    }

    public void logic() {

    }

    public void draw() {

    }

}

