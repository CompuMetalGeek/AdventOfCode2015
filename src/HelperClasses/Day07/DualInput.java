/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses.Day07;

import java.util.Map;

/**
 *
 * @author jarno
 */
public class DualInput extends BitwiseOp {

    boolean andOperation;

    public void setAndOperation(boolean andOperation) {
        this.andOperation = andOperation;
    }

    @Override
    public Character getOutput(Map<String, Character> values) {
        try { // kijken of een van de variabelen een getal is en getal plaatsen in de values
            int i = Integer.parseInt(input);
            if (values.get(i + "") == null) {
                values.put(i + "", (char) i);
            }
            i = Integer.parseInt(input2);
            if (values.get(i + "") == null) {
                values.put(i + "", (char) i);
            }
        } catch (NumberFormatException e) {

        }
        if (values.get(input) == null || values.get(input2) == null) { // minstens een van de inputs is nog niet berekend, poort mag geen signaal geven
            return null;
        }
        if (values.get(output) != null) { // output is al berekend, geen berekening meer nodig
            return values.get(output);
        }

        // bepalen van de output-waarden
        Character c;
        if (andOperation) {
            c = (char) (values.get(input) & values.get(input2));
        } else {
            c = (char) (values.get(input) | values.get(input2));
        }
        values.put(output, c); // output waarde opslaan
        return c;
    }

    @Override
    public String toString() {
        return input + (andOperation ? " AND " : " OR ") + input2 + " -> " + output;
    }

}
