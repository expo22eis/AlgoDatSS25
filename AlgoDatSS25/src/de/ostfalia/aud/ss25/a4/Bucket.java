package de.ostfalia.aud.ss25.a4;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;

public class Bucket<K, V extends IAlgoCollection<IMember>> {
    private K key;
    private V values;

    public K getKey(){
        return key;
    }
    public V getValues(){
        return values;
    }
    public boolean addValue(IMember m){
        return values.add(m);
    }
}
