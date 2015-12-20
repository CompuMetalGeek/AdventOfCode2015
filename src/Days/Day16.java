/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author jarno
 */
public class Day16 extends AllDays.Day {

    ArrayList<Map<String, Integer>> sues;

    public Day16() {
        sues = new ArrayList<>();

    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput();
        Scanner sc = new Scanner(f);
        Map<String, Integer> knownSue = new HashMap<>();
        knownSue.put("children", 3);
        knownSue.put("cats", 7);
        knownSue.put("samoyeds", 2);
        knownSue.put("pomeranians", 3);
        knownSue.put("akitas", 0);
        knownSue.put("vizslas", 0);
        knownSue.put("goldfish", 5);
        knownSue.put("trees", 3);
        knownSue.put("cars", 2);
        knownSue.put("perfumes", 1);

        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(": |, ");
            Map<String, Integer> properties = new HashMap<>();
            for (int i = 1; i < line.length; i += 2) {
                String eigenschap = line[i];
                int waarde = Integer.parseInt(line[i + 1]);
                properties.put(eigenschap, waarde);
            }
            sues.add(properties);
        }

        for (Map<String, Integer> sue : sues) {
            boolean canBe = true;
            boolean canBe2 = true;
            for (Entry<String, Integer> e : sue.entrySet()) {
                int knownValue = knownSue.get(e.getKey());
                if (knownValue!=e.getValue()) {
                    canBe = false;
                }
                switch (e.getKey()) {
                    case "cats":
                    case "trees":
                        if(knownValue>=e.getValue()){
                            canBe2=false;
                        }
                        break;
                    case "pomeranians":
                    case "goldfish":
                        if(knownValue<=e.getValue()){
                            canBe2=false;
                        }
                        break;
                    default:
                        if(knownValue!=e.getValue()){
                            canBe2=false;
                        }
                        break;
                }
            }
            if (canBe) {
                System.out.println("solution 1:"+(sues.indexOf(sue) + 1));
            }
            if(canBe2){
                System.out.println("solution 2:"+(sues.indexOf(sue)+1));
            }

        }
    }

}
