package Streams;

import java.util.stream.IntStream;

public class IntStreamPractice {

    private void rangePractice(){
        System.out.println("With For Loop");
        for (int i = 0; i < 10; i++) System.out.println(i);
        System.out.println("With IntStream");
        IntStream intstream = IntStream.rangeClosed(0, 10);
        intstream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        IntStreamPractice intStreamPractice = new IntStreamPractice();
        intStreamPractice.rangePractice();
    }
}
