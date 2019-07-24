/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author max
 */
public class Corner1 extends Shape{
    public Corner1(ObjectPool obj){
        super(obj);
        xSize=3;
        ySize=3;
        yPos=0;        
        shapeColor=Color.ORANGE;
        HashMap<String, Integer> h;
        h=new HashMap<>(); h.put("x", 0); h.put("y", 0); coords.add(h);
        h=new HashMap<>(); h.put("x", 1); h.put("y", 0); coords.add(h);
        h=new HashMap<>(); h.put("x", 0); h.put("y", 1); coords.add(h);
        h=new HashMap<>(); h.put("x", 0); h.put("y", 2); coords.add(h);
        System.out.println("Corner1 (Г) created and added to Game Entities");
    }
}