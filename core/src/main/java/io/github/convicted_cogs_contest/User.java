/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;

/**
 *
 * @author gongm
 */
public class User {
    String name;
    int wins;
    
    public User(String name, int wins) {
        this.name = name;
        this.wins = wins;
    }
    
    public String getName() {
        return name;
    }
    
    public int getWins() {
        return wins;
    }
    
    public void addWins(int win) {
        wins += win;
    }
    
    public String toString() {
        return "Name: " + name + "        Wins:" + wins;
    }
}
