package de.ostfalia.aud.ss25.a4;

import java.util.Comparator;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.a2.AlgoArrayList;

public class Bucket<K, V extends IAlgoCollection<IMember>> implements IAlgoCollection<IMember>{
    private final K key;
    private V values;

    public Bucket(K key){
        this.key = key;
        values = (V) new AlgoArrayList();
    }

    public K getKey(){
        return key;
    }

    public V getValues() {
        return values;
    }


    @Override
    public boolean add(IMember m) {
        return values.add(m);
    }

    @Override
    public boolean remove(IMember m) {
        return values.remove(m);
    }

    @Override
    public IMember get(IMember m) {
        return values.get(m);
    }

    @Override
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        return values.getAll(c, m);
    }

    @Override
    public int indexOf(IMember m) {
        return values.indexOf(m);
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        return values.size(c, m);
    }

    public IMember[] toArray() {
        return values.toArray();
    }
}


