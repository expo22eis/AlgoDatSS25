package de.ostfalia.aud.ss25.a4;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import java.util.Comparator;

public class AlgoHashMap implements IAlgoCollection<IMember>{

    private Bucket<Integer, IAlgoCollection<IMember>>[] bucketList;
    private final Comparator<IMember> comparator;
    private int capacity; 
    

    public AlgoHashMap(Comparator<IMember> c, int size){
        this.comparator = c;
        bucketList = new Bucket[size];
    }

    public boolean add(IMember m) {
        if (capacity / bucketList.length  > 0.8){
            //extends bucketList *=2
        }
        //if ((c.hashCode(m) + INTMAX.VALUE) % bucketList.length == -1)
        //  neuen bucket für key erstellen
        //else m in KeyBucket einfügen
        return false;
    }

    public boolean remove(IMember m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    public IMember get(IMember m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    
    public IAlgoCollection<IMember> getAll(Comparator c, IMember m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    
    public int indexOf(IMember m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    
    public int size() {
        return capacity;
    }

    public int size(Comparator c, IMember m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    public IMember[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
    
}
