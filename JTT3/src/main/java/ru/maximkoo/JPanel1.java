/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.maximkoo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author max
 */
public class JPanel1 extends JPanel{

    private final ObjectPool obj;
    public JPanel1(ObjectPool obj){
        super();
        this.obj=obj;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        obj.drawObjects(g);        
    }
}
