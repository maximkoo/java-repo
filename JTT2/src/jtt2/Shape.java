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
    int xPos=10;
    int yPos=10;
    protected int nextXPos;
    protected int nextYPos;
    protected int scale=10;
    protected List<HashMap> coords=new ArrayList<>();    
    protected int shapeColor;
    private final ObjectPool obj;
    public Shape(ObjectPool obj){
        super(obj);
        this.obj=obj;
    }
    
    @Override
    public void process(){
        //this.move("down"); //--<<---!!!
        this.fall();
        System.out.println("Shape processed, class="+this.getClass().getName());   
        Integer maxY=(Integer)coords.stream().max((a1,a2)->(Integer)a1.get("y")>(Integer)a2.get("y")?1:-1).get().get("y");
        System.out.println("maxY="+(yPos+maxY));
        //if (yPos+maxY>Constants.gfYSize-1) {
            //obj.informObjects("Landed");
            //obj.informObjectsPayload("Landed", (Object)coords);
        //}
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.red);
        for (HashMap i:coords){
            g.fillRect(xPos*scale+(Integer)i.get("x")*scale, yPos*scale+(Integer)i.get("y")*scale, scale, scale);
        }
    }
    
    @Override
    public List<HashMap> getCoords(){
        return coords;
    }
    
    @Override
    public void inform(String message){ //notify
        if (message.equals("move_left")){this.move("left");}
        if (message.equals("move_right")){this.move("right");}
        if (message.equals("rotate")){this.rotate();}
        if (message.equals("drop")){this.drop();}
    };
    
    public void printCoords(){
        for (HashMap i:coords){
            System.out.println("x="+i.get("x")+", y="+i.get("y"));
        }
    }
    
    public void move(String dir){ 
        Integer[] a=move(dir, new Integer[]{xPos,yPos});
        
        //if (!checkMovement(dir, xPos, yPos, coords)) return;
        if (!checkBorder(a[0], a[1], coords)) return;
        if (!checkOnStill(a[0], a[1], coords)) return;    
        //if (!checkOnStill(nextXPos, nextYPos, coords)) return;    
        xPos=a[0];
        yPos=a[1];
        //xPos=nextXPos;
        //yPos=nextYPos;
    }   
    
    public void fall(){ 
        String dir="down";
        Integer[] a=move(dir, new Integer[]{xPos,yPos});
        
//        if (!checkMovement(dir, xPos, yPos, coords)) //return;
        if (!checkBorder(a[0], a[1], coords)) //return;
            {
                obj.informObjectsPayload("Landed", (Object)this);
                obj.generate();
                return;
            }
        if (!checkOnStill(a[0], a[1], coords)) //return;
            {
                obj.informObjectsPayload("Landed", (Object)this);
                obj.generate();
                return;
            }
        
        xPos=a[0];
        yPos=a[1];
        //xPos=nextXPos;
        //yPos=nextYPos;
    }   
    
    private Integer[] move(String dir, Integer[] pos){
        int xShift=0; int yShift=0;
        //if (dir.equals("up")){xShift=0; yShift=-1;}
        if (dir.equals("down")){xShift=0; yShift=1;}
        if (dir.equals("left")){xShift=-1; yShift=0;}
        if (dir.equals("right")){xShift=1; yShift=0;}
        //xPos+=xShift;
        pos[0]=pos[0]+xShift;
        pos[1]=pos[1]+yShift;
        //yPos+=yShift;
        nextXPos=pos[0]+xShift;
        nextYPos=pos[1]+yShift;
        return pos;
    }
    
    public void rotate(){
        List<HashMap> coords2=rotate(this.coords);
        
        //if (!checkRotation(this.coords)) return;
        if (!checkBorder(xPos, yPos, coords2)) return;
        if (!checkOnStill(xPos, yPos, coords2)) return;
        
        coords=coords2;
        System.out.println("Rotated");
        printCoords();
    }
    
    private List<HashMap> rotate(List<HashMap> coords){
        //coords.stream().map(i->XSize-(Integer)(i.get("y")), (Integer)i.get(x))
        List<HashMap> coords2=new ArrayList<HashMap>();
        
        for (HashMap i:coords){
            HashMap h=new HashMap();
            int xs=(Integer)(i.get("x"));
            h.put("x", (xSize-1)-(Integer)(i.get("y")));
            h.put("y", xs);
            coords2.add(h);
        }
        return coords2;
    }
    
    private boolean checkBorder(int xPos2, int yPos2, List<HashMap> coords2){
        boolean result=true; 
        for (HashMap i: coords2){
            if (xPos2+(Integer)(i.get("x"))<0+Constants.gfBorderLeft) result=false;
            if (xPos2+(Integer)(i.get("x"))>Constants.gfXSize-Constants.gfBorderRight) result=false;
            if (yPos2+(Integer)(i.get("y"))>Constants.gfYSize-Constants.gfBorderRight) result=false;
        } 
        return result; 
    }
    
//    private boolean checkMovement(String dir, int xPos, int yPos, List<HashMap> coords){
//        boolean result=true; 
//        Integer[] a=move(dir, new Integer[]{xPos,yPos});
//        int xPos2=a[0];
//        int yPos2=a[1];
//        for (HashMap i: coords){
//            if (xPos2+(Integer)(i.get("x"))<0+Constants.gfBorderLeft) result=false;
//            if (xPos2+(Integer)(i.get("x"))>Constants.gfXSize-Constants.gfBorderRight) result=false;
//            if (yPos2+(Integer)(i.get("y"))>Constants.gfYSize-Constants.gfBorderRight) result=false;
//        } 
//        return result; 
//    }
    
//    private boolean checkRotation(List<HashMap> coords){
//        boolean result=true; 
//        
//        List<HashMap> coords2=new ArrayList<HashMap>();
//        
//        //coords2.addAll(coords); //Так нельзя ((
//       
//        for (HashMap i:coords){//Клонирование вручную ))
//            HashMap c2=new HashMap();
//            c2.put("x",i.get("x"));
//            c2.put("y",i.get("y"));
//            coords2.add(c2);
//        }
//        coords2=rotate(coords2);
////        System.out.println("Coords2");
////        for (HashMap i:coords2){
////            System.out.println("x="+i.get("x")+", y="+i.get("y"));
////        }
//        for (HashMap i: coords2){
//            if (xPos+(Integer)(i.get("x"))<0+Constants.gfBorderLeft) result=false;
//            if (xPos+(Integer)(i.get("x"))>Constants.gfXSize-Constants.gfBorderRight) result=false;
//            if (yPos+(Integer)(i.get("y"))>Constants.gfYSize-Constants.gfBorderRight) result=false;
//        } 
//        return result; 
//    }
    
    private boolean checkOnStill(int xPos, int yPos, List<HashMap> c){
        boolean result=obj.checkIntersection(xPos, yPos, c);
        return result;
    }  
    
    private void drop(){
          do {
              //move("down");
              //fall();
              yPos+=1;
             }
          while ((checkBorder(xPos, yPos+1, coords) && checkOnStill(xPos, yPos+1, coords)));
    }
    
    public int getXPos(){
        return xPos;
    }

    public int getYPos(){
        return yPos;
    }
    
}
