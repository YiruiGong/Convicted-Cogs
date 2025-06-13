/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.convicted_cogs_contest;


public class User {
    //Initilize Attributes
    private String name;
    int winNum;
    
    /**
     * Primary Constructor
     * @param name name of the user
     * @param winNum how many times that user had won
     */
    public User(String name, int winNum) {
        this.name = name;
        this.winNum = winNum;
    }
    /**
     * Getter, gets the name of the user
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Getter, gets the amount of wins from a specific user
     * @return 
     */
    public int getWinNum() {
        return winNum;
    }
    
    /**
     * Setter, Adds wins to a user
     * @param winNum 
     */
    public void addWinNum(int winNum) {
        this.winNum += winNum;
    }
    /**
     * Setter, Sets the name of the user in the winners file
     * @param name name of the user
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Setter, sets the amount of wins on a user
     * @param winNum 
     */
    public void setWinNum(int winNum) {
        this.winNum = winNum;
    }
    
    /**
     * A string that will show on the leader board
     * @return returns a string
     */
    public String toString() {
        return "Name: " + name + "     " + "Wins: " + winNum;
    }
}
