package Streams;

import java.util.List;
import java.util.stream.Collectors;

public class Exercises {

    private void listNames() {
        List<String> names = List.of("alice", "bob", "charlie", "marcus", "helena", "jackie");
        String joined = names.stream().map(name ->  {
            char firstChar = Character.toUpperCase(name.charAt(0));
            return "".concat(firstChar + "").concat(name.substring(1));
        }).collect(Collectors.joining(", "));
        System.out.println(joined);
    }

    public static void main(String[] args) {
        Exercises exercises = new Exercises();
        exercises.listNames();
    }
}
