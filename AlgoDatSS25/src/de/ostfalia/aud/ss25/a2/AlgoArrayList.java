package de.ostfalia.aud.ss25.a2;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import java.util.Comparator;

public class AlgoArrayList implements IAlgoCollection<IMember> {
    

    private IMember[] list = new IMember[0];
    private int size;

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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IMember[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void upsize(){
        IMember[] tmp = new IMember[size +1];
        for (int i = 0; i < size; i++){
            tmp[i] = this.list[i];
        }
        this.size++;
        this.list = tmp;
    }
    public void downsize(int index){
        IMember[] tmp = new IMember[size -1];

        
    }
}
