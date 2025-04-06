package de.ostfalia.aud.ss25.a2;

import java.io.IOException;

import de.ostfalia.aud.ss25.a0.Member;
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

    }

    @Override
    public boolean insert(IMember member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public boolean remove(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public IMember search(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public IAlgoCollection<IMember> members(String surname, String forename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'members'");
    }

    @Override
    public IAlgoCollection<IMember> members(Group group) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'members'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public int size(Group group) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public int indexOf(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public IMember[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
    
}
