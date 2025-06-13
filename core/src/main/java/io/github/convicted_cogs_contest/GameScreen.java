/*
Yirui Gong & Thomas Filsinger

 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import java.util.ArrayList;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class GameScreen implements Screen {

    private FitViewport viewport;
    private Character sol1;
    private Character sol2;
    private Texture background;
    private Texture healthUI;
    private Texture healthbar1;
    private Texture healthbar2;
    private boolean win;
    private BitmapFont p1Font;
    private BitmapFont p2Font;

    Color green = new Color();
    Color orange = new Color();

    Main game;

    public GameScreen(Main game) {
        this.game = game;
    }

    /**
     * will load the method so that the program is ready to render 
     */
    @Override
    public void show() {
        p1Font = new BitmapFont();
        p1Font.setColor(2, 189, 152, 100);

        p2Font = new BitmapFont();
        p2Font.setColor(236, 129, 17, 100);

        win = false;
        viewport = new FitViewport(1600, 900);
        background = new Texture("Lars_Canyon.png");
        healthUI = new Texture("healthUI.png");
        healthbar1 = new Texture("healthbar_1.png");
        healthbar2 = new Texture("healthbar_2.png");

        ArrayList<Animation> movement1 = new ArrayList<Animation>();
        movement1.add(new Animation("idle1.png", 8, 144, 283, -14));
        movement1.add(new Animation("walkforward1.png", 10, 214, 286, -80));
        movement1.add(new Animation("walkbackward1.png", 8, 213, 281, -79));
        movement1.add(new Animation("hit1.png", 4, 271, 289, -159));
        movement1.add(new Animation("block1.png", 5, 137, 280, -6));

        ArrayList<Move> attack1 = new ArrayList<Move>();

//        ArrayList<Integer> punch = new ArrayList<Integer>();
//        punch.add(3);
//        punch.add(4);
//        punch.add(5);
        int[] punch = {3, 4, 5};
        int[] kick = {4, 5};
        int[] slash = {5, 6, 7};
        int[] punch6 = {6, 7, 8};

//        ArrayList<Integer> kick = new ArrayList<Integer>();
//        kick.add(4);
//        kick.add(5);
//        ArrayList<Integer> punch6 = new ArrayList<Integer>();
//        punch6.add(5);
//        punch6.add(6);
//        punch6.add(7);
//        punch6.add(8);
        attack1.add(new Move("punch1.png", 7, 220, 279, -28, 10, new Rectangle(0, 0, 90, 300), punch));
        attack1.add(new Move("kick1.png", 8, 278, 280, -65, 20, new Rectangle(0, 0, 110, 300), kick));
        attack1.add(new Move("slash1.png", 14, 418, 281, -76, 25, new Rectangle(0, 0, 220, 300), slash));
        attack1.add(new Move("6punch1.png", 11, 276, 281, -67, 15, new Rectangle(0, 0, 100, 300), punch6));

        ArrayList<Animation> movement2 = new ArrayList<Animation>();
        movement2.add(new Animation("idle2.png", 8, 144, 283, -40));
        movement2.add(new Animation("walkbackward2.png", 8, 213, 281, -44));
        movement2.add(new Animation("walkforward2.png", 10, 214, 286, -44));

        movement2.add(new Animation("hit2.png", 4, 271, 289, -22));
        movement2.add(new Animation("block2.png", 5, 137, 280, -41));

        ArrayList<Move> attack2 = new ArrayList<Move>();

        attack2.add(new Move("punch2.png", 7, 220, 279, -102, 10, new Rectangle(0, 0, 90, 300), punch));
        attack2.add(new Move("kick2.png", 8, 278, 280, -123, 20, new Rectangle(0, 0, 110, 300), kick));
        attack2.add(new Move("slash2.png", 14, 418, 281, -252, 25, new Rectangle(0, 0, 220, 300), slash));
        attack2.add(new Move("6punch2.png", 11, 276, 281, -119, 15, new Rectangle(0, 0, 100, 300), punch6));

        sol1 = new Character(game.spriteBatch, movement1, attack1);
        sol2 = new Character(game.spriteBatch, movement2, attack2);
        sol1.moveCharacter(500, 100);
        sol2.moveCharacter(1600 - sol2.getWidth() - 500, 100);

    }
    
    /**
     * Changes the screen size
     * @param width changes the width of the screen
     * @param height changes the length of the screen
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    /**
     * Renders all of the methods 
     * @param f makes sures that this method is able to run
     */
    @Override
    public void render(float f) {
        input();
        logic();
        draw();
    }

    /**
     * The different movement keys for each of the characters
     * different for player one compared to player two
     * Also includes the combat and which buttons to press
     */
    public void input() {
        if (sol1.getStun() == false) {
            //Movement and combat for player 1
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                sol1.moveLeft();
            } else if (Gdx.input.isKeyPressed(Input.Keys.I) && Gdx.input.isKeyPressed(Input.Keys.D)) {
                sol1.attack(3);
            } else if (Gdx.input.isKeyPressed(Input.Keys.I)) {
                sol1.attack(0);
            } else if (Gdx.input.isKeyPressed(Input.Keys.O)) {
                sol1.attack(1);
            } else if (Gdx.input.isKeyPressed(Input.Keys.P)) {
                sol1.attack(2);
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                sol1.moveRight();
            } else {
                sol1.notMove();
            }
            //Blocking for player 1
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                sol1.setBlock(true);
            } else {
                sol1.setBlock(false);
            }
        }
        //Movement and combat for player 2
        if (sol2.getStun() == false) {
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                sol2.moveRight();
            } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && Gdx.input.isKeyPressed(Input.Keys.Z)) {
                sol2.attack(3);
            } else if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
                sol2.attack(0);
            } else if (Gdx.input.isKeyPressed(Input.Keys.X)) {
                sol2.attack(1);
            } else if (Gdx.input.isKeyPressed(Input.Keys.C)) {
                sol2.attack(2);
            } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                sol2.moveLeft();
            } else {
                sol2.notMove();
            }
            
            //Blocking for player 2
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                sol2.setBlock(true);
            } else {
                sol2.setBlock(false);
            }
        }
    }
    /**
     * This method calculates the hit boxes with hurt boxes to see if the attack connected
     * and also includes how much damage the player takes when getting hit with different types of attacks
     * and when one player reaches zero hit point will switch to the win screen
     */
    public void logic() {
        //When player 1 is attack player 2
        if (sol1.isAttacking() == true) {
            Rectangle hurtbox = sol1.getAttack().get(sol1.getAttackIndex()).dealDamage(sol1.getxPos() + 90, sol1.getyPos());
            if (hurtbox.overlaps(sol2.getHitbox())) {
                sol2.isHit(sol1.getAttack().get(sol1.getAttackIndex()).getDamage());
            }
        }
        //When player 2 is attacking player 1
        if (sol2.isAttacking() == true) {
            Rectangle hurtbox = sol2.getAttack().get(sol2.getAttackIndex()).dealDamage(sol2.getxPos() - 90, sol2.getyPos());
            if (hurtbox.overlaps(sol1.getHitbox())) {
                sol1.isHit(sol2.getAttack().get(sol2.getAttackIndex()).getDamage());
            }
        }
        //Checking to see if the hit boxes overlaps with a hurt box
        if (sol1.getHitbox().overlaps(sol2.getHitbox())) {
            if (sol1.isMoving() == true && sol2.isMoving() == false) {
                sol1.setxPos(-sol1.getSpeed());
            } else if (sol2.isMoving() == true && sol1.isMoving() == false) {
                sol2.setxPos(sol2.getSpeed());
            } else {
                sol1.setxPos(-sol1.getSpeed());
                sol2.setxPos(sol2.getSpeed());
            }
        }
        //When one the players reaches zero hit points show the win screen
        if (sol1.getHealth() == 0 || sol2.getHealth() == 0) {
            win = true;
        } else {
            win = false;
        }
    }
    /**
     * draws everything that the player might see such as the background, characters and health bars
     */
    public void draw() {
        ScreenUtils.clear(Color.BLACK);

        viewport.apply();
        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();
        game.spriteBatch.draw(background, 0, 0);
        game.spriteBatch.draw(healthUI, 0, 600);
        game.spriteBatch.draw(healthbar1, 100, 686, 0, 0, (sol1.getHealth() * 6), 34);
        game.spriteBatch.draw(healthbar2, 1500 - (sol2.getHealth() * 6), 686, (600 - sol2.getHealth() * 6), 0, 600, 34);

        sol1.draw();
        sol2.draw();

        p1Font.draw(game.spriteBatch, "Player 1", sol1.getxPos(), sol1.getyPos());
        p2Font.draw(game.spriteBatch, "Player 2", sol2.getxPos(), sol2.getyPos());

        game.spriteBatch.end();
    }

    /**
     * Disposes when switching screens
     */
    @Override
    public void dispose() {

    }
    /**
     * pauses the screen
     */
    @Override
    public void pause() {
    }
    /**
     * resumes the screen when paused
     */
    @Override
    public void resume() {
    }
    /**
     * Hides the screen
     */
    @Override
    public void hide() {
    }
    /**
     * Getter, gets win from user
     * @return win
     */
    public boolean getWin() {
        return win;
    }

    //Setters and getters 
    /**
     * Getter, gets ViewPort
     * @return view port
     */
    public FitViewport getViewport() {
        return viewport;
    }
    /**
     * Setter, sets the view port
     * @param viewport 
     */
    public void setViewport(FitViewport viewport) {
        this.viewport = viewport;
    }
    /**
     * Getter, Gets the first character
     * @return sol1
     */
    public Character getSol1() {
        return sol1;
    }
    /**
     * Setter, sets the first character
     * @param sol1 
     */
    public void setSol1(Character sol1) {
        this.sol1 = sol1;
    }
    /**
     * Getter, Gets the second character
     * @return sol2
     */
    public Character getSol2() {
        return sol2;
    }
    /**
     * Setter, sets the first character
     * @param sol2
     */
    public void setSol2(Character sol2) {
        this.sol2 = sol2;
    }

    /**
     * Getter, gets the image of the background
     * @return  returns background
     */
    public Texture getBackground() {
        return background;
    }
    /**
     * Setter, Sets the background with this image
     * @param background image of the background
     */
    public void setBackground(Texture background) {
        this.background = background;
    }
    /**
     * Gets the texture of the health unser interface
     * @return healthUI
     */
    public Texture getHealthUI() {
        return healthUI;
    }
    /**
     * Setter for the health 
     * @param healthUI texture for the health
     */
    public void setHealthUI(Texture healthUI) {
        this.healthUI = healthUI;
    }
    /**
     * gets the health bar for player 1
     * @return health bar 1
     */
    public Texture getHealthbar1() {
        return healthbar1;
    }
    /**
     * Sets the image for the health bar
     * @param healthbar1 
     */
    public void setHealthbar1(Texture healthbar1) {
        this.healthbar1 = healthbar1;
    }
    /**
     * gets the image for player 2
     * @return health bar
     */
    public Texture getHealthbar2() {
        return healthbar2;
    }
    /**
     * Sets the image for player 2
     * @param healthbar2 
     */
    public void setHealthbar2(Texture healthbar2) {
        this.healthbar2 = healthbar2;
    }
    /**
     * Gets a win when health is 0
     * @return win
     */
    public boolean isWin() {
        return win;
    }
    /**
     * Sets the win for one person
     * @param win 
     */
    public void setWin(boolean win) {
        this.win = win;
    }
    /**
     * Gets the player 1's font
     * @return p1Font
     */
    public BitmapFont getP1Font() {
        return p1Font;
    }
    /**
     * Sets the player 1's font
     * @param p1Font 
     */
    public void setP1Font(BitmapFont p1Font) {
        this.p1Font = p1Font;
    }
    /**
     * Gets the player 2's font
     * @return p1Font
     */
    public BitmapFont getP2Font() {
        return p2Font;
    }
    /**
     * Sets the player 2's font
     * @param p2Font 
     */
    public void setP2Font(BitmapFont p2Font) {
        this.p2Font = p2Font;
    }
    /**
     * Gets the color green
     * @return green
     */
    public Color getGreen() {
        return green;
    }
    /**
     * Sets the color green
     * @param green 
     */
    public void setGreen(Color green) {
        this.green = green;
    }
    /**
     * Gets the color orange
     * @return  orange
     */
    public Color getOrange() {
        return orange;
    }
    /**
     * Sets the color orange
     * @param orange 
     */
    public void setOrange(Color orange) {
        this.orange = orange;
    }

    /**
     * getter, gets the main game
     * @return returns the game
     */
    public Main getGame() {
        return game;
    }
    /**
     * Setter, sets the game for the user
     * @param game 
     */
    public void setGame(Main game) {
        this.game = game;
    }
    
    

}
