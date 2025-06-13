/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;


public class User {
    private String name;
    int winNum;
    
    public User(String name, int winNum) {
        this.name = name;
        this.winNum = winNum;
    }
    
    public String getName() {
        return name;
    }
    
    public int getWinNum() {
        return winNum;
    }
    
    public void addWinNum(int winNum) {
        this.winNum += winNum;
    }
    
    public String toString() {
        return "Name: " + name + "     " + "Wins: " + winNum;
    }
}
