/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author max
 */
public class ObjectPool {
    private final List<GameEntity> entities = new CopyOnWriteArrayList<>();
    public ShapeFactory shapeFactory;
    boolean gameOver=false;
    
    public void registerEntity(GameEntity e){
        entities.add(e);
        //System.out.println("Game entity of type "+e.getClass().getName()+" created and added to Game Entities");
    }
    
    public void informObjects(String message){
        for (GameEntity i: entities){
            i.inform(message);
            //System.out.println(i.getClass().getSimpleName() + " informed with message: "+message);
        }
    }
    
    public void informObjectsPayload(String message, Object payload){
        for (GameEntity i: entities){
            i.informPayload(message, payload);
            //System.out.println(i.getClass().getSimpleName() + " informed with message: "+message);
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
    
    public boolean checkIntersection(int xPos, int yPos, List<HashMap> c){
        boolean result=true;        
        for (GameEntity g: entities){
            if (!g.getClass().getSimpleName().equals("Still")) continue;
            //System.out.println("Still entity detected");
            for (HashMap i:c){
                for (HashMap j:g.getCoords()){
//                    System.out.println("x1="+((int)xPos+(int)(i.get("x"))));
//                    System.out.println("x2="+((int)g.getXPos()+(int)(j.get("x"))));
//                    System.out.println("y1="+((int)yPos+(int)(i.get("y"))));
//                    System.out.println("y2="+((int)g.getYPos()+(int)(j.get("y"))));
//                    System.out.println("---");
                    if (((int)xPos+(int)(i.get("x")))==(((int)g.getXPos()+(int)(j.get("x")))) && (yPos+(int)(i.get("y")))==(((int)g.getYPos()+(int)(j.get("y"))))){
                        result=false;
                        System.out.println("Intersection detected");
                    }
                }
                //System.out.println("-------");
            }
        }
        return result;
    }
    
    public void setShapeFactory(ShapeFactory fac){
        this.shapeFactory=fac;
    };
    
    public void generate(){
        removeShapeEntities();
        if (gameOver){return;}        
        Shape q=shapeFactory.generate();
        //System.out.println("Object pool has generated a new shape, of type ");//+q.getClass().getSimpleName());
    }
    
    public void removeShapeEntities(){
        entities.removeIf(q->q.getClass().getSuperclass().getSimpleName().equals("Shape"));
    }
    
    public void setGameOver(){
        gameOver=true;
    } 
    
    public boolean getGameOver(){
        return gameOver;
    } 
}
