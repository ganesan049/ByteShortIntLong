package oops;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

//    static <T> Collection<List<T>> partitionIntegerListBasedOnSize(List<T> inputList, int size) {
//        final AtomicInteger counter = new AtomicInteger(0);
//        return inputList.stream()
//                .collect(Collectors.groupingBy(s -> counter.getAndIncrement()/size))
//                .values();
//    }
static <T> List<List<T>> chopped(List<T> list, final int L) {
    List<List<T>> parts = new ArrayList<List<T>>();
    final int N = list.size();
    for (int i = 0; i < N; i += L) {
        parts.add(new ArrayList<T>(
                list.subList(i, Math.min(N, i + L)))
        );
    }
    return parts;
}
    private static BigDecimal getBigDecimal(Map<String, Object> m1) {
        BigDecimal m1Value = null;
        if(m1.get("COLUMN_ID") != null){
            if( m1.get("COLUMN_ID") instanceof BigDecimal ) {
                m1Value = (BigDecimal) m1.get("COLUMN_ID");
            } else if( m1.get("COLUMN_ID") instanceof String ) {
                m1Value = new BigDecimal( (String) m1.get("COLUMN_ID") );
            } else if( m1.get("COLUMN_ID") instanceof BigInteger) {
                m1Value = new BigDecimal( (BigInteger) m1.get("COLUMN_ID") );
            } else if( m1.get("COLUMN_ID") instanceof Number ) {
                m1Value = new BigDecimal( ((Number)m1.get("COLUMN_ID")).doubleValue() );
            }
        }else{
            m1Value = new BigDecimal(Integer.MAX_VALUE);
        }
        return m1Value;
    }
    public static void main(String[] args) {
            List<String> queryValue = new ArrayList<>();
            String columnNames = "ID,CREATED,CREATEDBY,PATIENTID,PROVIDERID,PRIMARYPATIENTINSURANCEID,SECONDARYPATIENTINSURANCEID,DEPARTMENTID,PATIENTDEPARTMENTID,DIAGNOSIS1,DIAGNOSIS2,DIAGNOSIS3,DIAGNOSIS4,REFERRINGPROVIDERID,APPOINTMENTID,CURRENTILLNESSDATE,SIMILARILLNESSDATE,FROMUNABLETOWORKDATE,TOUNABLETOWORKDATE,FROMHOSPITALIZATIONDATE,TOHOSPITALIZATIONDATE,RESERVED19,MEDICAIDRESUBMISSIONCODE,LASTMODIFIED,LASTMODIFIEDBY,SERVICEDATE,REFERRALAUTHID,ORIGINALCLAIMID,MANUALDROPYN,LASTACTION,LASTACTIONDATE,SUPERVISINGPROVIDERID,STATUS1,STATUS2,STATUSP,OUTSTANDING1,OUTSTANDING2,OUTSTANDINGP,LASTBILLEDDATE1,LASTBILLEDDATE2,LASTBILLEDDATEP,OTHERDIAGNOSES,CLAIMBATCHID,MANUALDROPREASONID,CLAIMTYPE,ADDITIONALFREETEXT,ACCEPTASSIGNMENTYN1,ACCEPTASSIGNMENTYN2,PRINTZERODOLLARCHARGESYN1,STATUS1LASTMODIFIED,STATUS2LASTMODIFIED,STATUSPLASTMODIFIED,PARENTCLAIMID,RELATEDTOEMPLOYMENTYN,RELATEDTOAUTOACCIDENTYN,RELATEDTOOTHERACCIDENTYN,AUTOACCIDENTSTATE,RELEASEOFINFORMATIONYN1,CLAIMSUBMISSIONCATEGORYID1,CLAIMSUBMISSIONCATEGORYID2,CLAIMPATIENTINSURANCEPID,PHYSICIANSIGNATUREDATE,SIGNATURESOURCECODE,ASSIGNMENTOFBENEFITSFLAG,SCHEDULINGPROVIDERID,ANOTHERPARTYRESPONSIBLEYN,FULLYWORKEDREASONID1,FULLYWORKEDREASONID2,FULLYWORKEDREASONIDP,MANUALDROPYN2,MANUALDROPREASONID2,STATUS1CLAIMNOTEID,STATUS2CLAIMNOTEID,STATUSPCLAIMNOTEID,CLAIMALARMELIGIBLEYN,NODENIALMANAGEMENTYN,DIAGNOSIS5,DIAGNOSIS6,DIAGNOSIS7,DIAGNOSIS8,RESERVED10D,RTAELIGIBLEYN1,MEDICAIDRESUBMISSIONORIGREFNO,PQRIPARTICIPATION,LASTSCRUBDATE1,LASTSCRUBDATE2,SLIDINGFEEPATIENTINSURANCEID,EPAYMENTCONTRACTID,PATIENTROUNDINGLISTID,PAYTOTAXID1,PAYTOTAXID2,PAYTONPI1,PAYTONPI2,ACCIDENTDATE,MSPINSURANCETYPEID,MSPINSURANCETYPESETYN,PRIMARYBILLINGPROVIDERID,COVERAGESCANYN,RETROMEDICAIDENROLLMENTYN,VISITGROUPID,HEALTHCARECLAIMTYPEID1,HEALTHCARECLAIMTYPEID2,VISITBILLID,ALTERNATIVEPAYMENTMODELID,LASTSCRUBDATEP,THIRDPARTYINSDETECTIONYN,LASTDML";
            String columnIds = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,null";
            List<String> columnNamesList = List.of(columnNames.split(","));
            List<String> columnIdsList = List.of(columnIds.split(","));
            List<String> hiddenList  = new ArrayList<>();
        for(int i=0;i<columnIdsList.size();i++){
            if(columnIdsList.get(i).equals("null")){
                hiddenList.add(columnNamesList.get(i));
            }
        }
        System.out.println(hiddenList);
        System.out.println(Collections.singletonList(columnNames).get(0));
        if(false){
        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String, String > test = new HashMap<>();
        test.put("a","1");
            test.put("b","2");
            test.put("c","3");
            test.put("d","4");
            System.out.println("value "+test.get("bb"));
            if(test.containsKey("bb")){
                System.out.println("false");
            }else {
                System.out.println("true");
            }
            Map<String,Object> mapValueE = new HashMap<>();
            System.out.println(mapValueE.size());
            System.out.println(mapValueE);
            mapValueE.put("COLUMN_ID",null);
            mapValueE.put("COLUMN_NAME","LASTDML");
            System.out.println(Objects.isNull(mapValueE.get("COLUMN_ID")));
            Map<String,Object> mapValueO = new HashMap<>();
            mapValueO.put("COLUMN_ID",new BigDecimal("0.03"));
            mapValueO.put("COLUMN_NAME","one");
            listMap.add(mapValueE);
            listMap.add(mapValueO);
            System.out.println(listMap);
            Comparator<Map<String, Object>> mapComparator = new Comparator<Map<String, Object>>() {
                public int compare(Map<String, Object> m1, Map<String, Object> m2) {
                    BigDecimal m1Value = getBigDecimal(m1);
                    BigDecimal m2Value = getBigDecimal(m2);
                    return m1Value.compareTo(m2Value);
                }
            };
            Collections.sort(listMap,mapComparator);
            System.out.println(listMap);
            listMap.forEach(i -> {
                if(i.get("COLUMN_ID") != null){
                    System.out.println(i.get("COLUMN_ID").getClass().getName());
                }else {
                    System.out.println(i.get("COLUMN_ID"));

                }
                queryValue.add((String)i.get("COLUMN_NAME"));
            });
            List<String> sortedCols = listMap.stream().map(i -> (String)i.get("COLUMN_NAME")).collect(Collectors.toList());
            System.out.println(sortedCols);
            BigDecimal _a = new BigDecimal("0.03");
        }
        queryValue.forEach(System.out::println);
//        String s = (String) _a;
//        System.out.println(Integer.);
        List<String> list = Arrays.asList("a","b","c","d","e");
        String listString = String.join(",",list);
        listString=listString.replace("a","A");
        System.out.println(listString);
        System.out.println(chopped(list, 4));
        String value = "\n  CREATE TABLE \"ATHENA250\".\"UNPOSTABLE\" \n   (\t\"ID\" NUMBER(12,0) NOT NULL ENABLE, \n\t\"PAYMENTBATCHID\" NUMBER(12,0), \n\t\"ERARECORDID\" NUMBER(12,0), \n\t\"AMOUNT\" NUMBER(22,2), \n\t\"UNPOSTABLETYPEID\" VARCHAR2(30), \n\t\"UNPOSTABLESTATUSID\" VARCHAR2(30), \n\t\"ASSIGNMENTGROUPCLASSID\" NUMBER(12,0), \n\t\"UNPOSTABLEROUTEID\" NUMBER(12,2), \n\t\"PENDALARMDATE\" DATE, \n\t\"NOTE\" VARCHAR2(2000), \n\t\"VOIDPAYMENTBATCHID\" NUMBER(12,0), \n\t\"ORIGINALPAYMENTBATCHID\" NUMBER(12,0), \n\t\"CREATED\" DATE, \n\t\"CREATEDBY\" VARCHAR2(20), \n\t\"LASTMODIFIED\" DATE, \n\t\"LASTMODIFIEDBY\" VARCHAR2(20), \n\t\"VOIDED\" DATE, \n\t\"VOIDEDBY\" VARCHAR2(20), \n\t\"VOIDPARENTID\" NUMBER(12,0), \n\t\"POSTDATE\" DATE, \n\t\"POSTEDBY\" VARCHAR2(20), \n\t\"CHECKCCNUMBER\" VARCHAR2(100), \n\t\"CHECKAMOUNT\" NUMBER(22,2), \n\t\"CHECKDATE\" DATE, \n\t\"CHECKIDENTIFIER\" VARCHAR2(100), \n\t\"KICKREASONCATEGORYID\" NUMBER(12,0), \n\t\"PAYORSTATE\" VARCHAR2(2), \n\t\"PATIENTID\" NUMBER(12,0), \n\t\"DISPLAYONPATIENTRECORDYN\" VARCHAR2(1), \n\t\"PROVIDERID\" NUMBER(12,0), \n\t\"MEDICALGROUPID\" NUMBER(12,0), \n\t\"INSURANCEREPORTINGCATEGORYID\" NUMBER(12,0), \n\t\"URGENTFLAG\" VARCHAR2(1), \n\t\"PERTAINSTOPRACTICEID\" NUMBER(12,0), \n\t\"ASSIGNMENTGROUPID\" NUMBER(12,0), \n\t\"LASTUNPOSTABLEEVENTID\" NUMBER(12,0), \n\t\"LASTEVENTUNPOSTABLENOTEID\" NUMBER(12,0), \n\t\"PROVIDERGROUPID\" NUMBER(12,0), \n\t\"PAYORCONTROLNUMBER\" VARCHAR2(110), \n\t\"PAYORCONTROLNUMBER2\" VARCHAR2(50), \n\t\"PAYORCONTROLNUMBER3\" VARCHAR2(50), \n\t\"DUALPOSTCLONEUNPOSTABLEID\" NUMBER(12,0), \n\t\"EPAYMENTID\" NUMBER(12,0), \n\t\"VOIDEPAYMENTID\" NUMBER(12,0), \n\t\"TAXRATE\" NUMBER(8,6), \n\t\"PAYMENTBATCHSCANPAGEID\" NUMBER(12,0), \n\t\"PROVIDERNUMBERID\" NUMBER(12,0), \n\t\"MEDICALGROUPNUMBERID\" NUMBER(12,0), \n\t\"CLAIMID\" NUMBER(12,0), \n\t\"INCENTIVEPROGRAMID\" NUMBER(12,0), \n\t\"INCENTIVEPROGRAMYEAR\" NUMBER(12,0), \n\t\"PAYMENTMETHODID\" VARCHAR2(10), \n\t\"ERADISCARDRULEID\" NUMBER(12,0), \n\t\"PAYORCONTROLNUMBERSTRIPPED\" VARCHAR2(110), \n\t\"READJMATCHSETID\" NUMBER(12,0), \n\t\"INSURANCEPACKAGEID\" NUMBER(12,0), \n\t\"CORRECTIONSPAYMENTBATCHID\" NUMBER(12,0), \n\t\"PRACTICEREPORTINGINFORMATION\" VARCHAR2(110), \n\t\"PATIENTPAYMENTID\" NUMBER(12,0), \n\t\"VOIDPATIENTPAYMENTID\" NUMBER(12,0), \n\t\"PAYERSITECLASSID\" NUMBER(12,0), \n\t\"DEPARTMENTID\" NUMBER(12,0), \n\t\"GLOBALROUTINGREASON\" VARCHAR2(2000), \n\t\"LASTDML\" DATE\n   ) SEGMENT CREATION DEFERRED \n  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 \n ROW STORE COMPRESS ADVANCED LOGGING\n  TABLESPACE \"ATHENA250\" ";
        value = value.replaceAll("\\n","");
        value = value.replaceAll("\\t","");
        value = value.replaceAll("\\\\","");
        System.out.println(value);

//        Car prosche = new Car();
//        prosche.setModel("Carrera");
//        System.out.println(prosche.available);
//        System.out.println(prosche.getDoors());
//        System.out.println(prosche.getModel());

//        SimpleCalculator calculator = new SimpleCalculator();
//        calculator.setFirstNumber(10.0);
//        calculator.setSecondNumber(14);
//        System.out.println("add= " + calculator.getAdditionResult());
//        System.out.println("subtract= " + calculator.getSubtractionResult());
//        calculator.setFirstNumber(-5.25);
//        calculator.setSecondNumber(-10);
//        System.out.println("multiply= " + calculator.getMultiplicationResult());
//        System.out.println("divide= " + calculator.getDivisionResult());

//        Person person = new Person();
//        person.setFirstName("");   // firstName is set to empty string
//        person.setLastName("");    // lastName is set to empty string
//        person.setAge(10);
//        System.out.println("fullName= " + person.getFullName());
//        System.out.println("teen= " + person.isTeen());
//        person.setFirstName("John");    // firstName is set to John
//        person.setAge(18);
//        System.out.println("fullName= " + person.getFullName());
//        System.out.println("teen= " + person.isTeen());
//        person.setLastName("Smith");    // lastName is set to Smith
//        System.out.println("fullName= " + person.getFullName());

//        VipCustomer cust0 = new VipCustomer();
//        System.out.println(cust0.toString());
//        VipCustomer cust2 = new VipCustomer("gans",1000);
//        System.out.println(cust2.toString());
//        VipCustomer cust3= new VipCustomer("gans",1000,"gans@gmail.com");
//        System.out.println(cust3.toString());

//        Wall wall = new Wall(5,4);
//        System.out.println("area= " + wall.getArea());
//
//        wall.setHeight(-1.5);
//        System.out.println("width= " + wall.getWidth());
//        System.out.println("height= " + wall.getHeight());
//        System.out.println("area= " + wall.getArea());

//        Point first = new Point(6, 5);
//        Point second = new Point(3, 1);
//        System.out.println("distance(0,0)= " + first.distance());
//        System.out.println("distance(second)= " + first.distance(second));
//        System.out.println("distance(2,2)= " + first.distance(2, 2));
//        Point point = new Point();
//        System.out.println("distance()= " + point.distance());

//        Carpet carpet = new Carpet(3.5);
//        Floor floor = new Floor(2.75, 4.0);
//        Calculator calculator = new Calculator(floor, carpet);
//        System.out.println("total= " + calculator.getTotalCost());
//        carpet = new Carpet(1.5);
//        floor = new Floor(5.4, 4.5);
//        calculator = new Calculator(floor, carpet);
//        System.out.println("total= " + calculator.getTotalCost());

//        ComplexNumber one = new ComplexNumber(1.0, 1.0);
//        ComplexNumber number = new ComplexNumber(2.5, -1.5);
//
//        System.out.println("one.real= " + one.getReal());
//        one.add(1,1);
//        System.out.println("one.real= " + one.getReal());
//        System.out.println("one.imaginary= " + one.getImaginary());
//        one.subtract(number);
//        System.out.println("one.real= " + one.getReal());
//        System.out.println("one.imaginary= " + one.getImaginary());
//        number.subtract(one);
//        System.out.println("number.real= " + number.getReal());
//        System.out.println("number.imaginary= " + number.getImaginary());
    }
}
