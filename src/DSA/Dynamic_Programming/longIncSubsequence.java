package DSA.Dynamic_Programming;

import java.util.Arrays;

public class longIncSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] array = new int[nums.length];
        Arrays.fill(array,1);
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++) {
                if (nums[i] < nums[j]) {
                    array[i] = Math.max(array[i], 1 + array[j]);
                }
            }
        }
        return Arrays.stream(array).max().getAsInt();
    }
}
