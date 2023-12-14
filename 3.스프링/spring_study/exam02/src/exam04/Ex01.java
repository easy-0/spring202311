package exam04;

public class Ex01 {
    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
        int result = sc.add(10,20);
        System.out.println(result);
        System.out.println(sc.num);  // 추상클래스이지만 객체 생성이 된다. 인스턴스자원일때 가능
    }
}
