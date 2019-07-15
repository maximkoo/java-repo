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
public class Still extends GameEntity{
    private final ObjectPool obj;
     
    public Still(ObjectPool obj){
        super(obj);
        this.obj=obj;
    }
    
    @Override
    public void process(){
        System.out.println("Entity processed, class="+this.getClass().getName());     
    }
    
    @Override
    public void inform(String message){
        if (message.equals("Landed")){
            System.out.println("Landed received");
        }
    }
}
