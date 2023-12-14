package exam04;

public class Ex03 {
    public static void main(String[] args) {
        Student.id = 1000; // 클래스 변수. 데이터영역에서 자원을 공유하기 때문에 객체를 만들 필요 없이 선언할 수 있다.
        Student.staticMethod(); // 클래스 메서드, 정적 메서드 : 객체 생성없이 사용가능하므로 this가 없다. 정적변수만 접근 가능.
    }
}
