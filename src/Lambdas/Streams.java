package Lambdas;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<String> bingoNumbers =
                Arrays.asList("N40","N36","B12","B5"
                ,"G44","G11","G22","g64",
                        "O71");

        List<String> list = bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(num -> num.startsWith("G"))
                .sorted((s1,s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        Employees john = new Employees("John Doe",30);
        Employees jane = new Employees("Jane Deer",25);
        Employees jack = new Employees("Jack Hill",40);
        Employees jackDaniel = new Employees("Jack Daniel",40);
        Employees snow = new Employees("Snow White",22);

        Department hr = new Department("Human Resource");
        hr.addEmployee(jack);
        hr.addEmployee(jackDaniel);
        hr.addEmployee(jane);
        hr.addEmployee(snow);

        Department accounting = new Department("Account");
        accounting.addEmployee(john);



        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);
        Map<Integer,List<Employees>> listMap =
                departments.stream()
                                .flatMap(e -> e.getEmployeesList().stream())
                                        .collect(Collectors.groupingBy(e -> e.getAge()));
        for(Map.Entry<Integer,List<Employees>> data : listMap.entrySet()){
            System.out.println("Key "+data.getKey());
            System.out.println("Value "+data.getValue());
        }

        departments.stream()
                .flatMap(e -> e.getEmployeesList().stream())
                .reduce((employees1, employees2) -> employees1.getAge() > employees2.getAge() ? employees1 : employees2)
                .ifPresent(System.out::println);
//                departments.stream()
////                .peek(department -> System.out.println(department.getEmployeesList()))
//                .flatMap(department -> department.getEmployeesList().stream())
//                .forEach(System.out::println);


        Collections.sort(bingoNumbers, String::compareTo);
        for (String bingoNumber : bingoNumbers) {
            System.out.println(bingoNumber);
        }
        List<String> gNum = new ArrayList<>();
        AtomicInteger i = new AtomicInteger();
        bingoNumbers.forEach(num -> {
            if(num.toUpperCase().startsWith("G")){
                i.getAndIncrement();
                gNum.add(num);
                System.out.println(num);
            }
        });
        System.out.println(i);
        System.out.println(gNum.toString());
    }
}
