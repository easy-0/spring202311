package exam01;

import java.util.Vector;

public class Ex04 {
    public static void main(String[] args) {
        Vector<String> names = new Vector<>(3);

        names.add("11");
        names.add("22");
        names.add("33");
        names.add("44");
        // 공간이 찰 경우, 초기화 capacity의 두배 공간을 할당
        System.out.println("capacity : " + names.capacity());
    }
}
