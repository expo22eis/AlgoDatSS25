package de.ostfalia.aud.ss25.a1;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IManagement;
import de.ostfalia.aud.ss25.base.IMember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManagementA1 implements IManagement {

    private IAlgoCollection<IMember> collection;


    public ManagementA1(String[] data) {

        collection = new AlgoLinkedList();

        for (String s : data) {

            IMember m = new Member(s);
            collection.add(m);
        }
    }

    public ManagementA1(String dateiName) throws IOException {
        collection = new AlgoLinkedList();
        BufferedReader reader = new BufferedReader(new FileReader(dateiName));
        String line;
        //Prüft, ob die ersten 3 Chars "key" sind, also, ob es sich um einen Header handelt.
        if (!((line = reader.readLine()).startsWith("key"))){
            IMember m = new Member(line);
            collection.add(m);
        }
        while ((line = reader.readLine()) != null) {

            IMember m = new Member(line);
            collection.add(m);
        }
    }

    public boolean insert(IMember member) {

        if (collection.get(member) != null){ //Wenn es den Member schon gibt, wird abgebrochen.
            return false;
        } else {
            collection.add(member);
            return true;
        }
    }
    public boolean remove(String id){

        return collection.remove(new Member(id,  null, null, null, null, false));
    }
    public IMember search(String id){
        return collection.get(new Member(id, null, null, null, null, false));
    }
    public IAlgoCollection<IMember> members(String surname, String forename){
        return ((AlgoLinkedList) collection)
                .getMembersByNames(new Member("dummy", null, surname, forename, null, false));
    }
    public IAlgoCollection<IMember> members(Group group){
        return ((AlgoLinkedList) collection).getMembersByGroup(new Member("dummy", null, null, null, group, false));
    }
    public int size(){
        return collection.size();
    }
    public int size(Group group){
        return ((AlgoLinkedList) collection).getMembersByGroup(new Member("dummy", null, null, null, group, false)).size();
    }
    public int indexOf(String id){
        return collection.indexOf(new Member(id, null, null, null, null , false));
    }
    public IMember[] toArray(){
        return collection.toArray();
    }
    @Override
    public String toString(){
        return collection.toString();
    }
}
