/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllDays;

import java.io.File;
import java.net.URI;
import java.net.URL;

/**
 *
 * @author jarno
 */
public abstract class Day {

    public abstract void run() throws Exception;

    public File getInput() throws Exception {
        String number = getClass().getSimpleName().substring(3, 5);
        URL url = getClass().getResource("/input/" + number + ".txt");
        URI uri = url.toURI();
        return new File(uri);
    }
}
