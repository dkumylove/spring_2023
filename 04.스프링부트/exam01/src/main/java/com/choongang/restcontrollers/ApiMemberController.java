package com.choongang.restcontrollers;

import com.choongang.commons.BadRequestException;
import com.choongang.commons.JSONData;
import com.choongang.entities.Member;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController //스프링 5에 추가된 기능 Json 변환방식
@RequestMapping("/api/member")
public class ApiMemberController {

    @PostMapping
    public ResponseEntity<JSONData> join(@Valid @RequestBody  RequestJoin form, Errors errors) {
        if (errors.hasErrors()) {
            List<String> messages = errors.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            log.info("에러 : {}", messages.toString());

            String message = messages.stream().collect(Collectors.joining(","));

            //throw new RuntimeException(message);
            throw new BadRequestException(message);
        }

        // 응답 코드 - 201, body - 없음
        HttpStatus status = HttpStatus.CREATED;
        JSONData<Object> data = new JSONData<>();
        data.setStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
        /*
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("CUSTOM_HEADER", "value1")
                .build();

         */
    }

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

        //JSONData<Member> data = new JSONData<>();
        //data.setData(member);

        //return new JSONData<>(member);

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

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity errorHandler(Exception e) {

        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }*/
}
