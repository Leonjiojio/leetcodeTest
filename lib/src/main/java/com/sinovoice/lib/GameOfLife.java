package com.sinovoice.lib;

/**
 * Created by  on 2021/4/1.
 **/
class GameOfLife {
    public static void main(String[] args) {
        int[][] world={
                {0,1,0},
                {0,0,1},
                {1,1,1}};
        System.out.println("before");
//        gameOfLife(world);
    }
    public static  void gameOfLife(int[][] world) {

        int[][] tmp=new int[world.length][world[0].length];

        for (int x = 0; x < world.length; x++)
        {
            for (int y = 0; y < world[0].length; y++)
            {
                //计算周围活着的生命数量
                int sum=0;

                if (x==0){
                    sum = world[x + 1][y] + world[x + 1][y - 1] + world[x][y - 1] + world[x - 1][y - 1]
                            + world[x - 1][y] + world[x - 1][y + 1] + world[x][y + 1] + world[x + 1][y - 1];
                }else{

                }
                sum = world[x + 1][y] + world[x + 1][y - 1] + world[x][y - 1] + world[x - 1][y - 1]
                        + world[x - 1][y] + world[x - 1][y + 1] + world[x][y + 1] + world[x + 1][y - 1];

                //计算当前位置的生命状态
                switch (sum)
                {
                    case 3:tmp[x][y] = 1; break;
                    case 2:tmp[x][y] = world[x][y]; break;
                    default:tmp[x][y] = 0; break;
                }
            }
        }

    }
}
