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
public class Day13 extends AllDays.Day {

    HashMap<String, Integer> modifiers;
    ArrayList<String> personen;
    HashSet<ArrayList<String>> permutations;

    public Day13() {
        modifiers = new HashMap<>();
        personen = new ArrayList<>();
        permutations = new HashSet<>();
    }

    @Override
    public void run() throws Exception {
        {
            // get input file
            File f = getInput("13");
            Scanner sc = new Scanner(f);

            while (sc.hasNext()) {
                String[] line = sc.nextLine().split(" ");
                String from = line[0]; // van-persoon bepalen
                boolean positive = line[2].equals("gain");
                int happyness = Integer.parseInt(line[3]); // waarde bepalen
                if (!positive) {
                    happyness *= -1;
                }
                String to = line[10]; // naar-persoon bepalen
                to = to.substring(0, to.length() - 1); // leesteken verwijderen

                // afstand directioneel toevoegen aan distances (gerichte graaf)
                modifiers.put(from + to, happyness);

                if (!personen.contains("me")) {
                    personen.add("me");
                }
                // alle unieke steden toevoegen aan locations
                if (!personen.contains(from)) {
                    personen.add(from);
                    modifiers.put("me" + from, 0);
                    modifiers.put(from + "me", 0);
                }
                if (!personen.contains(to)) {
                    personen.add(to);
                    modifiers.put("me" + to, 0);
                    modifiers.put(to + "me", 0);
                }
            }
        }

        int min = 9999; // stel een hoge waarde als eerste minimum, geen zin om extra code te schrijven
        int max = 0;
        for (List<String> perm : Collections2.permutations(personen)) {
            int distance = 0; // init afstand
            for (int i = 0; i < perm.size() - 1; i++) {
                distance += modifiers.get(perm.get(i) + perm.get(i + 1)); // voeg de afstand tussen 2 intermediaire locaties toe
                distance += modifiers.get(perm.get(i + 1) + perm.get(i));
            }
            distance += modifiers.get(perm.get(0) + perm.get(perm.size() - 1));
            distance += modifiers.get(perm.get(perm.size() - 1) + perm.get(0));
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
