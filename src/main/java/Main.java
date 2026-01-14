import Custom.EmailValidator;
import Predicate.PredicateFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        List<String> emails = PredicateFunction.getEmails();
        EmailValidator emailValidator = new EmailValidator();
        emails.stream().filter(emailValidator).forEach(System.out::println);


    }

//    static Function<Integer, Integer> plusOne(Integer number) {
//        return integer -> integer + number;
//    }
//
//    static int plusOne(int a) {
//        return a + 1;
//    }
}
