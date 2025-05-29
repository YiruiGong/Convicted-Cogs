/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

import java.util.ArrayList;

public class Character {
    int health;
    ArrayList<Move> attacks;
    boolean block;

    public Character(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public boolean isBlock() {
        return block;
    }
    
    
    
}
