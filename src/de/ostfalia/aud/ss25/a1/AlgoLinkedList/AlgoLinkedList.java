package de.ostfalia.aud.ss25.a1.AlgoLinkedList;

import java.util.Comparator;

import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IManagement;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.comparator.*;

public class AlgoLinkedList implements IAlgoCollection<IMember>  {
    private Knoten head;

    @Override
    public boolean add(IMember m) {
        if (head.equals(null)){
            head = new Knoten(m);
            return true;
        }else{
        Knoten newHead = new Knoten(m);
        newHead.setNext(this.head);
        this.head = newHead;
        return true;
        }
    }

    @Override
    public boolean remove(IMember m) {
        if (!find(m)){
            return false;
        }
        else{
            Knoten k = this.head;

            while (!k.getNextMember().equals(m)){           // iteriert solang durch Liste, bis k.getNextMember equals m
                k = k.getNextMember();
            }
            k.setNext(k.getNextMember().getNextMember());
            return true;
        }
    }

    public boolean find(IMember m){
        Knoten k = this.head;
        while( !k.getCurrentMember().equals(null)){
            if ( k.getCurrentMember().equals(m)){
                return true;
            }
            else{
                k = k.getNextMember();
            }
        }
        return false;
    }

    @Override
    public IMember get(IMember m) {
        if (find(m)){
            return m;
        }
        else{
            return null;
        }
    }

    @Override
    public IAlgoCollection getAll(Comparator c, IMember m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public int indexOf(IMember m) {
        if ( find(m) ){                               // wenn m in Liste enthalten ist
            int counter = 0;
            Knoten k = this.head;

            while (!k.getCurrentMember().equals(null)){     // solange k nicht null ist
                if (k.getCurrentMember().equals(m)){          // wenn k == m   
                    return counter;
                }
                else{                                         // wenn k != m
                    k = k.getNextMember();
                    counter++;
                }
                
            }
        }
        return -1;      // wenn m nicht in Liste enthalten ist                                              
        
    }

    @Override
    public int size() {
        Knoten k = this.head;
        int counter = 0;
        
        while ( !k.getCurrentMember().equals(null)){        // solange k != null wird weiter gezählt
            k = k.getNextMember();
            counter++;
        }
        return counter;
    }

    @Override
    public int size(Comparator c, IMember m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public IMember[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
    
}
