package Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {

    void streamPractice(){
        List<String> videoGames = List.of("The Legend of Zelda", "Super Mario Bros", "Metroid", "Final Fantasy", "Pokemon");
        Stream<String> gameStream = videoGames.stream();
        List<Object> collect = videoGames.stream().limit(2).map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new WorkingWithStreams().streamPractice();
    }

}
