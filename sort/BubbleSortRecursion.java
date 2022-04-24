package sort;

import java.util.Arrays;

/**
 * 冒泡排序的递归写法
 */
/**
 * @author hxc
 */
public class BubbleSortRecursion {
    public static void sort(int[] arr, int endIndex){
        if (endIndex==0){
            return ;
        }
        for (int i=0;i<endIndex;i++){
            if (arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i]  = arr[i+1];
                arr[i+1] = temp;
            }
        }
        sort(arr,endIndex-1);
    }

    public static void main(String[] args) {
        int[] array = {9,4,28,7,0,78,3,2};
        BubbleSortRecursion.sort(array, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}


