/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Test extends ApplicationAdapter {
    SpriteBatch batch;
    Texture sol;
    int x,y;
    Rectangle solHitBox;
    
    
    @Override
    public void create () {
        batch = new SpriteBatch();
        sol = new Texture("images.png");
        solHitBox = new Rectangle(x, y, 64, 64);
    }
    
    
    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x < 1600) {
            x += 1;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x > 0) {
            x -= 1;
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP) && y < 900) {
            y += 1;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && y > 0) {
            y -= 1;
        }
        
        solHitBox.setPosition(x,y);
        System.out.println(solHitBox.overlaps(solHitBox));
        
        batch.begin();
        batch.draw(sol, x, y);
        batch.end();
        System.out.println(x);
        System.out.println(y);
    }
    


    @Override
    public void dispose() {
        // Destroy screen's assets here.
        batch.dispose();
        sol.dispose();
    }

}
