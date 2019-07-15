/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtt1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class GameField implements GameEntity{
    List<Component> components=new ArrayList<Component>();
    
    @Override
    public void process() {
    }

    @Override
    public void registerComponent(Component c) {
        components.add(c);
    }
    
}
