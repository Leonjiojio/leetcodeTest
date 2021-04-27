package com.example.geektest.binarytree;


/**
 * Created by  on 2021/4/27.
 **/
class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode<Integer> head = getTestNode();

//        TreeNode<Integer> result = findRecursion(4, head);
//        System.out.println("result="+result.value);
        int deep=treeDeep(head);
        System.out.println("treeDeep="+deep);

    }
    private static TreeNode<Integer> find(int target,TreeNode<Integer> head){
        TreeNode<Integer> p=head;
        while (p!=null){
            if (p.value==target)return p;
            if (target<p.value){
                p=p.left;
            }else{
                p=p.right;
            }
        }
        return p;
    }
    private static  void insert(int data,TreeNode<Integer> head){
        TreeNode<Integer> newP = new TreeNode<Integer>(data);
        TreeNode<Integer> p=head;
        while (p!=null){
            if (data<p.value){
                if (p.left==null){
                    p.left=newP;
                    return;
                }
                p=p.left;
            }else{
                if (p.right==null){
                    p.right=newP;
                    return;
                }
                p=p.right;
            }
        }
    }

    private static int treeDeep(TreeNode<Integer> head){
        TreeNode<Integer> p=head;
        if (p==null){
            return 0;
        }
        int leftMax=treeDeep(p.left);
        int rightMax=treeDeep(p.right);
        return Math.max(leftMax,rightMax)+1;
    }
    private static TreeNode<Integer> findRecursion(int target,TreeNode<Integer> head){
        TreeNode<Integer> p=head;
        if (p!=null){
            if (p.value==target)return p;
            if (target<p.value){
                return findRecursion(target,p.left);
            }else{
                return findRecursion(target,p.right);
            }
        }
        return p;
    }


    private static TreeNode<Integer> getTestNode(){

        TreeNode<Integer> t2=new TreeNode<Integer>(2,null,null);
        TreeNode<Integer> t1=new TreeNode<Integer>(1,null,null);
        TreeNode<Integer> t3=new TreeNode<Integer>(3,t1,t2);

        TreeNode<Integer> t7=new TreeNode<Integer>(7,null,null);
        TreeNode<Integer> t5=new TreeNode<Integer>(5,null,null);
        TreeNode<Integer> t6=new TreeNode<Integer>(6,t5,t7);

        TreeNode<Integer> t4=new TreeNode<Integer>(4,t3,t6);

        return t4;
    }
}
