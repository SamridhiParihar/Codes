package contest.c6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MixMexMax {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            CustomStack s1 = new CustomStack();
            CustomStack s2 = new CustomStack();
            boolean flag = true;
            int n = in.nextInt();
            int[]arr = new int[n];
            int[]freq = new int[103];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int l =0;
            for (int r = 0; r < n; r++) {
                if(arr[r]!=-1)freq[arr[r]]++;
                else freq[102]++;
                add(s1,s2,arr[r]);
                while(r-l+1>3){
                    remove(s1,s2);
                    if(arr[l]!=-1)freq[arr[l]]--;
                    else freq[102]--;
                    l++;
                }
                if(r-l+1==3){
                    int mex = mex(freq);
                    int max = max(s1,s2);
                    int min = min(s1,s2);
                    if(mex!=(max(s1,s2)-min(s1,s2))) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) System.out.println("Yes");
            else System.out.println("No");
        }
    }
    public static int mex(int[]arr){
        for (int i = 0; i < 4; i++) {
            if(arr[i]==0) return i;
        }
        return -1;
    }

     static void remove(CustomStack s1, CustomStack s2){
        if(s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        s1.pop();
    }
     static void add(CustomStack s1, CustomStack s2, int ele){
        s2.push(ele);
    }
    static int max(CustomStack s1, CustomStack s2){
        return Math.max(s1.max(),s2.max());
    }
    static int min(CustomStack s1, CustomStack s2){
         return Math.min(s1.min(),s2.min());
     }
}
class  CustomStack{
    public List<Integer> s = new ArrayList<>();
    public List<Integer> smax = new ArrayList<>();
     public List<Integer> smin = new ArrayList<>();

    public CustomStack(){
        smax.add(Integer.MIN_VALUE);
         smin.add(Integer.MAX_VALUE);
    }
    public void push (int ele){
        s.add(ele);
        smax.add(Math.max(smax.get(smax.size()-1),ele));
         smin.add(Math.min(smin.get(smin.size()-1),ele));
    }
    public boolean isEmpty(){
        return s.isEmpty();
    }
    public int pop(){
        int res = s.remove(s.size()-1);
         smin.remove(smin.size()-1);
        smax.remove(smax.size()-1);
        return res;
    }
    public int max(){
        return smax.get(smax.size()-1);
    }
     public int min(){
         return smin.get(smin.size()-1);
     }
}
