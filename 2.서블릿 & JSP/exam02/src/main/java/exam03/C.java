package exam03;

public class C extends B{
    int numC = 30;

    public C(){
        super(); // B의 기본생성자 호출
        System.out.println("C 생성자!");
    }
}
