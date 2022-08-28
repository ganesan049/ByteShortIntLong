package DSA.Dynamic_Programming;

import java.util.*;
import java.util.stream.Collectors;

public class Word_Break {
    public static void main(String[] args) {
        System.out.println(wordBreakDP("carsclub",Arrays.asList("cars","ca","rsclub")));
    }
    public static boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[s.length()] = true;
        for(int i=s.length()-1;i>=0;i--){
            for(String word:wordDict){
                if((i+word.length() <= s.length()) &&
                        (word.matches(
//                                i+word.length() == s.length() ? s.substring(i) :
                                        s.substring(i,i+word.length())
                        )
                        )){
                    dp[i] = dp[i+word.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[0];
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int matchCount = 0;
        for(int i=0;i<s.length();i++){
            String curLetter = Character.toString(s.charAt(i));
            List<String> words = wordDict.stream().filter(word -> word.indexOf(curLetter) != -1).collect(Collectors.toList());
            if( words.size() > 0 ){
                for(String word:words){
                    if(word.matches(i+word.length() > s.length() ? s.substring(i) : s.substring(i,i+word.length()))){
                        matchCount+=word.length();
                        i = i+word.length()-1;
                    }
                }
            }
        }
        return matchCount == s.length();
    }
}
