package com.example.geektest.recursion;

/**
 * Created by  on 2021/4/22.
 **/
class ReferencesQuestion {

    //f(n)=f(n-1)+1;
    private int f(int n){
        if (n==1)return 1;
        return f(n-1)+1;
    }

    public static void main(String[] args) {

        ReferencesQuestion question=new ReferencesQuestion();
        int result=question.f(5);
        System.out.println("reslt="+result);
        result=question.stepsQuestion(7);
        System.out.println("reslt="+result);
    }
    /*
    ���������� n ��̨�ף�ÿ������Կ� 1 ��̨�׻��� 2 ��̨�ף��������� n ��̨���ж������߷���
    ����� 7 ��̨�ף������ 2��2��2��1 ��������ȥ��Ҳ���� 1��2��1��1��2 ��������ȥ��
    ��֮�߷��кܶ࣬������ñ������ܹ��ж������߷���
     */
    private int stepsQuestion(int n){
        if (n==1)return  1;
        if (n==2)return 2;
        return stepsQuestion(n-1)+stepsQuestion(n-2);
    }
    private int stepsQuestion2(int n){
        if (n==1)return  1;
        if (n==2)return 2;
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            ret=pre+prepre;
            prepre=pre;
            pre=ret;
        }
        return ret;
    }

}
