/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses.Day09;

/**
 *
 * @author jarno
 */
public class Distance implements Comparable<Distance> {

    private String from;
    private String to;
    private int distance;
    
    public Distance() {
    }
    
    public Distance(String from, String to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public String getFrom() {
        return from;
    }
    
    public void setFrom(String from) {
        this.from = from;
    }
    
    public String getTo() {
        return to;
    }
    
    public void setTo(String to) {
        this.to = to;
    }
    
    @Override
    public int compareTo(Distance o) {
        if (o == null) {
            return 1;
        }
        if (this.distance != o.distance) {
            return this.distance - o.distance;
        }
        if (this.from.compareTo(o.from) != 0) {
            return this.from.compareTo(o.from);
        }
        return this.to.compareTo(o.to);
    }
    
}
