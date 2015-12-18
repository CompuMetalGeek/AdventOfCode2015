/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllDays;

import java.lang.reflect.Constructor;

/**
 *
 * @author jarno
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String classNumber = "01";
        Class<?> day = Class.forName("Days.Day" + classNumber);
        Constructor<?> constructor = day.getConstructor();
        Day d = (Day) constructor.newInstance();
        try {
            for (int i = 1; i <= 25; i++) {
                classNumber = (i < 10 ? "0" + i : "" + i);
                day = Class.forName("Days.Day" + classNumber);
                constructor = day.getConstructor();
                d = (Day) constructor.newInstance();
            }
        } catch (ClassNotFoundException e) {
            int number = Integer.parseInt(classNumber);
            classNumber = (number-1 < 10 ? "0" + (number-1) : "" + (number-1));
        }
        System.out.println("----- Day " + classNumber + " -----");
        d.run();
    }
}
