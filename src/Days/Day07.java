/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import HelperClasses.Day07.*;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author jarno
 */
public class Day07 extends AllDays.Day {

    HashMap<String, Character> vars;
    ArrayList<BitwiseOp> gates;
    HashMap<String,Character> initVals;

    public Day07() {
        vars = new HashMap<>();
        gates = new ArrayList<>();
        initVals=new HashMap<>();
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput();
        Scanner sc = new Scanner(f);
        
        // alle logische poorten verwerken en opslaan
        while (sc.hasNext()) { // elke regel verwerken
            String line = sc.nextLine();
            String[] lineParts = line.split(" ");
            if (line.contains("NOT")) { // inversion
                handleNot(lineParts[1], lineParts[3]);
            } else if (line.contains("AND")) { // bitwise and
                handleAndOr(lineParts[0], lineParts[2], lineParts[4], true);
            } else if (line.contains("OR")) { // bitwise or
                handleAndOr(lineParts[0], lineParts[2], lineParts[4], false);
            } else if (line.contains("LSHIFT")) { // left shift
                handleShift(lineParts[0], lineParts[2], lineParts[4], true);
            } else if (line.contains("RSHIFT")) { // right shift
                handleShift(lineParts[0], lineParts[2], lineParts[4], false);
            } else { // assign
                handleAssign(lineParts[0], lineParts[2]);
            }
        }
        
        // signaal laten propageren voor de eerste keer tot er geen wijzigingen meer zijn
        int initSize;
        do {
            initSize = vars.size();
            for (BitwiseOp op : gates) {
                op.getOutput(vars);
            }
        } while (initSize < vars.size());
        char a = vars.get("a");
        System.out.println("De waarde van a is "+(int)a+".");
        
        // b moet nu de waarde van a krijgen
        initVals.put("b", a);
        // gevonden waarden verwijderen
        vars.clear();
        // nieuwe input op de poorten zetten
        vars.putAll(initVals);
        
        // signaal opnieuw laten propageren tot er geen wijzigingen meer zijn
        do {
            initSize = vars.size();
            for (BitwiseOp op : gates) {
                op.getOutput(vars);
            }
        } while (initSize < vars.size());
        
        System.out.println("De waarde van a is de tweede keer "+(int)vars.get("a")+".");
    }

    public void handleNot(String input, String output) { // maakt een not poort aan en voegt toe aan de gemaakte gates
        SingleInput si = new SingleInput();
        si.setInput(input);
        si.setOutput(output);
        si.setInvert(true);
        gates.add(si);
    }

    public void handleAssign(String input, String output) {// maakt een assignatie aan en voegt toe aan de gemaakte gates indien de input nog niet gekend is
        try { // eerste waarde is een getal, voeg direct in vars en initVals toe
            Character c = (char) Integer.parseInt(input);
            vars.put(output, c);
            initVals.put(output,c);
        } catch (NumberFormatException e) { // eerste waarde is variabele, voeg een gate toe
            SingleInput si = new SingleInput();
            si.setInput(input);
            si.setOutput(output);
            si.setInvert(false);
            gates.add(si);
        }
    }

    public void handleAndOr(String input, String input2, String output, boolean and) {// maakt een and of or poort aan en voegt toe aan de gemaakte gates
        DualInput di = new DualInput();
        di.setAndOperation(and);
        di.setInput(input);
        di.setInput2(input2);
        di.setOutput(output);
        gates.add(di);
    }

    public void handleShift(String input, String input2, String output, boolean left) {// maakt een linkse of rechtse shifter aan en voegt toe aan de gemaakte gates
        Shifter sh = new Shifter();
        sh.setShiftLeft(left);
        sh.setInput(input);
        sh.setInput2(input2);
        sh.setOutput(output);
        gates.add(sh);
    }

}
