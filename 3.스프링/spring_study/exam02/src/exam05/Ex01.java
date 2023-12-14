package exam05;

public class Ex01 {
    public static void main(String[] args) {
        SimpleCalculator cal = new SimpleCalculator();
        int result = cal.add(10,20);
        System.out.println(result);

        // Calculator.num = 30;

        System.out.println(cal.minus(10,20));
    }
}
