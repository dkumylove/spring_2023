package models.member;

import commons.exceptions.BadRequestException;
import commons.valdators.RequiredValidator;
import commons.valdators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JoinValidator implements Validator<Member>, RequiredValidator {

    @Autowired
    //@Qualifier("memberDao")
    private MemberDao memberDao;

    // 기본생성자
    public JoinValidator() {}

    public JoinValidator(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    // 검증
    public void validate(Member member) {
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
        // 필수 항목 - null 또는 빈 공백 " " 을 RequiredValidator 인터페이스로 묶음
        // RuntimeException e = new BadRequestException
        checkRequired(userId, new BadRequestException("아이디를 입력하세요."));
        checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new BadRequestException("비밀번호를 확인하세요."));
        checkRequired(userNm, new BadRequestException("회원명을 입력하세요."));

        // 아이디가 이미 등록되어있는지 체크
        // checkFalse() 예외처리
        checkFalse(memberDao.exists(userId), new BadRequestException("이미 등록된 아이디입니다."));

        // 비밀번호, 비밀번호 확인시 일치 여부
        // checkTrue() 인터페이스를 만들었기때문, 아래와 같이 수정
//        if(!userPw.equals((confirmPw))){
//            System.out.println();
//        }
        checkTrue(userPw.equals(confirmPw), new BadRequestException("비밀번호가 일치하지 않습니다."));
    }

}
