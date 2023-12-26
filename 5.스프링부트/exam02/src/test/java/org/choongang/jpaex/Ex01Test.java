package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01Test {
    @PersistenceContext // @Autowired 와 동일한 의존성 주입이지만 JPA에 맞게 사용
    private EntityManager em;

    @BeforeEach  // 작업 전 초기 데이터 입력시 사용
    void init() {
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);  // 영속성 컨테스트에 영속상태 - 변화 감지 시작
        em.flush();  // insert 쿼리 실행
        em.clear();  // 영속 상태 엔티티 모두 비우기

    }

    @Test
    void test1() {
        Member member = em.find(Member.class, 1L);

        em.detach(member);  // 영속성 분리

        member.setName("(수정)사용자01");
        em.flush();  // update 쿼리 실행

        em.merge(member); // 분리된 영속 상태 엔티티 - > 영속 상태
        em.flush();
/*
        em.remove(member);  // 제거 상태로 변경
        em.flush();  // delete 쿼리 실행
        */
    }

    @Test
    void test2(){
        Member member = em.find(Member.class, 1L); // SQL 실행 -> 엔티티 -> 영속 상태
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L);
        System.out.println(member2);  // 영속 상태 엔티티 ->
    }

    @Test
    void test3(){
        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
        members.forEach(System.out::println);
    }
}
