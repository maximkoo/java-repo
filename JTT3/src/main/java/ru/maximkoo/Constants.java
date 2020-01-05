/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.maximkoo;

/* @author kopa */
public class Constants {
    public static int speed=500;
    public static int gfXSize=12;
    public static int gfYSize=30;
    public static int gfBorderLeft=1;
    public static int gfBorderRight=1;
    public static int scale=20;
    
    private Constants() { // SonarQube рекомендует заглушить публичный конструктор
        throw new IllegalStateException("Utility class");
  }
}
