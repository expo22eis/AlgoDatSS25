package de.ostfalia.aud.ss25.a4;

import de.ostfalia.aud.ss25.a0.Member;
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

public class ManagementA4 implements IManagement{

    private IAlgoCollection<IMember> tableID;
    private IAlgoCollection<IMember> tableName;
    private IAlgoCollection<IMember> tableGroup;

    public ManagementA4(String[] data) {

        this.tableID = new AlgoHashMap(new ComparatorId(), 8);
        this.tableName = new AlgoHashMap(new ComparatorName(), 8);
        this.tableGroup = new AlgoHashMap(new ComparatorGroup(), 8);

        for (String s : data) {

            IMember m = new Member(s);
            this.tableID.add(m);
            this.tableName.add(m);
            this.tableGroup.add(m);
        }
    }

    public ManagementA4(String dateiName) throws IOException {
        this.tableID = new AlgoHashMap(new ComparatorId(), 200);
        this.tableName = new AlgoHashMap(new ComparatorName(), 200);
        this.tableGroup = new AlgoHashMap(new ComparatorGroup(), 200);

        BufferedReader reader = new BufferedReader(new FileReader(dateiName));
        String line = reader.readLine();
        //Prüft, ob die ersten 3 Chars "key" sind, also, ob es sich um einen Header handelt.
        if (!(line.startsWith("key"))) {
            IMember m = new Member(line);
            this.tableID.add(m);
            this.tableName.add(m);
            this.tableGroup.add(m);
        }
        while ((line = reader.readLine()) != null) {

            IMember m = new Member(line);
            this.tableID.add(m);
            this.tableName.add(m);
            this.tableGroup.add(m);
        }reader.close();
    }
    

    @Override
    public boolean insert(IMember member) {
        if (tableID.add(member)){
            tableGroup.add(member);
            tableName.add(member);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String id) {

        IMember member = tableID.get(new Member(id, null, null, null, null, false));

        if (tableID.get(member) != null){
            tableID.remove(member);
            tableGroup.remove(member);
            tableName.remove(member);
            return true;
        }
        return false;
    }

    @Override
    public IMember search(String id) {
        return this.tableID.get(new Member(id, null, null, null, null, false));
    }

    @Override
    public IAlgoCollection<IMember> members(String surname, String forename) {
        return this.tableName.getAll(new ComparatorName(), new Member("d", null, surname, forename, null, false));
    }

    @Override
    public IAlgoCollection<IMember> members(Group group) {
        return this.tableGroup.getAll(new ComparatorGroup(), new Member("d", null, null, null, group, false));
    }

    @Override
    public int size() {
        return tableID.size();
    }

    @Override
    public int size(Group group) {
        return tableGroup.size(new ComparatorGroup(), new Member(null, null, null, null, group, false));
    }

    @Override
    public int indexOf(String id) {
        return this.tableID.indexOf(new Member(id, null, null, null, null, false));
    }

    @Override
    public IMember[] toArray() {
        return tableID.toArray();
    }

    @Override
    public String toString() {
        return tableID.toString();
    }
    
}