package de.ostfalia.aud.ss25.base;

import de.ostfalia.aud.ss25.a3.ManagementA3;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {


        ManagementA3 test = new ManagementA3("C:/Users/Rick/Downloads/40k_member.csv");
        System.out.println(test.search("GI-109776"));
        //System.out.println(test.toString());
        System.out.println(test.size());
        System.out.println(test.size(Group.FULL));
        System.out.println(test.size(Group.REDUCED));
        System.out.println(test.size(Group.EMERITUS));
        System.out.println(test.size(Group.STUDENT));
        System.out.println(test.size(Group.STUDENT)+test.size(Group.EMERITUS)+test.size(Group.REDUCED)+test.size(Group.FULL));
        System.out.println(test.height());
        System.out.println(test.size());
        //System.out.println(test.search("GI-109776"));


        //ChronoLOG c = new ChronoLOG("C:/Users/Rick/Downloads/40k_member.csv", "C:/Users/Rick/Downloads/40k_keys.csv");
        //c.measureTimeSearch();
        //c.measureTimePaste();

    }
}
