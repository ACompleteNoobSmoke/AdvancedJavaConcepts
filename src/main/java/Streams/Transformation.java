package Streams;

import Beans.PersonDTO;
import Model.Gender;
import Model.NewPeople;

import java.util.*;

import static Custom.NewPeopleSuppler.newPeopleSupplier;

public class Transformation {

    private List<List<String>> getNames() {
        List<List<String>> result = new ArrayList<>();
        List<NewPeople> people = newPeopleSupplier.get();
        for (int i = 0; i < 3; i++) {
            List<String> name = new ArrayList<>();
            for (int j  = i; j < i + 3; j++) {
                name.add(people.get(j).firstName());
            }
            result.add(name);
        }
        return result;
    }

    public void transformWithMap() {
        List<NewPeople> people = newPeopleSupplier.get();
        List<PersonDTO> personDTOS = people.stream().map(PersonDTO::map).toList();
        personDTOS.forEach(System.out::println);
    }

    public void transformToAverageFemaleAge() {
        List<NewPeople> people = newPeopleSupplier.get();
        OptionalDouble averageAge = people.stream()
                .filter(p -> Gender.FEMALE.equals(p.gender()))
                .mapToDouble(NewPeople::age)
                .average();
        if (averageAge.isPresent())
            System.out.println("Average age of females: " + averageAge.getAsDouble());
    }

    public void reduce() {
        int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 19, 20, 123423, 22};
        int sum = Arrays.stream(integers).reduce(0, ((left, right) -> left + right));
        System.out.println("Sum of all integers: " + sum);
    }

    public void withoutFlatMap() {
        List<List<String>> names = getNames();
        List<String> result = new ArrayList<>();
        names.forEach(result::addAll);
        result.forEach(System.out::println);
    }

    public void withFlatMap() {
        List<String> names = getNames().stream().flatMap(Collection::stream).toList();
        names.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Transformation transformation = new Transformation();
        transformation.transformWithMap();
        System.out.println();
        transformation.transformToAverageFemaleAge();
        System.out.println();
        transformation.reduce();
        System.out.println();
        transformation.withoutFlatMap();
        System.out.println();
        transformation.withFlatMap();
    }
}
