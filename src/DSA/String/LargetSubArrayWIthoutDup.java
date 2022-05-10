package DSA.String;

import java.util.*;

public class LargetSubArrayWIthoutDup {
    public static void main(String[] args) {
        String input = "abcacdca";
        Set<Character> set = new HashSet<>();
        int l = 0,res = 0;
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            while(set.contains(c)){
                set.remove(input.charAt(l));
                l+=1;
            }
            set.add(c);
            res = Math.max(res,set.size());
        }
        System.out.println(res);
    }
}
