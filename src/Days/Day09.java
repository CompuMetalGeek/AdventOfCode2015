/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import com.google.common.collect.Collections2;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jarno
 */
public class Day09 extends AllDays.Day {

    HashMap<String, Integer> distances;
    ArrayList<String> locations;
    HashSet<ArrayList<String>> permutations;

    public Day09() {
        distances = new HashMap<>();
        locations = new ArrayList<>();
        permutations = new HashSet<>();
    }

    @Override
    public void run() throws Exception {
        {
            // get input file
            File f = getInput("09");
            String test = "London to Dublin = 464\n"
                    + "London to Belfast = 518\n"
                    + "Dublin to Belfast = 141\n";
            Scanner sc = new Scanner(f);

            while (sc.hasNext()) {
                String from = sc.next(); // van-stad bepalen
                sc.next();
                String to = sc.next(); // naar-stad bepalen
                sc.next();
                int distance = Integer.parseInt(sc.next()); // afstand bepalen
                
                // afstand bidirectioneel toevoegen aan distances (ongerichte graaf)
                distances.put(from + to, distance);
                distances.put(to + from, distance);

                // alle unieke steden toevoegen aan locations
                if (!locations.contains(from)) {
                    locations.add(from);
                }
                if (!locations.contains(to)) {
                    locations.add(to);
                }
            }
        }


        int min = 9999; // stel een hoge waarde als eerste minimum, geen zin om extra code te schrijven
        int max=0;
        for (List<String> perm : Collections2.permutations(locations)) {
            int distance = 0; // init afstand
            for (int i = 0; i < perm.size() - 1; i++) {
                distance += distances.get(perm.get(i) + perm.get(i + 1)); // voeg de afstand tussen 2 intermediaire locaties toe
            }
            if (distance < min) { // afstand is kleiner dan huidig minimum
                min = distance;
            }
            if (distance > max) { // afstand is groter dan huidig maximum
                max = distance;
            }
        }

        System.out.println(min);
        System.out.println(max);
    }

}
