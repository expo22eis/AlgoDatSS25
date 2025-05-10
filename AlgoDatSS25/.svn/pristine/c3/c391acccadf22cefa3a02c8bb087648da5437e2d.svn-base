package de.ostfalia.aud.ss25.base;

import de.ostfalia.aud.ss25.a2.ManagementA2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChronoLOG {

    private IManagement listToInsert;
    private String[] keys;
    private final int keyCount = 40000;
    private String filename = "";

    public ChronoLOG(String filename, String filenameKeys) throws IOException {
        this.listToInsert = new ManagementA2(filename);
        this.filename = filename;

        BufferedReader reader = new BufferedReader(new FileReader(filenameKeys));
        String line;
        this.keys = new String[this.keyCount];
        int index = 0;

        while ((line = reader.readLine()) != null) {

            keys[index] = line;
            index++;
        }
    }

    public void measureTimeSearch() throws IOException {

        long startTime = System.nanoTime();
        for (String k : keys) {
            this.listToInsert.search(k);
        }
        long endTime = System.nanoTime();
        System.out.println(String.format("Benötigte Zeit zum Suchen (in ns): %d (circa %d Millisekunden)",
                (endTime - startTime), (endTime - startTime) / 1_000_000L));
        resetList();
    }

    public void measureTimePaste() throws IOException {

        IMember[] membersToCopy = listToInsert.toArray();
        long startTime = System.nanoTime();
        for (IMember m : membersToCopy) {
            this.listToInsert.insert(m);
        }
        long endTime = System.nanoTime();
        System.out.println(String.format("Benötigte Zeit zum Einfügen (in ns): %d (circa %d Millisekunden)",
                (endTime - startTime), (endTime - startTime) / 1_000_000L));
        resetList();

    }

    private void resetList() throws IOException {
        this.listToInsert = new ManagementA2(this.filename);
    }
}
