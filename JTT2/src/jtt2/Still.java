/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author max
 */
public class Still extends GameEntity{
    private final ObjectPool obj;
    protected List<HashMap> coords=new ArrayList<>();
     
    public Still(ObjectPool obj){
        super(obj);
        this.obj=obj;
    }
    
    public void addShapeToStill(List<HashMap> shapeCoords){
        coords.addAll(shapeCoords);
    }
    
    @Override
    public void process(){
        System.out.println("Entity processed, class="+this.getClass().getName());     
    }
    
    @Override
    public void inform(String message){
        if (message.equals("Landed")){
            System.out.println("Landed received");
        }
    }
}
