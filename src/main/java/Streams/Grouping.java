package Streams;

import static Custom.NewPeopleSuppler.newPeopleSupplier;
import Model.NewPeople;

import java.util.List;
import java.util.stream.Collectors;

public class Grouping {

    private List<NewPeople> people;

    public Grouping(List<NewPeople> people) {
        this.people = people;
    }

    public Grouping() {
        this.people = newPeopleSupplier.get();
    }

    public void groupByGender() {
        people.stream()
                .collect(Collectors.groupingBy(NewPeople::gender))
                .forEach(((gender, peopleList) -> {
                    System.out.println(gender.toString());
                    peopleList.forEach(System.out::println);
                    System.out.println();
                }));
    }

    public void duplicateNames() {
        List<String> duplicateNames = List.of("John", "John", "Jane", "Mariam", "Jackie");
        duplicateNames.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .forEach((name, count) -> System.out.println(name + ": " + count));
    }

    public static void main(String[] args) {
        Grouping grouping = new Grouping();
        grouping.groupByGender();
        grouping.duplicateNames();
    }

}
