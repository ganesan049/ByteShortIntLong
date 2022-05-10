package DSA.Dynamic_Programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Coin_Change {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},3));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] map = new int[amount+1];
        for(int i=0;i<map.length;i++){
            map[i] = Integer.MAX_VALUE;
            for(int j=coins.length-1;j>=0;j--){
                if(i - coins[j] < 0){
                    continue;
                }else if(i - coins[j] == 0){
                    map[i]=1;
                    break;
                }else if(i - coins[j] > 0){
                    map[i] = Math.min(1+map[i-coins[j]],map[i]);
                }
            }
            if(map[i] == Integer.MAX_VALUE) map[i] = -1;
        }
        return map[amount];
    }
}
