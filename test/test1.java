package test;

import java.util.ArrayList;
import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {

//        int[] arr = {1,7,3,5,8,9,2};
//        BubbleSort(arr);
//        SelectSort(arr);
//        InsertSort(arr);
//        ShellSort(arr);
//        QuickSort(arr,0, arr.length-1);

        int arr[] = {1, 8, 10, 89, 1000,1000,1000,1000, 1234};
//        int number = binarySearch(arr,0,arr.length-1,1234);
//        System.out.println(number);


        ArrayList<Integer>  resIndex = new ArrayList<>();
        resIndex = enhanceBinarySearch(arr,0,arr.length-1,1000);

        System.out.println(resIndex);


    }

    public static void BubbleSort(int[] arr) {

        boolean flag = false; // 定义标识符，优化冒泡排序

        int temp = 0;   //定义交换的变量

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if(!flag){
                break;
            }
            else {
                flag= false;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void SelectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int min = arr[minIndex];

            for (int j = i + 1; j < arr.length - 1; j++) {

                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }


            arr[minIndex] = arr[i];
            arr[i] = min;

        }

        System.out.println(Arrays.toString(arr));

    }


    public static void InsertSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            //先定义出待插入的数组的值，和他的下标
            int insertVal = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

        }

        System.out.println(Arrays.toString(arr));

    }


    public static void ShellSort(int[] arr) {

        //获得分组间距，这里没有操作数组，只是获得间距
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {

            for (int i = gap; i < arr.length ; i++) {  //开始操作数组，进行遍历

                int j = i;   //定义插入的位置
                int InsertVal = arr[j];  // 定义插入的值

                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && InsertVal < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }

                    arr[j] = InsertVal;
                }
            }

        }

        System.out.println(Arrays.toString(arr));


    }


    public  static  void QuickSort(int[] arr , int left , int right){
        //左索引
              int l = left;
        //右索引

              int r = right;

        int pivot = arr[(left + right) / 2] ;
        //临时交换
        int temp = 0;

        while (l < r){

            while (arr[l] < pivot){
                l ++ ;
            }

            while (arr[r] > pivot){
                r--;
            }

            if(l >= r ){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot){
                r -- ;
            }

            if(arr[r] == pivot){
                l ++;
            }

        }

        if( l == r ){
            l++;
            r--;
        }

        if(left < r ){
            QuickSort(arr,left,r);
        }

        if(right > l){
            QuickSort(arr,l ,right);
        }

        System.out.println(Arrays.toString(arr));

    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        int mid = (left + right) / 2;

        int midVal = arr[mid];

        if (left > right) {
            return -1;
        }
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        }
        if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }

    public static ArrayList<Integer> enhanceBinarySearch(int[] arr, int left, int right, int findVal) {

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left > right) {
            return new ArrayList<>();
        }
        if (findVal > midVal) {
            return enhanceBinarySearch(arr, mid + 1, right, findVal);
        }
        if (findVal < midVal) {
            return enhanceBinarySearch(arr, left, mid - 1, findVal);
        } else {

            ArrayList arrayList = new ArrayList();

            int temp = mid - 1;

            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }

                arrayList.add(temp);

                temp--;
            }

            arrayList.add(mid);


            temp = mid + 1;
            while (true) {

                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }

                arrayList.add(temp);

                temp++;

            }

            return arrayList;

        }
    }

}
