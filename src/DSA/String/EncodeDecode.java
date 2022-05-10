package DSA.String;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>(){{add("neet");add("cod#e");}};
        String decode = "";
        for(String i:input){
            decode += i.length()+"#"+i;
        }
        List<String> res = new ArrayList<>();
        System.out.println(decode);
        for(int i=0;i<decode.length()-2;i++){
            if(decode.substring(i,i+2).matches("[0-9]#")){
                res.add(decode.substring(i+2,i+2+Integer.parseInt(decode.substring(i,i+1))));
                i+=Integer.parseInt(decode.substring(i,i+1));
            }
        }
        System.out.println(res);
    }

}
