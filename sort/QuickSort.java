package sort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,-567,70,0,0,0};

        //获取开始时间
        long startTime=System.currentTimeMillis();


        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            //生成一个[0,80000)的随机数
            arr[i] = (int) (Math.random() * 80000);
        }


        quickSort(arr , 0 , arr.length-1);


        //获取结束时间
        long endTime=System.currentTimeMillis();

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");


//        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int left, int right) {

        int l = left; //左索引
        int r = right; //右索引

        // pivot 中轴
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //while循环的目的是让比pivot小的值放在他的左边
        //pivot大的值放在他的右边
        while (l < r) {

            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            //说明pivot的左右两边的值已经按照左边全部是小于pivot，右边大于pivot
            if (l >= r) {

                break;

            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换玩后，发现这个arr[l] = pivot 相等 r-- ，前移一步
            if (arr[l] == pivot) {
                r--;
            }

            //如果交换玩后，发现这个arr[r] = pivot 相等 l++ ，前移一步
            if (arr[r] == pivot) {
                l++;
            }

        }

        //如果l  == r,必须l++ ， r --，否则栈溢出

        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }


    }

}
