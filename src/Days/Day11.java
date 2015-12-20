/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jarno
 */
public class Day11 extends AllDays.Day {

    public Day11() {
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput();
        Scanner sc = new Scanner(f);

        ArrayList<Character> invalidChars = new ArrayList<>();
        invalidChars.add('i');
        invalidChars.add('l');
        invalidChars.add('o');
        while (sc.hasNext()) { // for each password in the file
            // get old password
            String s = sc.next();
            char[] array = s.toCharArray(); // easier to work with array of char

            do {
                array = increment(array, s.length() - 1);// increment pass
            } while ((containsOneOfCharacters(array, invalidChars) || !containsSetOfRepeatedCharacters(array, 2, 2) || !containsStraight(array, 3)));
            // new password found
            s = new String(array);
            System.out.println("new pass: " + s);
        }

    }

    public char[] increment(char[] string, int index) {
        string[index] = (char) ((string[index] + 1 - 'a') % ('z' - 'a' + 1) + 'a');
        if (string[index] == 'a' && index != 0) {
            string = increment(string, index - 1);
        }
        return string;
    }

    public boolean containsStraight(char[] string, int lengthOfStraight) {
        int count = 1;
        char previous = string[0];
        for (char current : string) {
            if (current == previous + 1) {
                count++;
                if (count >= lengthOfStraight) {
                    return true;
                }
            } else {
                count = 1;
            }
            previous = current;
        }
        return false;

    }

    public boolean containsOneOfCharacters(char[] string, List<Character> characters) {
        for (char c : string) {
            if (characters.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsSetOfRepeatedCharacters(char[] string, int numberOfRepeats, int numberOfSets) {
        String s = new String(string);
        s = "_" + s + "_";
        String pattern = "(\\w)\\1{" + (numberOfRepeats - 1) + "}";
        String[] result = s.split(pattern);
        return result.length >= numberOfSets + 1;

    }
}
