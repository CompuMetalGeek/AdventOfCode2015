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
public class Day02 extends AllDays.Day {

    @Override
    public void run() throws Exception {
        // input ophalen
        File f = getInput();
        Scanner sc = new Scanner(f);
        sc.useDelimiter("x|\n"); // input wordt gesplitst op een newline en 'x'

        int totalArea = 0;
        int totalOmtrek = 0;
        while (sc.hasNext()) { // zolang er nog iets in de scanner zit
            // afmetingen ophalen
            int l = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();

            totalArea += bepaalOppervlak(l, w, h); // nodige oppervlak toevoegen aan totaal
            totalOmtrek += bepaalOmtrek(l, w, h); // nodige omtrek toevoegen aan totaal
        }
        System.out.println("De elven hebben " + totalArea + " vierkante voet papier");
        System.out.println("en " + totalOmtrek + " voet lint nodig.");
    }

    public int bepaalOppervlak(int l, int w, int h) {
        // oppervlak van elk zijvlak bepalen
        int area1 = l * w;
        int area2 = w * h;
        int area3 = h * l;
        int extra = Math.min(area1, Math.min(area2, area3)); // extra oppervlak dat nodig is bepalen
        return 2 * area1 + 2 * area2 + 2 * area3 + extra; // totale oppervlak teruggeven

    }

    public int bepaalOmtrek(int l, int w, int h) {
        // omtrek van elk zijvlak bepalen
        int omtrek1 = 2 * l + 2 * w;
        int omtrek2 = 2 * w + 2 * h;
        int omtrek3 = 2 * h + 2 * l;
        int minOmtrek = Math.min(omtrek1, Math.min(omtrek2, omtrek3)); // kleinste omtrek bepalen
        int extraOmtrek = l * w * h; // extra omtrek dat nodig is bepalen
        return minOmtrek + extraOmtrek; // totale omtrek teruggeven

    }

}
