package DSA.Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

public class Decode_Ways {
    public static void main(String[] args) {
        System.out.println(numDecodings("121"));
    }
    public static int numDecodings(String s) {
        Map<Integer,Integer> dp = new HashMap<>();
        dp.put(s.length(),1);
        class DP{
            public int dfs(int i){
                if(dp.containsKey(i)){
                    return dp.get(i);
                }
                String curr = Character.toString(s.charAt(i));
                if(curr.equals("0")){
                    return 0;
                }
                int res = dfs(i+1);
                if(i+1 < s.length() && (curr.equals("1")
                    || (curr.equals("2") && Character.toString(s.charAt(i+1)).matches("[0-6]")))){
                    res+=dfs(i+2);
                }
                dp.put(i,res);
                return res;
            }
        }
        return new DP().dfs(0);
    }
}
