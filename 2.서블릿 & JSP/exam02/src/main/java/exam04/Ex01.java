package exam04;

public class Ex01 {
    public static void main(String[] args) {
        // 빌더 패턴
        Book b1 = Book.builder()
                .title("책")
                .author("저자")
                .publisher("출판사")
                .build();

        System.out.println(b1);
    }
}
