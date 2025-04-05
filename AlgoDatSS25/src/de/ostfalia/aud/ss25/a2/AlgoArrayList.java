package de.ostfalia.aud.ss25.a2;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import java.util.Comparator;

public class AlgoArrayList implements IAlgoCollection<IMember> {
    

    private IMember[] list = new IMember[0];
    private int size = 0;

    @Override
    public boolean add(IMember m) {

        if (m.equals(null)){
            return false;
        }else{
            upsize();
            list[size -1] = m;
            return true;
        }       
    }

    @Override
    public boolean remove(IMember m) {
        if (m.equals(null)){
            return false;
        }else{
            for (int i =0; i< size; i++){
                if (this.list.equals(m)){
                    this.list[i] = null;
                }
            }
            downsize();
        }
    }

    @Override
    public IMember get(IMember m){
        for (int i = 0; i < size; i++){
            if (m.equals(this.list[i])){
                return m;
            }
        }return null;
    }

    @Override
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        AlgoArrayList algoArrayList = new AlgoArrayList();

        for (int i= 0; i<size; i++){
            if (c.compare(this.list[i], m) == 0){  
                algoArrayList.add(this.list[i]);
            }
        }
    }

    @Override
    public int indexOf(IMember m) {
        for (int i = 0; i < size; i++){
            if (m.equals(this.list[i])){
                return i;
            }
        }return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        int matches = 0;
        for (int i =0; i<size; i++){
            if(c.compare(this.list[i], m) == 0){
                matches++;
            }
        }return matches;
    }

    @Override
    public IMember[] toArray() {
          return this.list;    
    }

    public void sort(Comparator<IMember> c) {
        continue;
    }


    private void upsize(){
        IMember[] tmp = new IMember[size +1];
        for (int i = 0; i < size; i++){
            tmp[i] = this.list[i];
        }
        this.size++;
        this.list = tmp;
    }

    private void downsize(){
        IMember[] tmp = new IMember[size -1];
        int j = 0;
        for (int i= 0; i<size; i++ ){
            if (this.list[i] != null){
                tmp[j] = this.list[i];
                j++;
            }
        }this.list = tmp;       
    }
}
