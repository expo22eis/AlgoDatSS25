package de.ostfalia.aud.ss25.a3;

import de.ostfalia.aud.ss25.a2.AlgoArrayList;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.base.TreeNode;
import de.ostfalia.aud.ss25.comparator.ComparatorId;

import java.util.Comparator;

public class AlgoTreeMap implements IAlgoCollection<IMember> {

    private TreeNode root;
    private Comparator<IMember> comparator;

    private static class Index{
        int v = 0;
    }


    public AlgoTreeMap(Comparator<IMember> c) {
        this.comparator = c;
    }

    public boolean add(IMember m) {

        if (root == null) {
            this.root = new TreeNode(m);
            return true;
        }
        TreeNode pointer = root;
        TreeNode parent = root;
        while (pointer != null) {
            parent = pointer;
            int compResult = comparator.compare(m, pointer.getKey());
            if (compResult < 0) {
                pointer = pointer.getLeft();
            } else if (compResult > 0) {
                pointer = pointer.getRight();
            } else {

                if (comparator instanceof ComparatorId) {
                    return false;
                } else {
                    pointer.addValue(m);
                    return true;
                }
            }
        }
        if (comparator.compare(m, parent.getKey()) < 0) {
            parent.setLeft(new TreeNode(m));
        } else {
            parent.setRight(new TreeNode(m));
        }
        return true;
    }

    public boolean remove(IMember m) {
        return false;
    }

    public IMember get(IMember m) {

        TreeNode pointer = this.root;
        while (pointer != null) {
            int compResult = comparator.compare(m, pointer.getKey());
            if (compResult < 0) {
                pointer = pointer.getLeft();
            } else if (compResult > 0) {
                pointer = pointer.getRight();
            } else {
                if (this.comparator instanceof ComparatorId) {
                    return pointer.getKey();
                } else {
                    return pointer.getValue().get(m);
                }
            }
        }
        return null;
    }

    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        TreeNode pointer = this.root;
        while (pointer != null) {
            int compResult = comparator.compare(m, pointer.getKey());
            if (compResult < 0) {
                pointer = pointer.getLeft();
            } else if (compResult > 0) {
                pointer = pointer.getRight();
            } else {
                if (this.comparator instanceof ComparatorId) {
                    return pointer.getValue();
                } else {
                    return pointer.getValue();
                }
            }
        }
        return new AlgoArrayList();
    }

    public int indexOf(IMember m) {
        return -1;
    }

    @Override
    public int size() {
        if (this.root == null) {
            return 0;
        }
        return this.countMembers(this.root);
    }

    private int countMembers(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int count = node.getValue().size();
        count += countMembers(node.getLeft());
        count += countMembers(node.getRight());
        return count;
    }
    public int size(Comparator<IMember> c, IMember m){

        return this.getAll(c, m).size();
    }
    public IMember[] toArray(){
        if (this.root == null){
            return new IMember[0];
        }

        IMember[] r = new IMember[this.size()];
        traversalRecursive(r, new Index(), this.root);
        return r;
    }
    private void traversalRecursive(IMember[] array, Index index, TreeNode node){

        if (node == null){
            return;
        }
        traversalRecursive(array, index, node.getLeft());

        IMember[] t = node.getValue().toArray();
        for (IMember me : t){
            array[index.v] = me;
            index.v++;
        }
        traversalRecursive(array, index, node.getRight());
    }
    public String toString(){

        StringBuilder s = new StringBuilder();
        for (IMember m : this.toArray()){
            s.append(m.toString());
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public int height(){
        if (root == null){
            return 0;
        }
        return this.getHeight(this.root);
    }
    private int getHeight(TreeNode m){

        if (m == null){
            return 0;
        }
        int leftHeight = this.getHeight(m.getLeft());
        int rightHeight = this.getHeight(m.getRight());

        return Math.max(leftHeight, rightHeight) +1;
    }

}
