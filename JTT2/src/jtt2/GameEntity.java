/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.Graphics;

/**
 *
 * @author max
 */
class GameEntity {
    public GameEntity(ObjectPool obj){
        obj.registerEntity(this);
    };
    
    public void process(){
    };
    
    public void inform(String message){
        
    }
    
    public void draw(Graphics g){
        
    }
}
