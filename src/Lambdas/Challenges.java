package Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Challenges {
    public static void main(String[] args) {
        Runnable runnable = () -> {
                String myString = "Let's split this up into an array";
                Arrays.stream(myString.split(" ")).forEach(System.out::println);
        };
        new Thread(runnable).start();

        Function<String,String> lambdaFn = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0;i<s.length();i++){
                if(i%2==0){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

//        System.out.println(lambdaFn.apply("012345678"));
        everySecondCharacter(lambdaFn,"012345678");

        Supplier<String> iLoveJava = () -> "I Love Java";
        System.out.println(iLoveJava.get());

        List<String> topNames = Arrays.asList(
                "amelai",
                "omelia",
                "emiy",
                "Isla",
                "Oliver",
                "ack",
                "charlie",
                "harry",
                "jacob"
        );

        Long count = topNames.stream()
                .map(e -> {
                    return e.substring(0,1).toUpperCase()+e.substring(1);
                })
                .sorted()
                .filter(e -> e.charAt(0) == 'A')
                .count();
        System.out.println(count);
//                .forEach(System.out::println);

    }


    public static void everySecondCharacter(Function fn,String s){
        System.out.println(fn.apply(s));
    }
}
