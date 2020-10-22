package com.sinovoice.lib.tree;

/**
 * Created by liqiang on 2020/10/22.
 **/
public class IsBalanceTree {
    public static void main(String args[]){


        BinaryTreeNode t7=new BinaryTreeNode(7,null,null);
        BinaryTreeNode t6=new BinaryTreeNode(6,null,null);

        BinaryTreeNode t5=new BinaryTreeNode(5,null,null);
        BinaryTreeNode t4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode t3=new BinaryTreeNode(3,t4,t5);
        BinaryTreeNode t2=new BinaryTreeNode(2,t6,t7);
        BinaryTreeNode t1=new BinaryTreeNode(1,t2,t3);
        System.out.print("IsBalanceTree="+ isBlalance(t1));
    }
    private static int maxDepth(BinaryTreeNode root){
        if (root==null)return  0;
        return Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()))+1;
    }
    private static boolean isBlalance(BinaryTreeNode root){

        if (root==null)return true;
        int leftTreeMaxDepth=maxDepth(root.getLeft());
        int rightTreeMaxDepth=maxDepth(root.getRight());
        if (Math.abs(leftTreeMaxDepth-rightTreeMaxDepth)>1){
            return false;
        }
        return isBlalance(root.getLeft())&& isBlalance(root.getRight());
    }
}
