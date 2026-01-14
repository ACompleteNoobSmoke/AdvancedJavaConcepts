package Custom;

import Model.Person;
import Model.ValidationResult;

import java.util.function.Function;

public interface PersonRegistrationValidator extends Function<Person, ValidationResult> {

    static PersonRegistrationValidator isEmailValid() {
        return person -> person.email().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID_ERROR;
    }

    static PersonRegistrationValidator isAdult() {
        return person -> person.age() >= 18 ? ValidationResult.SUCCESS : ValidationResult.NOT_AN_ADULT_ERROR;
    }

    default PersonRegistrationValidator and (PersonRegistrationValidator other) {
        return person -> {
            ValidationResult result = this.apply(person);
            return result == ValidationResult.SUCCESS ? other.apply(person) : result;
        };
    }
}
