package exam02;

import java.util.HashSet;
import java.util.Set;

public class Ex05 {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        names.add("이름1");
        names.add("이름2");
        names.add(new String("이름2"));  // 내부에서 동등성비교(equals())를 사용하여 값이 같으면 제거
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");
        names.add("이름6");

        System.out.print(names);
    }
}
