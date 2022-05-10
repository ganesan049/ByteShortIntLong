package DSA.String;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepatingCharReplacement {
    public static void main(String[] args) {
        String input = "ababba";
        Map<Character,Integer> charMap = new HashMap<>();
        int l=0,r=0,k=1,res=0,maxF=0;
        while(r<input.length()){
            char c = input.charAt(r);
            if(!charMap.containsKey(c)){
                charMap.put(c,1);
            }else{
                charMap.put(c,charMap.get(c)+1);
            }
            maxF = Math.max(maxF,charMap.get(c));
            int maxRepChar =
//                    Collections.max(charMap.entrySet(),(e1,e2) -> e1.getValue() - e2.getValue()).getValue();
                        Collections.max(charMap.values());
            if((r-l+1-maxF) <= k){
                res = Math.max(res,r-l+1);
            }else{
                charMap.put(c,charMap.get(c)-1);
                l+=1;
            }
            r+=1;
        }
        System.out.println(res);
    }
}
