/*
Yirui Gong

*/
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Animation {
    //Create Protrected Attributes
    protected Texture images;
    protected int numFrames;
    protected int currentFrame;
    protected int frameHeight;
    protected int frameWidth;
    protected SpriteBatch spriteBatch;
    protected int xOffset;
    
    /**
     * Primary Constructor
     * @param imageName the name of the image/png
     * @param numFrames the number of frames
     * @param frameWidth how wide the frame is 
     * @param frameHeight how long the frame is
     * @param xOffset how off center the frame is
     */
    public Animation(String imageName, int numFrames, int frameWidth, int frameHeight, int xOffset) {
        images = new Texture(imageName);
        this.numFrames = numFrames;
        currentFrame = 1;
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
        this.xOffset = xOffset;
    }
    /**
     * Checks if the animation played is done
     * @return true or false depending if the animation is done
     */
    public boolean doneAnimation() {
        if (currentFrame == numFrames) {
            currentFrame = 1;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Gets the current width of the frame
     * @return the current width
     */
    public int currentWidth() {
        return currentFrame * frameWidth - frameWidth;
    }
    /**
     * Getter for Number of Frames
     * @return numFrames
     */
    public int getNumFrames() {
        return numFrames;
    }
    
    /**
     * Getter for images
     * @return images
     */
    public Texture getImages() {
        return images;
    }
    /**
     * Calculates the next frame of the animation that plays
     */
    public void nextFrame() {
        if (currentFrame == numFrames) {
            currentFrame = 1;
        } else {
            currentFrame ++;
        }
    }
    /**
     * draws the character image and a certain x and y position with its width and height
     * @param batch loads the image
     * @param xPos x position of the image
     * @param yPos y position of the image
     */
    public void draw(SpriteBatch batch, int xPos, int yPos) {
        spriteBatch = batch;
        spriteBatch.draw(images, xPos + xOffset, yPos, currentWidth(), 0, frameWidth, frameHeight);
        nextFrame();
    }
    /**
     * Getter
     * @return 
     */
    public int getCurrentFrame() {
        return currentFrame;
    }
    /**
     * Setter
     * @param currentFrame the current frame of the animation playing
     */
    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }
    /**
     * Getter
     * @return 
     */
    public int getFrameHeight() {
        return frameHeight;
    }
    /**
     * Setter
     * @param frameHeight height of the frame
     */
    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
    /**
     * Getter
     * @return 
     */
    public int getFrameWidth() {
        return frameWidth;
    }
    /**
     * Setter
     * @param frameWidth the Width of the frame
     */
    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }
    /**
     * Getter
     * @return 
     */
    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }
    /**
     * Setter
     * @param spriteBatch loads images
     */
    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }
    /**
     * Getter
     * @return 
     */
    public int getxOffset() {
        return xOffset;
    }
    /**
     * Setter
     * @param xOffset how much the x position is off center
     */
    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }
    
    
    
    
    
    
}
