package exam03;

import exam02.Fruit;

public class Juicer {

    public static void make(FruitBox<? super Apple> fruitBox){  // Apple, Fruit, Object
        System.out.println(fruitBox.getItems());
    }

    // 지네릭 메서드
    public static <T extends Fruit> void make2(FruitBox<T> fruitBox) {
        System.out.println(fruitBox.getItems());
    }
}
