package sort;


import java.util.Arrays;

/**
 * @author hxc
 */
public class SelectSort {


    public static void main(String[] args) {

//        int[] arr = {101, 34, 119, 1};

        //获取开始时间
        long startTime=System.currentTimeMillis();


        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            //生成一个[0,80000)的随机数
            arr[i] = (int) (Math.random() * 80000);
        }

        //测试
        selectSort(arr);

        //获取结束时间
        long endTime=System.currentTimeMillis();

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");


    }


    public static void selectSort(int[] arr) {


        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            //第一轮
            for (int j = i + 1; j < arr.length; j++) {
                //说明定的最小值不是最小的
                if (min > arr[j]) {
                    //重置最小值
                    min = arr[j];
                    minIndex = j;
                }
            }

            //将最小值与arr[0]交换
            if(minIndex !=  i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第"+(i+1)+"次排序后");
//            System.out.println(Arrays.toString(arr));

        }

//        //第二轮
//         minIndex = 1;
//         min = arr[1];
//
//        for (int j = 1 + 1; j < arr.length; j++) {
//            //说明定的最小值不是最小的
//            if (min > arr[j]) {
//                //重置最小值
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//
//        //将最小值与arr[0]交换
//        if(minIndex != 1){
//            arr[minIndex] = arr[1];
//            arr[1] = min;
//        }
//
//        System.out.println("第二次排序后");
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮
//        minIndex = 2;
//        min = arr[2];
//
//        for (int j = 1 + 1; j < arr.length; j++) {
//            //说明定的最小值不是最小的
//            if (min > arr[j]) {
//                //重置最小值
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//
//        //将最小值与arr[0]交换
//        if(minIndex != 2){
//            arr[minIndex] = arr[2];
//            arr[2] = min;
//        }
//
//        System.out.println("第三次排序后");
//        System.out.println(Arrays.toString(arr));

    }

}
