package de.ostfalia.aud.ss25.a5;

import de.ostfalia.aud.ss25.a0.Member;
import de.ostfalia.aud.ss25.base.Group;
import de.ostfalia.aud.ss25.base.IManagementA5;
import de.ostfalia.aud.ss25.base.IMember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ManagementHashMap implements IManagementA5{

    private HashMap<IMember, ArrayList<IMember>> mapID;
    private HashMap<IMember, ArrayList<IMember>> mapName;
    private HashMap<IMember, ArrayList<IMember>> mapGroup;

    public ManagementHashMap(String[] data) {

        this.mapID = new HashMap<>();
        this.mapName = new HashMap<>();
        this.mapGroup = new HashMap<>();

        for (String s : data) {

            IMember m = new Member(s);
            this.mapID.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.mapName.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.mapGroup.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
        }
    }

    public ManagementHashMap(String dateiName) throws IOException {

        this.mapID = new HashMap<>();
        this.mapName = new HashMap<>();
        this.mapGroup = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(dateiName));
        String line = reader.readLine();
        //Prüft, ob die ersten 3 Chars "key" sind, also, ob es sich um einen Header handelt.
        if (!(line.startsWith("key"))) {
            IMember m = new Member(line);
            this.mapID.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.mapName.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.mapGroup.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
        }
        while ((line = reader.readLine()) != null) {

            IMember m = new Member(line);
            this.mapID.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.mapName.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
            this.mapGroup.computeIfAbsent(m, n -> new ArrayList<>()).add(m);
        }
        reader.close();
    }

    @Override
    public boolean insert(IMember member) {
        if (mapID.containsKey(member)) {
            return false;
        }

        mapID.computeIfAbsent(member, k -> new ArrayList<>()).add(member);
        mapName.computeIfAbsent(member, k -> new ArrayList<>()).add(member);
        mapGroup.computeIfAbsent(member, k -> new ArrayList<>()).add(member);

        return true;
    }

    @Override
    public boolean remove(String id) {
        IMember dummy = new Member(id, null, null, null, null, false);
        ArrayList<IMember> removed = this.mapID.remove(dummy);
        if (removed == null || removed.isEmpty()) {
            return false;
        }

        IMember member = removed.get(0);
        this.mapGroup.remove(member);
        this.mapName.remove(member);
        return true;
    }

    @Override
    public IMember search(String id) {
        IMember member = (IMember) mapID.get(new Member(id, null, null, null, null, false));
        if (mapID.get(new Member(id, null, null, null, null, false)) != null){
            return null;
        }else{
            return member;
        }
    }

    @Override
    public Collection<IMember> members(String surname, String forename) {
        Collection<IMember> result = this.mapName.get(new Member("d", null, surname, forename, null, false));
        if (result == null){
            return List.of();
        }else{
            return result;
        }
    }

    @Override
    public Collection<IMember> members(Group group) {
        return this.mapGroup.get(new Member("d", null, null, null, group, false));
    }

    @Override
    public int size() {
        return this.mapID.size();
    }

    @Override
    public int size(Group group) {
        Collection<IMember> result = this.mapGroup.get(new Member("d", null, null, null, group, false));
        if (result == null){
            return 0;
        }else{
            return result.size();
        }
    }

    @Override
    public IMember[] toArray() {
        IMember[] members = new IMember[this.size()];
        int zeiger = 0;
        for (ArrayList<IMember> m : this.mapID.values()){
            for (IMember s : m){
                members[zeiger] = s;
                zeiger++;
            }
        }
        return members;
    }
    
}