/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.Color;
import java.util.HashMap;

public class TShape extends Shape{
    public TShape(ObjectPool obj){
        super(obj);
        xSize=3;
        ySize=3;        
        yPos=0;
        HashMap<String, Integer> h;
        shapeColor=Color.GRAY; 
        h=new HashMap<>(); h.put("x", 1); h.put("y", 0); coords.add(h);
        h=new HashMap<>(); h.put("x", 1); h.put("y", 1); coords.add(h);
        h=new HashMap<>(); h.put("x", 1); h.put("y", 2); coords.add(h);
        h=new HashMap<>(); h.put("x", 2); h.put("y", 1); coords.add(h);
        System.out.println("TShape created and added to Game Entities");      
    }
}