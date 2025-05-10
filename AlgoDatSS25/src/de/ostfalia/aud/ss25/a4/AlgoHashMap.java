package de.ostfalia.aud.ss25.a4;

import de.ostfalia.aud.ss25.a2.AlgoArrayList;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.comparator.ComparatorGroup;
import de.ostfalia.aud.ss25.comparator.ComparatorId;
import de.ostfalia.aud.ss25.comparator.ComparatorName;


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
            resizeArray();
        }

        int hashCode = computeHashCode(m);
        int index = (hashCode & Integer.MAX_VALUE) % bucketList.length;

        for (int i= 0; i< bucketList.length; i++){
            if(bucketList[index] == null){
                bucketList[index] = new Bucket<Integer, IAlgoCollection<IMember>>(hashCode);
                bucketList[index].add(m);
                capacity++;
                return true;
            }else if(bucketList[index].getKey().equals(hashCode)){
                bucketList[index].add(m);
                return true;
            }else{
                index = (index + 1) % bucketList.length;
            }
        }return false;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    
    public int indexOf(IMember m) {
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
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
                IMember[] array = bucket.toArray(); // Annahme: Bucket gibt ein Array aus
                for (IMember m : array) {
                    all.add(m);
                }
            }
        }return all.toArray();
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
}
