package Custom;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {


    @Override
    public boolean test(String s) {
        return s.contains("@");
    }

    public void printEmail(String email) {
        System.out.printf("Email: %s\n", email);
    }
}
