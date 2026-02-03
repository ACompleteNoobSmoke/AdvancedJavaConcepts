package Beans;

import Model.NewPeople;
import Model.Person;

public class PersonDTO {
    String firstName;
    String lastName;
    int age;

    public PersonDTO(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public static PersonDTO map(NewPeople person) {
        return new PersonDTO(person.firstName(),
                person.lastName(),
                person.age());
    }
}
