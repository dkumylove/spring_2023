package models.member;

import commons.exceptions.BadRequestException;
import commons.valdators.RequiredValidator;
import commons.valdators.Validator;


public class JoinValidator implements Validator<Member>, RequiredValidator {
    // 검증
    public void validate(Member member){
        /* 필수항목 검증( 아이디, 비번, 비번확인, 회원명)
        값의 유무 검증*/

        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();

        // 필수항목 - null 또는 빈 공백문자 있다면
//        if(userId == null || userId.isBlank()){
//            throw new BadRequestException("아이디를 입력하세요");
//        }
//
//        if(userPw == null || userPw.isBlank()){
//            throw new BadRequestException("아이디를 입력하세요");
//        }
        checkRequired(userId, new RuntimeException("아이디를 입력하세요"));
        checkRequired(userPw, new RuntimeException("비밀번호를 입력하세요"));
        checkRequired(confirmPw, new RuntimeException("비밀번호를 확인하세요"));
        checkRequired(userNm, new RuntimeException("회원명을 입력하세요"));

    }
}
