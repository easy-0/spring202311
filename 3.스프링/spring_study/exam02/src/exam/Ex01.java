package exam;

public class Ex01 {
    public static void main(String[] args) {
        // 생성자 - 객체를 생성하는 역할(힙 메모리에 필요한 자원을 위해 공간 할당)
        C c = new C();
        // C뿐만 아니라 B, A 모두 될 수 있다. (다형성)
        // C > B > A
        A a = c;
        B b = c;
    }
}
