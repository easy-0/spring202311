package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    
    private MemberDao memberDao;  // 변수에 넣으면 직접 주입
    @Autowired  // 세터 메서드 호출시 의존성 주입
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    public void print() {
        List<Member> members = memberDao.getList();

        for(Member member : members){
            System.out.println(member);
        }
    }
}
