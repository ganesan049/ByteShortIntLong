package DSA.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
//        Note that the letters wrap around.
//        For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
public class NextGreatestLetter {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'a'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        List<Character> list = IntStream.range(0,letters.length).mapToObj(i -> letters[i]).collect(Collectors.toList());
        //sort
        if(new String(letters).indexOf(target) < 0){
            list.add(target);
            list = list.stream().sorted().collect(Collectors.toList());
        }
        //search
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(target)){
                if(i!=list.size()-1 && !list.get(i+1).equals(target)){
                        return list.get(i+1);
                }else{
                    return list.get(0);
                }
            }
        }
        return target;
    }
}
