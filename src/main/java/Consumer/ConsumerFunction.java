package Consumer;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunction {

    public static Consumer<String> sendEmailConsumer = email -> System.out.println("Sending Email To " + email);

    public static void main(String[] args) {
        List<String> emails = List.of("OsoInifite@gmail", "OmoruyiOmofonmwan@yowzers.com", "hello@amigoscode.com");
        emails.forEach(sendEmailConsumer);
    }
}
