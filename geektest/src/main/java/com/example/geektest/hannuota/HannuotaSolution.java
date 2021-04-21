package com.example.geektest.hannuota;

import java.util.List;
import java.util.Stack;

/**
 * Created by  on 2021/4/21.
 **/
class HannuotaSolution {
    public static void main(String[] args) {

        Stack<Integer> a=new Stack<>();
        Stack<Integer> b=new Stack<>();
        Stack<Integer> c=new Stack<>();
        for (int i = 0; i < 10; i++) {
            a.push(i);
        }
        hanota(a,b,c);
        while (!c.empty()){
            System.out.println("result="+c.pop());
        }
        System.out.println("计算次数="+count);
    }
    private static int count=0;
    private static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A==null)return;
        int n= A.size();
        func(n,A,B,C);

    }

    /**
     * 1.定义问题的递归函数，明确函数的功能,我们定义这个函数的功能为：把 A 上面的 n 个圆盘经由 B 移到 C
     * 2.关系公式：move(n from A to C) = move(n-1 from A to B) + move(A to C) + move(n-1 from B to C`)
     * 分析可得，我们分三步走。
     * (1)先把A上的n-1个圆盘，通过和C的操作移动到B上。
     * (2)把A剩下的最大的一个盘移动到C。
     * (3)再把B上的n-1个盘，通过和A的操作移动到C上。
     * 不管怎么移动问题和子问题的关系都可以是这三步，下面就可以开始递归。
     *
     * 作者：jhtoed
     * 链接：https://leetcode-cn.com/problems/hanota-lcci/solution/zhi-qian-yi-zhi-tiao-guo-yi-nuo-ta-zhe-ci-zhong-yu/
     * 来源：力扣（LeetCode）
     */
    private static void func(int size,List<Integer> A, List<Integer> B, List<Integer> C){
        count++;
        //当盘子都移动空了之后停止递归
        if (size<=0){return;}
        //将A上面的 n-1 个圆盘经由 C 移到 B
        func(size-1,A,C,B);
        //此时将 A 底下的那块最大的圆盘移到 C
        C.add(A.remove(A.size()-1));
        // 再将 B 上的 n-1 个圆盘经由A移到 C上
        func(size-1,B,A,C);
    }
}
