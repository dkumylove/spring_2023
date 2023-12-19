package mapper;

import controllers.admin.MemberSearch;
import models.member.Member;

import java.util.List;

public interface MemberMapper {

    // 회원가입
    int register(Member member);

    // 아이디 중복 검사
    int exist(String userId);

    // 회원조회
    Member get(String userId);

    // 회원정보조회(리스트로출력)
    List<Member> getList(MemberSearch search);
}