/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.maximkoo;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author kopa */
public class ShapeFactory {

    private final ObjectPool obj;
    String[] shapeTypes={"Cube", "TShape", "Stick", "Corner1", "Corner2", "ZShape1", "ZShape2"};
    public ShapeFactory(ObjectPool obj){
        this.obj=obj;
    }
    
    public Shape generate() {
        float a=(float) (Math.random()*shapeTypes.length);
        //System.out.println("a="+a);
        Shape s = null;//=new Shape(obj);
         try {
            s = (Shape)Class.forName("ru.maximkoo."+shapeTypes[(int)a]).getConstructor(ObjectPool.class).newInstance(obj);
        } catch (ClassNotFoundException ex) {
            System.out.println("Класс не найден!");
            Logger.getLogger(ShapeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ShapeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ShapeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ShapeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ShapeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ShapeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ShapeFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
