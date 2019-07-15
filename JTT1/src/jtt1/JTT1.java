/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author max
 */
public class JTT1 {

    //private GameEntity[] entities;
    private final List<GameEntity> entities = new ArrayList<>();
    boolean go=true;
    private JFrame f=new JFrame();
    public JPanel1 panel1=new JPanel1();
    
    public void registerEntity(GameEntity e){
        entities.add(e);
    };
    
    public JTT1(){
        //Calendar calendar = Calendar.getInstance(); // gets a calendar using the default time zone and locale.
        //calendar.add(Calendar.SECOND, 5);
        //System.out.println(calendar.getTime());
        //registerEntity(new Shape());
        //registerEntity(new Score());
        //registerEntity(new Shape(entities));
        //registerEntity(new Score(entities));
        //registerEntity(new Cube(entities));
        //registerEntity(new TShape(entities));
        GameEntity a;
            a=new Score(entities);
            //a=new Cube(entities);
            a=new TShape(entities);
        
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel1);
        f.setVisible(true);
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = c1;
        c2.add(Calendar.SECOND, 1);
        int i=0;
        System.out.println("Total "+entities.size()+" entities");
        while(go){
            c1 = Calendar.getInstance();
            if (c1.compareTo(c2)>0){
                runEntities();
                System.out.println(c1.getTime());
                c2=c1;
                c2.add(Calendar.SECOND, 1);
                i++;
            }
            if (i>10){go=false;}
        }        
    };
    
    private void runEntities(){
        for (GameEntity i:entities){
            i.process();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        JTT1 j= new JTT1();
    }
    
    
}
