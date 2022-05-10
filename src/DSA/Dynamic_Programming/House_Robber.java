package DSA.Dynamic_Programming;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class House_Robber {
    public static void main(String[] args) {
        rob1(new int[]{1});
    }
    public static int rob2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(rob1(Arrays.copyOfRange(nums,0,nums.length-1)),rob1(Arrays.copyOfRange(nums,1,nums.length)));
    }
    public static int rob1(int[] nums) {
        int rob1 = 0,rob2 = 0;
        for(int n:nums){
            int tmp = Math.max(rob1+n,rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        System.out.println(rob2);
        return rob2;
    }
}
