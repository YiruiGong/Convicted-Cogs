/*
Yirui Gong & Thomas Filsinger

*/
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
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

    Main game;

    public GameScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        //setScreen(new Titlev2(this));
        win = false;
        viewport = new FitViewport(1600, 900);
        background = new Texture("Lars_Canyon.png");
        healthUI = new Texture("healthUI.png");
        healthbar1 = new Texture("healthbar_1.png");
        healthbar2 = new Texture("healthbar_2.png");
        
        ArrayList<Animation> movement1 = new ArrayList<Animation>();
        movement1.add(new Animation("idle.png", 8, 144, 283, -14));
        movement1.add(new Animation("walkforward.png", 10, 214, 286, -80));
        movement1.add(new Animation("walkbackward.png", 8, 213, 281, -79));
        movement1.add(new Animation("hit1.png", 4, 271, 289, -159));
        movement1.add(new Animation("block.png", 5, 137, 280, -6));

        ArrayList<Move> attack1 = new ArrayList<Move>();
        
        ArrayList<Integer> punch = new ArrayList<Integer>();
        punch.add(3);
        punch.add(4);
        punch.add(5);
        
        ArrayList<Integer> kick = new ArrayList<Integer>();
        kick.add(4);
        kick.add(5);

        attack1.add(new Move("punch.png", 7, 220, 279, -28, 20, new Rectangle(0, 0, 90, 300), punch));
        attack1.add(new Move("kick1.png", 8, 278, 280, -65, 40, new Rectangle(0, 0, 110, 300), kick));

        ArrayList<Animation> movement2 = new ArrayList<Animation>();
        movement2.add(new Animation("idle2.png", 8, 144, 283, -40));
        movement2.add(new Animation("walkbackward2.png", 8, 213, 281, -44));
        movement2.add(new Animation("walkforward2.png", 10, 214, 286, -44));

        movement2.add(new Animation("hit2.png", 4, 271, 289, -22));
        movement2.add(new Animation("block2.png", 5, 137, 280, -41));

        ArrayList<Move> attack2 = new ArrayList<Move>();
        
        attack2.add(new Move("punch2.png", 7, 220, 279, -102, 20, new Rectangle (0, 0, 90, 300), punch));
        attack2.add(new Move("kick2.png", 8, 278, 280, -123, 40, new Rectangle(0, 0, 110, 100), kick));
        
        
        sol1 = new Character(game.spriteBatch, movement1, attack1);
        sol2 = new Character(game.spriteBatch, movement2, attack2);
        sol1.moveCharacter(500, 100);
        sol2.moveCharacter(1600 - sol2.getWidth() - 500, 100);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float f) {
        input();
        logic();
        draw();
    }

    public void input() {
        if (sol1.getStun() == false) {
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                sol1.moveRight();
            } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                sol1.moveLeft();
            } else if (Gdx.input.isKeyPressed(Input.Keys.O)) {
                sol1.attack(0);
            } else if (Gdx.input.isKeyPressed(Input.Keys.P)) {
                sol1.attack(1);
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            } else {
                sol1.notMove();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                sol1.setBlock(true);
            } else {
                sol1.setBlock(false);
            }
        }

        if (sol2.getStun() == false) {
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                sol2.moveRight();
            } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                sol2.moveLeft();
            } else if (Gdx.input.isKeyPressed(Input.Keys.N)) {
                sol2.attack(0);
            } else if (Gdx.input.isKeyPressed(Input.Keys.M)) {
                sol2.attack(1);
            } else {
                sol2.notMove();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                sol2.setBlock(true);
            } else {
                sol2.setBlock(false);
            }
        }
    }

    public void logic() {
        if (sol1.isAttacking() == true) {
            Rectangle hurtbox = sol1.getAttack().get(sol1.getAttackIndex()).dealDamage(sol1.getxPos() + 90, sol1.getyPos());
            if (hurtbox.overlaps(sol2.getHitbox())) {
                sol2.isHit(sol1.getAttack().get(sol1.getAttackIndex()).getDamage());
            }
        }

        if (sol2.isAttacking() == true) {
            Rectangle hurtbox = sol2.getAttack().get(sol2.getAttackIndex()).dealDamage(sol2.getxPos() - 90, sol2.getyPos());
            if (hurtbox.overlaps(sol1.getHitbox())) {
                sol1.isHit(sol2.getAttack().get(sol2.getAttackIndex()).getDamage());
            }
        }
        
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
        
        if (sol1.getHealth() == 0 || sol2.getHealth() == 0) {
            win = true;
        } else {
            win = false;
        }
    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        
        viewport.apply();
        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();
        game.spriteBatch.draw(background, 0, 0);
        game.spriteBatch.draw(healthUI, 0, 600);
        game.spriteBatch.draw(healthbar1, 100, 686, 0,0, (sol1.getHealth() * 6), 34);
        game.spriteBatch.draw(healthbar2, 1500 - (sol2.getHealth() * 6), 686, (600 - sol2.getHealth() * 6),0, 600, 34);
        System.out.println(sol1.getHealth());
        sol1.draw();
        sol2.draw();

        game.spriteBatch.end();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }
    
    public boolean getWin() {
        return win;
    }

}
