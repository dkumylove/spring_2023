package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 아이디로 회원이 조회 되는지?
         * 2. 조회된 회원의 비밀번호와 입력한 비밀번호의 일치 여부
         */

        RequestLogin form = (RequestLogin)target;

        String userId = form.userId();
        String userPw = form.userPw();

        // 1. 아이디로 회원이 조회 되는지?
        // 로그인에러시 안내메시지는 통합적으로 안내하는 것이 보안에 좋음
        Member member = memberDao.get(userId);
        if(member == null) {
            errors.reject("Login.auth.fail");
        }

        // 비밀번호가 일치하지 않습니다. -> 아이디는 맞다, 비번만 돌려가며 해킹가능성 있음

        // 2. 조회된 회원의 비밀번호와 입력한 비밀번호의 일치 여부
        if(member != null && StringUtils.hasText(userPw) && !BCrypt.checkpw(userPw, member.getUserPw())) {
            errors.reject("Login.auth.fail");
        }
    }
}
