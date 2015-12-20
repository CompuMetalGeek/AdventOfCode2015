/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Days;

import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author jarno
 */
public class Day19 extends AllDays.Day {

    HashMap<String, ArrayList<String>> replacements;
    String initialMolecule;
    HashSet<String> generatedMolecules;

    public Day19() {
        replacements = new HashMap<>();
        generatedMolecules = new HashSet<>();
    }

    @Override
    public void run() throws Exception {
        // get input file
        File f = getInput();
        String test = "H => HO\n"
                + "H => OH\n"
                + "O => HH\n"
                + "\n"
                + "HOHOHO\n";
        String test2 = "e => H\n"
                + "e => O\n"
                + "H => HO\n"
                + "H => OH\n"
                + "O => HH\n"
                + "\n"
                + "HOHOHO\n";
        Scanner sc = new Scanner(f);

        String separator = " => ";
        while (sc.hasNext()) {
            String line = sc.nextLine();
            while (line.contains(separator)) {
                String[] parts = line.split(separator);
                if (!replacements.containsKey(parts[0])) {
                    replacements.put(parts[0], new ArrayList<>());
                }
                replacements.get(parts[0]).add(parts[1]);
                line = sc.nextLine();
            }
            initialMolecule = sc.nextLine();
        }

        generateMolecules();
        System.out.println(generatedMolecules.size());

    }

    private void generateMolecules() {
        HashSet<String> input = new HashSet(generatedMolecules);
        if (input.isEmpty()) {
            generateMolecules(initialMolecule);
        } else {
            for (String molecule : input) {
                generateMolecules(molecule);
            }
        }
    }

    private void generateMolecules(String molecule) {
        for (Entry<String, ArrayList<String>> entry : replacements.entrySet()) {
            String original = entry.getKey();
            for (String replacement : entry.getValue()) {
                generateMolecules(molecule, original, replacement);
            }
        }
    }

    private void generateMolecules(String molecule, String original, String replacement) {
        for (int i = 0; i < molecule.length(); i++) {
            StringBuilder sb = new StringBuilder(molecule.substring(0, i));
            String newMolecule = sb.append(molecule.substring(i).replaceFirst(original, replacement)).toString();
            if (!newMolecule.equals(molecule)) {
                generatedMolecules.add(newMolecule);
            }
        }
    }

}
