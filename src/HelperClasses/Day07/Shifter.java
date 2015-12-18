package HelperClasses.Day07;

import java.util.Map;

/**
 *
 * @author jarno
 */
public class Shifter extends BitwiseOp {

    private boolean shiftLeft;

    @Override
    public Character getOutput(Map<String, Character> values) {
        if (values.get(input) == null) { // input bestaat nog niet, geen signaal uitsturen
            return null;
        }
        if (values.get(output) != null) { // output bestaat al, berekeningen niet nodig
            return values.get(output);
        }

        // shift bepalen
        Character c;
        if (shiftLeft) {
            c = (char) (values.get(input) << Integer.parseInt(input2));
        } else {
            c = (char) (values.get(input) >> Integer.parseInt(input2));
        }
        values.put(output, c); // gevonden waarde opslaan
        return c;
    }

    public void setShiftLeft(boolean shiftLeft) {
        this.shiftLeft = shiftLeft;
    }

    @Override
    public String toString() {
        return input + (shiftLeft ? " << " : " >> ") + input2 + " -> " + output;
    }

}
