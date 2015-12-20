/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jarno
 */
public class Day15 extends AllDays.Day {

    boolean[] inUse;
    int[][] properties;
    int[] result;
    long max = -1;
    long max2 = -1;

    public Day15() {
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput();
        String test = "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8\n"
                + "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3\n"
                + "Test: capacity 0, durability 0, flavor 0, texture 0, calories 0\n"
                + "Test2: capacity 0, durability 0, flavor 0, texture 0, calories 0";
        Scanner sc = new Scanner(f);

        ArrayList<int[]> ingredients = new ArrayList<>();
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(": |, | ");

            int capacity = Integer.parseInt(line[2]);
            int durability = Integer.parseInt(line[4]);
            int flavor = Integer.parseInt(line[6]);
            int texture = Integer.parseInt(line[8]);
            int calories = Integer.parseInt(line[10]);

            int[] waarden = {capacity, durability, flavor, texture, calories};
            ingredients.add(waarden);
        }

        inUse = new boolean[ingredients.size()];
        properties = new int[ingredients.size()][];
        for (int i = 0; i < properties.length; i++) {
            properties[i] = ingredients.get(i);
        }
        result = new int[ingredients.get(0).length];

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    for (int l = 0; l < 100; l++) {
                        if (i + j + k + l == 100) {
                            for (int m = 0; m < 5; m++) {
                                result[m] = i * properties[0][m];
                                result[m] += j * properties[1][m];
                                result[m] += k * properties[2][m];
                                result[m] += l * properties[3][m];
                            }
                            calculateMax();
                        }
                    }
                }
            }
        }
        System.out.println(max);
        System.out.println(max2);

    }

    public void calculateMax() {
        long totaal = 1;
        for (int i = 0; i < 4; i++) {
            if (result[i] < 0) {
                totaal = 0;
            }
            totaal *= result[i];
        }
        if (totaal > max) {
            max = totaal;
        }
        if (totaal > max2 && result[4] == 500) {
            max2 = totaal;
        }
    }
}
