package de.ostfalia.aud.ss25.base;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {


        //ManagementA2 test = new ManagementA2("C:/Users/Rick/Downloads/40k_member.csv");
        //System.out.println(test.search("GI-109776"));


        ChronoLOG c = new ChronoLOG("C:/Users/Rick/Downloads/40k_member.csv", "C:/Users/Rick/Downloads/40k_keys.csv");
        c.measureTimeSearch();
        c.measureTimePaste();

    }
}
