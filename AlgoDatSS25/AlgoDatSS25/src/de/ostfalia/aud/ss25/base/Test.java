package de.ostfalia.aud.ss25.base;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.a3.ManagementA3;
import de.ostfalia.aud.ss25.a4.AlgoHashMap;
import de.ostfalia.aud.ss25.comparator.ComparatorGroup;
import de.ostfalia.aud.ss25.comparator.ComparatorId;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {


        //ManagementA3 test = new ManagementA3("C:/Users/Rick/Downloads/10_member.csv");

        String[] testString = new String[11];
        testString[0] = "GI-100144; 1986-07-28; Wolfenbüttel; Björn;STUDENT; false";
        testString[1] = "GI-100370; 1986-07-28; saas; lol;FULL; false";
        testString[2] = "GI-109776; 1986-07-28; Kot; Erich;STUDENT; false";
        testString[3] = "GI-102345; 1986-07-28; BS; fre;FULL; true";
        testString[4] = "GI-100333; 1986-07-28; Wolfenbüttel; Tattoo;EMERITUS; false";
        testString[5] = "GI-109999; 1986-07-28; Wolfenbüttel; Björn;EMERITUS; true";
        testString[6] = "GI-102355; 1986-07-28; BShhh; frrereee;EMERITUS; true";
        testString[7] = "GI-100222; 1986-07-28; Wolfvfttel; Tbvdtoo;REDUCED; false";
        testString[8] = "GI-104532; 1986-07-28; Wolfenkkkkkkk; Berwn;FULL; true";
        testString[9] = "GI-122222; 1986-07-28; Wolfvftdgftel; Tbvdtuzoo;EMERITUS; false";
        testString[10] = "GI-109862; 1986-07-28; Wolfenkkkkkxskk; Berwden;REDUCED; true";
        IMember dummy1 = new Member(testString[0]);
        IMember dummy2 = new Member(testString[1]);
        IMember dummy3 = new Member(testString[2]);
        IMember dummy4 = new Member(testString[3]);
        IMember dummy5 = new Member(testString[4]);
        IMember dummy6 = new Member(testString[5]);
        IMember dummy7 = new Member(testString[6]);
        IMember dummy8 = new Member(testString[7]);
        IMember dummy9 = new Member(testString[8]);
        IMember dummy10 = new Member(testString[9]);
        IMember dummy11 = new Member(testString[10]);

        AlgoHashMap test = new AlgoHashMap(new ComparatorId(), 8);
        System.out.println(test.add(dummy1));
        System.out.println(test.add(dummy2));
        System.out.println(test.add(dummy3));
        System.out.println(test.add(dummy4));
        System.out.println(test.add(dummy5));
        System.out.println(test.add(dummy6));
        System.out.println(test.add(dummy7));
        System.out.println(test.add(dummy8));
        System.out.println(test.add(dummy9));
        System.out.println(test.add(dummy10));
        System.out.println(test.add(dummy11));
        System.out.println();

        //System.out.println(test.get(new Member("GI-100370", null, null, null, null, false)).toString());
        //System.out.println(test.indexOf(new Member("GI-100222", null, null, null, Group.FULL, false)));
        System.out.println(test);


        //ChronoLOG c = new ChronoLOG("C:/Users/Rick/Downloads/40k_member.csv", "C:/Users/Rick/Downloads/40k_keys.csv");
        //c.measureTimeSearch();
        //c.measureTimePaste();

    }
}