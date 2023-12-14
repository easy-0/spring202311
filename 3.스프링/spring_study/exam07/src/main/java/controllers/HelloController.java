package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    // 스프링6 부터 @RequestParam("파라미터명")은 필수요소. required 속성 변경 or default 값 추가
    public String hello(@RequestParam(value = "name", defaultValue = "default") String nm, Model model) {
        model.addAttribute("name",nm);  // model 은 데이터

        return "hello";
    }
















/*
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name,
                        @RequestParam("num") int num){
        System.out.println(name+", "+num);
        // return 타입이 String이지만 내부적으로 ModelAndView로 반환한다.
        return "hello";  // ViewResolver가 /WEB-INF/templates/hello.jsp 경로를 찾아 view를 띄워준다.
    }
*/

/*    @GetMapping("/hello")
    public String hello(HttpServletRequest req,
                        HttpServletResponse resp,
                        HttpSession session){
        System.out.println("request : " + req);
        System.out.println("response : " + resp);
        System.out.println("session : " + session);
        return "hello";
    }*/
/*    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        // request.setAttribute("message", "ㅎㅇ"); 아래와 동일하다.
        mv.addObject("message", "ㅎㅇ");
        mv.setViewName("hello");

        return mv;
    }
    @GetMapping("/bye")
    public ModelAndView bye() {
        ModelAndView mv = new ModelAndView();
        // request.setAttribute("message", "안녕하세요."); 아래와 동일하다.
        mv.addObject("message", "ㅂㅇ");
        mv.setViewName("hello");

        return mv;
    }*/
}
