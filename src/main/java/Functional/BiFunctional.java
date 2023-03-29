package Functional;

import java.util.function.BiFunction;

public class BiFunctional {

    BiFunction<Object, Object, Boolean> biFunction = (o, o2) -> o.equals(o2);

    public static void main(String[] args) {
        System.out.println(new BiFunctional().biFunction.apply("Uyi", "Osaretin"));
    }


}
