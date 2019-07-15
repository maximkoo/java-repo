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
public class ShapeGraphics extends Component{

    public ShapeGraphics(GameEntity ge) {
        super(ge);
    }

    @Override
    public void process(GameEntity ge) {
        System.out.println("Shape graphics ");
    }
    
}
