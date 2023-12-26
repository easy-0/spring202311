package exam03;

import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        String[] strs = { "aa", "bbb", "aaa", "ccc" };
        // allMatch = and
        boolean result1 = Arrays.stream(strs).allMatch(s -> s.length() >= 3);
        System.out.println(result1);

        // anyMatch = or
        boolean result2 = Arrays.stream(strs).anyMatch(s -> s.length() >= 3);
        System.out.println(result2);

    }
}
