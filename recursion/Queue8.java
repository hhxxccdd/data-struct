package recursion;

public class Queue8 {


    //定义一个max表示有多少个皇后
    int max =8;
    //第一数组 array， 保存皇后放置位置的结果
    int array[]  =  new int[max];
    static  int count = 0;
    public static void main(String[] args) {

         //测试一把,8皇后是否正确

       Queue8 queue8 =new Queue8();

       queue8.check(0);

        System.out.println("一共打印"+count+"次");

    }


    //编写一个方法，放置第n个皇后
    private void check(int n){
          if(n == max){   // n = 8,其实8个皇后已经放好了
              print();
              return;
          }

          //依次放入皇后，并判断是否重复
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突；
            if(judge(n)){   //不冲突
                //接着放n+1个皇后
                check(n+1);
            }
            //如果冲突，就继续执行array[n] = i，将第n个皇后，放置在本行的后移的一个位置

        }
    }






    //查看当我们放置第n个皇后，就去检查是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {

           //说明：array[i] == array[n]表示第n个皇后是否和前面的皇后在同一列
           //Math.abs(n-i) == Math.abs(array[n] - array[i])表示第n个皇后是否和前面的皇后在同一斜线上，tan45°
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                    return  false;
            }

        }

        return true;

    }





    //写一个方法 , 可以将皇后摆放的位置输出

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

}
