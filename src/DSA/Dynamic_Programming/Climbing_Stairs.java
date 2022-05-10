package DSA.Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

public class Climbing_Stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        return climbStairs(n,map);
    }

    private static int climbStairs(int n, Map<Integer, Integer> map) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n <= 1){
            return 1;
        }
        map.put(n,climbStairs(n-1,map)+climbStairs(n-2,map));
        return map.get(n);
    }

}
