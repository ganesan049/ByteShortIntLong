package DSA.Arrays;

import java.util.Arrays;
import java.util.Collections;

public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
    public static int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int currMax = 1;
        int currMin = 1;
        boolean hasZero = false;
        for(int n:nums){
            if(n == 0){
                hasZero = true;
                currMax = 1;
                currMin = 1;
                continue;
            }
            int tmpMax = currMax*n;
            currMax = Math.max(n,Math.max(tmpMax,currMin*n));
            currMin = Math.min(n,Math.min(tmpMax,currMin*n));
            maxProd = Math.max(currMax,Math.max(maxProd,currMin));
        }
        return Math.max(maxProd,hasZero ? 0 : Integer.MIN_VALUE);
    }
}
