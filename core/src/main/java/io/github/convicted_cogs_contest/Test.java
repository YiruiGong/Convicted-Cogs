/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Test extends ApplicationAdapter {
    SpriteBatch batch;
    Texture sol;
    double x,y;
    
    @Override
    public void create () {
        batch = new SpriteBatch();
        sol = new Texture("sol.png");
        
    }
    
    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        
    }
}


