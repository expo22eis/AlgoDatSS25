package de.ostfalia.aud.ss25.comparator;

import de.ostfalia.aud.ss25.base.IMember;
import java.util.Comparator;

public class ComparatorGroup implements Comparator<IMember>{

    @Override
    public int compare(IMember o1, IMember o2) {
        return o1.getGroup().ordinal() - o2.getGroup().ordinal();
    }


}
