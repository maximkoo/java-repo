/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.maximkoo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/* @author kopa */
public class GameField extends GameEntity{

    private final ObjectPool obj;
    int gfXSize=Constants.gfXSize; 
    int gfYSize=Constants.gfYSize;
    int scale=Constants.scale;
    boolean gameOver=false;

    public GameField(ObjectPool obj) {
        super(obj);
        this.obj=obj;
    }

    @Override
    public void process(){}
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        for (int i=0; i<gfYSize; i++){
            g.fillRect(0, i*scale, scale, scale);
            g.fillRect(gfXSize*scale, i*scale, scale, scale);
        }
        for (int i=0; i<=gfXSize; i++){
            g.fillRect(i*scale, gfYSize*scale, scale, scale);
        }
        if (obj.getGameOver()){
            g.setColor(Color.red);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            //g.setFont(new Font("Times New Roman", Font.BOLD, 20));
            g.drawString("GAME OVER", 80,100);
        }
    }
    
    @Override
    public void inform(String message){ //notify
        if (message.equals("Game over")){
            //gameOver=true;
            obj.setGameOver();} 
    };
}
