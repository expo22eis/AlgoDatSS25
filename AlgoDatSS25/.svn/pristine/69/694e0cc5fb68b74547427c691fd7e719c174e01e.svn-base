package de.ostfalia.aud.ss25.base;

import de.ostfalia.aud.ss25.a1.ManagementA1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChronoLOG {

    private ManagementA1 listToInsert;
    private String[] keys;
    private final int keyCount = 40000;

    public ChronoLOG(String filename, String filenameKeys) throws IOException {
        this.listToInsert = new ManagementA1(filename);

        BufferedReader reader = new BufferedReader(new FileReader(filenameKeys));
        String line;
        this.keys = new String[this.keyCount];
        int index = 0;

        while ((line = reader.readLine()) != null) {

            keys[index] = line;
            index++;
        }
    }

    public void measureTimeSearch(IManagement list) {

        long startTime = System.nanoTime();
        for (String k : keys) {
            list.search(k);
        }
        long endTime = System.nanoTime();
        System.out.println(String.format("Benötigte Zeit zum Suchen (in ns): %d (circa %d Sekunden)", (endTime - startTime), (endTime - startTime) / 1_000_000_000L));
    }

    public void measureTimePaste(IManagement list) {

        IMember[] membersToCopy = listToInsert.toArray();
        long startTime = System.nanoTime();
        for (IMember m : membersToCopy) {
            list.insert(m);
        }
        long endTime = System.nanoTime();
        System.out.println(String.format("Benötigte Zeit zum Einfügen (in ns): %d (circa %d Sekunden)", (endTime - startTime), (endTime - startTime) / 1_000_000_000L));

    }
}
