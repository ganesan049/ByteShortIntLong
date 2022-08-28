package DSA.Recursion;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    //    System.out.println(factorialRecursive(5));
    //    System.out.println(fibbonocciRecursive(6));
    System.out.println(fibbonocciDP(5));
  }

  private static int fibbonocciDP(int i) {
    Map<Integer,Integer> memo = new HashMap<>();
    return fibDp(i, memo);
  }

  private static int fibDp(int i, Map<Integer, Integer> memo) {

    if (!memo.containsKey(i)) {
      if (i < 2) {
        memo.put(i,i);
      } else {
        memo.put(i,fibDp(i - 2, memo) + fibDp(i - 1, memo));
      }
    }
    return memo.get(i);
  }

  private static int fibbonocciRecursive(int i) {
    if (i < 2) {
      return i;
    }
    return fibbonocciRecursive(i - 1) + fibbonocciRecursive(i - 2);
  }

  private static int factorialRecursive(int i) {
    if (i == 1) {
      return i;
    }
    return i * factorialRecursive(i - 1);
  }
}
