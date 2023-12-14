package exam05;

import java.util.Arrays;
import java.util.Comparator;

public class Ex05 {
    public static void main(String[] args) {
        Integer[] nums = { 10, 3, 5, 44, 19, 67};
        // Arrays.sort(nums); // 기본 정렬 기준 - 오름차순
        Arrays.sort(nums, Comparator.reverseOrder());
        System.out.println(Arrays.toString(nums));
    }
}
