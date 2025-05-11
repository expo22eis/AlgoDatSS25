package de.ostfalia.aud.ss25.a4;

import de.ostfalia.aud.ss25.a2.AlgoArrayList;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.comparator.ComparatorGroup;
import de.ostfalia.aud.ss25.comparator.ComparatorId;
import de.ostfalia.aud.ss25.comparator.ComparatorName;


import java.util.Comparator;
import java.util.function.Function;

public class AlgoHashMap implements IAlgoCollection<IMember>{

    private Bucket<Integer, IAlgoCollection<IMember>>[] bucketList;
    private final Comparator<IMember> comparator;
    private int capacity; 
    

    public AlgoHashMap(Comparator<IMember> c, int size){
        this.comparator = c;
        bucketList = new Bucket[size];
        capacity = 0;
    }
    
    public boolean add(IMember m) {
    if ((double) capacity / bucketList.length > 0.8) {
        resizeArray();
    }

    int hashCode = computeHashCode(m);
    int index = (hashCode & Integer.MAX_VALUE) % bucketList.length;

    for (int i = 0; i < bucketList.length; i++) {
        if (bucketList[index] == null) {
            bucketList[index] = new Bucket<>(hashCode);
            bucketList[index].add(m);
            capacity++;
            return true;
        } else if (bucketList[index].getKey().equals(hashCode)) {
            if (bucketList[index].indexOf(m) >= 0) {
                return false;
            }
            bucketList[index].add(m);
            return true;
        } else {
            index = (index + 1) % bucketList.length;
        }
    }
    return false;
}

    public boolean remove(IMember m) {
        int hashCode = computeHashCode(m);
        int index = (hashCode & Integer.MAX_VALUE) % bucketList.length;

        for(int i= 0; i< bucketList.length; i++){
            if (bucketList[index] == null){
                return false;
            }else if(bucketList[index].getKey().equals(hashCode)){
                return bucketList[index].remove(m);
            }else{
                index = (index + 1) % bucketList.length;
            }
        }return false;
    }

    public IMember get(IMember m) {
        int hash = this.computeHashCode(m);
        int index = (hash & Integer.MAX_VALUE) % this.bucketList.length;

        if (this.bucketList[index] != null && this.bucketList[index].getKey().equals(hash)) {
            return this.bucketList[index].get(m);
        }
        else {
            return linearSondieren(m, index, hash, t -> t.get(m));
        }
    }

    
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        int hash = this.computeHashCode(m);
        int index = (hash & Integer.MAX_VALUE) % this.bucketList.length;

        if (this.bucketList[index] != null && this.bucketList[index].getKey().equals(hash)) {
            return this.bucketList[index].getAll(this.comparator, m);
        }
        else {
            IAlgoCollection<IMember> r = linearSondieren(m, index, hash, t -> t.getAll(this.comparator, m));
            if (r == null){
                return new AlgoArrayList();
            }
            return r;
        }
    }

    
    public int indexOf(IMember m) {
        int hash = this.computeHashCode(m);
        int index = (hash & Integer.MAX_VALUE) % this.bucketList.length;

        if (this.bucketList[index] != null && this.bucketList[index].getKey().equals(hash)) {
            return this.bucketList[index].indexOf(m);
        }
        else {
            Integer r = linearSondieren(m, index, hash, t -> t.indexOf(m));
            if (r == null){
                return -1;
            }
            else{
                return r;
            }
        }
    }

    
    public int size() {
        return capacity;
    }

    public int size(Comparator<IMember> c, IMember m) {
        int size = 0;
        int hashCode = computeHashCode(m);
        int index = (hashCode & Integer.MAX_VALUE) % bucketList.length;

        for(int i= 0; i< bucketList.length; i++){
            if(bucketList[index] == null){
                return 0;
            }else if(bucketList[index].getKey().equals(computeHashCode(m))){
                return bucketList[index].size(c, m);
            }else{
                index = (index + 1) % bucketList.length;
            }
        }return 0;
    }

    public IMember[] toArray() {
        AlgoArrayList all = new AlgoArrayList();

        for (Bucket<Integer, IAlgoCollection<IMember>> bucket : bucketList) {
            if (bucket != null) {
                IMember[] array = bucket.toArray();
                for (IMember m : array) {
                    all.add(m);
                }
            }
        }return all.toArray().sort(comparator);
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();

        for (int i = 0; i< this.bucketList.length; i++){
            if (bucketList[i] == null){
                continue;
            }
            s.append(String.format("Hashcode: %d. Erwartet an: %d, tatsächlich an: %d. Enthält: \n %s\n",
                    bucketList[i].getKey(),
                    ((bucketList[i].getKey() & Integer.MAX_VALUE) % this.bucketList.length),
                    i,
                    bucketList[i].getValues().toString()));
        }
        return s.toString();
    }
    
    private int computeHashCode(IMember m){
        if (comparator instanceof ComparatorId){
            return m.getId().hashCode();
        }else if (comparator instanceof ComparatorGroup){
            return m.getGroup().hashCode();
        }else if (comparator instanceof ComparatorName){
            return (m.getSurname().concat(m.getForename())).hashCode();
        }
        return 0;
    }

    private void resizeArray(){
        Bucket<Integer, IAlgoCollection<IMember>>[] bucketListNeu = new Bucket[this.bucketList.length*2];

        for (int i = 0; i< this.bucketList.length; i++){
            if (this.bucketList[i] == null){
                continue;
            }
            int currentHash = this.bucketList[i].getKey();
            int newIndex = (currentHash & Integer.MAX_VALUE) % bucketListNeu.length;
            if (bucketListNeu[newIndex] == null){
                bucketListNeu[newIndex] = this.bucketList[i];
            }else{
                int index = (newIndex + 1) % bucketListNeu.length;
                while (index != newIndex){
                    if (bucketListNeu[index] == null){
                        bucketListNeu[index] = this.bucketList[i];
                        break;
                    }
                    index = (index + 1) % bucketListNeu.length;
                }
            }
        }
        this.bucketList = bucketListNeu;
    }

    private <T> T linearSondieren(IMember m, int startIndex, int hash, Function<Bucket<Integer, IAlgoCollection<IMember>>, T> func) {
        int index = (startIndex + 1) % bucketList.length;

        while (index != startIndex) {
            if (bucketList[index] != null && bucketList[index].getKey().equals(hash)) {
                T result = func.apply(bucketList[index]);
                return result;
            }
            index = (index + 1) % bucketList.length;
        }
        return null;
    }
}
