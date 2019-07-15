/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class Score implements GameEntity{
    private int scoreValue=0;
    List<Component> components=new ArrayList<Component>();
    
    public Score(){
        System.out.println("Score created");
    };
    
    public void process(){
        System.out.println("Score processed");
    }
    
    public Score(List entities){
        entities.add(this);
        System.out.println("Score created and added to Game Entities");
    }; 
    
    public void incScoreValue(int i){
        scoreValue+=i;
    }
    
    public int getScoreValue(){
        return scoreValue;
    }

    @Override
    public void registerComponent(Component c) {
        components.add(c);
    }
}
