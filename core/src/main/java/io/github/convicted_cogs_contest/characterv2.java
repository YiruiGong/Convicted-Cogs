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

public class characterv2 {
    Texture texture;
    Sprite sprite;
    Rectangle hitBox;
    
    float speed;
    
    SpriteBatch spriteBatch;
    
    int health;
    ArrayList<Move> attacks;
    boolean block;
    
    public characterv2(SpriteBatch sb) {
        spriteBatch = sb;
        texture = new Texture("character/180px-GGST_Sol_Badguy_5P.png");
        sprite = new Sprite(texture);
        sprite.setSize(2, 2);
        hitBox = new Rectangle();
        float speed = 2f;
    }
    
    public Sprite getSprite() {
        return sprite;
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