/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class ObjectPool {
    private final List<GameEntity> entities = new ArrayList<>();
    
    public void registerEntity(GameEntity e){
        entities.add(e);
        System.out.println("Game entity of type "+e.getClass().getName()+" created and added to Game Entities");
    }
    
    public void informObjects(String message){
        for (GameEntity i: entities){
            i.inform(message);
        }
    }
    
    public void informObjectsPayload(String message, Object payload){
        for (GameEntity i: entities){
            i.informPayload(message, payload);
        }
    }
    
    public void drawObjects(Graphics g){
        for (GameEntity i: entities){
            i.draw(g);
        }
    }
    
    public List<GameEntity> getEntities(){
        return entities;
    }
}
