/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jtt2;

import java.awt.Color;
import java.awt.Graphics;

/* @author kopa */
public class GameField extends GameEntity{

    private final ObjectPool obj;
    int gfXSize=20; int gfYSize=40;
    int scale=10;

    public GameField(ObjectPool obj) {
        super(obj);
        this.obj=obj;
    }

    @Override
    public void process(){}
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        for (int i=0; i<gfYSize; i++){
            g.fillRect(0, i*scale, scale, scale);
            g.fillRect(gfXSize*scale, i*scale, scale, scale);
        }
        for (int i=0; i<=gfXSize; i++){
            g.fillRect(i*scale, gfYSize*scale, scale, scale);
        }
    }
}
