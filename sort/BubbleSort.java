package sort;


import java.util.Arrays;
import java.util.Random;

/**
 * @author hxc
 */
public class BubbleSort {

    public static void main(String[] args) {

//        int[] arr = {3, 9, -1, 10, 20};

        //获取开始时间
        long startTime=System.currentTimeMillis();


        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            //生成一个[0,80000)的随机数
            arr[i] = (int) (Math.random() * 80000);
        }
//        System.out.println(Arrays.toString(arr));

       //测试冒泡排序
        BubbleSort.bubblesort(arr);

        //输出排序后的数组
//        System.out.println("排序后的数组");
//        System.out.println(Arrays.toString(arr));


        //获取结束时间
        long endTime=System.currentTimeMillis();

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

//        //第二次排序，把第二大的数排在倒数第二位
//        for(int j=0; j< arr.length-1-1;j++){
//            //如果前面的数比后面的数大，则交换
//            if(arr[j] > arr[j+1]){
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//
//        System.out.println("第二次排序");
//        System.out.println(Arrays.toString(arr));
//
//        //第三次排序，把第三大的数排在倒数第三位
//        for(int j=0; j< arr.length-1-1-1;j++){
//            //如果前面的数比后面的数大，则交换
//            if(arr[j] > arr[j+1]){
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//
//        System.out.println("第三次排序");
//        System.out.println(Arrays.toString(arr));
//
//        //第四次排序，把第四大的数排在倒数第四位
//        for(int j=0; j< arr.length-1-1-1-1;j++){
//            //如果前面的数比后面的数大，则交换
//            if(arr[j] > arr[j+1]){
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//
//        System.out.println("第四次排序");
//        System.out.println(Arrays.toString(arr));
//
//    }

    }

    //将前面的冒泡排序封装成一个方法
    /**
     *
     * @param arr   传来的数组
     */
    public static void bubblesort(int[] arr){

        //冒泡排序的时间复杂度o(n*2)
        //标识符
        boolean flag = false;
        for(int i =0 ;i<arr.length-1;i++){
            for (int j = 0; j < arr.length - 1-i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            //在一次排序中,一次都没交换过
            if(!flag){
                break;
            }else {
                //重置flag，下次判断
                flag = false;
            }
        }
    }
}
