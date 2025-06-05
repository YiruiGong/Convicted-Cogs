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
    Rectangle hitbox;
    
    int speed;
    
    
    SpriteBatch spriteBatch;
    
    int xPos;
    int yPos;   
    
    int health;
    ArrayList<Move> attack;
    ArrayList<Animation> movement;
    int movementIndex;
    boolean block;
    boolean attacking;
    boolean stun;
    
    public Character(SpriteBatch sb, ArrayList<Animation> movement, ArrayList<Move> attacks) {
        spriteBatch = sb;
        texture = new Texture("idle.png");
        hitbox = new Rectangle(xPos, yPos, 200, 300);
        speed = 5;
        xPos = 0;
        yPos = 0;
        this.movement = movement;
        this.attack = attacks;
        health = 100;
    }
    
    public Texture getTexture() {
        return texture;
    }
    
    public void draw() {
        if (stun == true) {
            if (block == true) {
                movement.get(movementIndex).draw(spriteBatch, xPos, yPos);
            } else {

            }
        }
        movement.get(movementIndex).draw(spriteBatch, xPos, yPos);
        hitbox.setPosition(xPos, yPos);
    }
    
    public void attack(int move) {
        
        stun = true;
    }
    
    public void setStun(Animation a) {
        if (a.doneAnimation() == false) {
            stun = true;
        } else {
            stun = false;
        }
    }
    
    public boolean getStun() {
        return stun;
    }
    
    public float getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }
    
    public Rectangle getHitbox() {
        return hitbox;
    }

    public void Block() {
        block = true;  
    }
    
    public boolean isHit(boolean collision, int damage) {
        if (block == true) {
            movementIndex = 3;
            return false;
        } else {
            movementIndex = 4;
            return true;
        }
    }
    
    public void takeDamage(int damage) {
        health -= damage;
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
