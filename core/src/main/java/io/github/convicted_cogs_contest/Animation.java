/*
Yirui Gong & Sahadad Ewaz
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Animation {

    //Create Protrected Attributes
    protected Texture images;
    protected String imageName;
    protected int numFrames;
    protected int currentFrame;
    protected int frameHeight;
    protected int frameWidth;
    protected SpriteBatch spriteBatch;
    protected int xOffset;

    /**
     * Primary Constructor
     *
     * @param imageName the name of the image/png
     * @param numFrames the number of frames
     * @param frameWidth how wide the frame is
     * @param frameHeight how long the frame is
     * @param xOffset how off center the frame is
     */
    public Animation(String imageName, int numFrames, int frameWidth, int frameHeight, int xOffset) {
        this.imageName = imageName;
        images = new Texture(imageName);
        this.numFrames = numFrames;
        currentFrame = 1;
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
        this.xOffset = xOffset;
    }

    /**
     * Checks if the animation played is done
     *
     * @return true or false depending if the animation is done
     */
    public boolean doneAnimation() {
        //Checks by comparing current frame with number of total frames
        //Also resets frame number to 1 if last frame is reached
        if (currentFrame == numFrames) {
            currentFrame = 1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the current width of the frame for the animation
     *
     * @return the current width
     */
    public int currentWidth() {
        return currentFrame * frameWidth - frameWidth;
    }

    /**
     * Getter for Number of Frames
     *
     * @return numFrames
     */
    public int getNumFrames() {
        return numFrames;
    }

    /**
     * Getter for images
     *
     * @return images
     */
    public Texture getImages() {
        return images;
    }

    /**
     * Calculates the next frame of the animation that plays
     */
    public void nextFrame() {
        //Resets to first frame if last frame is reached
        if (currentFrame == numFrames) {
            currentFrame = 1;
        } else {
            //Add 1 to frame
            currentFrame++;
        }
    }

    /**
     * draws the character image and a certain x and y position with its width
     * and height
     *
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
     * Getter for the current frame
     *
     * @return the current frame number
     */
    public int getCurrentFrame() {
        return currentFrame;
    }

    /**
     * Setter
     *
     * @param currentFrame the current frame of the animation playing
     */
    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    /**
     * Getter for the frame height
     *
     * @return
     */
    public int getFrameHeight() {
        return frameHeight;
    }

    /**
     * Setter for the frame height
     *
     * @param frameHeight height of the frame
     */
    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    /**
     * Getter for the frame width
     *
     * @return
     */
    public int getFrameWidth() {
        return frameWidth;
    }

    /**
     * Setter for the frame width
     *
     * @param frameWidth the Width of the frame
     */
    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    /**
     * Getter
     *
     * @return the sprite batch
     */
    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    /**
     * Setter
     *
     * @param spriteBatch loads images
     */
    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    /**
     * Gets the x off set
     *
     * @return
     */
    public int getxOffset() {
        return xOffset;
    }

    /**
     * Sets the x offset
     *
     * @param xOffset how much the x position is off center
     */
    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }
    
    /**
     * Getter for image name
     * @return 
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Setter for image name
     * @param imageName 
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    /**
     * Equals method
     * @param a - other animation to check with
     * @return is equal boolean
     */
    public boolean equals(Animation a) {
        if (images.equals(a.images)
                && numFrames == a.numFrames
                && currentFrame == a.currentFrame
                && frameHeight == a.frameHeight
                && frameWidth == a.frameWidth
                && xOffset == a.xOffset) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Clone method
     * @return Animation clone
     */
    public Animation clone() {
        return new Animation(imageName, numFrames, frameWidth, frameHeight, xOffset);
    }

    /**
     * To String method
     * @return String
     */
    public String toString() {
        return "ImageName: " + imageName + "\nCurrent Frame: " + currentFrame + "\nNumber of Frames: " + numFrames + "\nFrame Height: " + frameHeight + "\nFrame Width: " + frameWidth + "\nx Offset" + xOffset;
    }

}
