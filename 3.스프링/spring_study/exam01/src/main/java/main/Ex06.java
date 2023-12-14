package main;

import models.member.*;

import java.time.LocalDateTime;

public class Ex06 {
    public static void main(String[] args) {
        JoinService joinService = ServiceManager.getInstance().joinService();
        ListService listService = ServiceManager.getInstance().listService();

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("1234");
        member.setConfirmPw("1234");
        member.setUserName("momo");
        member.setRegDt(LocalDateTime.now());
        
        joinService.join(member);   // 가입
        
        listService.print();    // 목록 출력
    }
}
