package mybatistest;

import config.AppCtx;
import mapper.MemberMapper;
import models.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class MemberMapperTest {
    @Autowired
    private MemberMapper mapper;
    
    @Test
    @DisplayName("회원 목록 조회 테스트")
    void memberListTest() {
        Member m = Member.builder()
                .userNm("88")
                .userId("user")
                .build();
        List<Member> members = mapper.getMembers(m);
        for(Member member : members){
            System.out.println(member);
        }
        System.out.println(mapper.getClass().getName());
    }

    @Test
    @DisplayName("회원 가입 테스트")
    void memberInsertTest() {
        Member member = Member.builder()
                .userId("user33")
                .userPw("123456")
                .userNm("사용자33")
                .email("user33@test.org")
                .build();
        int affectedRow = mapper.register(member);

        System.out.println("변경된 행 : " + affectedRow);
        System.out.println(member);
    }

    @Test
    @DisplayName("회원정보 수정 테스트")
    void memberUpdateTest() {
        Member member = Member.builder()
                .userId("USER88")
                //.userPw("654321")
                //.userNm("99user")
                .email("99user@test.org")
                .build();
        int affectedRows = mapper.update(member);
        System.out.println("변경된 행 : " + affectedRows);
    }

    @Test
    @DisplayName("회원 삭제 테스트")
    void memberDeleteTest() {
        int affectedRow = mapper.delete("user99");
        System.out.println(affectedRow);
    }
}
