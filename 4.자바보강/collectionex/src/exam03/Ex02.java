package exam03;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex02 {
    public static void main(String[] args) {

        // Comparator<Integer> comp = (o1, o2) -> o2 - o1;

        TreeSet<Integer> numbers = new TreeSet<>(Comparator.reverseOrder());
        numbers.add(10);
        numbers.add(5);
        numbers.add(44);
        numbers.add(9);

        System.out.println(numbers);
    }
}
