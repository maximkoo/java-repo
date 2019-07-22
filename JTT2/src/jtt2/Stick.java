package jtt2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author max
 */
import java.util.HashMap;

public class Stick extends Shape{
    public Stick(ObjectPool obj){
        super(obj);
        xSize=5;
        ySize=4;
        yPos=0;
        HashMap<String, Integer> h;
        h=new HashMap<>(); h.put("x", 2); h.put("y", 1); coords.add(h);
        h=new HashMap<>(); h.put("x", 2); h.put("y", 2); coords.add(h);
        h=new HashMap<>(); h.put("x", 2); h.put("y", 3); coords.add(h);
        h=new HashMap<>(); h.put("x", 2); h.put("y", 4); coords.add(h);
        System.out.println("Stick created and added to Game Entities");
    }
}