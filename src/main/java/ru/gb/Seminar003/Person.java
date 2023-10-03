package ru.gb.Seminar003;

public class Person {
    private final String lastName;
    private final String secondName;
    private final String firstName;
    private final String birthday;
    private final long phone;
    private final String sex;

    public Person(String lastName, String firstName, String secondName, String birthday, long phone, String sex) {
        this.lastName = lastName;
        this.secondName = secondName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.phone = phone;
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%d><%s>\n",lastName, firstName, secondName, birthday, phone, sex);
    }
}
