package main;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int result = add(10, 20, 30, 40);
        System.out.println(result);
    }

    // 함수의 시그니처 : 메소드의 이름, 단순히 이름(add)가 아닌 패키지명 + 클래스명 + 반환타입 + 함수명 + 매개변수 타입 + 예외 전가
    public static int add(int num1, int num2){
        return num1 + num2;
    }

    // 따라서 두 함수는 다르다. overload
    public static int add(int num1, int num2, int num3){
        return num1 + num2 + num3;
    }

    // 가변적인 매개변수 : 입력되는 개수만큼 배열로 인식된다.
    public static int add(int... nums){
        /*
        int total = 0;
        for (int num : nums){
            total += num;
        }
        */
        int total = Arrays.stream(nums).sum();
        return total;
    }
}
