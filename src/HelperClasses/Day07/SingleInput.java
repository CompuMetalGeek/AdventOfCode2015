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
public class SingleInput extends BitwiseOp {

    boolean invert;

    public void setInvert(boolean invert) {
        this.invert = invert;
    }

    @Override
    public Character getOutput(Map<String, Character> values) {
        if (values.get(input) == null) { // input heeft geen waarde, poort mag geen signaal doorgeven
            return null;
        }
        if (values.get(output) != null) { // output van de gate heeft al een waarde, geen berekening nodig
            return values.get(output);
        }
        Character c = (invert) ? (char) ~values.get(input) : values.get(input); // bepalen van output
        values.put(output, c); // output opslaan
        return c;

    }

    @Override
    public String toString() {
        return (invert?"NOT ":"")+input+" -> "+output;
    }

}
