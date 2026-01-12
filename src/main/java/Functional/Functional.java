package Functional;

import com.sun.tools.javac.Main;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Functional {

    //Function - Takes in type and needs return type
    //Function - Uses apply method to complete the function
    static Function<Integer, Integer> plusOne = number -> number + 1;
    static Function<Integer, Integer> doubleNum = number -> number * 2;
    static Function<Integer, Integer> combined = plusOne.andThen(doubleNum);


    public static void main(String[] args) {
//        System.out.println(plusOne.apply(10));
        Stream.of(1,2,3,4,5,6,7,8,9,10).map(x -> combined.apply(x)).forEach(System.out::println);
    }
}
