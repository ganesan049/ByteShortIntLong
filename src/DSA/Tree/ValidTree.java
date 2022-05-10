package DSA.Tree;

import java.util.*;

public class ValidTree {
    public static Set<Integer> visit = new HashSet<>();
    public static Map<Integer,List<Integer>> json = new HashMap<>();
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> input = new ArrayList<>(new ArrayList<>());
        input.add(new ArrayList<>(){{add(0);add(1);}});
        input.add(new ArrayList<>(){{add(0);add(2);}});
        input.add(new ArrayList<>(){{add(0);add(4);}});
        input.add(new ArrayList<>(){{add(1);add(3);}});

        for(int i=0;i<n;i++){
            json.put(i,new ArrayList<>());
        }
        for(List<Integer> i: input){
            json.get(i.get(0)).add(i.get(1));
            json.get(i.get(1)).add(i.get(0));
        }
        boolean result = dfs(0,-1) ? n == visit.size(): false;
        System.out.println(result);
    }

    private static boolean dfs(int curr, int prev) {
        if(visit.contains(curr)){
            return false;
        }
        visit.add(curr);
        System.out.println(json);
        for(Integer v : json.get(curr)){
        System.out.println(v);
            if(v != prev){
                if(!dfs(v,curr)){
                    return false;
                }
            }
        };
        return true;
    }
}
