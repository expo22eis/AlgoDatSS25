package de.ostfalia.aud.ss25.a5;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.a3.AlgoTreeMap;
import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IManagementA5;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.comparator.ComparatorGroup;
import de.ostfalia.aud.ss25.comparator.ComparatorId;
import de.ostfalia.aud.ss25.comparator.ComparatorName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

public class ManagementTreeMap implements IManagementA5 {

    private TreeMap<IMember, ArrayList<IMember>> treeID;
    private TreeMap<IMember, ArrayList<IMember>> treeName;
    private TreeMap<IMember, ArrayList<IMember>> treeGroup;

    public ManagementTreeMap(String[] data) {

        this.treeID = new TreeMap<>(new ComparatorId());
        this.treeName = new TreeMap<>(new ComparatorName());
        this.treeGroup = new TreeMap<>(new ComparatorGroup());

        for (String s : data) {

            IMember m = new Member(s);
            this.treeID.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.treeName.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.treeGroup.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
        }
    }

    public ManagementTreeMap(String dateiName) throws IOException {
        this.treeID = new TreeMap<>(new ComparatorId());
        this.treeName = new TreeMap<>(new ComparatorName());
        this.treeGroup = new TreeMap<>(new ComparatorGroup());

        BufferedReader reader = new BufferedReader(new FileReader(dateiName));
        String line = reader.readLine();
        //Prüft, ob die ersten 3 Chars "key" sind, also, ob es sich um einen Header handelt.
        if (!(line.startsWith("key"))) {
            IMember m = new Member(line);
            this.treeID.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.treeName.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.treeGroup.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
        }
        while ((line = reader.readLine()) != null) {

            IMember m = new Member(line);
            this.treeID.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.treeName.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.treeGroup.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
        }
        reader.close();
    }

    @Override
    public boolean insert(IMember member) {
        if (treeID.containsKey(member)) {
            return false;
        }

        treeID.computeIfAbsent(member, k -> new ArrayList<>()).add(member);
        treeName.computeIfAbsent(member, k -> new ArrayList<>()).add(member);
        treeGroup.computeIfAbsent(member, k -> new ArrayList<>()).add(member);

        return true;
    }



    @Override
    public boolean remove(String id) {
        IMember dummy = new Member(id, null, null, null, null, false);
        ArrayList<IMember> removed = this.treeID.remove(dummy);
        if (removed == null || removed.isEmpty()) {
            return false;
        }

        IMember member = removed.get(0);
        this.treeGroup.remove(member);
        this.treeName.remove(member);
        return true;
    }

    @Override
    public IMember search(String id) {
        ArrayList<IMember> list = this.treeID.get(new Member(id, null, null, null, null, false));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }


    @Override
    public Collection<IMember> members(String surname, String forename) {
        Collection<IMember> result = this.treeName.get(new Member("d", null, surname, forename, null, false));
        if (result == null){
            return List.of();
        }
        else{
            return result;
        }
    }


    @Override
    public Collection<IMember> members(Group group) {
        return this.treeGroup.get(new Member("d", null, null, null, group, false));
    }

    @Override
    public int size() {
        return this.treeID.size();
    }

    @Override
    public int size(Group group) {
        Collection<IMember> result = this.treeGroup.get(new Member("d", null, null, null, group, false));
        if (result == null){
            return 0;
        }
        else{
            return result.size();
        }
    }


    @Override
    public IMember[] toArray() {
        IMember[] r = new IMember[this.size()];
        int zeiger = 0;
        for (ArrayList<IMember> m : this.treeID.values()){
            for (IMember s : m){
                r[zeiger] = s;
                zeiger++;
            }
        }
        return r;
    }
}
