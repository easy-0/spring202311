package exam02;

public class Box<T extends Fruit> {
    private T item;

    // private static T item2;  // static 사용 불가능
    // private T[] item3 = new T[];  // 배열 사용 불가능

    public T getItem(){
        return item;
    }

    public void setItem(T item){
        this.item = item;
    }

    public void printItem(){
        // T -> Fruit, 객체를 만드는 시점 -> 투입된 타입으로 형변환
        item.print();
    }

    public <T> void testMethod(T t) {  // 지네릭 메서드 : 위의 T와 다르다. 호출 될 때 타입 결정

    }
}
