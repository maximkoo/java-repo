/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.Color;
import java.util.HashMap;

public class Cube extends Shape{
    public Cube(ObjectPool obj){
        super(obj);
        xSize=2;
        ySize=2;
        yPos=0;
        shapeColor=Color.RED;
        HashMap<String, Integer> h;
        h=new HashMap<>(); h.put("x", 0); h.put("y", 0); coords.add(h);
        h=new HashMap<>(); h.put("x", 1); h.put("y", 0); coords.add(h);
        h=new HashMap<>(); h.put("x", 0); h.put("y", 1); coords.add(h);
        h=new HashMap<>(); h.put("x", 1); h.put("y", 1); coords.add(h);
        System.out.println("Cube created and added to Game Entities");
    }
}
