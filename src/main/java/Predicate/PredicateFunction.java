package Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunction {

    private static Predicate<String> containsAt = email -> email.contains("@");
    private static Predicate<String> containsDot = email -> email.contains(".");
    private static Predicate<String> isValidEmail = email -> containsAt.and(containsDot).test(email);

    public static List<String> getEmails() {
        List<String> emails = new ArrayList<>();

        // ✅ Valid emails
        emails.add("john.doe@gmail.com");
        emails.add("admin@company.org");
        emails.add("support@amazon.co.uk");
        emails.add("user_123@test.io");

        // ❌ Invalid emails
        emails.add("missingatsign.com");          // no @
        emails.add("missingdomain");             // no domain
        emails.add("@nousername.com");             // no username
        emails.add("spaces in@email.com");         // spaces
        emails.add("double@@email.com");           // double @
        emails.add("invalid@domain");              // no TLD
        emails.add("invalid.com");                // dot issue
        emails.add("plainaddress");                // not an email

        return emails;
    }

    static void main() {
        List<String> emails = getEmails();
        emails.forEach(x -> System.out.println(isValidEmail.test(x)));
    }
}
