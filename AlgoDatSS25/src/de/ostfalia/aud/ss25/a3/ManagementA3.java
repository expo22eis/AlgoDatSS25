package de.ostfalia.aud.ss25.a3;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.a2.AlgoArrayList;
import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IManagement;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.comparator.ComparatorGroup;
import de.ostfalia.aud.ss25.comparator.ComparatorId;
import de.ostfalia.aud.ss25.comparator.ComparatorName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManagementA3 implements IManagement {

    private IAlgoCollection<IMember> treeID;
    private IAlgoCollection<IMember> treeName;
    private IAlgoCollection<IMember> treeGroup;

    public ManagementA3(String[] data) {

        this.treeID = new AlgoTreeMap(new ComparatorId());
        this.treeName = new AlgoTreeMap(new ComparatorName());
        this.treeGroup = new AlgoTreeMap(new ComparatorGroup());

        for (String s : data) {

            IMember m = new Member(s);
            this.treeID.add(m);
            this.treeName.add(m);
            this.treeGroup.add(m);
        }
    }

    public ManagementA3(String dateiName) throws IOException {
        this.treeID = new AlgoTreeMap(new ComparatorId());
        this.treeName = new AlgoTreeMap(new ComparatorName());
        this.treeGroup = new AlgoTreeMap(new ComparatorGroup());

        BufferedReader reader = new BufferedReader(new FileReader(dateiName));
        String line;
        //Prüft, ob die ersten 3 Chars "key" sind, also, ob es sich um einen Header handelt.
        if (!((line = reader.readLine()).startsWith("key"))) {
            IMember m = new Member(line);
            this.treeID.add(m);
            this.treeName.add(m);
            this.treeGroup.add(m);
        }
        while ((line = reader.readLine()) != null) {

            IMember m = new Member(line);
            this.treeID.add(m);
            this.treeName.add(m);
            this.treeGroup.add(m);
        }
    }

    @Override
    public boolean insert(IMember member) {
        if (this.treeID.add(member)){
            this.treeName.add(member);
            this.treeGroup.add(member);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public IMember search(String id) {
        return this.treeID.get(new Member(id, null, null, null, null, false));
    }

    @Override
    public IAlgoCollection<IMember> members(String surname, String forename) {
        return this.treeName.getAll(new ComparatorName(), new Member("d", null, surname, forename, null, false));
    }

    @Override
    public IAlgoCollection<IMember> members(Group group) {
        return this.treeGroup.getAll(new ComparatorGroup(), new Member("d", null, null, null, group, false));
    }

    @Override
    public int size() {
        return this.treeID.size();
    }

    @Override
    public int size(Group group) {
        return this.treeGroup.size(new ComparatorGroup(), new Member("d", null, null, null, group, false));
    }

    @Override
    public int indexOf(String id) {
        return -1;
    }

    @Override
    public IMember[] toArray() {
        return this.treeID.toArray();
    }

    @Override
    public int height() {
        return this.treeID.height();
    }
    @Override
    public String toString(){
        return this.treeID.toString();
    }
}
