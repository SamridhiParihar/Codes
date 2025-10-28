package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
       int[]arr = {-1,-2,-3,0};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] nums) {
        int product = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                res = Math.max(res, product);
                product = 1;
                continue;
            }
            if (nums[i] < 0) {
                if (i - 1 >= 0 && nums[i - 1] == 0)
                    res = Math.max(res, 0);
                else
                    res = Math.max(res, product);
            }
            product *= nums[i];
        }

        product = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                res = Math.max(res, product);
                product = 1;
                continue;
            }
            if (nums[i] < 0) {
                if (i +1<=nums.length-1 && nums[i + 1] == 0)
                    res = Math.max(res, 0);
                else
                    res = Math.max(res, product);
            }
            product *= nums[i];
        }
        res = Math.max(res, product);
        return res;
    }

}
