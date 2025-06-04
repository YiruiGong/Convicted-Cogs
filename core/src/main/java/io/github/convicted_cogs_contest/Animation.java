/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;

public class Animation {
    
    Texture image;
    int frameNum;
    Texture frameImage;
    
    
    public Animation(String imageName) {
        image = new Texture(imageName);
        frameNum = 0;
        frameImage = new Texture(imageName);
    }
    
    public void draw() {
        
    }
    
    
    
    
    
    
}
