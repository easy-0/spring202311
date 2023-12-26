package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "USERS",
        indexes = {@Index(name="idx_member_createdAt", columnList = "createdAt DESC")})
/*@EntityListeners(AuditingEntityListener.class)*/
public class Member extends Base {
    @Id @GeneratedValue
    private Long seq;

    @Column(length = 80, unique = true, nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 65, name = "userPw", nullable = false)
    private String password;    // varchar2

    //@Lob
    @Transient
    private String introduction;// CLOB

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MemberType type;
    
    //@CreationTimestamp  // INSERT SQL 실행시 날짜시간 작성, hibernate 만 지원(비표준적)
   /* @CreatedDate  // 엔티티 생성 시간
    private LocalDateTime createdAt;*/
    
    //@UpdateTimestamp    // UPDATE SQL 실행시 날짜시간 작성, hibernate 만 지원(비표준적)
    /*@LastModifiedDate  // 엔티티 수정 시간
    private LocalDateTime modifiedAt;*/

    //@Temporal(TemporalType.DATE)  // 날짜
    //@Temporal(TemporalType.TIME)  // 시간
    //@Temporal(TemporalType.TIMESTAMP)  // 날짜 + 시간
    //private Date dt;
}
