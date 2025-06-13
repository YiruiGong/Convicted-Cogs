/*
Yirui Gong
*/
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Move extends Animation {
    //Initilize Private Attributes
    private int damage;
    private int[] damageFrames;
    private int dFrameIndex;
    private Rectangle hurtbox;
    
    /**
     * Primary Constructor
     * @param imageName name of the image
     * @param numFrames number of frames
     * @param frameWidth width of the frame
     * @param frameHeight height of the frame
     * @param xOffset x position off set
     * @param damage 
     * @param hurtbox
     * @param damageFrames  number of frames that are considered "damage"
     */
    public Move(String imageName, int numFrames, int frameWidth, int frameHeight, int xOffset, int damage, Rectangle hurtbox, int [] damageFrames) {
        super(imageName, numFrames, frameWidth, frameHeight, xOffset);
        this.damage = damage;
        this.hurtbox = hurtbox;
        this.damageFrames = damageFrames;
    }
    /**
     * Getter, gets the damage from an attack
     * @return returns damage
     */
    public int getDamage() {
        return damage;
    }
    /**
     * Getter, gets the damage frames from an attack
     * @return returns damageFrames
     */
    public int[] getDamageFrames() {
        return damageFrames;
    }
    /**
     * Setter, sets the amount of damage frames
     * @param damageFrames different for each animation
     */
    public void setDamageFrames(int[] damageFrames) {
        this.damageFrames = damageFrames;
    }
    /**
     * Getter, gets the frame index
     * @return returns frame index
     */
    public int getdFrameIndex() {
        return dFrameIndex;
    }
    /**
     * Setter, sets the frame index
     * @param dFrameIndex different for each animation
     */
    public void setdFrameIndex(int dFrameIndex) {
        this.dFrameIndex = dFrameIndex;
    }
    /**
     * Getter, gets the hurt boxes of the characters
     * @return returns damage
     */
    public Rectangle getHurtbox() {
        return hurtbox;
    }
    /**
     * Setter, sets the hurt box for each character
     * @param hurtbox different for each character
     */
    public void setHurtbox(Rectangle hurtbox) {
        this.hurtbox = hurtbox;
    }
    /**
     * Getter, gets the images
     * @return returns images
     */
    @Override
    public Texture getImages() {
        return images;
    }
    /**
     * Setter, Sets the images for the player to see
     * @param images 
     */
    public void setImages(Texture images) {
        this.images = images;
    }
    /**
     * Getter, gets the number of frames
     * @return returns numFrames
     */
    @Override
    public int getNumFrames() {
        return numFrames;
    }
    /**
     * Setter, sets the number of frames
     * @param numFrames different for each animation
     */
    public void setNumFrames(int numFrames) {
        this.numFrames = numFrames;
    }
    /**
     * Getter, gets the current frame being played
     * @return returns current frame
     */
    @Override
    public int getCurrentFrame() {
        return currentFrame;
    }
    /**
     * Setter, sets the current frame
     * @param currentFrame 
     */
    @Override
    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }
    /**
     * Getter, gets the height of the frame
     * @return returns frameHeight
     */
    @Override
    public int getFrameHeight() {
        return frameHeight;
    }
    /**
     * Setter, sets the frame height
     * @param frameHeight 
     */
    @Override
    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
    /**
     * Getter, gets the width of the frame
     * @return returns frameWidth
     */
    @Override
    public int getFrameWidth() {
        return frameWidth;
    }
    /**
     * Setter, sets the frames width
     * @param frameWidth 
     */
    @Override
    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }
    /**
     * Getter, gets images and text
     * @return returns spriteBatch
     */
    @Override
    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }
    /**
     * Setter, sets the images
     * @param spriteBatch 
     */
    @Override
    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }
    /**
     * Getter, gets x position that is off centered
     * @return returns xOffset
     */
    @Override
    public int getxOffset() {
        return xOffset;
    }
    /**
     * Setter, sets the x positions off set
     * @param xOffset 
     */
    @Override
    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }
    
    /**
     * Method to check the frame if it is a damage frame
     * @return 
     */
    public int isDamageFrame() {
        //Checks if damage frame by seeing if the current frame is a damage frame
        for (int i = 0; i < damageFrames.length; i ++) {
            if (currentFrame == damageFrames [i]) {
                //If successful, return the frame
                dFrameIndex = i;
                return currentFrame;
            }
        }
        //Otherwise return -1
        return -1;
    }
    /**
     * Method to deal damage to the other character
     * @param xPos x position of the character
     * @param yPos y position of the character
     * @return hurt box positions or a new rectangle
     */
    public Rectangle dealDamage(int xPos, int yPos) {
        //Check if damage frame
        int f = isDamageFrame();
        //if is damage frame, return a hurtbox
        if (f != -1) {
            return hurtbox.setPosition(xPos, yPos);
        }
        //Else create a hurtbox off world
        else {
            return new Rectangle(-1,-1, 0, 0);
        }
    }
    
    /**
     * Equals method
     * @param m - Move to compare to
     * @return boolean whether is equal
     */
    public boolean equals(Move m) {
        if (super.equals(m) == true && damage == m.damage && hurtbox.equals(m.hurtbox) && damageFrames == m.damageFrames) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Clone method
     * @return a clone
     */
    public Move clone() {
        return new Move(imageName, numFrames, frameWidth, frameHeight, xOffset, damage, hurtbox, damageFrames);
    }
    
    /**
     * To String method
     * @return a String
     */
    public String toString() {
        return super.toString() + "\nDamage: " + damage + "\nHurtbox: " + hurtbox.toString() + "\nDamage Frames: " + damageFrames;
    }
}
