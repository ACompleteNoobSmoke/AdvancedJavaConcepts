package Streams;

import Model.Gender;
import Model.NewPeople;

import java.util.List;

import static Custom.NewPeopleSuppler.newPeopleSupplier;

public class Filtering {

    private List<NewPeople> people;

    public Filtering (List<NewPeople> people) {
        this.people = people;
    }

    public Filtering() {
        this.people = newPeopleSupplier.get();
    }

    private List<NewPeople> filterByAge() {
        return people.stream().filter(person -> person.age() < 29).toList();
    }

    private List<NewPeople> filterByMale() {
        return people.stream().filter(person -> person.gender().equals(Gender.MALE)).toList();
    }

    private List<NewPeople> filterByFemale() {
        return people.stream().filter(person -> person.gender().equals(Gender.FEMALE)).toList();
    }

    // takeWhile collects values while it fits the condition,
    // the moment the condition is no longer true, it ignores the rest
    private List<NewPeople> takeWhile() {
        return people.stream().takeWhile(person -> person.age() < 30).toList();
    }

    // dropWhile ignores values while it fits the condition,
    // the momen the condition is no longer true, then it collects the rest
    private List<NewPeople> dropWhile() {
        return people.stream().dropWhile(person -> person.age() < 35).toList();
    }

    public static void main(String[] args) {
        Filtering filterObj = new Filtering();
        filterObj.filterByAge().forEach(System.out::println);
        System.out.println();
        filterObj.filterByMale().forEach(System.out::println);
        System.out.println();
        filterObj.filterByFemale().forEach(System.out::println);
        System.out.println();
        filterObj.takeWhile().forEach(System.out::println);
        System.out.println();
        filterObj.dropWhile().forEach(System.out::println);
    }
}

