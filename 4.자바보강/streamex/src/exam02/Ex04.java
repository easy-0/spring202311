package exam02;

import java.util.Random;

public class Ex04 {
    public static void main(String[] args) {
        Random rand = new Random();
        rand.ints().filter(x -> x >= 0).limit(10).forEach(System.out::println);
    }
}
