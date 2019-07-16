/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

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
     
    public Still(ObjectPool obj){
        super(obj);
        this.obj=obj;
    }
    
    public void addShapeToStill(List<HashMap> shapeCoords){
        coords.addAll(shapeCoords);
    }
    
    @Override
    public void process(){
        System.out.println("Entity processed, class="+this.getClass().getName());     
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
            addShapeToStill((List<HashMap>)payload);
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
}
