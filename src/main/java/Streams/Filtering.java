package Streams;

import Model.Gender;
import Model.NewPeople;

import java.util.List;
import java.util.Optional;

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
    // the moment the condition is no longer true, then it collects the rest
    private List<NewPeople> dropWhile() {
        return people.stream().dropWhile(person -> person.age() < 35).toList();
    }

    // findFirst returns the first object/value that fits the criteria
    private NewPeople findFirst(int ageLimit) {
        return people.stream()
                .filter(person -> person.age() == ageLimit).findFirst()
                .orElse(new NewPeople("Osaretin","Omofonmwan", 30, "oso@gmail.com", Gender.MALE));

    }

    // findAny returns any object/value that fits the criteria -- you have no control of the one it picks
    private NewPeople findAny(String gender){
        return people.stream()
                .filter(person -> person.gender().toString().equals(gender))
                .findAny()
                .orElse(new NewPeople("Omoruyi","Omofonmwan", 30, "oso@gmail.com", Gender.MALE));
    }

    // allMatch requires that all elements matches the condition set the it returns true otherwise false
    private boolean isInAgeRange(int ageLimit) {
        return people.stream().allMatch(person -> person.age() >= ageLimit);
    }

    // anyMatch requires that at least 1 element matches the condition set then it returns true otherwise false
    private boolean isPartOfGender(String gender) {
        return people.stream().anyMatch(person -> person.gender().toString().equals(gender));
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
        System.out.println();
        System.out.println(filterObj.findFirst(3));
        System.out.println();
        System.out.println(filterObj.findAny("MALES"));
        System.out.println();
        System.out.println(filterObj.isInAgeRange(0));
        System.out.println();
        System.out.println(filterObj.isPartOfGender("MALE"));
    }
}

