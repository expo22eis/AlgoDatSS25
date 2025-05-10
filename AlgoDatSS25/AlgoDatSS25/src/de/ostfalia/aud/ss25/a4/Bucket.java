package de.ostfalia.aud.ss25.a4;

import java.util.Comparator;

import de.ostfalia.aud.ss25.a2.AlgoArrayList;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;

public class Bucket<K, V extends IAlgoCollection<IMember>>{
    private final K key;
    private V values;

    public Bucket(K key, V values){
        this.key = key;
        this.values = values;
    }

    public K getKey(){
        return key;
    }

    public V getValues() {
        return values;
    }

    public boolean add(IMember m){
        return values.add(m);
    }

    public boolean remove(IMember m){
        return values.remove(m);
    }

    public IMember get(IMember m) {
        return values.get(m);
    }

    public int indexOf(IMember m){
        return values.indexOf(m);
    }

    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        return values.getAll(c, m);
    }

    public IMember[] toArray() {
        return values.toArray();
    }
}


