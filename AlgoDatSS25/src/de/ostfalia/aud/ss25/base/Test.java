package de.ostfalia.aud.ss25.base;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.a2.AlgoArrayList;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        String[] testString = new String[3];
        testString[0] = "GI-100144; 1986-07-28; Wolfenbüttel; Björn;EMERITUS; false";
        testString[1] = "GI-100370; 1986-07-28; Wolfenbüttel; Björn;EMERITUS; false";
        testString[2] = "GI-109776; 1986-07-28; Wolfenbüttel; Björn;EMERITUS; false";
        IMember dummy1 = new Member(testString[0]);
        IMember dummy2 = new Member(testString[1]);
        IMember dummy3 = new Member(testString[2]);

        


        ChronoLOG c = new ChronoLOG("C:/Users/Rick/Downloads/40k_member.csv", "C:/Users/Rick/Downloads/40k_keys.csv");
        c.measureTimeSearch(new ManagementA1("C:/Users/Rick/Downloads/40k_member.csv"));
        c.measureTimePaste(new ManagementA1("C:/Users/Rick/Downloads/40k_member.csv"));
        
        

    }
}
