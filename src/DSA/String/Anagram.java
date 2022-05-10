package DSA.String;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
//        anagram();
        groupAnagram();
    }

    private static void groupAnagram() {
        List<String> inputs = Arrays.asList("ant","malayalam","tan","tank","malamalay");
        Map<String,List<String>> res = new HashMap<>();
        for(String input : inputs){
            int[] count = new int[26];
            Arrays.fill(count,0);
            for(int i=0;i<input.length();i++){
                char c = input.charAt(i);
                int n = (int)c - (int)'a';
                count[n] += 1;
            }
            String counts = Arrays.toString(count);
            if(res.containsKey(counts)){
                res.get(counts).add(input);
            }else{
                res.put(counts,new ArrayList<>(){{add(input);}});
            }
        }
        System.out.println(res.values());
    }

    public static void anagram(){
        String s = "anagram", t = "aaagrmn";
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(tMap.containsKey(c)){
                tMap.put(c,tMap.get(c));
            }else{
                tMap.put(c,1);
            }
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(sMap.containsKey(c)){
                sMap.put(c,sMap.get(c));
            }else{
                sMap.put(c,1);
            }
        }
        boolean res = true;
        for(Map.Entry<Character,Integer> tmp: tMap.entrySet()){
            if(!(sMap.containsKey(tmp.getKey()) && sMap.get(tmp.getKey()) == tmp.getValue())){
                res = false;
                break;
            }
        }
        System.out.println(res);
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        System.out.println(Arrays.equals(sArray,tArray));
    }
}
