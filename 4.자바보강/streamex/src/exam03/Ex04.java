package exam03;

import java.util.Optional;

public class Ex04 {
    public static void main(String[] args) {
        Optional<Book> book = Optional.ofNullable(null);

        // Book b1 = new Book();
        // Book b = book.orElse(b1); // 직접 객체를 만들어야함.
        // Book b = book.orElseGet(() -> new Book());
        Book b = book.orElseGet(Book::new);
    }
}
