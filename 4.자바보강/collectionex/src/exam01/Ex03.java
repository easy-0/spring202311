package exam01;

import java.util.Stack;

public class Ex03 {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();

        names.push("오");
        names.push("사");
        names.push("삼");

        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());
    }
}
