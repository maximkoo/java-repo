/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt2;

/**
 *
 * @author max
 */
public class Score extends GameEntity{

    private final ObjectPool obj;
     
    public Score(ObjectPool obj){
        super(obj);
        this.obj=obj;
    }
    
    @Override
    public void process(){
        //System.out.println("Entity processed, class="+this.getClass().getName());     
    }
}
