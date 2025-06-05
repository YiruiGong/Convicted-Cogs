/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Administrator
 */
public class Main extends Game {
    public SpriteBatch spriteBatch;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        this.setScreen(new TitleScreen(this));
            
    }

    @Override
    public void render() {
        super.render();
        input();
        logic();
        draw();
    }
    
    public void input(){
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            this.setScreen(new GameScreen(this));
        }
        
        System.out.println("X Val: " + Gdx.input.getX());
        System.out.println("Y Val: " + Gdx.input.getY());
        
        
        
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > 680 && Gdx.input.getX() < 1380 && Gdx.input.getY() < 750 && Gdx.input.getY() > 700 && getScreen() instanceof TitleScreen){
            this.setScreen(new ControlScreen(this));
            
        }
        
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > 800 && Gdx.input.getX() < 1500 && Gdx.input.getY() < 750 && Gdx.input.getY() > 700 && getScreen() instanceof ControlScreen){
            this.setScreen(new TitleScreen(this));
            
        }
    }
    public void logic() {
        
    }
    public void draw(){
        
    }
        
}
