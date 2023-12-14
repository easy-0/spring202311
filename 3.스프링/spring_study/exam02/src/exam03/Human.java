package exam03;

public class Human extends Animal{
    @Override   // 컴파일 시 컴파일러에 정보 전달
    public void move() {
        System.out.println("두 발로 직립보행합니다.");
    }
    public void readBook() {
        System.out.println("독서를 합니다.");
    }
}
