package DSA.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        for(int i=0;i<nums.length;i++){
            res[i] = prefix;
            prefix*=nums[i];
        }
        int postfix = 1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] *= postfix;
            postfix*=nums[i];
        }
        return res;
    }
}
