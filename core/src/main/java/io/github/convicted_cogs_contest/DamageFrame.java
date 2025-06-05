/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.math.Rectangle;

public class DamageFrame {
    
    Rectangle hurtbox;
    int frame;
    
    public DamageFrame(int frame, Rectangle hurtbox) {
        this.hurtbox = hurtbox;
        this.frame = frame;
    }
    
    public Rectangle getHurtbox(int xPos, int yPos) {
        hurtbox.setPosition(xPos, yPos);
        return hurtbox;
    }
    
    public int getFrame() {
        return frame;
    }
}
