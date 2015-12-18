/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import HelperClasses.Day03.Coordinate;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author jarno
 */
public class Day03 extends AllDays.Day {

    @Override
    public void run() throws Exception {
        // ophalen input
        File f = getInput("03");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(""); // elk karakter apart bekijken
        
        // initialiseren van locaties van de kerstman en de robot
        int[] x = new int[2];
        int[] y = new int[2];
        int person=0; // 0 betekent kerstman, 1 betekent robot
        
        // veld aanmaken en (0,0) toevoegen als cadeau ontvangen
        HashMap<Coordinate, Integer> grid = new HashMap<>();
        grid.put(new Coordinate(), 1);
        
        while (sc.hasNext()) { // elk karakter overlopen
            String s = sc.next();
            switch (s) {
                case "^":
                    y[person]++;
                    break;
                case "v":
                    y[person]--;
                    break;
                case "<":
                    x[person]--;
                    break;
                case ">":
                    x[person]++;
                    break;
                default:
                    break;
            }
            
            // nieuwe locatie toevoegen aan het veld
            Coordinate c= new Coordinate(x[person], y[person]);
            if (grid.containsKey(c)) { // huis is al bezocht, dus gewoon incrementeren
                Integer temp = grid.get(c);
                temp++;
                grid.put(c, temp);
            } else { // nieuw huis dus toevoegen aan veld
                grid.put(c, 1);
            }
            // volgende beweging is voor volgende persoon
            person++;
            person%=x.length;
        }
        
        // bepalen van aantal cadeaus verdeeld en huis met meeste cadeaus
        int totaalCadeaus = 0;
        int maxCadeaus = 0;
        for (Coordinate c : grid.keySet()) { // elk bezocht huis overlopen
            totaalCadeaus += grid.get(c); // cadeaus bij totaal tellen
            maxCadeaus = Math.max(maxCadeaus, grid.get(c)); // vergelijken met het tijdelijk maximum en nieuw max bijhouden
        }
        
        System.out.println("Er zijn " + grid.keySet().size() + " huizen bezocht");
        System.out.println("en " + totaalCadeaus + " cadeaus afgeleverd (Max per huis is " + maxCadeaus + ").");
    }

}
