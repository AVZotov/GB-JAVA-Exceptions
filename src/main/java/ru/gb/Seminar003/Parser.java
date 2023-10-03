package ru.gb.Seminar003;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final StringBuilder userInput;
    private final String fullNameRegex = "[A-Z]\\S*\\s[A-Z]\\S*\\s[A-Z]\\S*";
    private final String birthdayRegex = "(?:(?:(?:(?:0[1-9]|1[0-9]|2[0-8])[\\.](?:0[1-9]|1[012]))|(?:(?:29|30|31)[\\.]" +
                                            "(?:0[13578]|1[02]))|(?:(?:29|30)[\\.](?:0[4,6,9]|11)))[\\.](?:19|[2-9][0-9])\\d\\d)|(?:29[\\.]02[\\.]" +
                                            "(?:19|[2-9][0-9])(?:00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96))";
    private final String phoneRegex = "[0-9]{11}";
    private final String sexRegex = "\\b[fm]\\b";

    public Parser(String userInput) {
        this.userInput = new StringBuilder(userInput);
    }

    public Person getPerson() throws ParserError{
        String sex = null;
        String phone = null;
        String birthday = null;
        String fullName = null;

        try{
            sex = getSex();
        }
        catch (ParserError e){
            System.out.println(e.getMessage());
        }
        try{
            phone = getPhone();
        }
        catch (ParserError e){
            System.out.println(e.getMessage());
        }
        try{
            birthday = getBirthday();
        }
        catch (ParserError e){
            System.out.println(e.getMessage());
        }
        try{
            fullName = getFullName();
        }
        catch (ParserError e){
            System.out.println(e.getMessage());
        }

        if (sex != null & phone != null & birthday != null & fullName != null){
            String[] splitFullName = fullName.split(" ");
            return new Person(splitFullName[0], splitFullName[1], splitFullName[2], birthday, Long.parseLong(phone), sex);
        }
        return null;
    }

    public String getFullName() throws ParserError{
        HashMap<Integer, String> result = searchByRegex(fullNameRegex);
        if (result.isEmpty())
            throw new ParserError("Person Full name did not found in inputted string: " +
                    "You need to input full name in format: <Lastname> <Firstname> <Secondname>");

        if (result.size() > 1)
            throw new ParserError("Person Full name is mentioned in more then 1 time, please check positions:" + result.keySet());

        return parseResult(result);
    }

    public String getBirthday() throws ParserError{
        HashMap<Integer, String> result = searchByRegex(birthdayRegex);
        if (result.isEmpty())
            throw new ParserError("Person birthday date not found in inputted string: " +
                    "You need to input birthday in format: dd.mm.yyyy");

        if (result.size() > 1)
            throw new ParserError("Person birthday is mentioned in more then 1 time, please check positions:" + result.keySet());

        return parseResult(result);
    }

    public String getPhone() throws ParserError{
        HashMap<Integer, String> result = searchByRegex(phoneRegex);
        if (result.isEmpty())
            throw new ParserError("Person phone not found in inputted string: " +
                    "You need to input phone in format: phone number(11 digits) with country code without spaces and +");

        if (result.size() > 1)
            throw new ParserError("Person phone is mentioned in more then 1 time, please check positions:" + result.keySet());

        return parseResult(result);
    }

    public String getSex() throws ParserError {
        HashMap<Integer, String> result = searchByRegex(sexRegex);
        if (result.isEmpty())
            throw new ParserError("Person sex not found in inputted string: You need to input f & m");

        if (result.size() > 1)
            throw new ParserError("Person sex is mentioned in more then 1 time, please check positions:" + result.keySet());

        return parseResult(result);
    }

    public boolean checkUserInput() throws ParserError{
        int correctSubstringsQuantity = 4;
        int counter = 0;
        counter += (countSubstrings(fullNameRegex) + countSubstrings(birthdayRegex) + countSubstrings(phoneRegex) + countSubstrings(sexRegex));

        return true;
    }

    private HashMap<Integer, String> searchByRegex(String regex){
        HashMap<Integer, String> result = new HashMap<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);

        while (matcher.find()){
            result.put(matcher.start(), String.format("%s", userInput.substring(matcher.start(), matcher.end())));
        }
        return result;
    }

    private int countSubstrings(String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        int counter = 0;

        while (matcher.find()){
            counter++;
        }

        return counter;
    }
    private String parseResult(HashMap<Integer, String> result){
        Set<Integer> positions = result.keySet();
        int valuePositionStart = positions.iterator().next();
        String parsedValue = result.values().toString().replaceAll("\\[", "").replaceAll("]", "");
        int parsedValueLength = parsedValue.length();
        userInput.delete(valuePositionStart, valuePositionStart + parsedValueLength + 1);
        return parsedValue;
    }
}
