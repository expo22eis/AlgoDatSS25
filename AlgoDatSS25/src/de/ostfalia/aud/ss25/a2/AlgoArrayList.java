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
            int lowerLimit = 0;
            int upperLimit = this.size -1;

            while (lowerLimit <= upperLimit){
                int median = (lowerLimit + upperLimit) /2;

                if(this.list[median].equals(m)){
                    this.list[median] = null;
                    downsize();
                    return true;
                }else if(m.compareTo(this.list[median]) < 0){
                    upperLimit = median -1;
                }else{
                    lowerLimit = median +1;
                }
                }
            }return false;
    }

    @Override
    public IMember get(IMember m){
        if (m.equals(null)){
            return null;
        }else{
            int lowerLimit = 0;
            int upperLimit = this.size -1;

            while (lowerLimit <= upperLimit){
                int median = (lowerLimit + upperLimit) /2;

                if(this.list[median].equals(m)){
                    return this.list[median];
                }else if(m.compareTo(this.list[median]) < 0){
                    upperLimit = median -1;
                }else{
                    lowerLimit = median +1;
                }
            }
        }return null;
    }

    @Override
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        AlgoArrayList algoArrayList = new AlgoArrayList();

        if (m.equals(null)){
            return null;
        }else{
            int lowerLimit = 0;
            int upperLimit = this.size -1;

            while (lowerLimit <= upperLimit){
                int median = (lowerLimit + upperLimit) /2;

                if(this.list[median].equals(m)){
                    algoArrayList.add(this.list[median]);
                }else if(m.compareTo(this.list[median]) < 0){
                    upperLimit = median -1;
                }else{
                    lowerLimit = median +1;
                }
            }
        }return algoArrayList;
    }

    @Override
    public int indexOf(IMember m) {
        if (m.equals(null)){
            return -1;
        }else{
            int lowerLimit = 0;
            int upperLimit = this.size -1;

            while (lowerLimit <= upperLimit){
                int median = (lowerLimit + upperLimit) /2;

                if(this.list[median].equals(m)){
                    return median;
                }else if(m.compareTo(this.list[median]) < 0){
                    upperLimit = median -1;
                }else{
                    lowerLimit = median +1;
                }
            }
        }return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        int counter = 0;

        if (m.equals(null)){
            return -1;
        }else{
            int lowerLimit = 0;
            int upperLimit = this.size -1;

            while (lowerLimit <= upperLimit){
                int median = (lowerLimit + upperLimit) /2;

                if(this.list[median].equals(m)){
                    counter++;
                }else if(m.compareTo(this.list[median]) < 0){
                    upperLimit = median -1;
                }else{
                    lowerLimit = median +1;
                }
            }
        }return counter;
    }

    @Override
    public IMember[] toArray() {
          return this.list;    
    }

    public void sort(Comparator<IMember> c) {
        
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
