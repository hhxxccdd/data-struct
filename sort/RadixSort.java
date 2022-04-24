package sort;

import java.util.Arrays;

public class RadixSort {


    public static void main(String[] args) {

        //获取开始时间
        long startTime=System.currentTimeMillis();


        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            //生成一个[0,80000)的随机数
            arr[i] = (int) (Math.random() * 80000);
        }

        radixSort(arr);

        //获取结束时间
        long endTime=System.currentTimeMillis();

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");


    }

    //基数排序
    public static void radixSort(int[] arr) {

        //得到每个数组最大的数
        int max = arr[0];  //假设第一个数据是最大的数
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > arr[0]) {

                max = arr[i];
            }


        }

        //得到最大的数字几位数
        int maxLength = (max + "").length();


        //第一轮（针对每个元素的个位数进行处理）

        //定义一个二维数组，表示10个桶

        int[][] bucket = new int[10][arr.length];


        //为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];


        //这里使用循环处理maxLength
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的各位
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];

                bucketElementCounts[digitOfElement]++;

            }
            //按照这个桶的顺序取数据
            int index = 0;

            for (int k = 0; k < 10; k++) {
                //如果桶中有数据，我们才放回原数组
                if (bucketElementCounts[k] != 0) {
                    //循环第k个桶，即第k个以为数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到array中
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一轮后，需要bucketElementCounts置0

                bucketElementCounts[k] = 0;


            }

        }


//        //第二轮
//        for(int j = 0; j < arr.length ; j++){
//            //取出每个元素的各位
//            int digitOfElement = arr[j] / 10 % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//
//            bucketElementCounts[digitOfElement]++;
//
//        }
//        //按照这个桶的顺序取数据
//         index = 0 ;
//
//        for (int k = 0; k < 10; k++) {
//            //如果桶中有数据，我们才放回原数组
//            if (bucketElementCounts[k] != 0) {
//                //循环第k个桶，即第k个以为数组
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入到array中
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            bucketElementCounts[k]  =  0;
//
//
//        }
//
//        System.out.println(Arrays.toString(arr));
//
//
//        //第三轮
//        for(int j = 0; j < arr.length ; j++){
//            //取出每个元素的各位
//            int digitOfElement = arr[j] / 100 % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//
//            bucketElementCounts[digitOfElement]++;
//
//        }
//        //按照这个桶的顺序取数据
//        index = 0 ;
//
//        for (int k = 0; k < 10; k++) {
//            //如果桶中有数据，我们才放回原数组
//            if (bucketElementCounts[k] != 0) {
//                //循环第k个桶，即第k个以为数组
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入到array中
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//
//
//        }
//
//        System.out.println(Arrays.toString(arr));

    }


}
