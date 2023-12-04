package exam04;

public class Ex02 {
    public static void main(String[] args) {
        Book2 b2 = Book2.builder()
                .title("book2")
                .author("author2")
                .publisher("publisher2")
                .build();
        System.out.println(b2);
    }
}
