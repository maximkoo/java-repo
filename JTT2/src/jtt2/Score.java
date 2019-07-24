/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

/**
 *
 * @author max
 */
public class Score extends GameEntity{

    private final ObjectPool obj;
    private int score=0; 
    private int shapesDropped=0;
    private int linesDropped=0;
     
    public Score(ObjectPool obj){
        super(obj);
        this.obj=obj;
    }
    
    @Override
    public void process(){
        //System.out.println("Entity processed, class="+this.getClass().getName());     
    }
    
    @Override
    public void inform(String message){ //notify
        //System.out.println(message+" is received");
        //if (message.equals("Shape Dropped")){
        if (message.equals("Landed")){
        //if (Objects.equals(message, "Shape Dropped")){
            shapesDropped+=1;
            System.out.println("Shape Dropped received");
        }             
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawString("Score: "+score, 5, Constants.gfYSize*Constants.scale+Constants.scale*2);
        g.drawString("Shapes dropped: "+shapesDropped, 5, Constants.gfYSize*Constants.scale+Constants.scale*4);
        g.drawString("Lines dropped: "+linesDropped, 5, Constants.gfYSize*Constants.scale+Constants.scale*6);
    }
    
    @Override
    public void informPayload(String message, Object payload){
        if (message.equals("Landed")){
            shapesDropped+=1;
            System.out.println("Score: Landed received");
        }       
        if (message.equals("Line Dropped")){
            linesDropped+=(int)payload;
            score+=(int)payload*(int)payload;
        } 
    }; 
}
