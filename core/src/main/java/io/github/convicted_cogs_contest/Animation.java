/*
Yirui Gong

*/
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Animation {
    
    protected Texture images;
    protected int numFrames;
    protected int currentFrame;
    protected int frameHeight;
    protected int frameWidth;
    protected SpriteBatch spriteBatch;
    protected int xOffset;
    
    
    public Animation(String imageName, int numFrames, int frameWidth, int frameHeight, int xOffset) {
        images = new Texture(imageName);
        this.numFrames = numFrames;
        currentFrame = 1;
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
        this.xOffset = xOffset;
    }
    
    public boolean doneAnimation() {
        if (currentFrame == numFrames) {
            currentFrame = 1;
            return true;
        } else {
            return false;
        }
    }
    
    public int currentWidth() {
        return currentFrame * frameWidth - frameWidth;
    }
    
    public int getNumFrames() {
        return numFrames;
    }
    
    public Texture getImages() {
        return images;
    }
    
    public void nextFrame() {
        if (currentFrame == numFrames) {
            currentFrame = 1;
        } else {
            currentFrame ++;
        }
    }
    
    public void draw(SpriteBatch batch, int xPos, int yPos) {
        spriteBatch = batch;
        spriteBatch.draw(images, xPos + xOffset, yPos, currentWidth(), 0, frameWidth, frameHeight);
        nextFrame();
    }
    
    
    
    
    
    
}
