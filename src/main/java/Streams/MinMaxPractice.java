package Streams;

import java.util.List;
import java.util.stream.IntStream;

public class MinMaxPractice {

    private List<Integer> numbers;

    public MinMaxPractice() {
        this.numbers = List.of(4, 5, 8, 1, 2, 9, 3, 7, 6, -3);
    }

    public MinMaxPractice(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private int min() {
        return numbers.stream().min(Integer::compareTo).get();
    }

    private int max() {
        return numbers.stream().max((x, y) -> x.compareTo(y)).get();
    }

    public static void main(String[] args) {
        MinMaxPractice minMaxPractice = new MinMaxPractice();
        System.out.printf("Min Num: %d\n", minMaxPractice.min());
        System.out.printf("Max Num: %d\n", minMaxPractice.max());
    }
}
