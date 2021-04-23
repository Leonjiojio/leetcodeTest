package com.sinovoice.lib.tree;

import java.util.Stack;

/**
 * Created by liqiang on 2020/10/22.
 **/
public class IsBalanceTree {
    public static void main(String args[]){



//        System.out.print("IsBalanceTree="+ isBlalance(t1));
        System.out.print("TreeDep="+ depth2(getTestNode()));
    }
    private static int maxDepth(BinaryTreeNode root){
        if (root==null)return  0;
        return Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()))+1;
    }

    public static BinaryTreeNode getTestNode(){
        BinaryTreeNode t9=new BinaryTreeNode(9,null,null);
        BinaryTreeNode t8=new BinaryTreeNode(8,t9,null);

        BinaryTreeNode t7=new BinaryTreeNode(7,t8,null);
        BinaryTreeNode t6=new BinaryTreeNode(6,null,null);

        BinaryTreeNode t5=new BinaryTreeNode(5,null,null);
        BinaryTreeNode t4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode t3=new BinaryTreeNode(3,t4,t5);
        BinaryTreeNode t2=new BinaryTreeNode(2,t6,t7);
        BinaryTreeNode t1=new BinaryTreeNode(1,t2,t3);
        return t1;
    }

    static int depth2(BinaryTreeNode pNode){
        Stack<BinaryTreeNode> stack=new Stack<>();
        Stack<Integer> tag=new Stack<>();
        if(pNode==null) return 0;
        BinaryTreeNode cur=pNode;
        int max=0;
        while(cur!=null||!stack.empty()){
            while(cur!=null){//将当前元素入栈，并尝试不断将其左孩子入栈
                stack.push(cur);
                tag.push(0);
                cur=cur.getLeft();
            }
//cur为null，栈顶元素无左孩子
            if(tag.peek()==1){
                max=Math.max(max, stack.size());
//System.out.print(stack.peek().getValue()+",");此处输出的值为后序遍历的结果
                stack.pop();
                tag.pop();
                cur=null;//将当前指针指向空，则不执行从该节点向左找左孩子的操作
            }else{
                BinaryTreeNode node=stack.peek();
                cur=node.getRight();
//修改栈顶tag标记为1
                tag.pop();
                tag.push(1);
            }

        }
        return max;
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

    private static int depth(BinaryTreeNode root){
        int m,n;
        if (root==null ){
            return 0; //如果是空树，深度为0，递归结束
        }else{
            m=depth(root.getLeft()); //递归计算左子树的深度记为m
            n=depth(root.getRight());//递归计算右子树的深度记为n
            if (m>n){//二叉树的深度为m 与n的较大者加1
                return m+1;
            }else{
                return n+1;
            }
        }

    }
}
