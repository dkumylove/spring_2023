package mapper;

import models.member.Member;

public interface MemberMapper {

    // 회원가입
    int register(Member member);

    // 아이디 중복 검사
    int exist(String userId);

    // 회원조회
    Member get(String userId);
}