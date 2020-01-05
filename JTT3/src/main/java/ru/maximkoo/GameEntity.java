/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.maximkoo;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author max
 */
abstract class GameEntity {
    public GameEntity(ObjectPool obj){
        obj.registerEntity(this);
    };
    
    public void process(){
    };
    
    public void inform(String message){
    };
    
    public void informPayload(String message, Object payload){
    };    
    
    public void draw(Graphics g){
        
    }
    
    public List<HashMap> getCoords(){
        return new ArrayList<HashMap>();
    }
    
    public int getXPos(){
        return 0;
    }

    public int getYPos(){
        return 0;
    }
   
}
