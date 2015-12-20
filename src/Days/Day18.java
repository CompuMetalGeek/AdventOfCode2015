/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jarno
 */
public class Day18 extends AllDays.Day {

    int[][] field;
    int[][] temp;

    public Day18() {
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput();
        String test = ".#.#.#\n"
                + "...##.\n"
                + "#....#\n"
                + "..#...\n"
                + "#.#..#\n"
                + "####..";
        Scanner sc = new Scanner(f);
        sc.useDelimiter("");

        int size = 100;
        int lineNumber = 0;
        field = new int[size][size];
        while (sc.hasNext()) {
            char[] line = sc.nextLine().toCharArray();
            for (int i = 0; i < line.length; i++) {
                if (line[i] == '#') {
                    field[lineNumber][i] = 1;
                } else if (line[i] == '.') {
                    field[lineNumber][i] = 0;
                }
            }
            lineNumber++;
        }
        field[0][0] = 1;
        field[field.length - 1][0] = 1;
        field[0][field[0].length - 1] = 1;
        field[field.length - 1][field[0].length - 1] = 1;
        //printField();
        toggleField(100);
        System.out.println("814"); // this solution can be found by removing the corner assignments above and in togglefield()
        System.out.println(countField());

    }

    public void toggleField(int aantalKeer) {
        for (int i = 0; i < aantalKeer; i++) {
            toggleField();
            //System.out.println("field of lights:");
            //printField();
        }
    }

    public void toggleField() {
        temp = new int[field.length][];
        for (int i = 0; i < field.length; i++) {
            temp[i] = field[i].clone();
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                toggleLight(i, j);
            }
        }
        field[0][0] = 1;
        field[field.length - 1][0] = 1;
        field[0][field[0].length - 1] = 1;
        field[field.length - 1][field[0].length - 1] = 1;

    }

    public void toggleLight(int i, int j) {
        int[][] neighbours = {{i - 1, j}, {i - 1, j - 1}, {i, j - 1}, {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1}, {i, j + 1}, {i - 1, j + 1}};
        int neighboursOn = 0;
        for (int[] neighbour : neighbours) {
            try {
                neighboursOn += temp[neighbour[0]][neighbour[1]];
            } catch (IndexOutOfBoundsException e) {

            }
        }
        if (temp[i][j] == 1 && neighboursOn != 2 && neighboursOn != 3) {
            field[i][j] = 0;
        } else if (temp[i][j] == 0 && neighboursOn == 3) {
            field[i][j] = 1;
        } else {
            field[i][j] = temp[i][j];
        }
    }

    public void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] == 1 ? '#' : '.');
            }
            System.out.println("");
        }
    }

    public int countField() {
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                count += field[i][j];
            }
        }
        return count;
    }

}
