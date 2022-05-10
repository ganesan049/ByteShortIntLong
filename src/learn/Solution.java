package learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution{
    public static void main(String[] args) {
//        reverseString(new char[]{'a','b','c','d'});
        String str = "test string";
        printDups(str);
    }

    private static void printDups(String str) {
//        str = str.trim();
        Map<Character,Integer> res = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(res.get(str.charAt(i)) != null){
                res.put(str.charAt(i),res.get(str.charAt(i))+1);
            }else {
                res.put(str.charAt(i),1);
            }
        }
        System.out.println(res);
    }

    public static void reverseString(char[] s) {
        String S="abc";
        boolean pal = true;
        int l=0,h=S.length()-1;
        while (l<h){
            if(S.charAt(l) != S.charAt(h)){
                pal = false;
                break;
            }
            l++;
            h--;
        }
        System.out.println(pal);
    }
}