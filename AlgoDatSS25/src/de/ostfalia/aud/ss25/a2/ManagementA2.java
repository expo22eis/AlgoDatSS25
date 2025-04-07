package de.ostfalia.aud.ss25.a2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.a1.AlgoLinkedList;
import de.ostfalia.aud.ss25.a2.AlgoArrayList;
import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IManagement;
import de.ostfalia.aud.ss25.base.IMember;

public class ManagementA2 implements IManagement{

    private IAlgoCollection<IMember> collection;

    public ManagementA2(String[] data){
        collection = new AlgoArrayList();

        for (String s : data) {
 
            IMember m = new Member(s);
            collection.add(m);
        }
    }

    public ManagementA2(String dateiName) throws IOException{
        collection = new AlgoLinkedList();
        BufferedReader reader = new BufferedReader(new FileReader(dateiName));
        String line;
        //Prüft, ob die ersten 3 Chars "key" sind, also, ob es sich um einen Header handelt.
        line = reader.readLine();
        if (!(line.startsWith("key"))){
            IMember m = new Member(line);
            collection.add(m);
        }
        while ((line = reader.readLine()) != null) {

            IMember m = new Member(line);
            collection.add(m);
        }
        reader.close();
    }

    @Override
    public boolean insert(IMember member) {
        if (collection.get(member) != null){
            return false;
        }else{
            collection.add(member);
            return true;
        }
    }

    @Override
    public boolean remove(String id) {
        return collection.remove(new Member(id,  null, null, null, null, false));
    }

    @Override
    public IMember search(String id) {
        return collection.get(new Member(id, null, null, null, null, false));
    }

    @Override
    public IAlgoCollection<IMember> members(String surname, String forename) {
        return ((AlgoArrayList) collection)
                    .getMembersByNames(new Member("dummy", null, surname, forename, null, false));
    }

    @Override
    public IAlgoCollection<IMember> members(Group group) {
        return ((AlgoArrayList) collection)
                    .getMembersByGroup(new Member("dummy", null, null, null, group, false));
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public int size(Group group) {
        return ((AlgoArrayList) collection)
                    .getMembersByGroup(new Member("dummy", null, null, null, group, false))
                    .size();

        
    }

    @Override
    public int indexOf(String id) {
        return ((AlgoArrayList) collection)
                    .indexOf(new Member(id, null, null, null, null, false));
    }

    @Override
    public IMember[] toArray() {
        return ((AlgoArrayList) collection).toArray();
    }
    
}
