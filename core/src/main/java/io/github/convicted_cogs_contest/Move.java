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
    int damage;
    //ArrayList<DamageFrame> dFrames = new ArrayList<DamageFrame>();
    ArrayList<Integer> dFrames;
    int dFrameIndex;
    Rectangle hurtbox;
    
    public Move(String imageName, int numFrames, int frameWidth, int frameHeight, int xOffset, int damage, Rectangle hurtbox, ArrayList<Integer> dFrames) {
        super(imageName, numFrames, frameWidth, frameHeight, xOffset);
        this.damage = damage;
        this.hurtbox = hurtbox;
        this.dFrames = dFrames;
        //this.dFrames = dFrames;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public int isDamageFrame() {
        for (int i = 0; i < dFrames.size(); i ++) {
            if (currentFrame == dFrames.get(i)) {
                dFrameIndex = i;
                return currentFrame;
            }
        }
        return -1;
    }
    
//    public int isDamageFrame() {
//        for (int i = 0; i < dFrames.size(); i ++) {
//            if (currentFrame == dFrames.get(i).getFrame()) {
//                dFrameIndex = i;
//                return currentFrame;
//            }
//        }
//        return -1;
//    }
    
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
