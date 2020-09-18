package com.sinovoice.lib.tree;

/**
 * Created by liqiang on 2020/9/16.
 **/
public class NodeWD<T> {
    private T value;//节点值
    private  NodeWD<T> leftNode; //左节点
    private  NodeWD<T> rightNode;//右节点
    public NodeWD(){
    }
    public NodeWD(T value,NodeWD<T> leftNode,NodeWD<T> rightNode){
        this.value=value;
        this.leftNode=leftNode;
        this.rightNode=rightNode;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeWD<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(NodeWD<T> leftNode) {
        this.leftNode = leftNode;
    }

    public NodeWD<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(NodeWD<T> rightNode) {
        this.rightNode = rightNode;
    }

    }
