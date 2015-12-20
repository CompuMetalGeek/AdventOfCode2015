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
public class Day06 extends AllDays.Day {

    boolean[][] grid; // rooster van de lichtjeslayout voor opgave 1
    int[][] grid2; // rooster van de lichtjeslayout voor opgave 2

    public Day06() {
        // initialiseer eerste rooster
        grid = new boolean[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                grid[i][j] = false;
            }
        }
        // initialiseer tweede rooster
        grid2 = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                grid2[i][j] = 0;
            }
        }
    }

    @Override
    public void run() throws Exception {
        // get input
        File f = getInput();
        Scanner sc = new Scanner(f);

        while (sc.hasNext()) { // zolang er nog input is
            String next = sc.next(); // eerste woord van nieuwe instructie ophalen
            switch (next) {
                case "turn": // bij "turn" methode turn aanroepen
                    turn(sc);
                    break;
                case "toggle": //bij "toggle" methode toggle aanroepen
                    toggle(sc);
                    break;
            }
        }
        int aantalAan = 0; // aantal lampen die op het einde branden
        int aantalAan2 = 0; // helderheid van alle lampen die op het einde branden samen
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (grid[i][j]) { // lamp staat aan
                    aantalAan++;
                }
                aantalAan2 += grid2[i][j]; // tel helderheid van lamp erbij
            }
        }

        System.out.println("Er branden " + aantalAan + " lampen.");
        System.out.println("De helderheid van alle lampen samen is " + aantalAan2 + ".");
    }

    public void turn(Scanner sc) {
        String onOff = sc.next(); // haal "on" of "off" op
        String start = sc.next(); // haal startcoordinaat op
        int xStart = Integer.parseInt(start.substring(0, start.indexOf(","))); // bepaal x van startcoordinaat
        int yStart = Integer.parseInt(start.substring(start.indexOf(",") + 1)); // bepaal y van startcoordinaat
        sc.next(); // negeer verbindingswoord
        String end = sc.next(); // haal eindcoordinaat op
        int xEnd = Integer.parseInt(end.substring(0, end.indexOf(","))); // bepaal x van eindcoordinaat
        int yEnd = Integer.parseInt(end.substring(end.indexOf(",") + 1)); // bepaal y van eindcoordinaat
        if (onOff.equals("on")) { // indien "turn on" roep methode met true aan, anders met false
            turner(xStart, yStart, xEnd, yEnd, true);
        } else {
            turner(xStart, yStart, xEnd, yEnd, false);
        }
    }

    public void turner(int xStart, int yStart, int xEnd, int yEnd, boolean bool) {
        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) { // voor elke lamp in het opgegeven rooster
                grid[i][j] = bool; // zet lamp aan of uit voor eerste opgave
                grid2[i][j] += bool ? 1 : -1; // verhoog of verlaag intensiteit van lamp met 1 intensiteit voor tweede opgave
                if (grid2[i][j] < 0) { // bij negatieve intensiteit, reset lamp
                    grid2[i][j] = 0;
                }
            }
        }
    }

    public void toggle(Scanner sc) {
        String start = sc.next(); // haal startcoordinaat op
        int xStart = Integer.parseInt(start.substring(0, start.indexOf(","))); // bepaal x van startcoordinaat
        int yStart = Integer.parseInt(start.substring(start.indexOf(",") + 1)); // bepaal y van startcoordinaat
        sc.next(); // negeer verbindingswoord
        String end = sc.next(); // haal eindcoordinaat op
        int xEnd = Integer.parseInt(end.substring(0, end.indexOf(","))); // bepaal x van eindcoordinaat
        int yEnd = Integer.parseInt(end.substring(end.indexOf(",") + 1)); // bepaal y van eindcoordinaat
        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) { // voor elke lamp in het opgegeven rooster
                grid[i][j] = !grid[i][j]; // zet lamp in andere status voor eerste opgave
                grid2[i][j] += 2; // verhoog lamp met 2 intensiteiten voor tweede opgave
            }
        }

    }

}
