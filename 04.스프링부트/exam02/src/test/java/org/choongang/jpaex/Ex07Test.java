package org.choongang.jpaex;

import org.choongang.entities.Address;
import org.choongang.entities.Member;
import org.choongang.repositories.AddressRepository;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test") // application-test.yml 파일의 설정 사용
public class Ex07Test {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @BeforeEach
    void init() {
        Address address = new Address();
        address.setZipcode("12345");
        address.setAddr1("주소1");
        address.setAddr2("주소2");

        addressRepository.saveAndFlush(address);

        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setName("사용자01");
        member.setAddress(address);

        memberRepository.saveAndFlush(member);
    }

    @Test
    void test1() {
        Member member = memberRepository.findByEmail("user01@test.org");
        Address address = member.getAddress();
        System.out.println("address = " + address);
    }
}
