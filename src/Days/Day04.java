/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

/**
 *
 * @author jarno
 */
public class Day04 extends AllDays.Day {

    @Override
    public void run() throws Exception {
        // input ophalen
        File f = getInput();
        String input = (new Scanner(f)).next();

        // md5 encryptor ophalen
        MessageDigest md = MessageDigest.getInstance("MD5");

        int i = 1;
        boolean vijfNullenGevonden = false;
        boolean goOn = true;
        while (goOn) { // zolang de eerste oplossing niet gevonden is verdergaan
            String tempInput = input + i; // originele input geconcateneerd met een volgnummer
            md.update(tempInput.getBytes(), 0, tempInput.length()); // data in md5 encryptor toevoegen
            byte[] bytes = md.digest(); // resultaat terugkrijgen
            String md5 = new BigInteger(1, bytes).toString(16); // bytes eerst naar een binair getal omzetten om dan in hex naar een string te schrijven
            if (md5.length() <= 27 && !vijfNullenGevonden) { // als eerste 6 getallen 0 zijn is dit een oplossing
                vijfNullenGevonden = true;
                System.out.println("Eerste hash met "+(32-md5.length())+" nullen is: 00000"+md5+" en komt voor met index "+i+".");
            }
            if (md5.length() <= 26) { // als eerste 5 getallen 0 zijn is dit een oplossing en mag iteratie stoppen
                goOn = !goOn;
                System.out.println("Eerste hash met "+(32-md5.length())+" nullen is: 000000"+md5+" en komt voor met index "+i+".");
            }
            i++; // volgende getal nemen

        }
    }

}
