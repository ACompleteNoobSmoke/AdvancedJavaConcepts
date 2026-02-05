package Streams;

import Model.Gender;
import Model.NewPeople;

import java.util.List;
import static Custom.NewPeopleSuppler.newPeopleSupplier;

public class Statistics {

    private List<NewPeople> people;

    public Statistics(List<NewPeople> people) {
        this.people = people;
    }

    public Statistics() {
        this.people = newPeopleSupplier.get();
    }

    public long maleCount() {
        return people.stream()
                .filter(person -> Gender.MALE.equals(person.gender()))
                .count();
    }

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        long average = statistics.maleCount();
        System.out.println("Average male count: " + average);
    }
}
