/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Test extends Game {
    SpriteBatch batch;
    Texture sol;
    int x,y;
    Rectangle solHitBox;
    ShapeRenderer shapeRenderer;
    FitViewport viewport;
    
    
    @Override
    public void create () {
        batch = new SpriteBatch();
        sol = new Texture("images.png");
        solHitBox = new Rectangle(x, y, 64, 64);
        viewport = new FitViewport(8, 5);
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
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.rect(x, y, 1600, 900, com.badlogic.gdx.graphics.Color.BLUE, com.badlogic.gdx.graphics.Color.BLUE, com.badlogic.gdx.graphics.Color.RED, com.badlogic.gdx.graphics.Color.RED);
//        System.out.println(x);
//        System.out.println(y);
    }
    


    @Override
    public void dispose() {
        // Destroy screen's assets here.
        batch.dispose();
        sol.dispose();
    }

}
