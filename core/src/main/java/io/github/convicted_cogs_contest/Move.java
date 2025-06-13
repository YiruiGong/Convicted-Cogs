/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author gongm
 */
public class Move extends Animation {
    private int damage;
    private int[] damageFrames;
    private int dFrameIndex;
    private Rectangle hurtbox;
    
    public Move(String imageName, int numFrames, int frameWidth, int frameHeight, int xOffset, int damage, Rectangle hurtbox, int [] damageFrames) {
        super(imageName, numFrames, frameWidth, frameHeight, xOffset);
        this.damage = damage;
        this.hurtbox = hurtbox;
        this.damageFrames = damageFrames;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public int isDamageFrame() {
        for (int i = 0; i < damageFrames.length; i ++) {
            if (currentFrame == damageFrames [i]) {
                dFrameIndex = i;
                return currentFrame;
            }
        }
        return -1;
    }
    
    public Rectangle dealDamage(int xPos, int yPos) {
        int f = isDamageFrame();
        if (f != -1) {
            return hurtbox.setPosition(xPos, yPos);
        }
        else {
            return new Rectangle(-1,-1, 0, 0);
        }
    }
}
