/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import javax.swing.JFrame;

/**
 *
 * @author max
 */
public class JTT2 {
    boolean go=true;
    private JFrame f=new JFrame(); 
    int gfXSize=10; int gfYSize=20;
    
    ObjectPool obj=new ObjectPool();
    public JPanel1 panel1=new JPanel1(obj);
    GameEntity a;
    public JTT2(){
    a=new Score(obj);
    //a=new Cube(obj);
    a=new TShape(obj);
    
    a=new Still(obj);
        
    f.setSize(500,500);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(panel1);
    f.setVisible(true);
        
    f.addKeyListener(new KeyListener1());
    
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = c1;
    c2.add(Calendar.SECOND, 1);
    int i=0;
    System.out.println("Total "+obj.getEntities().size()+" entities");
    while(go){
        c1 = Calendar.getInstance();
        if (c1.compareTo(c2)>0){            
            //panel1.repaint();
            runEntities();
            panel1.repaint();
            System.out.println(c1.getTime());
            c2=c1;
            c2.add(Calendar.SECOND, 1);
            i++;            
        }
        if (i>10){go=false;}        
            //{a=new TShape(obj);}
        }        
    };
    
    private void runEntities(){
        for (GameEntity i:obj.getEntities()){
            i.process();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        JTT2 j= new JTT2();
    }

    private class KeyListener1 implements KeyListener {

        public KeyListener1() {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_LEFT) {obj.informObjects("move_left");}
            if (e.getKeyCode()==KeyEvent.VK_RIGHT) {obj.informObjects("move_right");}
            panel1.repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
    
}
