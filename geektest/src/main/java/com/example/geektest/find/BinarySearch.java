package com.example.geektest.find;

/**
 * Created by  on 2021/4/27.
 **/
class BinarySearch {
//    public static int data[]={1,2,3,4,5,6,7,8,9,10};
//    public static int data[]={6,7,8,9,10,1,2,3,4,5};
    public static int data[]={4,1};

    public static void main(String[] args) {
      int result=  bSearchLoop(data,1);
//      double result=  getSqureRoot(5,0.00000001);
      System.out.println("result="+result);
    }

    private static int bSearchLoop(int[] data,int value){
        if (data==null)return -1;
       if (data.length==1)return data[0]==value?0:-1;

        int left=0;
        int right=data.length-1;
        while (left<=right){
            int middle=left+(right-left)/2;
            if (data[middle]==value)return middle;
            if (data[0]<=data[middle]){
                //左侧是有序的
                if (data[0]<=value&&data[middle]>value){
                    //在其中
                    right=middle-1;
                }else{
                    left=middle+1;
                }

            }else{
                //右侧是循环数组 mid+1 right
                if (data[middle]<value&&data[data.length-1]>=value){
                    left=middle+1;
                }else{
                    right=middle-1;
                }

            }

        }
        return -1;
    }

    private static int bSearchLastSmallerThanValue(int[] data,int value){
        if (data==null)return -1;
        if (value<data[0]||value>data[data.length-1])return -1;

        int left=0;
        int right=data.length-1;
        while (left<=right){
            int middle=left+(right-left)/2;
            if (data[middle]<=value){
                if (middle==data.length-1||data[middle+1]>value){
                    return middle;
                }else{
                    left=middle+1;
                }
            }else{
                right=middle-1;
            }

        }
        return -1;
    }

    private static int bSearchFirstBiggerThanValue(int[] data, int value){
        if (data==null)return -1;
        if (value<data[0]||value>data[data.length-1])return -1;

        int left=0;
        int right=data.length-1;
        while (left<=right){
            int middle=left+(right-left)/2;
            if (data[middle]>=value){
                if (middle==0||data[middle-1]<value){
                    return middle;
                }else{
                    right=middle-1;
                }
            }else{
                left=middle+1;
            }

        }
        return -1;
    }

    private static int bSearchLastValue(int[] data,int value){
        if (data==null)return -1;
        if (value<data[0]||value>data[data.length-1])return -1;

        int left=0;
        int right=data.length-1;
        while (left<=right){
            int middle=left+(right-left)/2;
            if (data[middle]<value){
                left=middle+1;
            }else if (data[middle]>value){
                right=middle-1;
            }else  {
                if (middle==data.length-1||data[middle+1]!=value){
                    return middle;
                }else{
                    left=middle+1;
                }
            }
        }
        return -1;
    }
    private static int bSearchFirstValue(int[] data,int value){
        if (data==null)return -1;
        if (value<data[0]||value>data[data.length-1])return -1;

        int left=0;
        int right=data.length-1;
        while (left<=right){
            int middle=left+(right-left)/2;
            if (data[middle]<value){
                left=middle+1;
            }else if (data[middle]>value){
                right=middle-1;
            }else  {
                if (middle==0||data[middle-1]!=value){
                    return middle;
                }else{
                    right=middle-1;
                }
            }
        }
        return -1;
    }

    private static int bSearch(int[] data,int value){
        if (data==null)return -1;
        if (value<data[0]||value>data[data.length-1])return -1;

        int left=0;
        int right=data.length-1;
        while (left<=right){
            int middle=left+(right-left)/2;

            if (data[middle]==value)return middle;
            if (data[middle]<value){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return -1;
    }

    private static  int _bSearchRecursion(int[] data,int left,int right,int value){
        if (left<=right){
            int middle=left+(right-left)/2;
            if (data[middle]==value)return  middle;
            if (data[middle]<value){
               return  _bSearchRecursion(data,middle+1,right,value);
            }else{
               return  _bSearchRecursion(data,left,middle-1,value);
            }
        }
        return -1;
    }
    /**
     * 我们今天讲的都是非常规的二分查找问题，今天的思考题也是一个非常规的二分查找问题。如果有序数组是一个循环有序数组，比如 4，5，6，1，2，3。针对这种情况，如何实现一个求“值等于给定值”的二分查找算法呢？
     * @param data
     * @param value
     * @return
     */

    private static int bSearchRecursion(int[] data,int value){
        if (data==null)return -1;
        if (value<data[0]||value>data[data.length-1])return -1;
        return  _bSearchRecursion(data,0,data.length-1,value);
    }

    public static double getSqureRoot(int n, double deltaThreshold) {
        double low=1;
        double high=n;
        while (low<=high){
            double middle=low+(high-low)/2;
            double squre=middle*middle;
            double delt=Math.abs(squre/n-1);
            if (delt<deltaThreshold){
                return middle;
            }else if (squre<n){
                low=middle;
            }else{
                high=middle;
            }
        }
        return  -1;

    }
}
