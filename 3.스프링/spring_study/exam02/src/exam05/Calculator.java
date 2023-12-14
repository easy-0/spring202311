package exam05;

public interface Calculator {
    // public abstract 키워드가 자동으로 붙는다!! & 다른 키워드는 사용하지 못한다
    //   >> 무조건 추상메서드로 인식 : 순수 설계 목적
    int add(int num1, int num2); // 인스턴스 메서드
    int num = 10;   // public static final : 정적 상수
    default int minus(int num1, int num2) { // public, 하위클래스에서 구현하지않아도 사용가능
        return num1 - num2;
    }
}
