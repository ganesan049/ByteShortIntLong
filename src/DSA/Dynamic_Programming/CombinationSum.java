package DSA.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSumDP(new int[]{2,3,6,7},7));
    }
    public static List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        class Solution{
            public void dfs(int i,List<Integer> curr,int total){
                if(total == target){
                    result.add(new ArrayList<>(curr));
                    return;
                }
                if(total > target || i >= candidates.length){
                    return;
                }
                curr.add(candidates[i]);
                dfs(i,curr,total+candidates[i]);
                curr.remove(curr.size()-1);
                dfs(i+1,curr,total);
            }
        }
        new Solution().dfs(0,new ArrayList<>(),0);
        return result;
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> candidatesList = Arrays.stream(candidates).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<candidates.length;i++) {
            List<Integer> res = new ArrayList<>();
            int value = candidates[i];
            while(value<=target){
                res.add(candidates[i]);
                int index = candidatesList.indexOf(target - value);
                if(index >= 0){
                    List<Integer> tmpRes = new ArrayList<>(res);
                    tmpRes.add(candidates[index]);
                    Collections.sort(tmpRes);
                    if(result.indexOf(tmpRes) == -1){
                        result.add(tmpRes);
                    }
                }else if(target - value == 0){
                    if(result.indexOf(res) == -1){
                        result.add(res);
                    }
                }
                value=value+candidates[i];
            }
        }
        return result;
    }
}
