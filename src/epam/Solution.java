package epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//    public static void main(String[] args) {
//        int[]arr = {1,3,-1,-3,5,3,6,7};
//        System.out.println(Arrays.toString(maxSlidingWindow(arr,3)));
//    }
     CustomStack s1 = new CustomStack();
     CustomStack s2 = new CustomStack();

    public   int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[]max = new int[n-k+1];
        int ind =0;
        int l =0;
        for(int r =0; r<n; r++){
            add(nums[r]);
            while(r-l+1>k){
                remove();
                l++;
            }
            if(r-l+1==k) max[ind++]=max();
        }
        return max;
    }
     void remove(){
        if(s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        s1.pop();
    }
     void add(int ele){
        s2.push(ele);
    }
     int max(){
        return Math.max(s1.max(),s2.max());
    }
    // static int min(){
    //     return Math.min(s1.min(),s2.min());
    // }
}

 class CustomStack{
    public List<Integer> s = new ArrayList<>();
    public List<Integer> smax = new ArrayList<>();
    // public List<Integer> smin = new ArrayList<>();

    public CustomStack(){
        smax.add(Integer.MIN_VALUE);
        // smin.add(Integer.MAX_VALUE);
    }
    public void push (int ele){
        s.add(ele);
        smax.add(Math.max(smax.getLast(),ele));
        // smin.add(Math.min(smin.get(smin.size()-1),ele));
    }
    public boolean isEmpty(){
        return s.isEmpty();
    }
    public int pop(){
        int res = s.removeLast();
        // smin.remove(smin.size()-1);
        smax.removeLast();
        return res;
    }
    public int max(){
        return smax.getLast();
    }
    // public int min(){
    //     return smin.get(smin.size()-1);
    // }
}

