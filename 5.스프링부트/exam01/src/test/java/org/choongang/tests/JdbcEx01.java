package org.choongang.tests;

import lombok.extern.slf4j.Slf4j;
import org.choongang.entities.Member;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@Slf4j
@SpringBootTest
public class JdbcEx01 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MemberRepository repository;

    @Test
    public void test1() {
        List<Member> members = (List<Member>) repository.findAll();
        members.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Member member = repository.findById(22L).orElse(null);

        member.setUserNm("(수정)사용자02");
        member.setModDt(LocalDateTime.now());

        repository.save(member); // 쿼리를 작성하지 않고 INSERT 수행!!
    }

    @Test
    public void test3() {
        Member member = repository.findByUserId("user02");
        log.info(member.toString());
    }

    @Test
    public void test4() {
        List<Member> members = repository.findByUserNmContainingOrUserIdContainingOrderByRegDtDesc("용","Id");
        members.forEach(System.out::println);
    }

    @Test
    public void test5() {
        List<Member> members = repository.getMembers("02","02");
        members.forEach(System.out::println);
    }

    @Test
    public void test6() {
        Pageable pageable = PageRequest.of(0,10, Sort.by(
                desc("regDt"),
                asc("userId")) );
        Page<Member> data = repository.findByUserNmContaining("02", pageable);

        List<Member> members = data.getContent();
        long total = data.getTotalElements();

    }
}
