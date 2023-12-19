package controllers.member;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
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

    }
}
