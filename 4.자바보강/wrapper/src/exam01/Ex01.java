package exam01;

public class Ex01 {
    public static void main(String[] args) {
        /*Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);*/
        Integer num1 = Integer.valueOf(10);  // byte 범위면 같은 객체
        Integer num2 = Integer.valueOf(10);  // byte 범위 밖이면 다른 객체 생성

        System.out.println(num1 == num2);
        System.out.println("num1 : " + System.identityHashCode(num1));
        System.out.println("num2 : " + System.identityHashCode(num2));

        //long num2 = num1.longValue();
    }
}
