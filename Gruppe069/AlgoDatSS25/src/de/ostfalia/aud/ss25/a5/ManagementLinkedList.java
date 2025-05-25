package de.ostfalia.aud.ss25.a5;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.a1.AlgoLinkedList;
import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IManagementA5;
import de.ostfalia.aud.ss25.base.IMember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ManagementLinkedList implements IManagementA5 {

    private LinkedList<IMember> collection;

    public ManagementLinkedList(String[] data) {

        collection = new LinkedList<>();

        for (String s : data) {

            IMember m = new Member(s);
            collection.add(m);
        }
    }

    public ManagementLinkedList(String dateiName) throws IOException {
        collection = new LinkedList<>();
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
        if (this.collection.contains(member)){
            return false;
        }
        this.collection.add(member);
        return true;
    }

    @Override
    public boolean remove(String id) {
        return this.collection.removeIf(n -> n.getId().equals(id));
    }

    @Override
    public IMember search(String id) {
        for (IMember m : this.collection){
            if (m.getId().equals(id)){
                return m;
            }
        }
        return null;
    }

    @Override
    public Collection<IMember> members(String surname, String forename) {
        Predicate<IMember> vorname = n -> n.getForename().equals(forename);
        Predicate<IMember> nachname = n -> n.getSurname().equals(surname);
        return this.collection.stream().filter(vorname.and(nachname)).toList();
    }

    @Override
    public Collection<IMember> members(Group group) {
        Predicate<IMember> gruppe = n -> n.getGroup().equals(group);
        return this.collection.stream().filter(gruppe).toList();
    }

    @Override
    public int size() {
        return this.collection.size();
    }

    @Override
    public int size(Group group) {
        Predicate<IMember> gruppe = n -> n.getGroup().equals(group);
        return this.collection.stream().filter(gruppe).toList().size();
    }

    @Override
    public IMember[] toArray() {
        return this.collection.toArray(new IMember[0]);
    }
}
