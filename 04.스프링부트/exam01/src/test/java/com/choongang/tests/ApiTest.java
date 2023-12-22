package com.choongang.tests;

import com.choongang.entities.Member;
import com.choongang.restcontrollers.RequestJoin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    @DisplayName("회원가입 성공시 응압코드 201")
    void  joinTest() throws Exception {
        //MediaType.APPLICATION_JSON == application/json

        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setConfirmPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01.test@org");
        form.setRegDt(LocalDateTime.now());  // 그냥은 변환이 지원되지 않음

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule()); // LocalDateTime도 잘 변환됨

        String body = om.writeValueAsString(form); // 자바객체 -> JSON문자열 변환
        System.out.println(body);

        mockMvc.perform(
                        post("/api/member")
                                //.header("Content-Type", "application/json")
                                .header("Content-Type", MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8")
                                .content(body)
                )
                .andDo(print())
                .andExpect(status().isCreated());   //201
    }

    @Test
    @DisplayName("JSON문자열 -> Member객체로 변환")
    void infoTest() throws Exception {

        String body = mockMvc.perform(get("/api/member"))
                    .andDo(print())
                    .andReturn().getResponse() //응답객체를 가져올수 있음
                    .getContentAsString(Charset.forName("UTF-8"));

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        Member member = om.readValue(body, Member.class);
        System.out.println("========= member : " + member);
    }

    @Test
    void listTest() throws Exception {

        String body = mockMvc.perform(get("/api/member/list"))
                    .andDo(print())  // 헤더와 바디를의 내용을 확인할때 활용
                    .andReturn()  // 응답 내용을 확인할떄
                    .getResponse()
                    .getContentAsString(Charset.forName("UTF-8"));

        System.out.println("=============body : " + body);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        //List<Member> members = om.readValue(body, new TypeReference<List<Member>>() {
        List<Member> members = om.readValue(body, new TypeReference<>() {});
        members.forEach(System.out::println);
    }
}
