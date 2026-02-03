package Streams;

import Beans.PersonDTO;
import Model.Gender;
import Model.NewPeople;

import java.util.List;
import java.util.OptionalDouble;

import static Custom.NewPeopleSuppler.newPeopleSupplier;

public class Transformation {

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

    public static void main(String[] args) {
        Transformation transformation = new Transformation();
        transformation.transformWithMap();
        System.out.println();
        transformation.transformToAverageFemaleAge();
    }
}
