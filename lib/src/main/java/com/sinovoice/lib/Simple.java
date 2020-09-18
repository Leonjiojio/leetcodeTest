package com.sinovoice.lib;

/**
 * Created by liqiang on 2020/9/10.
 **/
public class Simple {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int reverse(int x)
    {
        int max = 0x7fffffff, min = 0x80000000;//int的最大值最小值
        long rs = 0;//用long类型判断溢出

        for(;x>0;
            rs = rs*10+x%10,x/=10);//逆序，正负通吃，不用单独考虑负值
        return (rs>max||rs<min)?0:(int)rs;//超了最大值低于最小值就返回0
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode n1=headA;
        ListNode n2=headB;
        while (n1!=n2){
            n1=n1==null?headB:n1.next;
            n2=n2==null?headA:n2.next;
        }
        return n1;
    }

     class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
