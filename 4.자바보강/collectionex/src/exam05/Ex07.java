package exam05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex07 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "이름1", "이름2", "이름3", "이름4", "이름5");
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);
    }
}
