package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.setItem(new Apple());
        // appleBox.setItem(new Pear()); // 타입 안전성 증가

        Apple apple = appleBox.getItem(); // 형변환 x

        Box<Pear> pearBox = new Box<>();

    }
}
