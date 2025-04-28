package de.ostfalia.aud.ss25.a3;

import de.ostfalia.aud.ss25.a2.AlgoArrayList;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;

class TreeNode {

    private IAlgoCollection<IMember> value;
    private IMember key;
    TreeNode left;
    TreeNode right;

    protected TreeNode(IMember value){
        this.value = new AlgoArrayList();
        this.value.add(value);
        this.key = value;
    }
    protected void setLeft(TreeNode n){
        this.left = n;
    }
    protected void setRight(TreeNode n){
        this.right = n;
    }
    protected TreeNode getLeft(){
        return this.left;
    }
    protected TreeNode getRight(){
        return this.right;
    }
    protected IMember getKey(){
        return this.key;
    }
    protected IAlgoCollection<IMember> getValue(){
        return this.value;
    }
    protected boolean addValue(IMember m){
        return this.value.add(m);
    }
}
