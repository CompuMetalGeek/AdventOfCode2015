/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

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
public class Day10 extends AllDays.Day {

    public Day10() {
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput("10");
        String test = "11";
        Scanner sc = new Scanner(f);
        String number = "";
        while (sc.hasNext()) {
            
            
            
            number = sc.next();
            System.out.println("initial number: " + number);
            for (int i = 0; i < 40; i++) {
                number = lookAndSay(number);
                System.out.print(i + ", ");
            }
            System.out.println("");
            System.out.println(number.length());
            for (int i = 40; i < 50; i++) {
                number = lookAndSay(number);
                System.out.print(i + ", ");
            }
            System.out.println("");
            System.out.println(number.length());
        }

    }

    public String lookAndSay(String number) {
        char currentChar = number.toCharArray()[0];
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (currentChar == c) {
                count++;
            } else {
                result.append(count);
                result.append(currentChar);
                currentChar = c;
                count = 1;
            }
        }
        result.append(count);
        result.append(currentChar);
        return result.toString();

    }

}
