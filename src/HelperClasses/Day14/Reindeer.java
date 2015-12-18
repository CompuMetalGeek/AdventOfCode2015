/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses.Day14;

/**
 *
 * @author jarno
 */
public class Reindeer {
    public String name;
    public int speed,flyingTime,restingTime;

    public Reindeer(String name, int speed, int flyingTime, int restingTime) {
        this.name = name;
        this.speed = speed;
        this.flyingTime = flyingTime;
        this.restingTime = restingTime;
    }

    public Reindeer() {
    }

    public int fly(int seconds){
        int distance=0;
        boolean needsRest=false;
        while(seconds>0){
            if(needsRest){
                seconds-=restingTime;
            } else{
                seconds-=flyingTime;
                distance+=flyingTime*speed;
            }
                needsRest= !needsRest;
        }
        if(seconds<0&&needsRest){
            distance+=seconds*speed;
        }
        return distance;
    }
    
}
