package Streams;

import static Custom.NewPeopleSuppler.newPeopleSupplier;

import Model.Gender;
import Model.NewPeople;

import java.util.Comparator;
import java.util.List;

public class Sorting {

    private List<NewPeople> people;

    public Sorting() {
        people = newPeopleSupplier.get();
    }

    public Sorting(List<NewPeople> peopleList) {
        this.people = peopleList;
    }

    private void sortByName() {
        people.stream()
                .map(NewPeople::firstName)
                .sorted()
                .forEach(System.out::println);
    }

    public void sortByAge() {
        people.stream()
                .sorted(Comparator.comparingInt(NewPeople::age))
                .forEach(System.out::println);
    }

    public void sortByOldestWomen() {
        people.stream()
                .filter(p -> Gender.FEMALE.equals(p.gender()))
                .sorted(Comparator.comparingInt(NewPeople::age).reversed())
                .limit(5)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        System.out.println("Sort By First Name");
        sorting.sortByName();
        System.out.println("Sort By Age");
        sorting.sortByAge();
        System.out.println("Sort By Oldest Women");
        sorting.sortByOldestWomen();
    }
}
