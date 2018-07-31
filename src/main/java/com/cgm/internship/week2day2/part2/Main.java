package com.cgm.internship.week2day2.part2;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {

    static List<Person> persons = Arrays.asList(
            new Person("John", "Doe", LocalDate.of(1960, 11, 3), "jdoe@example.com",
                    Arrays.asList(
                            new Person("Timmy", "Doe", LocalDate.of(1990, 11, 10), "timmydoe@example.com"),
                            new Person("Jimmy", "Doe", LocalDate.of(1988, 11, 30), "jimmydoe@example.com")
                    )),
            new Person("Ellen", "Smith", LocalDate.of(1992, 5, 13), "ellensmith@example.com",
                    Arrays.asList(
                            new Person("Anne", "Smith", LocalDate.of(2017, 1, 25), null),
                            new Person("Lizzy", "Smith", LocalDate.of(2015, 7, 16), null)
                    )),
            new Person("Jane", "White", LocalDate.of(1986, 2, 1), "janewhite@example.com",
                    Arrays.asList(
                            new Person("Peter", "White", LocalDate.of(2016, 12, 25), null)
                    )
            ),
            new Person("Bill", "Jackson", LocalDate.of(1999, 11, 6), "bjackson@example.com"),
            new Person("John", "Smith", LocalDate.of(1975, 7, 14), "johnsmith@example.com",
                    Arrays.asList(
                            new Person("Billy", "Smith", LocalDate.of(2001, 4, 13), "billy@example.com"),
                            new Person("Rodrick", "Smith", LocalDate.of(2005, 5, 1), null),
                            new Person("Hans", "Smith", LocalDate.of(2007, 6, 17), null)
                    )),
            new Person("Jack", "Williams", LocalDate.of(1973, 5, 28), "")
    );

    public static void main(String args[]) {

        //split persons by the initial of their last name
        Map <Character,List<Person>> groupByInitLastName = persons.stream().collect(Collectors.groupingBy(persons->persons.getLastName().charAt(0)));
        System.out.println("People by last name initial: "+groupByInitLastName);

        //get all persons born this month, sorted by age
        List<Person> bornThisMonthByAge = persons.stream().filter(person -> person.getDateOfBirth().getMonth().equals(LocalDate.now().getMonth()))
                .sorted(Comparator.comparing(Person::getDateOfBirth)).collect(Collectors.toList());
        System.out.println("People born this month, by age: "+bornThisMonthByAge);

        //get persons with no children
        List<Person> peopleWithNoChildren = persons.stream().filter(person -> person.getChildren().isEmpty()).collect(toList());
        System.out.println("People with no children: "+peopleWithNoChildren);

        //number of kids per person full name
        Map<String,Integer> noOfKidsPerPerson = persons.stream().collect(Collectors.toMap(Person::getFullName,Person->Person.getChildren().size()));
        System.out.println("People and the number of their kids: "+noOfKidsPerPerson);

        //names of children who have an email address
        List<String> namesOfChildrenWithEmailAdress = persons.stream().flatMap( p-> p.getChildren().stream()).filter(children -> children
                .getEmailAddress()!=null).collect(Collectors.toMap(Person::getFirstName,Person::getLastName));
        System.out.println(namesOfChildrenWithEmailAdress);


    }
}
