package DSA.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s = "adobecodebanc";
        String t = "abc";
        Map<Character,Integer> mapS = new HashMap<>();
        Map<Character,Integer> mapT = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(!mapT.containsKey(c)){
                mapT.put(c,1);
            }
        }
        int l=0,have=0,need=mapT.size(),resLen = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>(){{add(-1);add(-1);}};
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(!mapS.containsKey(c)){
                mapS.put(c,1);
            }else{
                mapS.put(c,mapS.get(c)+1);
            }
            if(mapT.containsKey(c) && mapS.get(c) == mapT.get(c)){
                have+=1;
            }
            while(have == need){
                if(r-l+1 < resLen){
                    resLen = r-l+1;
                    res.add(0,l);
                    res.add(1,r);
                }
                char lc = s.charAt(l);
                mapS.put(lc,mapS.get(lc)-1);
                if(mapT.containsKey(lc) && mapS.get(lc) < mapT.get(lc)){
                    have-=1;
                }
                l+=1;
            }
        }
        if(resLen != -1){
            System.out.println(s.substring(res.get(0),res.get(1)+1));
        }
    }
}
