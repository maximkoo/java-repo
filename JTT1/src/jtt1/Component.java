/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt1;

/**
 *
 * @author max
 */
public class Component {
    public Component(GameEntity ge){
        ge.registerComponent(this);
    };
    
    public void process(GameEntity ge){
        //To be overridden
    };
}
