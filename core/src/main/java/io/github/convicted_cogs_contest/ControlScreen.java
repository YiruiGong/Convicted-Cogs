/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author gongm
 */
public class ControlScreen implements Screen {
    BitmapFont title;
    BitmapFont ControlP1;
    BitmapFont ControlP2;
    BitmapFont exit;
    Texture background;
    
    Main game;
    
    public ControlScreen(Main game) {
        this.game = game;
    }
    
    @Override
    public void show() {
        title = new BitmapFont();
        ControlP1 = new BitmapFont();
        ControlP2 = new BitmapFont();
        exit = new BitmapFont();
        background = new Texture("background.png");
        
        title.getData().scale(1f);
        ControlP1.getData().scale(1f);
        ControlP2.getData().scale(1f); 
        exit.getData().scale(1f);
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.spriteBatch.begin();
        game.spriteBatch.draw(background, 0, 0);
        Gdx.gl.glClearColor(0.3f,0,0,1);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        title.draw(game.spriteBatch, "Controls", 800, 800);
        ControlP1.draw(game.spriteBatch, "Move WASD \nPunch F\nKick G",533, 700);
        ControlP2.draw(game.spriteBatch, "Move: Arrow keys \nPunch: N\nKick: M",1066, 700);
        exit.draw(game.spriteBatch, "Return to main screen",800, 200);
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
        game.spriteBatch.dispose();
        title.dispose();
        ControlP1.dispose();
        ControlP2.dispose();
        background.dispose();
        exit.dispose();
    }
    
}
