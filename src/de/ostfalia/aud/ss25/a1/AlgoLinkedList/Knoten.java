package de.ostfalia.aud.ss25.a1.AlgoLinkedList;

import de.ostfalia.aud.ss25.base.*;
import de.ostfalia.aud.ss25.a0.*;

public class Knoten{
    private IMember currentMember; //first Member in IMember List
    private Knoten nextMember; //last Member in IMember List

    public Knoten(IMember m){
        this.currentMember = m;
    }
    public void setNext(Knoten k){
        this.nextMember = k;
    }
    public Knoten getNextMember(){
        return this.nextMember;
    }
    public IMember getCurrentMember(){
        return this.currentMember;
    }


}

