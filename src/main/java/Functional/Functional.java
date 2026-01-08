package Functional;

import java.util.function.Function;

public class Functional {

    //Function - Takes in type and needs return type
    //Function - Uses apply method to complete the function
    static Function<Integer, Integer> plusOne = (number) -> number + 1;

    public static void main(String[] args) {
        System.out.println(plusOne.apply(10));
    }
}
