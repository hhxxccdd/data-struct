package sort;


import java.util.Arrays;

/**
 * @author hxc
 */
public class InsertSort {

    public static void main(String[] args) {
        //获取开始时间
        long startTime=System.currentTimeMillis();


        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            //生成一个[0,80000)的随机数
            arr[i] = (int) (Math.random() * 80000);
        }

          insertSort(arr);

        //获取结束时间
        long endTime=System.currentTimeMillis();

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }


    /**
     *
     * @param arr  数组
     */
    public static void insertSort(int[] arr){
        //使用逐步推导的方式

        int insertVal = 0;
        int insertIndex = 0;

        for(int i = 1; i<arr.length;i++) {


            //定义待插入的数
             insertVal = arr[i];
            //即arr[1]前面这个数的下标
             insertIndex = i - 1;
            //说明
            //insertIndex >= 0保证在给insertVal找插入位置，不越界
            //insertVal < arr[insertIndex] 待插入的数， 还没有找到插入位置
            //给insertVal找到插入位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

                //就需要将arr[insertIndex]后移
                arr[insertIndex + 1] = arr[insertIndex];

                insertIndex--;

            }
            //当退出这个循环时，说明插入的位置找到


            if(insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }

//            System.out.println("第"+i+"轮后");
//            System.out.println(Arrays.toString(arr));

        }



//        //第二轮
//        insertVal = arr[2];
//        insertIndex = 2 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//
//            //就需要将arr[insertIndex]后移
//            arr[insertIndex + 1] = arr[insertIndex];
//
//            insertIndex--;
//
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println("第二轮后");
//        System.out.println(Arrays.toString(arr));
//
//
//
//
//        //第三轮
//        insertVal = arr[3];
//        insertIndex = 3 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//
//            //就需要将arr[insertIndex]后移
//            arr[insertIndex + 1] = arr[insertIndex];
//
//            insertIndex--;
//
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println("第三轮后");
//        System.out.println(Arrays.toString(arr));

    }

}
