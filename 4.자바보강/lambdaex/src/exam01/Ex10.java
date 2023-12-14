package exam01;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;


public class Ex10 {
    public static void main(String[] args) {
        //Consumer<String> func1 = s -> System.out.println(s.length());
        Consumer<String> func1 = System.out::println; // :: 우측의 메서드를 참조해라.
        func1.accept("hello!");

        //Function<String, Integer> func2 = s -> s.length();
        Function<String, Integer> func2 = String::length;
        func2.apply("hihihihihihi");

        //BiPredicate<String, String> func3 = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> func3 = String::equals;
    }

}
