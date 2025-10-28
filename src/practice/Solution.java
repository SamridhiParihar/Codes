package practice;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] arr = {900 ,940, 950, 1100, 1500 ,1800};
        int[] dep = {910 ,1200 ,1120, 1130 ,1900 ,2000};
        System.out.println(minPlatform(arr,dep));

    }
    public static int minPlatform(int arr[], int dep[]) {
        //  code here\
        int n = arr.length;
        Pair[] pairs =  new Pair[n];
        for(int i=0; i<n ;i++){
            pairs[i] = new Pair(arr[i],dep[i]);
        }
        Arrays.sort(pairs,(a,b)->a.dep-b.dep);
        int ans  = 1 , curr = 1;
        int dept = pairs[0].dep;
        for(int i=1; i<n; i++){
            if(pairs[i].arr<dept){
                curr++;
                ans = Math.max(ans,curr);
            }
            else{
                curr = 1;
                dept = pairs[i].dep;
            }
        }
        return ans;

    }
    static class Pair{
        int arr ;
        int dep;
        public Pair(int arr, int dep){
            this.arr = arr;
            this.dep = dep;
        }
    }
}