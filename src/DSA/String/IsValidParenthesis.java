package DSA.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsValidParenthesis {
    public static void main(String[] args) {
        String input = "{([])}";
        List<String> stack = new ArrayList<>();
        Map<String,String> closeToOpen = new HashMap<>();
        closeToOpen.put(")","(");
        closeToOpen.put("}","{");
        closeToOpen.put("]","[");
        boolean res = true;
        for(int i=0;i<input.length();i++){
            String n = String.valueOf(input.charAt(i));
            if(closeToOpen.containsKey(n)){
                if(stack.size() != 0 && stack.get(stack.size() - 1).equals(closeToOpen.get(n))){
                    stack.remove(stack.size() - 1);
                }else{
                    res = false;
                    break;
                }
            }else{
                stack.add(n);
            }
        }
        System.out.println(res);
    }
}
