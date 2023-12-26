package controllers.admin;

import commons.CommonException;
import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import models.member.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberDao memberDao;


    @GetMapping // 상단 주소로 접속(/admin/member)
    // 양식 연동시 빈 값이어도 오류를 방지 할 수 있다. 순서 중요!
    public String index(@ModelAttribute MemberSearch search, Errors errors, Model model) {

        List<Member> members = memberDao.getList(search);
        model.addAttribute("members", members);

        members.forEach(System.out::println);

        return "admin/member/list";
    }

    // /admin/member/회원아이디
    // Spring 6.1 버전부터는 명시적으로 작성해야한다.
    @GetMapping("/{id}")
    public String info(@PathVariable("id") String userId) {
        System.out.println(userId);
        return "/admin/member/info";
    }

    @GetMapping("/test")
    public String errorTest() {
        boolean result = true;
        if (result) {
            //throw new RuntimeException("예외 발생");
            throw new MemberNotFoundException();
        }

        return "/admin/member/info";
    }

/*    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model){

        e.printStackTrace();

        model.addAttribute("message", e.getMessage());

        return "error/common";
    }*/
}
