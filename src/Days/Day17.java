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
public class Day17 extends AllDays.Day {

    int[] emmers;
    boolean[] inGebruik;
    int winningCombinations = 0;
    int min;
    int numberMin = 1;

    public Day17() {
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput();
        Scanner sc = new Scanner(f);
        ArrayList<Integer> emmersList = new ArrayList<>();
        while (sc.hasNext()) {
            emmersList.add(sc.nextInt());
        }

        emmers = new int[emmersList.size()];
        for (int i = 0; i < emmers.length; i++) {
            emmers[i] = emmersList.get(i);
        }
        inGebruik = new boolean[emmersList.size()];
        min=emmers.length;

        calculate(150, 0);
        System.out.println(winningCombinations);
        System.out.println(min+ ": "+numberMin);
    }

    public void calculate(int volume, int index) {
        if (volume > 0) {
            for (int i = index; i < emmers.length; i++) {
                if (!inGebruik[i]) {
                    inGebruik[i] = true;
                    calculate(volume - emmers[i], i + 1);
                    inGebruik[i] = false;
                }
            }
        } else if (volume == 0) {
            winningCombinations++;
            int emmersAantal = getNumberOfEmmers();
            if (emmersAantal < min) {
                min = emmersAantal;
                numberMin = 1;
            } else if (emmersAantal == min) {
                numberMin++;
            }
        }
    }

    public int getNumberOfEmmers() {
        int i = 0;
        for (boolean b : inGebruik) {
            if (b) {
                i++;
            }
        }
        return i;
    }

}
