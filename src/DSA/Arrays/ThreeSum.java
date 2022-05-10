package DSA.Arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
    //        twosum II
//            if(i > 0 && nums[i] == nums[i-1]){
//                continue;
//            }
            int l=i+1,r=nums.length-1;
            while(l<r){
                int threeSum = nums[l]+nums[r]+nums[i];
                if(threeSum == 0){
                    List<Integer> result = Arrays.asList(nums[i],nums[l],nums[r]);
                    if(!res.contains(result)){
                        res.add(result);
                    }
                    break;
                }else if(threeSum > 0){
                    r-=1;
                }else{
                    l+=1;
                }
            }
        }
        return res;
    }
}
