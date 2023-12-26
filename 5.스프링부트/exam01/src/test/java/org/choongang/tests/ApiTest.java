package org.choongang.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.choongang.entities.Member;
import org.choongang.restcontrollers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("회원 가입 테스트(성공시 응답코드 : 201)")
    void joinTest() throws Exception {

        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setConfirmPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");
        form.setRegDt(LocalDateTime.now()); // java time package 지원 x 모듈 추가하여 사용

        ObjectMapper om = new ObjectMapper();

        om.registerModule(new JavaTimeModule());  // 모듈을 추가해도 배열 형식으로 나오기 때문에 커맨드객체에 JsonFormat으로 날짜 형식 추가!

        String body = om.writeValueAsString(form); // form 이라는 자바 객체를 JSON 문자열로 변환

        System.out.println(body);

        mockMvc.perform(post("/api/member")
                        .header("Content-Type", MediaType.APPLICATION_JSON) //  == application/json
                        .characterEncoding("UTF-8")
                        .content(body)
                )
                .andDo(print())
                .andExpect(status().isCreated()); // 201
    }

    @Test
    @DisplayName("JSON 문자열 -> Member 객체로 변환")
    void infoTest() throws Exception {
        String body = mockMvc.perform(get("/api/member"))
                .andDo(print())
                .andReturn().getResponse()
                .getContentAsString(Charset.forName("UTF-8"));

        System.out.println("body : " + body);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        Member member = om.readValue(body, Member.class);
        System.out.println("member : " + member);
    }

    @Test
    @DisplayName("")
    void listTest() throws Exception {
        String body = mockMvc.perform(get("/api/member/list"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        
        ObjectMapper om = new ObjectMapper();
        
        om.registerModule(new JavaTimeModule());
        List<Member> members = om.readValue(body, new TypeReference<>() {});  // TypeReference 를 사용하여 중첩된 객체도 자바객체로 변환 가능하다!
        members.forEach(System.out::println);
        
    }
}
