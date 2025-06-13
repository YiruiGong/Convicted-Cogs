/*
Yirui Gong & Thomas Filsinger

*/
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class Character {
    //Initilize Private Attributes
    private Rectangle hitbox;

    private int speed;
    private boolean moving;

    private SpriteBatch spriteBatch;

    private int xPos;
    private int yPos;

    private int health;
    private ArrayList<Move> attack;
    private int attackIndex;

    private ArrayList<Animation> movement;
    private int movementIndex;

    private boolean blocking;
    private boolean hit;
    private boolean stun;
    private boolean attacking;

    private int width;

    /**
     * Primary Constructor
     * @param spriteBatch Loads images
     * @param movement movement animations
     * @param attacks animations for attacking
     */
    public Character(SpriteBatch spriteBatch, ArrayList<Animation> movement, ArrayList<Move> attacks) {
        this.spriteBatch = spriteBatch;
        width = 90;
        hitbox = new Rectangle(xPos, yPos, width, 300);
        
        speed = 10;
        moving = false;
        
        xPos = 0;
        yPos = 0;

        this.movement = movement;
        this.attack = attacks;

        health = 100;

        stun = false;
        hit = false;
        blocking = false;
        attacking = false;
    }
    
    /**
     * Draw the animation of the character moving
     * and drawing the animation of the character getting hit and the x and y position
     */
    public void draw() {
        if (stun == true) {
            if (hit == true) {
                movement.get(movementIndex).draw(spriteBatch, xPos, yPos);
                setStun(movement.get(movementIndex));
            } else {
                attacking = true;
                attack.get(attackIndex).draw(spriteBatch, xPos, yPos);
                setStun(attack.get(attackIndex));
            }
        } else {
            movement.get(movementIndex).draw(spriteBatch, xPos, yPos);
        }
        hitbox.setPosition(xPos, yPos);
    }
    /**
     * method for attack animation
     * @param move checks to see if the character is moving before attacking
     */
    public void attack(int move) {
        attackIndex = move;
        stun = true;
        attacking = true;
    }
    /**
     * Setter for when a character gets hit, the character will play a certain animation
     * @param a animation for when the player gets hit
     */
    public void setStun(Animation a) {
        if (a.doneAnimation() == true) {
            if (hit == true) {
                hit = false;
                blocking = false;
                attacking = false;
            } else {
                attacking = false;
            }
            stun = false;
        } else {
            stun = true;
            if (!attacking) {
                hit = true;
            }
        }
    }
    /**
     * Getter for stun
     * @return stun
     */
    public boolean getStun() {
        return stun;
    }
    /**
     * getter for Width
     * @return width
     */
    public int getWidth() {
        return width;
    }
    /**
     * Getter for health and checking if health is 0
     * @return health or 0
     */
    public int getHealth() {
        if (health > 0) {
            return health;
        } else {
            return 0;
        }
    }
    /**
     * getter for hit boxes
     * @return hit box
     */
    public Rectangle getHitbox() {
        return hitbox;
    }
    /**
     * Setter for blocking
     * @param blocking a boolean either true if the character is blocking or false if not blocking
     */
    public void setBlock(boolean blocking) {
        this.blocking = blocking;
    }
    /**
     * Method to calculate the damage the character takes with getting hit with and without blocking 
     * @param damage how much damage a certain attack does
     */
    public void isHit(int damage) {
        stun = true;
        if (hit == false) {
            if (blocking == true) {
                health -= 3;
                movementIndex = 4;
            } else {
                movementIndex = 3;
                health -= damage;
            }
            hit = true;
        }
    }
    /**
     * method for the characters taking damage
     * @param damage depends on the attack preformed
     */
    public void takeDamage(int damage) {
        health -= damage;
    }
    /**
     * Method to move right
     */
    public void moveRight() {
        movementIndex = 1;
        if (stun == false && xPos <= 1500) {
            xPos += speed;
        }
        moving = true;
    }
    /**
     * Method for staying still
     */
    public void notMove() {
        movementIndex = 0;
        moving = false;

    }
    /**
     * method for moving to the left
     */
    public void moveLeft() {
        movementIndex = 2;
        if (stun == false && xPos > 0) {
            xPos -= speed;
        }
        moving = true;
    }
    /**
     * Method to see where the character has moved to
     * @param xPos x position of the character
     * @param yPos y position of the character
     */
    public void moveCharacter(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    /**
     * Getter for attack index
     * @return returns attackIndex
     */
    public int getAttackIndex() {
        return attackIndex;
    }
    /**
     * getter for attack move list
     * @return returns attack
     */
    public ArrayList<Move> getAttack() {
        return attack;
    }
    /**
     * getting for if the character is attacking
     * @return returns attacking
     */
    public boolean isAttacking() {
        return attacking;
    }
    /**
     * Getter for the character's speed
     * @return returns speed
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * Getter  checking to see if the character is moving
     * @return returns moving
     */
    public boolean isMoving() {
        return moving;
    }
    /**
     * Getter  Gets the X position
     * @return returns x position
     */
    public int getxPos() {
        return xPos;
    }
    /**
     * Getter  Gets the Y position
     * @return returns y position
     */
    public int getyPos() {
        return yPos;
    }
    /**
     * Setter, sets the x position when character is moving
     * @param move and integer of how much a character is moving
     */
    public void setxPos(int move) {
        this.xPos += move;
    }
    /**
     * Setter, sets the y position when character is moving
     * @param move and integer of how much a character is moving
     */
    public void setyPos(int move) {
        this.yPos += move;
    }
    /**
     * Getter, Loads all of the images and fonts
     * @return returns spriteBatch
     */
    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }
    /**
     * Setter, sets all of the fonts/text and images
     * @param spriteBatch loads fonts/text and images
     */
    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }
    /**
     * Getter, Animation for movement for each character
     * @return returns movement
     */
    public ArrayList<Animation> getMovement() {
        return movement;
    }
    /**
     * Setter, sets the animation for movement
     * @param movement array list for animation of movement
     */
    public void setMovement(ArrayList<Animation> movement) {
        this.movement = movement;
    }
    /**
     * Getter, for movement index
     * @return returns movement index
     */
    public int getMovementIndex() {
        return movementIndex;
    }
    /**
     * Setter, sets the movement index
     * @param movementIndex sets how much they change move in frames
     */
    public void setMovementIndex(int movementIndex) {
        this.movementIndex = movementIndex;
    }
    
    
}
