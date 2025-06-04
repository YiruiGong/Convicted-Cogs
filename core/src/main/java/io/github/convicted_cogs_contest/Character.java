/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class Character {
    Texture texture;
    Rectangle hitBox;
    
    int speed;
    
    
    SpriteBatch spriteBatch;
    
    int xPos;
    int yPos;   
    
    int health;
    ArrayList<Move> attacks;
    ArrayList<Animation> movement;
    int movementIndex;
    boolean block;
    
    public Character(SpriteBatch sb, ArrayList<Animation> movement) {
        spriteBatch = sb;
        texture = new Texture("idle.png");
        hitBox = new Rectangle();
        speed = 5;
        xPos = 0;
        yPos = 0;
        this.movement = movement;
    }
    
    public Texture getTexture() {
        return texture;
    }
    
    public void draw() {
        movement.get(movementIndex).draw(spriteBatch, xPos, yPos);
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
    
    public void moveForward() {
        movementIndex = 1;
        xPos += speed;
    }
    
    public void notMove() {
        movementIndex = 0;
   
    }
    
    public void moveBackward() {
        movementIndex = 2;
        xPos -= speed;
    }
    
    public void move(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    
    
}
