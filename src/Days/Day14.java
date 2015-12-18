/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import HelperClasses.Day14.Reindeer;
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
public class Day14 extends AllDays.Day {

    ArrayList<Reindeer> reindeers;
    ArrayList<Integer> points;

    public Day14() {
        reindeers = new ArrayList<>();
        points = new ArrayList<>();
    }

    @Override
    public void run() throws Exception {

        // get input file
        File f = getInput("14");
        int inputSeconds = 2503;
        String test = "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n"
                + "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.";
        int testSeconds = 140;
        Scanner sc = new Scanner(f);
        int seconds = inputSeconds;

        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            String name = line[0];
            int speed = Integer.parseInt(line[3]);
            int flyingTime = Integer.parseInt(line[6]);
            int restingTime = Integer.parseInt(line[13]);
            reindeers.add(new Reindeer(name, speed, flyingTime, restingTime));
            points.add(0);
        }

        for (int i = 1; i <= seconds; i++) {
            //System.out.println("after "+i+" seconds:");
            int maxDistance = reindeers.get(0).fly(i);
            Reindeer fastestReindeer = reindeers.get(0);
            for (Reindeer reindeer : reindeers) {
                int distance = reindeer.fly(i);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    fastestReindeer = reindeer;
                }
                //System.out.println("\t"+reindeer.name+" -> "+distance);
            }
            if (i == seconds) {
                System.out.println("The fastest reindeer is " + fastestReindeer.name + " with " + maxDistance + " km travelled.");
            }
            int oldPoints = points.get(reindeers.indexOf(fastestReindeer));
            points.set(reindeers.indexOf(fastestReindeer), oldPoints + 1);
        }
        String fastest = "";
        int max = 0;
        for (int i = 0; i < reindeers.size(); i++) {
            //System.out.println(reindeers.get(i).name + " has " + points.get(i) + " points.");
            if (points.get(i) > max) {
                fastest = reindeers.get(i).name;
                max = points.get(i);
            }
        }
        System.out.println("The best reindeer is " + fastest + ", with " + max + " points.");
    }
}
