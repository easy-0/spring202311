package exam02;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums = IntStream.iterate(10, x -> x + 2).limit(10).toArray();
        System.out.println(Arrays.toString(nums));

        int[] nums2 = IntStream.generate(() -> 1).limit(10).toArray();
        System.out.println(Arrays.toString(nums2));
    }
}
