/*
Yirui Gong
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
     * Adds wins to a user
     * @param winNum win number to add to
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
     * Clone method
     * @return a cloned user
     */
    public User clone() {
        return new User(name, winNum);
    }
    
    /**
     * Equals method
     * @param u - User to compare to
     * @return is equal true or false boolean
     */
    public boolean equals(User u) {
        if (name.equals(u.name) && winNum == u.winNum) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * A string that will show on the leader board
     * @return returns a string
     */
    public String toString() {
        return "Name: " + name + "     " + "Wins: " + winNum;
    }
}
