/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author max
 */
public class Shape extends GameEntity{
    protected int XSize;
    protected int YSize;   
    protected Integer scale=10;
    protected List<HashMap> coords=new ArrayList<>();    
    protected int shapeColor;
    private final ObjectPool obj;
    public Shape(ObjectPool obj){
        super(obj);
        this.obj=obj;
    }
    
    @Override
    public void process(){
        this.move("down");
        System.out.println("Shape processed, class="+this.getClass().getName());   
        //int maxY=coords.entrySet().stream().max((entry1, entry2)->entry1.getValue()>entry2.getValue()? 1: -1).get().getValue();
        Integer maxY=(Integer)coords.stream().max((a1,a2)->(Integer)a1.get("y")>(Integer)a2.get("y")?1:-1).get().get("y");
        System.out.println(maxY);
        if (maxY>10) {
            obj.informObjects("Landed");
        }
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        for (HashMap i:coords){
            g.fillRect((Integer)i.get("x")*scale, (Integer)i.get("y")*scale, scale, scale);
        }
    }
    
    public void inform(){ //notify
    };
    
    public void printCoords(){
        for (HashMap i:coords){
            System.out.println("x="+i.get("x")+", y="+i.get("y"));
        }
    }
    
    public void move(String dir){
        int xshift=0; int yshift=0;
        if (dir.equals("up")){xshift=0; yshift=-1;}
        if (dir.equals("down")){xshift=0; yshift=1;}
        if (dir.equals("left")){xshift=-1; yshift=0;}
        if (dir.equals("right")){xshift=1; yshift=0;}
        for (HashMap i:coords){
            i.put("x",(Integer)i.get("x")+xshift);
            i.put("y",(Integer)i.get("y")+yshift);
        }
        System.out.println("----");
        for (HashMap i:coords){
            System.out.println("x="+i.get("x")+", y="+i.get("y"));
        }
        System.out.println("----");
        //repaint();
    }    
}
