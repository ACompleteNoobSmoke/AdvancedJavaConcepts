package Streams;

import Custom.PersonSupplier.*;
import Model.Person;

import java.util.ArrayList;
import java.util.List;

import static Custom.PersonSupplier.getPeople;

public class BeginnerStreamPractice {

    List<Person> people = null;

    public BeginnerStreamPractice(List<Person> people) {
        this.people = people;
    }

    public BeginnerStreamPractice() {
        this.people = getPeople();
    }

    public void imperativeApproach() {
        List<Person> youngPeople = new ArrayList<>();
        int limit = 10;
        int counter = 0;
        for (Person person: people) {
            if (person.age() <= 25) {
                youngPeople.add(person);
                counter++;
            }
            if (counter == limit) break;
        }

        youngPeople.forEach(System.out::println);
    }

    public void declarativeApproach() {
        people.stream()
                .filter(p -> p.age() <= 25)
                .limit(10)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        BeginnerStreamPractice beginnerStreamPractice = new BeginnerStreamPractice();
        beginnerStreamPractice.imperativeApproach();
        System.out.println();
        beginnerStreamPractice.declarativeApproach();
    }
}
