package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box box = new Box();
        box.setItem(new Apple());

        Apple apple = (Apple)box.getItem(); // 2. Object 는 형변환을 해야한다.
        apple.print();

        Object obj = box.getItem();
        if(obj instanceof Pear){    // 1. 타입 안정성이 떨어진다.
            Pear pear = (Pear) obj;
        }

    }
}
