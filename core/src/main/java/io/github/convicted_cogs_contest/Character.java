/*
Yirui Gong & Thomas Filsinger

*/
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class Character {

    private Texture texture;
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

    public Character(SpriteBatch spriteBatch, ArrayList<Animation> movement, ArrayList<Move> attacks) {
        this.spriteBatch = spriteBatch;
        texture = new Texture("idle.png");
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

    public void attack(int move) {
        attackIndex = move;
        stun = true;
        attacking = true;
    }

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

    public boolean getStun() {
        return stun;
    }

    public int getWidth() {
        return width;
    }

    public int getHealth() {
        if (health > 0) {
            return health;
        } else {
            return 0;
        }
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setBlock(boolean blocking) {
        this.blocking = blocking;
    }

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

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void moveRight() {
        movementIndex = 1;
        if (stun == false && xPos <= 1500) {
            xPos += speed;
        }
        moving = true;
    }

    public void notMove() {
        movementIndex = 0;
        moving = false;

    }

    public void moveLeft() {
        movementIndex = 2;
        if (stun == false && xPos > 0) {
            xPos -= speed;
        }
        moving = true;
    }

    public void moveCharacter(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getAttackIndex() {
        return attackIndex;
    }

    public ArrayList<Move> getAttack() {
        return attack;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isMoving() {
        return moving;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int move) {
        this.xPos += move;
    }

    public void setyPos(int move) {
        this.yPos += move;
    }
}
