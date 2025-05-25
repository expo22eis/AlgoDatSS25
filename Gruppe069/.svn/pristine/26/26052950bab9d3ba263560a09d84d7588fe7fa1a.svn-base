package de.ostfalia.aud.ss25.base;

import de.ostfalia.aud.ss25.a2.AlgoArrayList;

public class TreeNode {

    private IAlgoCollection<IMember> value;
    private IMember key;
    TreeNode left;
    TreeNode right;

    public TreeNode(IMember value){
        this.value = new AlgoArrayList();
        this.value.add(value);
        this.key = value;
    }
    public void setLeft(TreeNode n){
        this.left = n;
    }
    public void setRight(TreeNode n){
        this.right = n;
    }
    public TreeNode getLeft(){
        return this.left;
    }
    public TreeNode getRight(){
        return this.right;
    }
    public IMember getKey(){
        return this.key;
    }
    public IAlgoCollection<IMember> getValue(){
        return this.value;
    }
    public boolean addValue(IMember m){
        return this.value.add(m);
    }
}
