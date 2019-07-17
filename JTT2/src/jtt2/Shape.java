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
    protected int xSize=0;
    protected int ySize=0;  
    protected int xPos=0;
    protected int yPos=0;
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
        this.move("down"); //--<<---!!!
        System.out.println("Shape processed, class="+this.getClass().getName());   
        Integer maxY=(Integer)coords.stream().max((a1,a2)->(Integer)a1.get("y")>(Integer)a2.get("y")?1:-1).get().get("y");
        System.out.println(maxY);
        if (maxY>10) {
            //obj.informObjects("Landed");
            obj.informObjectsPayload("Landed", (Object)coords);
        }
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.red);
        for (HashMap i:coords){
            g.fillRect(xPos*scale+(Integer)i.get("x")*scale, yPos*scale+(Integer)i.get("y")*scale, scale, scale);
        }
    }
    
    @Override
    public void inform(String message){ //notify
        if (message.equals("move_left")){this.move("left");}
        if (message.equals("move_right")){this.move("right");}
        if (message.equals("rotate")){this.rotate();}
    };
    
    public void printCoords(){
        for (HashMap i:coords){
            System.out.println("x="+i.get("x")+", y="+i.get("y"));
        }
    }
    
    public void move(String dir){
        int xShift=0; int yShift=0;
        if (dir.equals("up")){xShift=0; yShift=-1;}
        if (dir.equals("down")){xShift=0; yShift=1;}
        if (dir.equals("left")){xShift=-1; yShift=0;}
        if (dir.equals("right")){xShift=1; yShift=0;}
        xPos+=xShift;
        yPos+=yShift;
//        for (HashMap i:coords){
//            i.put("x",(Integer)i.get("x")+xshift);
//            i.put("y",(Integer)i.get("y")+yshift);
//        }
        //System.out.println("----");
        //for (HashMap i:coords){
        //    System.out.println("x="+i.get("x")+", y="+i.get("y"));
        //}
        //System.out.println("----");
        //repaint();
    }   
    
    public void rotate(){
        //coords.stream().map(i->XSize-(Integer)(i.get("y")), (Integer)i.get(x)    )
        for (HashMap i:coords){
            int xs=(Integer)(i.get("x"));
            i.put("x", (xSize-1)-(Integer)(i.get("y")));
            i.put("y", xs);
        }
        System.out.println("Rotated");
        printCoords();
    }
}
