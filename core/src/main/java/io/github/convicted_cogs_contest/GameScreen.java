package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import java.util.ArrayList;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class GameScreen implements Screen {

    FitViewport viewport;
    Character sol1;
    Character sol2;

    Main game;

    public GameScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        //setScreen(new Titlev2(this));
        viewport = new FitViewport(1600, 900);
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
        //45
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
        ArrayList<Integer> punch2 = new ArrayList<Integer>();
        punch2.add(3);
        punch2.add(4);
        punch2.add(5);

        attack2.add(new Move("punch2.png", 7, 220, 279, -102, 20, new Rectangle(0, 0, 90, 300), punch2));
        attack2.add(new Move("kick1.png", 8, 278, 280, -123, 40, new Rectangle(0, 0, 110, 100), kick));
        sol1 = new Character(game.spriteBatch, movement1, attack1);
        sol2 = new Character(game.spriteBatch, movement2, attack2);
        sol1.move(300, 0);
        sol2.move(1600 - sol2.getWidth() - 300, 0);

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

        float delta = Gdx.graphics.getDeltaTime();
        if (sol1.getStun() == false) {
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                sol1.moveForward();
            } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                sol1.moveBackward();
                //sol1.Block();
            } else if (Gdx.input.isKeyPressed(Input.Keys.O)) {
                sol1.attack(0);
            } else if (Gdx.input.isKeyPressed(Input.Keys.P)) {
                sol1.attack(1);
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                sol1.Block();
            } else {
                sol1.notMove();
                sol1.blocking = false;
            }
        }

        if (sol2.getStun() == false) {
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                sol2.moveForward();
            } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                sol2.moveBackward();
                //sol2.Block();
            } else if (Gdx.input.isKeyPressed(Input.Keys.N)) {
                sol2.attack(0);
            } else if (Gdx.input.isKeyPressed(Input.Keys.M)) {
                sol2.attack(1);
            } else {
                sol2.notMove();
            }
        }
    }

    public void logic() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        if (sol1.attacking == true) {
            Rectangle hurtbox = sol1.attack.get(sol1.attackIndex).dealDamage(sol1.xPos + 90, sol1.yPos);
            if (hurtbox.overlaps(sol2.hitbox)) {
                sol2.isHit(true, sol1.attack.get(sol1.attackIndex).getDamage());
                System.out.println("hit");
            }
        }

        if (sol2.attacking == true) {
            Rectangle hurtbox = sol2.attack.get(sol2.attackIndex).dealDamage(sol2.xPos - 90, sol2.yPos);
            if (hurtbox.overlaps(sol1.hitbox)) {
                sol1.isHit(true, sol2.attack.get(sol2.attackIndex).getDamage());
                System.out.println("hit");
            }
        }
//        float character1Width = sol1.getWidth();
//        float character1Height = sol1.getHeight();
        //character1Sprite.setX(MathUtils.clamp(character1Sprite.getX(), 0, worldWidth - character1Width));
    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();
        System.out.println(sol1.getHealth());
        float worldHeight = viewport.getWorldHeight();
        float worldWidth = viewport.getWorldWidth();
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

}
