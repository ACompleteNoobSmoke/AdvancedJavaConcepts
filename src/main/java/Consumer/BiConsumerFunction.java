package Consumer;

import java.util.function.BiConsumer;

public class BiConsumerFunction {

    private static BiConsumer<String, String> emailMessage = (from, to) ->
            System.out.printf("Sending Email From %s to %s", from, to);

    static void main() {
        emailMessage.accept("OsoInfinite95@gmail.com", "OmoruyiOmofonmwan@yowzer.com");
    }
}
