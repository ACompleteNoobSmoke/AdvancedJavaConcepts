import Custom.EmailValidator;
import Custom.PersonRegistrationValidator;
import Custom.PersonSupplier;
import Model.Person;
import Predicate.PredicateFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    private static Scanner input = new Scanner(System.in);

    private Gmail getGmail() {
        return new Gmail();
    }

    private Hotmail getHotmail() {
        return new Hotmail();
    }

//    private EmailSender getEmailSender(int choice) {
//        return switch (choice) {
//            case 1 -> getGmail();
//            case 2 -> getHotmail();
//            default -> null;
//        };
//    }


    public static void main(String[] args) {
//        int choice = input.nextInt();
//        EmailSender emailSender = new Main().getEmailSender(choice);
//        if (emailSender != null) emailSender.sendEmail("");

//        List<String>  videoGames = List.of("God of War", "Gears of War", "Devil May Cry 3");
//        videoGames.forEach(System.out::println);
//        int number = plusOne(1);

//        List<String> emails = PredicateFunction.getEmails();
//        EmailValidator emailValidator = new EmailValidator();
//        emails.stream().filter(emailValidator).forEach(emailValidator::printEmail);

//        PersonRegistrationValidator validator = PersonRegistrationValidator.isEmailValid().and(PersonRegistrationValidator.isAdult());
//        List<Person> people = PersonSupplier.getPeople();
//        people.forEach(person -> System.out.println(validator.apply(person)));

        hello("Osaretin", "Omofonmwan", callback);
        hello("Ajinboye", "", callback);



    }

//    static Function<Integer, Integer> plusOne(Integer number) {
//        return integer -> integer + number;
//    }
//
//    static int plusOne(int a) {
//        return a + 1;
//    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null && !lastName.isEmpty()) System.out.println(lastName);
        else callback.accept(firstName);

    }

    public static Consumer<String>  callback = (firstName) -> {
        System.out.println(firstName + " did not enter his last name");
    };


}
