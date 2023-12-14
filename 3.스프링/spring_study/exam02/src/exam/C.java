package exam;

public class C extends B{
    int numC = 30;

    public C() {
        super();    // b() - super() 상위 클래스 생성자 메서드 <> this() 생성자 메서드
        System.out.println("C 생성자");
    }
}
