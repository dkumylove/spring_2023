package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01Test {

    @PersistenceContext  // @Autowired와 동일
    private EntityManager em;

    @BeforeEach // 테스트 이전에 시작
    void init() {
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        // 회원1명 추가
        em.persist(member);
        em.flush();
        em.clear();  // 영속상테 엔티티 모두 비우기
    }

    @Test
    void test1() {
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        // insert
        em.persist(member);  // 영속성 컨텍스트에 영속상테 - 변화 감지 시작
        em.flush();

        em.detach(member); // 영속성 분리 - 변화감지 x

        // update
        member.setName("(수정)사용자01");
        em.flush();

        em.merge(member);  // 분리된 영속 상테 엔티티 -> 영속상태 : 변화감지 o
        em.flush();


        // delete
//        em.remove(member);  // 제거상태로 변경(제거하는것 아님)
//        em.flush();

    }

    @Test
    void test2() {
        Member member = em.find(Member.class, 1L);
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L);
        System.out.println(member2);
    }

    @Test
    void test03() {
        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
        members.forEach(System.out::println);
    }

}
