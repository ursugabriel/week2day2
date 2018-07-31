package com.cgm.internship.week2day2.part2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String emailAddress;
    private List<Person> children;

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.children = Collections.emptyList();
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String emailAddress, List<Person> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.children = children;
    }

    public String getFullName() {
        return getLastName() + "," + getFirstName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + dateOfBirth.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
    }
}
