package com.example.geektest.stringmatch;

/**
 * Created by  on 2021/6/8.
 **/
class BoyerMoore {
    private static final int SIZE=256;
    private static final int[] BC=new int[SIZE];
    private static  int[] suffix;
    private static  boolean[] prefix;
    public static void main(String[] args) {
//        int index=bm("abcacabcbcbacabc".toCharArray(),"cbacabc".toCharArray());
        int index=bm("baaabaaabaaa".toCharArray(),"aaaa".toCharArray());
        System.out.print("index="+index);
    }
    private static void gennerateBC(char [] b){
        for (int i = 0; i < SIZE; i++) {
            BC[i]=i;
        }
        for (int i = 0; i < b.length; i++) {
            int ascii=b[i];//计算b[i]的ascaii值
            BC[ascii]=i;
        }
    }

    private static  void generateGS(char [] pattern){
        int m=pattern.length;
        suffix=new int[m];
        prefix =new boolean[m];

        for (int i = 0; i < m; i++) {
            suffix[i]=-1;
            prefix[i]=false;
        }

        for (int i = 0; i < m-1; i++) {
            //循环处理b[0,i]
            int j=i;
            int k =0;//公共后缀子串长度
            while (j>=0&&pattern[j]==pattern[m-1-k]){

                --j;
                ++k;
                suffix[k]=j+1;//j+1表示公共后缀子串在b[0,i]的起始下标
            }
            if(j==-1) prefix[k]=true;//公共后缀子串也是模式串的子串前缀

        }
    }
    public static int bm(char []a,char[] pattern){
        int n=a.length;
        int m=pattern.length;
        gennerateBC(pattern);
        generateGS(pattern);
        int i=0;//i 表示主串与模式串上下对齐的第一个字符
        while (i<=n-m){
            int j;
            for (j=m-1;j>=0;j--){
                if (a[i+j]!=pattern[j])break;
            }
            if (j<0){
                return  i;
            }
            //等同于将模式串往后滑动j-BC[(int)a[i+j]]
            int badX=j-BC[(int)a[i+j]];
            int goodX=0;

            if (j<m-1){//如果有好后缀的话
                goodX= moveByGS(j,m);
            }
            i=i+Math.max(badX,goodX);
        }
        return  -1;
    }
    private static  int moveByGS(int j, int m){
        int k=m-1-j;//好后缀长度
        if (suffix[k]!=-1)return  j-suffix[k]+1;
        for (int r=j+2;r<=m-1;r++){
            if (prefix[m - r]){
                return  r;
            }
        }
        return  m;
    }
}
