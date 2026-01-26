package Streams;

import Custom.NewPeopleSuppler;
import Model.NewPeople;
import Model.Person;

import java.util.List;
import java.util.stream.IntStream;
import static Custom.NewPeopleSuppler.newPeopleSupplier;

public class IntStreamPractice {

    private void rangePractice(){
        System.out.println("With For Loop");
        for (int i = 0; i < 10; i++) System.out.println(i);
        System.out.println("With IntStream");
        IntStream intstream = IntStream.rangeClosed(0, 10);
        intstream.forEach(System.out::println);
    }

    private void rangeIteratingLists() {
        List<NewPeople> people = newPeopleSupplier.get();
        IntStream intstream = IntStream.range(0, people.size());
        intstream.forEach(i -> System.out.println(people.get(i)));
    }

    private void intStreamIterate() {
        IntStream.iterate(0, value -> ++value)
                .limit(20)
                .forEach(System.out::println);
        int sum = IntStream.range(1, 5).sum();
        System.out.println(sum);
    }

    private int intSum() {
        List<Integer> list = List.of(5, 1, 0, 5, 100, 5, 89, 2, -1, 50);
        return list.stream().mapToInt(integer -> integer).sum();
    }

    public static void main(String[] args) {
        IntStreamPractice intStreamPractice = new IntStreamPractice();
//        intStreamPractice.rangePractice();
//        intStreamPractice.rangeIteratingLists();
        intStreamPractice.intStreamIterate();
        System.out.println(intStreamPractice.intSum());
    }
}
