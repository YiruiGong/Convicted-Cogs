/*
Yirui Gong, Sahadad Ewaz, & Thomas Filsinger

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
    public Character(SpriteBatch spriteBatch, ArrayList<Animation> movement, ArrayList<Move> attacs) {
        this.spriteBatch = spriteBatch;
        width = 90;
        hitbox = new Rectangle(xPos, yPos, width, 300);
        
        speed = 10;
        moving = false;
        
        xPos = 0;
        yPos = 0;

        this.movement = movement;
        this.attack = attack;

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
        //If stunned
        if (stun == true) {
            //And if hit
            if (hit == true) {
                //Plays either hit or block animation
                movement.get(movementIndex).draw(spriteBatch, xPos, yPos);
                //Set to see if still stunned
                setStun(movement.get(movementIndex));
            //Otherwise play attack animation
            } else {
                //Set attacking to true
                attacking = true;
                attack.get(attackIndex).draw(spriteBatch, xPos, yPos);
                //Set to see if still stunned
                setStun(attack.get(attackIndex));
            }
        //Otherwise play the corresponding animation
        } else {
            movement.get(movementIndex).draw(spriteBatch, xPos, yPos);
        }
        //Update hitbox
        hitbox.setPosition(xPos, yPos);
    }
    /**
     * method for attack animation
     * @param move move to use
     */
    public void attack(int move) {
        attackIndex = move;
        //Set attacking and stunned to true
        stun = true;
        attacking = true;
    }
    /**
     * Setter for when a character gets hit, the character will play a certain animation
     * @param a animation for when the player gets hit
     */
    public void setStun(Animation a) {
        //Check if animation is done
        if (a.doneAnimation() == true) {
            //If hit, then reset it to not hit
            if (hit == true) {
                hit = false;
                //Blocking and attacking are false
                blocking = false;
                attacking = false;
            //Otherwise still hit, so only set attacking to false
            } else {
                attacking = false;
            }
            //No longer stunned
            stun = false;
        //Otherwise still stunned
        } else {
            stun = true;
            //If not attacking, then still being hit
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
        //If health is less than 0, return 0
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
        //Make stunned
        stun = true;
        //If not hit yet
        if (hit == false) {
            //If blocking, play block animation and subtract health
            if (blocking == true) {
                health -= 3;
                movementIndex = 4;
            //Otherwise subtract health and play hit animation
            } else {
                movementIndex = 3;
                health -= damage;
            }
            //Set hit to true
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
        //Set to correct animation
        movementIndex = 1;
        //Move if not stunned and position is less than 1500
        if (stun == false && xPos <= 1500) {
            xPos += speed;
        }
        moving = true;
    }
    /**
     * Method for staying still
     */
    public void notMove() {
        //Set to correct animation
        movementIndex = 0;
        moving = false;

    }
    /**
     * method for moving to the left
     */
    public void moveLeft() {
        //Set to correct animation
        movementIndex = 2;
        //Move if not stunned and position is greater than 0
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

    /**
     * Getter for blocking 
     * @return 
     */
    public boolean isBlocking() {
        return blocking;
    }
    
    /**
     * Setter for hit boolean
     * @param hit 
     */
    public void setHit(boolean hit) {
        this.hit = hit;
    }
    
    /**
     * Clones character
     * @return a clone
     */
    public Character clone() {
        return new Character(spriteBatch, movement, attack);
    }
    
    /**
     * Equals method
     * @param c other character to compare to
     * @return boolean whether is equal
     */
    public boolean equals(Character c) {
        if (hitbox.equals(c.hitbox) && speed == c.speed && moving == c.moving && xPos == c.xPos && yPos == c.yPos && health == c.health 
&& attack.equals(c.attack) && movement.equals(c.movement) && blocking == c.blocking && hit == c.hit && stun == c.stun &&attacking == c.attacking && width == c.width) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * To String method
     * @return String
     */
    public String toString() {
        return "Hitbox: " + hitbox + "\nMoving: " + moving + "\nSpeed: " + speed + "\nx Position: " + xPos + "\ny Position: " + yPos + "\nHealth: " + health + "\nAttacks: " + attack.toString() + "\nMovements: " + movement.toString() + "\nBlocking: " + blocking + "\nHit: " + hit + "\nStun: " + stun + "\nAttacking: " + attacking + "Width: " + width;
    }
}
