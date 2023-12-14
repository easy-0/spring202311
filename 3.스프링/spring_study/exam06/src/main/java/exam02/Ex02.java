package exam02;

public class Ex02 {
    public static void main(String[] args) {
        Calculator cal = (num1, num2) -> num1 + num2;
        add(cal);
    }

    public static void add(Calculator cal){
        int result = cal.add(10, 20);
        System.out.println(result);
    }
}
