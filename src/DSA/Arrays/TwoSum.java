package DSA.Arrays;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target=9;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer neededKey = target - nums[i];
            if(map.containsKey(neededKey)){
                int[] res = new int[]{i,map.get(neededKey)};
                Arrays.sort(res);
                System.out.println(Arrays.toString(res));
//                return res;
            }else{
                map.put(nums[i],i);
            }
        }
    }
}
