package sort;


import java.util.Arrays;

/**
 * @author hxc
 */
public class ShellSort {

    public static void main(String[] args) {

//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

//        //获取开始时间
//        long startTime=System.currentTimeMillis();
//
//
//        int[] arr = new int[80000];
//        for (int i = 0; i < arr.length; i++) {
//            //生成一个[0,80000)的随机数
//            arr[i] = (int) (Math.random() * 80000);
//        }

        int[] arr = {1,7,3,5,8,9,2};

        shellSort2(arr);

//        //获取结束时间
//        long endTime=System.currentTimeMillis();
//
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }


    //使用逐步推导的方式来编写shellsort

    /**
     *
     * @param arr 数组
     */
    public static void shellSort(int[] arr) {
        int  temp = 0;
        //希尔排序的第一轮

        for(int gap = arr.length/2 ; gap > 0 ; gap /= 2){
            //因为第一轮排序，是将10个数据分成了5组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素
                for (int j = i - gap; j >= 0; j -= gap) {

                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }


                }


            }
        }

//        System.out.println(Arrays.toString(arr));

//        System.out.println("希尔排序一轮后");
//        System.out.println(Arrays.toString(arr));

//        //第二轮排序
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素
//            for (int j = i - 2; j >= 0; j -= 2) {
//
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//
//
//            }
//
//
//        }
//
//        System.out.println("希尔排序二轮后");
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮排序
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有的元素
//            for (int j = i - 1; j >= 0; j -= 1) {
//
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//
//
//            }
//
//
//        }
//
//        System.out.println("希尔排序三轮后");
//        System.out.println(Arrays.toString(arr));


    }

    /**
     *
     * @param arr
     */
    //对交换的希尔排序优化
    public static void shellSort2(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {

                        arr[j] = arr[j - gap];
                        j -= gap;

                    }
                    arr[j] = temp;
                }

            }


        }

        System.out.println(Arrays.toString(arr));

    }


}
