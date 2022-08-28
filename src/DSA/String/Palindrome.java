package DSA.String;

import java.util.*;
import java.util.stream.Collectors;

public class Palindrome {
    public static void main(String[] args) {
        String s = "race e car";
        s = s.replaceAll("[^a-zA-Z0-9]","");
//        palindrome(s);
//        largestPalindrome(s);
        palindromeSubstring(s);
    }

    private static void palindromeSubstring(String s) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int l = i, r = i;
            while(l >= 0 && r<s.length() && s.substring(l,l+1).equals(s.substring(r,r+1))){
                if(!res.contains(s.substring(l,r+1))){
                    res.add(s.substring(l,r+1));
                }
                l-=1;
                r+=1;
            }

            //even length
            l= i;
            r=i+1;
            while(l >= 0 && r<s.length() && s.substring(l,l+1).equals(s.substring(r,r+1))){
                if(!res.contains(s.substring(l,r+1))){
                    res.add(s.substring(l,r+1));
                }
                l-=1;
                r+=1;
            }
        }
        System.out.println(res);
        String result =
//                String.join("",res);
                res.stream().map(i -> i).collect(Collectors.joining(""));
        System.out.println(result);
    }

    private static void largestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        for(int i=0;i<s.length();i++){
            int l = i, r = i;
            while(l >= 0 && r<s.length() && s.substring(l,l+1).equals(s.substring(r,r+1))){
                if(r-l+1 > resLen){
                    resLen = r-l+1;
                    res = s.substring(l,r+1);
                }
                l-=1;
                r+=1;
            }

            //even length
            l= i;
            r=i+1;
            while(l >= 0 && r<s.length() && s.substring(l,l+1).equals(s.substring(r,r+1))){
                if(r-l+1 > resLen){
                    resLen = r-l+1;
                    res = s.substring(l,r+1);
                }
                l-=1;
                r+=1;
            }
        }
        System.out.println(res);
    }

    private static void palindrome(String s) {
        int j = 0;
        boolean res = true;
        for(int i=s.length()-1;i>=0;i--){
            if(s.substring(i,i+1).equals(s.substring(j,j+1))){
                j+=1;
            }else{
                res = false;
                break;
            }
        }
        System.out.println(res);
    }
}
