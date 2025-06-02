/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class Character {
    Texture texture;
    Rectangle hitBox;
    
    float speed;
    
    SpriteBatch spriteBatch;
    
    float x;
    float y;
    
    int health;
    ArrayList<Move> attacks;
    boolean block;
    
    public Character(SpriteBatch sb) {
        spriteBatch = sb;
        texture = new Texture("images.png");
        hitBox = new Rectangle();
        speed = 5;
        x = 0;
        y = 0;
    }
    
    public Texture getTexture() {
        return texture;
    }
    
    public void draw() {
        spriteBatch.draw(texture, x, y);
    }
    
    public float getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public boolean isBlock() {
        return block;
    }
    
    
    
}
