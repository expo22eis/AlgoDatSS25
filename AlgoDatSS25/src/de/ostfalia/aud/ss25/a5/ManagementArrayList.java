package de.ostfalia.aud.ss25.a5;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IManagementA5;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.comparator.ComparatorId;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ManagementArrayList implements IManagementA5 {

    private ArrayList<IMember> list;
    private Comparator<IMember> c;
    private boolean isSorted;

    public ManagementArrayList(String[] data) {

        this.list = new ArrayList<>();

        for (String s : data) {

            IMember m = new Member(s);
            this.list.add(m);
        }
        this.list.sort(new ComparatorId());
        this.c = new ComparatorId();
        this.isSorted = true;
    }

    public ManagementArrayList(String dateiName) throws IOException {
        this.list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(dateiName));
        String line = reader.readLine();
        //Prüft, ob die ersten 3 Chars "key" sind, also, ob es sich um einen Header handelt.
        if (!(line.startsWith("key"))) {
            IMember m = new Member(line);
            this.list.add(m);
        }
        while ((line = reader.readLine()) != null) {

            IMember m = new Member(line);
            this.list.add(m);
        }
        this.list.sort(new ComparatorId());
        this.c = new ComparatorId();
        this.isSorted = true;
        reader.close();
    }
    @Override
    public boolean insert(IMember member) {
        if (this.list.stream().anyMatch(m -> m.getId().equals(member.getId()))) {
            return false;
        }
        this.list.add(member);
        this.isSorted = false;
        return true;
    }

    @Override
    public boolean remove(String id) {
        return this.list.removeIf(n -> n.getId().equals(id));
    }

    @Override
    public IMember search(String id) {
        if (!this.isSorted){
            this.list.sort(c);
        }
        int i = this.list.indexOf(new Member(id, null, null, null, null, false));
        if(i == -1){
            return null;
        }
        return this.list.get(i);

    }

    @Override
    public Collection<IMember> members(String surname, String forename) {
        List<IMember> result = new ArrayList<>();
        for (IMember m : this.list) {
            if (m.getSurname().equals(surname) && m.getForename().equals(forename)) {
                result.add(m);
            }
        }
        return result;
    }


    @Override
    public Collection<IMember> members(Group group) {
        Predicate<IMember> gruppe = n -> n.getGroup().equals(group);
        return this.list.stream().filter(gruppe).toList();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public int size(Group group) {
        Predicate<IMember> gruppe = n -> n.getGroup().equals(group);
        return this.list.stream().filter(gruppe).toList().size();
    }

    @Override
    public IMember[] toArray() {
        this.list.sort(this.c);
        this.isSorted = true;
        return this.list.toArray(new IMember[0]);
    }
}