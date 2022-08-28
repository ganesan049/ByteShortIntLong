package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
  int[] memo;

  public Solution(int size) {
    this.memo = new int[size + 1];
  }

  public static void main(String[] args) {
    //    Solution sol = new Solution(3);
    //    System.out.println(sol.climbStairs2(3));
    //    System.out.println(rob1(new int[]{2,1,1,2}));
//    System.out.println(rob2(new int[] {3, 2, 3, 5, 2}));
    TreeNode root = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left = new TreeNode(3);
    root.right.right = new TreeNode(1);
    root.left.right = new TreeNode(3);
    System.out.println(rob3(root));
  }

  private static int rob3(TreeNode root) {
    return Collections.max(dfs(root));
  }

  private static List<Integer> dfs(TreeNode root) {
    if(root == null){
      return List.of(0,0);
    }
    List<Integer> leftPair = dfs(root.left);
    List<Integer> rightPair = dfs(root.right);
    int withRoot = root.val + leftPair.get(1) + rightPair.get(1);
    int withoutRoot = Collections.max(leftPair) + Collections.max(rightPair);
    return List.of(withRoot,withoutRoot);
  }

  private static int rob2(int[] nums) {
    //    System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,2)));
    //    return 1;
    return Math.max(
        rob1(Arrays.copyOfRange(nums, 0, nums.length - 1)),
        rob1(Arrays.copyOfRange(nums, 1, nums.length)));
  }

  public int climbStairs2(int i) {
    if (i < 0) {
      return 0;
    } else if (i == 0) {
      return 1;
    }
    if (memo[i] != 0) {
      return memo[i];
    }
    memo[i] = climbStairs2(i - 1) + climbStairs2(i - 2);
    System.out.println(Arrays.toString(memo));
    return memo[i];
  }

  public int climbStairs(int n) {
    int one = 1, two = 1;
    for (int i = 0; i < n - 1; i++) {
      int tmp = one;
      one = one + two;
      two = tmp;
    }
    return one;
  }

  private static int rob1(int[] nums) {
    int rob1 = 0, rob2 = 0;
    for (int n : nums) {
      int tmp = Math.max(rob1 + n, rob2);
      rob1 = rob2;
      rob2 = tmp;
    }
    return rob2;
  }


}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}