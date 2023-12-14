package mapper;

import models.member.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {
    
    // MemberMapper.xml 의 id값과 매칭
    List<Member> getMembers(Member member);

    //@Insert("INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
    //        "VALUES (SEQ_MEMBER.nextval, #{userId}, #{userPw}, #{userNm}, #{email})")
    int register(Member member);

    int update(Member member);

    int delete(String userId);
}
