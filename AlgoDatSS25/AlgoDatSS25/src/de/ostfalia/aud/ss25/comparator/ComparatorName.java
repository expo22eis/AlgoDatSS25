package de.ostfalia.aud.ss25.comparator;

import java.util.Comparator;

import de.ostfalia.aud.ss25.base.IMember;

public class ComparatorName implements Comparator<IMember> {


    @Override
    public int compare(IMember m1, IMember m2) {
        String name1 = m1.getForename() + m1.getSurname();
        String name2 = m2.getForename() + m2.getSurname();
        return name1.compareTo(name2);
    }

    public int hashCode(IMember m){
        return (m.getSurname().concat(m.getForename())).hashCode();
    }

}
