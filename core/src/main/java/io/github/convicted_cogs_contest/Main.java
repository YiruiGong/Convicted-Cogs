/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Administrator
 */
public class Main extends Game {

    int screen = 1;
    public SpriteBatch spriteBatch;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        if (screen == 0) {
            this.setScreen(new TitleScreen(this));

        } else {
            this.setScreen(new GameScreen(this));

        }
    }

    @Override
    public void render() {
        super.render();
    }
}
