package com.sinovoice.lib;

/**
 * Created by liqiang on 2020/10/27.
 **/
public class ListRevert {
    static class  ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
    public static  void main(String args[]){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        System.out.println("before");
        printList(n1);
        System.out.println("after");
        printList(revert(n1));


    }
    private static void  printList(ListNode head){
        while (head!=null){
            System.out.print( head.value+" ");
            head=head.next;
        }
    }
    private static ListNode revert(ListNode head){
        if (head==null) return null;
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode p3=null;
        while (p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        head.next=null;
        head=p1;

        return head;
    }
    private boolean getIntersectionNode(ListNode head1,ListNode head2){
        if (head1==null||head2==null) return false;
        ListNode p1=head1;
        ListNode p2=head2;
        while (p1!=p2){
            p1=p1.next==null?head2:p1.next;
            p2=p2.next==null?head1:p2.next;
            if (p1==p2)return true;
        }
        return false;
    }
}
