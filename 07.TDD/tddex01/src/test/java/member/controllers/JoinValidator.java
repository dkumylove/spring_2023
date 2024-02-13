package member.controllers;

import commons.Validator;
import member.service.BadRequestException;

public class JoinValidator implements Validator<Member> {
    @Override
    public void check(Member member) {
        /* 아이디 검증 null, 빈값 */
        String userId = member.getUserId();
        if (userId == null || userId.isBlank()) {
            throw new BadRequestException("아이디를 입력하세요.");
        }

        String userPw = member.getUserPw();
        if (userPw == null || userPw.isBlank()) {
            throw new BadRequestException("비밀번호를 입력하세요.");
        }
    }
}