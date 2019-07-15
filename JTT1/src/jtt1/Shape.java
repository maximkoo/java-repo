/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author max
 */
public class Shape implements GameEntity{
    protected int XSize;
    protected int YSize;    
    protected List<HashMap> coords=new ArrayList<HashMap>();    
    protected int shapeColor;
    List<Component> components=new ArrayList<Component>();
    List<Observer> observers=new ArrayList<Observer>();
    
    public Shape(){
        System.out.println("Shape created");
    };
    
    public Shape(List entities){
        entities.add(this);
        System.out.println("Shape of type "+this.getClass().getName()+" created and added to Game Entities");
        //components.add(new ShapePhysics());
        //components.add(new ShapeGraphics());
        //HashMap<String, Integer> h=new HashMap<>();
        //h.put("x",1);
        //h.put("y",2);
        //coords.add(h);
    };    
    
    @Override
    public void process(){
        System.out.println("Shape processed, class="+this.getClass().getName());        
        //printCoords();
        for (Component i:components){
            i.process(this);
        }
    }
    
    public void printCoords(){
        for (HashMap i:coords){
            System.out.println("x="+i.get("x")+", y="+i.get("y"));
        }
    }
    
    public void registerComponent(Component c){
        components.add(c);
    } 
    
    public void registerObserver(Observer o){
        observers.add(o);
    }       
    
    private void notifyObservers(String param){
        for (Observer i:observers){
            i.notify(param);
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
