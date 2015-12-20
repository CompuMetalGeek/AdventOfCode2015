/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import java.util.HashSet;

/**
 *
 * @author jarno
 */
public class Day20 extends AllDays.Day {

    HashSet<Integer> elves;

    public Day20() {
        elves = new HashSet<>();
    }

    @Override
    public void run() throws Exception {
        int limit = 34000000;

        int gifts = 0;
        int house = 0;
        while (gifts < limit) {
            house++;
            elves.clear();
            for (int i = 1; i <= Math.sqrt(house); i++) {
                if (house % i == 0) {
                    elves.add(i);
                    elves.add(house / i);
                }
            }

            gifts = 0;
            for (int i : elves) {
                gifts += i * 10;
            }
        }
        System.out.println("House " + house + " receives " + gifts + " gifts.");

        gifts = 0;
        house = 0;
        while (gifts < limit) {
            house++;
            elves.clear();
            for (int i = 1; i <= Math.sqrt(house); i++) {
                if (house % i == 0) {
                    if (house / i <= 50) {
                        elves.add(i);
                    }
                    if (i <= 50) {
                        elves.add(house / i);
                    }
                }
            }

            gifts = 0;
            for (int i : elves) {
                gifts += i * 11;
            }
        }
        System.out.println("House " + house + " receives " + gifts + " gifts.");
    }

}
