package DSA.Arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int currSum = 0;
        for(int n: nums){
            if(currSum < 0){
                currSum = 0;
            }
            currSum+=n;
            res = Math.max(res,currSum);
        }
        return res;
    }
}
