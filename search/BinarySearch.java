package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {


        int arr[] = {1, 8, 10, 89, 1000,1000,1000,1000, 1234};


//        int resIndex = binarySearch(arr,0,6,8);

        List<Integer> resIndexList =  binarySearch(arr,0, arr.length-1,1000);

        System.out.println(resIndexList);
    }


    public static ArrayList binarySearch(int[] arr, int left, int right, int findVal) {

        int mid = (left + right) / 2;

        int midVal = arr[mid];

        if(left > right){
            return new ArrayList<Integer>();
        }
        if(findVal > midVal){
           return binarySearch(arr,mid+1,right,findVal);
        }
        else if(findVal<midVal){
           return binarySearch(arr,left,mid-1,findVal);
        }else {

            ArrayList<Integer>  resIndex= new ArrayList<Integer>();

            //向右遍历，找出满足条件的数
            int temp = mid - 1;
            while (true){
                if(temp < 0 || arr[temp] != findVal){
                      break;
                }
                resIndex.add(temp);
                temp -= 1; // temp左移
            }
           resIndex.add(mid);

            //向左遍历，找出满足条件的数
            temp = mid+1;
            while (true){
                if(temp > arr.length-1 || arr[temp] != findVal){
                    break;
                }
                resIndex.add(temp);
                temp += 1; // temp左移
            }

            return resIndex;
        }



    }
}
