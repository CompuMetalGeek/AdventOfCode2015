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
public class Day08 extends AllDays.Day {

    public Day08() {
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput();
        String test = "\"\""+"\n"
                +"\"abc\""+"\n"
                +"\"aaa\\\"aaa\""+"\n"
                +"\"\\x27\"";
        Scanner sc = new Scanner(f);
        int totaalLenght = 0;
        int totaalKarakters = 0;
        int encodedLength = 0;
        // alle logische poorten verwerken en opslaan
        while (sc.hasNext()) { // elke regel verwerken
            String line = sc.nextLine();
            totaalLenght += getLength(line);
            totaalKarakters += getKarakters(line);
            encodedLength += getLength(encode(line));
        }
        System.out.println("totale lengte: " + totaalLenght + ", totaal aantal karakters: " + totaalKarakters + ", verschil:" + (totaalLenght - totaalKarakters));
        System.out.println("totale geëncodeerde lengte: "+encodedLength+", verschil met totale lengte van origineel: "+(encodedLength-totaalLenght));

    }

    public int getLength(String s) {
        return s.length();
    }

    public int getKarakters(String s) {
        int aantal = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\\') {
                i++;
                if (chars[i] == 'x') {
                    i += 2;
                }
            }
            aantal++;

        }
        return aantal - 2;

    }

    public String encode(String s) {
        String result = s;
        result=result.replaceAll("\\\\", "\\\\\\\\");
        result=result.replaceAll("\\\"", "\\\\\"");
        return "\""+result+"\"";
    }
}
