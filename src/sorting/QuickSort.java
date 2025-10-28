package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[]arr = {4,3,5,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public  static void quickSort(int[]arr, int s , int e){
        if(e-s+1>1){
            int pivotElement = arr[s]; // considering the first element as pivotElement
            int pi = pivotIndex(arr,s,e,pivotElement);
            quickSort(arr,s,pi-1);
            quickSort(arr,pi+1,e);
        }
    }
    public static int pivotIndex(int[]arr, int s, int e, int pivot ){
        int low = s, high = e;
        while(high>low){
            while(arr[low]<=pivot && low<=e-1){
                low++;
            }
            while (arr[high]>pivot && high>=s+1){
                high--;
            }
            if(low < high){
                swap(arr,low,high);
            }
        }
        swap(arr,s,high);
        return high;
    }
    public static void swap(int[]arr, int low, int high){
        int temp = arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    }
}
