package exam01;

import lombok.*;

//@Getter
//@Setter
//@NoArgsConstructor(access = AccessLevel.PRIVATE)  // 기본 생성자 (접근 제한자)
//@AllArgsConstructor       // 모든 멤버 변수 초기화 생성자
//@RequiredArgsConstructor    // 반드시 초기화가 필요한 상수(final) 멤버 변수가 있을때 사용
//@ToString
//@EqualsAndHashCode          // jpa에서 pk 유효성검사 확인할 때 사용
@Data
public class Book {
    private String title;
    private String author;
    private String publisher;


}
