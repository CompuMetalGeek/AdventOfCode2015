/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author jarno
 */
public class Day12 extends AllDays.Day {

    public Day12() {
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput("12");
        
        Scanner sc = new Scanner(f);
        sc.useDelimiter("[^0-9-]{1,}");
        
        int totaal=0;
        while(sc.hasNext()){
            int next = sc.nextInt();
            totaal+=next;
        }
        System.out.println(totaal);
        sc.close();
        
        
        FileReader fr = new FileReader(f);
        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(fr);
        totaal=parseElement(root);
        System.out.println(totaal);
        
        
    }
    
    public int parseElement(JsonElement element){
        int totaal=0;
        if(element.isJsonArray()){
            totaal+=parseArray(element.getAsJsonArray());
        }else if(element.isJsonObject()){
            totaal+=parseObject(element.getAsJsonObject());
        }else if(element.isJsonPrimitive()){
            totaal+=parsePrimitive(element.getAsJsonPrimitive());
        }
        return totaal;
    }
    
    public int parseArray(JsonArray array){
        int totaal =0;
        for(JsonElement e:array){
            totaal+=parseElement(e);
        }
        return totaal;
    }
    public int parseObject(JsonObject object){
        boolean hasRed=false;
        int totaal=0;
        for(Entry<String,JsonElement> entry:object.entrySet()){
            if(entry.getKey().equalsIgnoreCase("red")){
                hasRed=true;
                break;
            } else{
                try{
                    totaal+=Integer.parseInt(entry.getKey());
                }catch(NumberFormatException e){
                    
                }
            }
            if(entry.getValue().isJsonPrimitive()){
                JsonPrimitive value = entry.getValue().getAsJsonPrimitive();
                if(value.isString()&&value.getAsString().equalsIgnoreCase("red")){
                    hasRed=true;
                    break;
                }
            }
        }
        if(!hasRed){
            for(Entry<String,JsonElement> entry:object.entrySet()){
                totaal+=parseElement(entry.getValue());
            }
        }
        return totaal;
    }
    public int parsePrimitive(JsonPrimitive primitive){
        if(primitive.isNumber()){
            return primitive.getAsInt();
        }
        return 0;
    }
}
