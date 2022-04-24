package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2,0,9};


        //获取开始时间
        long startTime=System.currentTimeMillis();


        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            //生成一个[0,80000)的随机数
            arr[i] = (int) (Math.random() * 80000);
        }

        int[]  temp = new int[arr.length];

        mergeSort(arr,0, arr.length-1,temp );

//        System.out.println(Arrays.toString(arr));

        //获取结束时间
        long endTime=System.currentTimeMillis();

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");


    }

    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
          if(left < right){
              int mid = (left + right) / 2;
              //向左递归分解
              mergeSort(arr,left,mid,temp);
              //向右递归分解
              mergeSort(arr,mid+1,right,temp);
              //合并
              merge(arr,left,mid,right,temp);
          }

    }

    //合并的方法

    /**
     *
     * @param arr   需要排序的原始数组
     * @param left   左边有序序列的初始索引
     * @param mid     中间索引
     * @param right   右边的索引
     * @param temp     中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;   //初始化i，左边有序序列的初始索引

        int j = mid + 1;    //初始化j，右边有序序列的初始索引

        int t = 0;  //指向temp数组的当前索引

        //(-)
        //先把左右两边的数据按规则填充到temp中
        //知道左右两边的有序序列，有一边处理完毕
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //(二)
        // 把有剩余数据的一方的数据一次全部填充到temp去
        while (i <= mid) {   //说明左边的序列还有剩余元素
            temp[t] = arr[i];
            t++;
            i++;

        }

        while (j <= right) {   //说明右边的序列还有剩余元素
            temp[t] = arr[j];
            t++;
            j++;

        }
        //(三)
        //将temp数组的元素拷贝到Arrays
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }


    }




}
