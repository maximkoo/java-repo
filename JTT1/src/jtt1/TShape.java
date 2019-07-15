/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt1;

import java.util.HashMap;
import java.util.List;

public class TShape extends Shape{
    public TShape(List entities){
        super(entities);
        XSize=3;
        YSize=3;
        HashMap<String, Integer> h;
        h=new HashMap<>(); h.put("x", 1); h.put("y", 0); coords.add(h);
        h=new HashMap<>(); h.put("x", 1); h.put("y", 1); coords.add(h);
        h=new HashMap<>(); h.put("x", 1); h.put("y", 2); coords.add(h);
        h=new HashMap<>(); h.put("x", 2); h.put("y", 1); coords.add(h);
        System.out.println("TShape created and added to Game Entities");
        //printCoords();
        //entities.add(this);        
    }
}