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
public interface GameEntity {
    public void registerComponent(Component c);
    public void process();
}
