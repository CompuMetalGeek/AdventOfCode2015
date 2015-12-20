/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import java.io.File;
import java.io.FileReader;

/**
 *
 * @author jarno
 */
public class Day01 extends AllDays.Day {

    @Override
    public void run() throws Exception {
        // input ophalen
        File f = getInput();
        FileReader fr = new FileReader(f);

        int verdiep = 0;
        int aantal = 0;
        int eersteNegatief = 0;

        int c;
        do {
            c = fr.read(); // lees volgende opdracht in
            switch (c) {
                case (int) '(': // stijg een verdiep
                    verdiep++;
                    aantal++;
                    break;
                case (int) ')': // daal een verdiep
                    verdiep--;
                    aantal++;
                    break;
                default:
                    break;
            }
            if (verdiep == -1 && eersteNegatief <= 0) { // bijhouden wanneer voor het eerst -1 wordt bereikt
                eersteNegatief = aantal;
            }
        } while (c != -1); // bij fr.read()==-1 is het einde van het bestand bereikt

        System.out.println("De lift stopt op verdiep " + verdiep + " na " + aantal + " verplaatsingen");
        System.out.println("en komt een eerste keer op verdiep -1 na " + eersteNegatief + " verplaatsingen.");

    }

}
