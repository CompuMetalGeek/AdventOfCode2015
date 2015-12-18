/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses.Day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jarno
 */
public class Ingredient {

    public String name;
    public Map<String, Integer> properties;

    public Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {
        this.name = name;
        properties = new HashMap<>();
        properties.put("capacity", capacity);
        properties.put("durability", durability);
        properties.put("flavor", flavor);
        properties.put("texture", texture);
        properties.put("calories", calories);
    }

    public Ingredient() {
    }

    public int getCapacity() {
        return properties.get("capacity");
    }

    public int getDurability() {
        return properties.get("durability");

    }

    public int getFlavor() {
        return properties.get("flavor");

    }

    public int getTexture() {
        return properties.get("texture");

    }

    public int getCalories() {
        return properties.get("calories");

    }

    public List<Integer> getProperties() {
        List list = new ArrayList<Integer>();
        list.add(getCapacity());
        list.add(getDurability());
        list.add(getFlavor());
        list.add(getTexture());
        list.add(getCalories());
        return list;
    }
    
    public int[] getProperties(int i){
        int[] retVal= {getCapacity(),getDurability(),getFlavor(),getTexture(),getCalories()};
        return retVal;
    }

}
