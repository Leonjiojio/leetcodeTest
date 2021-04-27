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
        System.out.println("�������="+count);
    }
    private static int count=0;
    private static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A==null)return;
        int n= A.size();
        func(n,A,B,C);

    }

    /**
     * 1.��������ĵݹ麯������ȷ�����Ĺ���,���Ƕ�����������Ĺ���Ϊ���� A ����� n ��Բ�̾��� B �Ƶ� C
     * 2.��ϵ��ʽ��move(n from A to C) = move(n-1 from A to B) + move(A to C) + move(n-1 from B to C`)
     * �����ɵã����Ƿ������ߡ�
     * (1)�Ȱ�A�ϵ�n-1��Բ�̣�ͨ����C�Ĳ����ƶ���B�ϡ�
     * (2)��Aʣ�µ�����һ�����ƶ���C��
     * (3)�ٰ�B�ϵ�n-1���̣�ͨ����A�Ĳ����ƶ���C�ϡ�
     * ������ô�ƶ������������Ĺ�ϵ��������������������Ϳ��Կ�ʼ�ݹ顣
     *
     * ���ߣ�jhtoed
     * ���ӣ�https://leetcode-cn.com/problems/hanota-lcci/solution/zhi-qian-yi-zhi-tiao-guo-yi-nuo-ta-zhe-ci-zhong-yu/
     * ��Դ�����ۣ�LeetCode��
     */
    private static void func(int size,List<Integer> A, List<Integer> B, List<Integer> C){
        count++;
        //�����Ӷ��ƶ�����֮��ֹͣ�ݹ�
        if (size<=0){return;}
        //��A����� n-1 ��Բ�̾��� C �Ƶ� B
        func(size-1,A,C,B);
        //��ʱ�� A ���µ��ǿ�����Բ���Ƶ� C
        C.add(A.remove(A.size()-1));
        // �ٽ� B �ϵ� n-1 ��Բ�̾���A�Ƶ� C��
        func(size-1,B,A,C);
    }
}
