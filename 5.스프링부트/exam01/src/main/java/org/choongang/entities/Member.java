package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Member {
    // USER_NO -> userNo
    @Id // 기본키(PK)임을 명시, 엔티티를 만들때 필수로 알려줘야한다.
    private Long userNo;
    private String userId;
    @JsonIgnore // 민감한 정보 변환 제외
    private String userPw;
    private String userNm;
    private String email;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;
}
