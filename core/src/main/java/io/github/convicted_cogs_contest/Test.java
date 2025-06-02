/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Test extends Game {
    
    Texture character1Texture;
    Texture backgroundTexture;
    
    SpriteBatch spriteBatch;
    FitViewport viewport;
    
    Sprite character1Sprite;
    
    int x,y;
    Rectangle character1Rectangle;
    ShapeRenderer shapeRenderer;
    
    
    
    @Override
    public void create () {
        //backgroundTexture = new Texture("");
        character1Texture = new Texture("character/180px-GGST_Sol_Badguy_5P.png");
        
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(16, 9);
        
        character1Sprite = new Sprite(character1Texture);
        character1Sprite.setSize(2, 2);
        
        character1Rectangle = new Rectangle();
    }
    
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
    
    @Override
    public void render() {
        input();
        logic();
        draw();
        
//        Gdx.gl.glClearColor(0, 0, 0, 0);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x < 1600) {
//            x += 1;
//        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x > 0) {
//            x -= 1;
//        } else if (Gdx.input.isKeyPressed(Input.Keys.UP) && y < 900) {
//            y += 1;
//        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && y > 0) {
//            y -= 1;
//        }
//        
//        solHitBox.setPosition(x,y);
//        System.out.println(solHitBox.overlaps(solHitBox));
//        
//        batch.begin();
//        batch.draw(sol, x, y);
//        batch.end();
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.rect(x, y, 1600, 900, com.badlogic.gdx.graphics.Color.BLUE, com.badlogic.gdx.graphics.Color.BLUE, com.badlogic.gdx.graphics.Color.RED, com.badlogic.gdx.graphics.Color.RED);
//        System.out.println(x);
//        System.out.println(y);
    }
    
    private void input() {
        float speed = 2f;
        float delta = Gdx.graphics.getDeltaTime();
        
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            character1Sprite.translateX(speed * delta);
        } else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            character1Sprite.translateX(-speed * delta);
        }
    }
    
    private void logic() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        
        float character1Width = character1Sprite.getWidth();
        float character1Height = character1Sprite.getHeight();
        
        character1Sprite.setX(MathUtils.clamp(character1Sprite.getX(), 0, worldWidth - character1Width));
    }
    
    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        
        float worldHeight = viewport.getWorldHeight();
        float worldWidth = viewport.getWorldWidth();
        
        character1Sprite.draw(spriteBatch);
        
        
        spriteBatch.end();
    }


    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }

}
