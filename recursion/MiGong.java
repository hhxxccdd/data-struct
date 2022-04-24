package recursion;

public class MiGong {

    public static void main(String[] args) {
          //先创建一个二维数组，模拟迷宫
          //地图
        int[][] map =new int[8][7];
        //使用1表示墙
        //上下全部置位1
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右置位1
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        for(int i=0 ;i<8;i++){
            for(int j=0 ; j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay2(map,1,1);

        //输出新的地图
        System.out.println("-------------------------------");
        for(int i=0 ;i<8;i++){
            for(int j=0 ; j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }

    //使用递归回溯来给小球找路
    //1表示墙 ， 2表示通路可走 ， 3表示走不通
    /**
     *
     * @param map   表示地图
     * @param i     表示从哪里找
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map , int i ,int j){
         if(map[6][5] == 2){   //通路已找到

             return  true;
         }else {
             if(map[i][j] == 0){   //如果当前这个点还没走过
                 //按照策略 上、右、下、左 走
                 map[i][j] = 2;  //假定该点可以走通
                 if(setWay2(map,i-1,j)){ //向上走

                         return true;

                 }else if(setWay2(map,i,j+1)){   //向右走

                     return true;

                 }else if(setWay2(map,i+1,j)){  //向下走

                     return true;

                 }
                 else if(setWay2(map,i,j-1)){  //向左走

                     return true;

                 } else {
                     //说明该点走不通
                     map[i][j] = 3;
                     return false;
                 }
             }
             else {   //如果map[i][j] != 0 ,可能是1，2,3
                 return  false;
             }

         }

    }


    //修改找路的策略，改成上、右、下、左
    public static boolean setWay2(int[][] map , int i ,int j){
        if(map[6][5] == 2){   //通路已找到

            return  true;
        }else {
            if(map[i][j] == 0){   //如果当前这个点还没走过
                //按照策略 下、右、上、左 走
                map[i][j] = 2;  //假定该点可以走通
                if(setWay(map,i-1,j)){ //向上走

                    return true;

                }else if(setWay(map,i,j+1)){   //向右走

                    return true;

                }else if(setWay(map,i+1,j)){  //向下走

                    return true;

                }
                else if(setWay(map,i,j-1)){  //向左走

                    return true;

                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            }
            else {   //如果map[i][j] != 0 ,可能是1，2,3
                return  false;
            }

        }

    }




}
