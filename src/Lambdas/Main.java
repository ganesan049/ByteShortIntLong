package Lambdas;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        String query = "\n  CREATE TABLE \"ATHENA250\".\"ACEAPPOINTMENT\" \n   (\t\"ID\" NUMBER(12,0) NOT NULL ENABLE, \n\t\"APPOINTMENTID\" NUMBER, \n\t\"CONTEXTID\" NUMBER, \n\t\"DEPARTMENTNAME\" VARCHAR2(100), \n\t\"DEPARTMENTADDRESS\" VARCHAR2(100), \n\t\"DEPARTMENTADDRESS2\" VARCHAR2(100), \n\t\"DEPARTMENTCITY\" VARCHAR2(100), \n\t\"DEPARTMENTSTATE\" VARCHAR2(2), \n\t\"DEPARTMENTZIP\" VARCHAR2(10), \n\t\"DEPARTMENTPHONE\" VARCHAR2(20), \n\t\"SCHEDULERUSERNAME\" VARCHAR2(100), \n\t\"PATIENTAPPOINTMENTLABELID\" NUMBER, \n\t\"DELETED\" DATE, \n\t\"DELETEDBY\" VARCHAR2(20), \n\t\"CREATED\" DATE, \n\t\"CREATEDBY\" VARCHAR2(20), \n\t\"LASTMODIFIED\" DATE, \n\t\"LASTMODIFIEDBY\" VARCHAR2(20), \n\t\"DEPARTMENTID\" NUMBER, \n\t\"DEPARTMENTNAMEINTERNAL\" VARCHAR2(100), \n\t\"DEPARTMENTFAX\" VARCHAR2(20), \n\t\"ORDERINGPROVIDERID\" NUMBER, \n\t\"ORDERINGPROVIDERNAME\" VARCHAR2(100), \n\t\"SPECIALTYID\" NUMBER, \n\t\"DOCUMENTREQUISITIONID\" NUMBER, \n\t\"FOREIGNREFERRALDOCUMENTNUMBER\" VARCHAR2(30), \n\t\"ORDERDOCUMENTID\" NUMBER\n   ) SEGMENT CREATION DEFERRED \n  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 \n ROW STORE COMPRESS ADVANCED LOGGING\n  TABLESPACE \"ATHENA250\" ";
        String mainQuery = query.split("SEGMENT")[0];
        System.out.println(mainQuery);

        List<String> stringList = Arrays.asList("a","b","c");
        stringList.forEach(System.out::println);
//        new Thread(() -> {
//            System.out.println("Printing Runnable");
//        })
//        .start();
        List<Employees> employees = new ArrayList<>();
        Employees gans = new Employees("Gans Bourne",20);
        Employees ganesan = new Employees("Ganesan Ramesh",24);
        Employees ganesanRamesh = new Employees("Ganesan Ramesh",31);
        employees.add(gans);
        employees.add(ganesan);
        employees.add(ganesanRamesh);
        Collections.sort(employees,(e1, e2) -> e1.getName().compareTo(e2.getName())) ;
        employees.forEach(e -> {
            System.out.println(e.getName()+" _ "+e.getAge());
        });

        Predicate<Employees> over30 = employee -> employee.getAge() > 30;
        printEmployeesByAge(employees,"Over 30",over30);
        printEmployeesByAge(employees,"under 30",employee -> employee.getAge() <= 30);
        printEmployeesByAge(employees, "under 20", new Predicate<Employees>() {
            @Override
            public boolean test(Employees employee) {
               return employee.getAge() <= 20;
            }
        });

        IntPredicate gt10 = i -> i > 10;
        IntPredicate lt50 = i -> i < 50;
        System.out.println(gt10.and(lt50).test(15));

        Random random = new Random();
        Supplier<Integer> supplier = () -> random.nextInt(10);
        for (int i=0;i<10;i++){
            System.out.println(supplier.get());
        }

        Function<Employees,String> getLastName = employee -> {
            return employee.getName().split(" ")[1];
        };

        employees.forEach(e -> {
            System.out.println(getLastName.apply(e));
        });

        System.out.println();
        System.out.println("==================");
        Function<Employees,String > upperCase = e -> e.getName().toUpperCase();
        Function<String,String > firstName = name -> name.substring(0,name.indexOf(" "));
        Function chainedFunction = upperCase.andThen(firstName);

        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employees,String> concatAge = (s, employee) -> {
          return s+" - "+employee.getAge();
        };

        System.out.println(concatAge.apply((String) chainedFunction.apply(employees.get(0)),employees.get(0)));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("gans");
        UpperConcat uc = (s1, s2) -> {
            return s1.toUpperCase(Locale.ROOT).concat(s2.toUpperCase(Locale.ROOT));
        };

        String sillyString = doSomeStuff(uc,gans.getName(),ganesan.getName());
        System.out.println(sillyString);
    }

    public static String doSomeStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);
    }

    private static void printEmployeesByAge(List<Employees> employees
        , String ageText, Predicate<Employees> ageCondition){
        System.out.println(ageText);
        System.out.println("============");
        employees.forEach(employee -> {
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        });
    }
}


interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

