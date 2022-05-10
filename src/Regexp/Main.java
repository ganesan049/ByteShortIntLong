package Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "I apple a Stringgggggg.123456789 Yes \\ I am";
        String youString = string.replaceAll("I","You");
        System.out.println(youString);
        System.out.println(youString.matches("You am a String. Yes You am"));
        System.out.println(youString.replaceAll("(?i)[Y]Ou","I"));
        System.out.println(youString.replaceAll("\\w","x"));
        System.out.println(youString.replaceAll("\\W","x"));
        System.out.println(youString.replaceAll("\\b","x"));

        System.out.println(string.replaceAll("(?i)am+","x"));
        System.out.println(string.replaceAll("(?i)a.{3}e","x"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-Heading</h2>");
        htmlText.append("<p>Paragraph</p>");
        htmlText.append("<h2>SubSUb-Heading</h2>");
        htmlText.append("<p>SUbParagraph</p>");

        System.out.println(htmlText);
        String h2Pattern = "</h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurences "+count+" from: "+matcher.start()+" end: "+matcher.end());
        }

        String h2TextExtract = "(<h2>)(.+?)(</h2>)";
        System.out.println(h2TextExtract);
        Pattern extractPattern = Pattern.compile(h2TextExtract);
        Matcher matcher1 = extractPattern.matcher(htmlText);
        System.out.println(matcher1.find());
        System.out.println(matcher1.group(2));
//        while (matcher1.find()){
//            System.out.println(matcher1.group(2));
//        }
        challenge();
    }

    private static void challenge() {
        String challenge1 = "I want a bike";
        String challenge2 = "I want a ball";
        String regExp = "I want a \\w+";
        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscore";
        System.out.println(challenge4.replaceAll("[ ]","_"));

        String challenge5 = "aaaabbbccdddeeeffff";
        System.out.println(challenge5.matches("[a-z]*"));

        String challenge6 = "aabbcc1.42424";
        System.out.println(challenge6.matches("[a-z]+\\.[0-9]+"));

        String challenge7 = "abc.123uvws.7dsf.999";
        String regExp7 = "(\\.)(\\d+)([a-z]*)";
        Pattern pattern1 = Pattern.compile(regExp7);
        Matcher matcher1 = pattern1.matcher(challenge7);

        while (matcher1.find()){
            System.out.println(matcher1.group(2));
        }

        String challenge8 = "abc.123\tuvws.8\tdsf.999\n";
        String regExp8 = "(\\.)(\\d+)(\\s[a-z]*)";
        Pattern pattern2 = Pattern.compile(regExp8);
        Matcher matcher2 = pattern2.matcher(challenge8);

        while (matcher2.find()){
            System.out.println(matcher2.group(2));
        }

        String challenge9 = "{1,2},{11,12},{21,22},{31,32}";
        String regExp9 = "\\{([\\d]+,[\\d]+)\\}";
        Pattern pattern9 = Pattern.compile(regExp9);
        Matcher matcher9 = pattern9.matcher(challenge9);

        while (matcher9.find()){
            System.out.println(matcher9.group(1));
        }
    }
}
