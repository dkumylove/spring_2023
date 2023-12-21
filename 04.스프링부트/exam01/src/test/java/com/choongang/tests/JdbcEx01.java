package com.choongang.tests;

import com.choongang.entities.Member;
import com.choongang.repositories.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@SpringBootTest
public class JdbcEx01 {

    @Autowired
    private MemberRepository repository;

    @Test
    void test1() {
        List<Member> members = (List<Member>)repository.findAll();
        members.forEach(System.out::println);
    }

    @Test
    void test2() {
        Member member = repository.findById(21L).orElse(null);
        member.setUserNm("(수정)사용자01");
        member.setModDt(LocalDateTime.now());

        repository.save(member);
    }

    @Test
    void test3() {
        Member member = repository.findByUserId("user01");
        log.info(member.toString());
    }

    @Test
    void test4() {
        List<Member> members = repository.findByUserNmContainingOrUserIdContainingOrderByRegDtDesc("용", "u");
        members.forEach(System.out::println);
    }

    @Test
    void test5() {
        List<Member> members = repository.getMembers("용", "Id");
        members.forEach(System.out::println);
    }
}
