package com.choongang.restcontrollers;

import com.choongang.entities.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@RestController //스프링 5에 추가된 기능 Json 변환방식
@RequestMapping("/api/member")
public class ApiMemberController {

    @GetMapping
    public Member info() {
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("12345678")
                .userNm("사용자01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .modDt(LocalDateTime.now())
                .build();

        return member;
    }

    @GetMapping("/list")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .userNo(Long.valueOf(i))
                        .userId("user" + i)
                        .userPw("12345678")
                        .userNm("사용자" + i)
                        .email("user" + i + "@test.org")
                        .regDt(LocalDateTime.now())
                        .modDt(LocalDateTime.now())
                        .build()
                ).toList();

        return  members;
    }

    @GetMapping("/message")
    public String message() {
        return "안녕하세요";
    }

    // 일반 컨트롤러는 반환값이 반드시 있어야한다.
    // Rest에서는 처리하는 것만 있고 반환값이 없는 경우도 가능

    @GetMapping("/process")
    public void process() {
        System.out.println("처리===========");
    }
}
