package exam01;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex05 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        Iterator<String> iter = names.iterator();

        // 커서(위치)가 기록되어 반복은 한번만 가능하다.
        while(iter.hasNext()){
            String name = iter.next();
            System.out.println(name);
        }
        // 커서 재설정
        iter = names.iterator();
        while(iter.hasNext()){
            String name = iter.next();
            System.out.println(name);
        }

        //names.forEach(System.out::println);
    }
}
