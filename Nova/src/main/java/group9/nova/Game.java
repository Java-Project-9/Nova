/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nova;

/**
 *
 * @author xxcoo
 */
public class Game {
    private String title;
    
    public Game(String title){
        this.title = title;
    }
    
    public void setGameName(String title){
        this.title = title;
    }
   
    public String getGameName(){
        return title;
    }
    
    public void callGame(String title){
        System.out.printf("Now playing game %s...", title);
    }
    
    public void deleteGame(String title){
        this.title = null;
        System.out.println("Game is now deleted.");
    }
}
