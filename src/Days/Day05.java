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
public class Day05 extends AllDays.Day {

    @Override
    public void run() throws Exception {
        // input ophalen
        File f = getInput();
        Scanner sc = new Scanner(f);
        
        boolean bool = true; // woord voldoet aan eerste set voorwaarden
        boolean bool2 = true; // woord voldoet aan tweede set voorwaarden
        int teller = 0; // aantal woorden dat voldoet aan eerste set voorwaarden
        int teller2 = 0; // aantal woorden dat voldoet aan tweede set voorwaarden
        while (sc.hasNext()) { // voor alle woorden
            String line = sc.nextLine(); // lees woord in
            // eerste set voorwaarden
            if (line.replaceAll("[^aeiou]", "").length() < 3) { // woord heeft minder dan 3 klinkers
                bool = false; // woord voldoet dus niet
            } else if (!line.matches("^.*(.)\\1+.*$")) { // woord heeft geen 2 dezelfde opeenvolgende letters
                bool = false; // woord voldoet dus niet
            } else if (line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy")) { // woord bevat "ab","cd","pq" of "xy"
                bool = false; // woord voldoet dus niet
            }
            if (bool) { // woord voldoet aan eerste set voorwaarden
                teller++; // tel het woord
            }
            // tweede set voorwaarden
            if(!line.matches("^.*(.{2}).*\\1.*$")){ // woord heeft geen set van 2 opeenvolgende letters die 2x voorkomt
                bool2=false; // woord voldoet dus niet
            } else if(!line.matches("^.*(.).\\1.*$")){ // woord heeft geen letter die terugkomt met 1 letter tussen
                bool2=false; // woord voldoet dus niet
            }
            if (bool2) { // woord voldoet aan tweede set voorwaarden
                teller2++; // tel het woord
            }
            // reset voor het volgende woord
            bool = true;
            bool2=true;
        }
        
        System.out.println(teller+" woorden voldoen aan de eerste set voorwaarden.");
        System.out.println(teller2+" woorden voldoen aan de tweede set voorwaarden.");
    }

}
