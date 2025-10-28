package epam.practicwe;

public class Solution {
    public static int divide(int dividend, int divisor) {
        long dvs = Math.abs(divisor);
        long dvd = Math.abs(dividend);
        boolean flag = ((dividend>0 && divisor>0) ||(dividend<0 && divisor<0));

        long ans = fun(dvs,dvd);
        int pans = (int)ans;
        if(ans>=(1L <<31) && flag ) return (1<<31)-1;
        return flag?pans:-pans;
    }
    public static long fun(long dvs, long dvd){
        if(dvd<dvs) return 0;

        long i = 0;
        boolean flag = true;
        while(flag){
            if((dvs<<i)>dvd) flag = false;
            else i++;
        }
        long val = 1L<<i-1;
        System.out.println(val);
        return (1L<<i-1)+fun(dvs,dvd-(dvs<<i-1));
    }

    public static void main(String[] args) {
        System.out.println(divide(10,3));
    }

}
