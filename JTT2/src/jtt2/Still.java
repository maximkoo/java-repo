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
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author max
 */
public class Still extends GameEntity{
    private final ObjectPool obj;
    protected List<HashMap> coords=new ArrayList<>();
    //////////////
//        int xSize=10;
//        int ySize=10;
        int xPos=0;
        int yPos=0;
        int scale=Constants.scale;
    
    /////////////
    public Still(ObjectPool obj){
        super(obj);
        this.obj=obj;
        ////
//        HashMap<String, Integer> h;
//        h=new HashMap<>(); h.put("x", 0); h.put("y", 0); coords.add(h);
//        h=new HashMap<>(); h.put("x", 1); h.put("y", 0); coords.add(h);
//        h=new HashMap<>(); h.put("x", 0); h.put("y", 1); coords.add(h);
//        h=new HashMap<>(); h.put("x", 1); h.put("y", 1); coords.add(h); 
//        h=new HashMap<>(); h.put("x", 2); h.put("y", 0); coords.add(h);
//        h=new HashMap<>(); h.put("x", 3); h.put("y", 0); coords.add(h);
//        h=new HashMap<>(); h.put("x", 2); h.put("y", 1); coords.add(h);
//        h=new HashMap<>(); h.put("x", 3); h.put("y", 1); coords.add(h); 
        ////
    }
    
    public void addShapeToStill(List<HashMap> shapeCoords){
        coords.addAll(shapeCoords);
    }
    
     public void addShapeToStill(Shape shape){
        for (HashMap i:shape.getCoords()){
            HashMap h=new HashMap();
            h.put("x",(Integer)(shape.getXPos())+(Integer)i.get("x"));h.put("y",(Integer)(shape.getYPos())+(Integer)i.get("y"));
            coords.add(h);
        }
    }
    
    @Override
    public void process(){
        System.out.println("Entity processed, class="+this.getClass().getName());     
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        for (HashMap i:coords){
            g.fillRect(/*xPos*scale+*/(Integer)i.get("x")*scale, /*yPos*scale+*/(Integer)i.get("y")*scale, scale, scale);
        }
    }
    
    @Override
    public List<HashMap> getCoords(){
        return coords;
    }
    
    @Override
    public void inform(String message){
        if (message.equals("Landed")){
            System.out.println("Landed received");
            //checkSolidLine();
            //getCountXGroupByY();
        }
    }
    
    @Override
    public void informPayload(String message, Object payload){
        if (message.equals("Landed")){
            System.out.println("Landed received + payload");
            //checkSolidLine();
            //addShapeToStill((List<HashMap>)payload);
            addShapeToStill((Shape)payload);
            System.out.println("Still size="+coords.size());
            getCountXGroupByY();
        }
    }
    
    public void checkSolidLine(){
        List<HashMap> srt = new ArrayList<>();
        srt=coords;
        srt.sort((h1,h2)->compareCellsByYX(h1,h2));
       
        System.out.println("SORTED!"+srt.size());
        for (HashMap i:srt){
            System.out.println("x="+i.get("x")+", y="+i.get("y"));
        }
         System.out.println("SORTED2!");
    }

    private void getCountXGroupByY(){
        Map<Integer, Long> grouped=coords.stream().collect(Collectors.groupingBy(foo->(Integer)(foo.get("y")), Collectors.counting()));
        System.out.println("Grouped! Size="+grouped.size());
        System.out.println(grouped.toString());
    }
    
    private void getDistinctY(){
    
    };
    
    private void getAllXByY(){
    
    }
    
    private int compareCellsByYX(HashMap h1, HashMap h2){
        if ((Integer)h1.get("y")>(Integer)h2.get("y")){return 1;}
        else if ((Integer)h1.get("y")==(Integer)h2.get("y") && (Integer)h1.get("x")>(Integer)h2.get("x")){return 1;}
        else return -1;
    }
    
    public int getXPos(){
        return xPos;
    }

    public int getYPos(){
        return yPos;
    }
}
