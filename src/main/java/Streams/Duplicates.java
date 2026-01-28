package Streams;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicates {

    private List<Integer> distinct(List<Integer> numbers) {
        return numbers.stream().distinct().toList();
    }

    private Set<Integer> distinctNums(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,1, 2, 2, 2, 3, 3, 4, 4, 5, 5);
        Duplicates duplicates = new Duplicates();
        List<Integer> distinct = duplicates.distinct(numbers);
        distinct.forEach(nums-> System.out.print(nums + " "));
        System.out.println();
        duplicates.distinctNums(numbers).forEach(nums -> System.out.print(nums + " "));
    }
}
