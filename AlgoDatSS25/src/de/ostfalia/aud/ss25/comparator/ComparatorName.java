package de.ostfalia.aud.ss25.comparator;

import de.ostfalia.aud.ss25.base.IMember;
import java.util.Comparator;

public class ComparatorName implements Comparator<IMember>{

    @Override
    public int compare(IMember o1, IMember o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
    
}
