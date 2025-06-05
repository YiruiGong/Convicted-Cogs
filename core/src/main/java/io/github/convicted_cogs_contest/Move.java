/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author gongm
 */
public class Move extends Animation {
    Rectangle hurtbox;
    
    public Move(String imageName, int numFrames, int frameWidth, int frameHeight, int xOffset, Rectangle hurtbox) {
        super(imageName, numFrames, frameWidth, frameHeight, xOffset);
        this.hurtbox = hurtbox;
    }
    
    public Rectangle getHurtbox() {
        return hurtbox;
    }
    
    
    
    
}
