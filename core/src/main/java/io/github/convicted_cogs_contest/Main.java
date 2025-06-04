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
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            this.setScreen(new GameScreen(this));
        }
    }
    
    public void Input(){
        
    }
    public void Logic() {
        
    }
    public void Draw(){
        
    }
        
}
