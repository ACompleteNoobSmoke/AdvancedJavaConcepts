package Streams;

import Model.Gender;
import Model.NewPeople;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
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

    public NewPeople getYoungestMale() {
        return people.stream()
                .filter(person -> Gender.MALE.equals(person.gender()))
                .sorted(Comparator.comparing(NewPeople::age))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Error Generating People List"));
    }

    public double averageAgeOfMales() {
        return people.stream()
                .filter(person -> person.gender().equals(Gender.MALE))
                .mapToDouble(NewPeople::age)
                .average()
                .orElse(0);
    }

    public int sumOfMaleAges(){
        return people.stream()
                .filter(person -> Gender.MALE.equals(person.gender()))
                .mapToInt(NewPeople::age)
                .sum();
    }

    public IntSummaryStatistics getSummaryStatistics() {
        return people.stream()
                .filter(person -> person.gender().equals(Gender.MALE))
                .mapToInt(NewPeople::age)
                .summaryStatistics();
    }

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        long average = statistics.maleCount();
        System.out.println("Average male count: " + average);
        System.out.println();
        NewPeople youngMale = statistics.getYoungestMale();
        System.out.println(youngMale);
        double averageAge = statistics.averageAgeOfMales();
        System.out.println("Average age of males: " + averageAge);
        int sumOfAges = statistics.sumOfMaleAges();
        System.out.println("Sum of male ages: " + sumOfAges);
        IntSummaryStatistics summary = statistics.getSummaryStatistics();
        System.out.println("Summary statistics: " + summary);
    }
}
